package at.fhtw.swen3.services.impl;


import at.fhtw.swen3.gps.service.impl.MapsEncodingProxy;
import at.fhtw.swen3.model.Address;
import at.fhtw.swen3.persistence.entities.*;
import at.fhtw.swen3.persistence.repositories.*;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.mapper.HopArrivalMapper;
import at.fhtw.swen3.services.mapper.HopArrivalMapperImpl;
import at.fhtw.swen3.services.mapper.ParcelMapperImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private final ParcelRepository parcelRepository;

    @Autowired
    private final RecipientRepository recipientRepository;

    private final ParcelMapperImpl parcelMapper = new ParcelMapperImpl();
    @Autowired
    private final GeoCoordinateRepository geoCoordinateRepository;
    @Autowired
    private final WarehouseRepository warehouseRepository;
    @Autowired
    private final TruckRepository truckRepository;
    @Autowired
    private final HopArrivalRepository hopArrivalRepository;
    @Autowired
    private final TransferwarehouseRepository transferwarehouseRepository;


    @Override
    public String submitNewParcel(Parcel parcel, String id) {

        UUID uuid = UUID.randomUUID();

        MapsEncodingProxy mapsEncodingProxy = new MapsEncodingProxy();

        if (id.equals("")) id = UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0, 9);

        ParcelEntity parcelEntity = parcelMapper.dtoToEntity(parcel);

        parcelEntity.setTrackingId(id);
        parcelEntity.setState(TrackingInformation.StateEnum.PICKUP);
        GeoCoordinateEntity geoCoordinateEntityR = mapsEncodingProxy.encodeAddress(new Address(parcelEntity.getRecipient().getStreet(), parcelEntity.getRecipient().getPostalCode(), parcelEntity.getRecipient().getCity(), parcelEntity.getRecipient().getCountry()));
        GeoCoordinateEntity geoCoordinateEntityS = mapsEncodingProxy.encodeAddress(new Address(parcelEntity.getSender().getStreet(), parcelEntity.getSender().getPostalCode(), parcelEntity.getSender().getCity(), parcelEntity.getSender().getCountry()));

        parcelEntity.getRecipient().setLocationCoordinates(geoCoordinateEntityR);
        parcelEntity.getSender().setLocationCoordinates(geoCoordinateEntityS);

        geoCoordinateRepository.save(geoCoordinateEntityR);
        geoCoordinateRepository.save(geoCoordinateEntityS);
        Long recp_id = recipientRepository.save(parcelEntity.getRecipient()).getId();
        Long send_id = recipientRepository.save(parcelEntity.getSender()).getId();
        List<TruckEntity> truck = truckRepository.getClosestHop(recp_id);
        List<TransferwarehouseEntity> transferwarehouseEntity = transferwarehouseRepository.getClosestHop(recp_id);//TODO: check whats closer
        List<TruckEntity> s_truck = truckRepository.getClosestHop(send_id);
        List<TransferwarehouseEntity> s_transferwarehouseEntity = transferwarehouseRepository.getClosestHop(send_id);
        HopEntity closestR = new HopEntity();
        HopEntity closestS = new HopEntity();
        if(truck.size()>0 && transferwarehouseEntity.size()>0) {
            closestR = closerHop(truck.get(0),transferwarehouseEntity.get(0),recp_id);
        }else if(s_truck.size()>0 && s_transferwarehouseEntity.size()>0) {
            closestS = closerHop(s_truck.get(0),s_transferwarehouseEntity.get(0),send_id);
        }
        if(transferwarehouseEntity.isEmpty()){
            closestR = truck.get(0);
        }
        if(s_transferwarehouseEntity.isEmpty()){
            closestS = s_truck.get(0);
        }
        List<HopEntity> routehops = calculateRoute(closestR, closestS);
        parcelEntity.setFutureHops(createFutureHops(routehops));
        hopArrivalRepository.saveAll(parcelEntity.getFutureHops());
        parcelRepository.save(parcelEntity);
        log.info("parcel has been submit");
        return parcelEntity.getTrackingId();
    }

    private HopEntity closerHop(HopEntity hopA,HopEntity hopB, long id){
        Double distRTruck = truckRepository.getDistance(hopA.getLocationCoordinates().getId(), id);
        Double distRTrans = transferwarehouseRepository.getDistance(hopB.getLocationCoordinates().getId(), id);
        if (distRTruck < distRTrans) {
            return hopA;
        } else {
            return hopB;
        }
    }

    private List<HopEntity> calculateRoute(HopEntity aParent, HopEntity bParent) {

        WarehouseEntity warehouseEntity = warehouseRepository.findByLevel(0);

        WarehouseNextHopsEntity aParentNextHop = getParentNextHops(aParent, warehouseEntity);
        WarehouseNextHopsEntity bParentNextHop = getParentNextHops(bParent, warehouseEntity);
        WarehouseEntity aParentWarehouse = getParentWarehouse(aParentNextHop, warehouseEntity);
        WarehouseEntity bParentWarehouse = getParentWarehouse(bParentNextHop, warehouseEntity);
        if (aParentWarehouse == bParentWarehouse) {
            List<HopEntity> commonParent = new ArrayList<>();
            commonParent.add(0,aParent);
            commonParent.add(aParentWarehouse);
            commonParent.add(bParent);
            return commonParent;
        } else {
            List<HopEntity> route = calculateRoute(aParentWarehouse, bParentWarehouse);
            route.add(0, aParent);
            route.add(bParent);
            return route;
        }
    }

    private WarehouseNextHopsEntity getParentNextHops(HopEntity parent, WarehouseEntity warehouseEntity) {


        WarehouseNextHopsEntity nextHops = null;
        for (WarehouseNextHopsEntity nextHop : warehouseEntity.getNextHops()) {
            if (nextHop.getHop().getCode().equals(parent.getCode())) {
                return nextHop;
            } else if (nextHop.getHop().getHopType().equals("warehouse")) {
                nextHops = getParentNextHops(parent, (WarehouseEntity) nextHop.getHop());
                if (nextHops != null) {
                    return nextHops;
                }
            }
        }
        return null;

    }

    private WarehouseEntity getParentWarehouse(WarehouseNextHopsEntity warehouseNextHopsEntity, WarehouseEntity warehouseEntity) {

        WarehouseEntity entity = null;

        for (WarehouseNextHopsEntity nextHop : warehouseEntity.getNextHops()) {
            if (nextHop.getHop().getHopType().equals("warehouse")) {
                if(nextHop.equals(warehouseNextHopsEntity)){
                    return warehouseEntity;
                }else {
                    for (WarehouseNextHopsEntity hop : ((WarehouseEntity) nextHop.getHop()).getNextHops()) {
                        if (hop.equals(warehouseNextHopsEntity)) {
                            return (WarehouseEntity) nextHop.getHop();
                        }
                    }
                }
                entity = getParentWarehouse(warehouseNextHopsEntity, ((WarehouseEntity) nextHop.getHop()));
                if (entity != null) {
                    return entity;
                }
            }
        }
        return null;
    }

    private List<HopArrivalEntity> createFutureHops(List<HopEntity> hops){

        List<HopArrivalEntity> futureHops= new ArrayList<>();
        int process = 0;
        for (HopEntity hop :  hops){
            HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();
            hopArrivalEntity.setCode(hop.getCode());
            hopArrivalEntity.setDescription(hop.getDescription());
            process+=hop.getProcessingDelayMins();
            hopArrivalEntity.setDateTime(OffsetDateTime.now().plusMinutes(process));
            futureHops.add(hopArrivalEntity);
        }
        return futureHops;
    }
    @Override
    public TrackingInformation getParcel(String tracking_id)    {

        HopArrivalMapperImpl hopArrivalMapper = new HopArrivalMapperImpl();
        ParcelEntity parcelEntity = parcelRepository.findByTrackingId(tracking_id);
        TrackingInformation trackingInformation = new TrackingInformation();

        List<HopArrival> hopArrivals = new ArrayList<HopArrival>();
        List<HopArrival> visited = new ArrayList<HopArrival>();
        for (HopArrivalEntity hopArrivalEntity : parcelEntity.getFutureHops()){
            hopArrivals.add(hopArrivalMapper.entityToDto(hopArrivalEntity));
        }
        for (HopArrivalEntity hopArrivalEntity : parcelEntity.getVisitedHops()){
            visited.add(hopArrivalMapper.entityToDto(hopArrivalEntity));
        }
        trackingInformation.setState(parcelEntity.getState());
        trackingInformation.setFutureHops(hopArrivals);
        trackingInformation.setVisitedHops(visited);

        return trackingInformation;
    }

    @Override
    public void reportParcel(String tracking, String code) {
        ParcelEntity parcelEntity = parcelRepository.findByTrackingId(tracking);

        for (HopArrivalEntity hopArrival : parcelEntity.getFutureHops()){
            if(hopArrival.getCode().equals(code)){
                parcelEntity.getFutureHops().remove(hopArrival);
                parcelEntity.getVisitedHops().add(hopArrival);
                switch (hopArrival.getDescription().split(" ")[0]) {
                    case "Warehouse" -> parcelEntity.setState(TrackingInformation.StateEnum.INTRANSPORT);
                    case "Truck" -> parcelEntity.setState(TrackingInformation.StateEnum.INTRUCKDELIVERY);
                    case "Transferwarehouse" ->// TODO: partner url call
                            parcelEntity.setState(TrackingInformation.StateEnum.TRANSFERRED);
                }
             break;
            }
        }
        parcelRepository.save(parcelEntity);
    }

    @Override
    public void reportDelivery(String tracking) {
        ParcelEntity parcelEntity = parcelRepository.findByTrackingId(tracking);

        parcelEntity.setState(TrackingInformation.StateEnum.DELIVERED);
        parcelRepository.save(parcelEntity);
    }
}
