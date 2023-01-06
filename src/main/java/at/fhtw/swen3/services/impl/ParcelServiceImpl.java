package at.fhtw.swen3.services.impl;


import at.fhtw.swen3.gps.service.impl.MapsEncodingProxy;
import at.fhtw.swen3.model.Address;
import at.fhtw.swen3.persistence.entities.*;
import at.fhtw.swen3.persistence.repositories.*;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.mapper.ParcelMapperImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
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
    private final TransferwarehouseRepository transferwarehouseRepository;


    @Override
    public String submitNewParcel(Parcel parcel, String id) {

        UUID uuid = UUID.randomUUID();

        MapsEncodingProxy mapsEncodingProxy = new MapsEncodingProxy();

        if (id.equals("")) id = uuid.toString();

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
        List<TruckEntity> hops = truckRepository.getClosestHop(recp_id);
        List<TransferwarehouseEntity> transferwarehouseEntities = transferwarehouseRepository.getClosestHop(recp_id);
        Long send_id = recipientRepository.save(parcelEntity.getSender()).getId();
        List<TruckEntity> s_hops = truckRepository.getClosestHop(send_id);
        List<TransferwarehouseEntity> s_transferwarehouseEntities = transferwarehouseRepository.getClosestHop(send_id);
        parcelRepository.save(parcelEntity);
        List<HopEntity> routehops = calculateRoute(hops.get(0), s_hops.get(0));
        log.info("parcel has been submit");
        return parcelEntity.getTrackingId();
    }

    private List<HopEntity> calculateRoute(HopEntity aParent, HopEntity bParent) {
        WarehouseEntity warehouseEntity = warehouseRepository.findByLevel(0);

        WarehouseNextHopsEntity aParentNextHop = getParentNextHops(aParent, warehouseEntity);
        WarehouseNextHopsEntity bParentNextHop = getParentNextHops(bParent, warehouseEntity);
        WarehouseEntity aParentWarehouse = getParentWarehouse(aParentNextHop, warehouseEntity);
        WarehouseEntity bParentWarehouse = getParentWarehouse(bParentNextHop, warehouseEntity);
        if (aParentWarehouse == bParentWarehouse) {
            List<HopEntity> commonParent = new ArrayList<>();
            commonParent.add(aParentWarehouse);
            return commonParent;
        } else {
            List<HopEntity> route = calculateRoute(aParentWarehouse, bParentWarehouse);
            route.add(0, aParentWarehouse);
            route.add(bParentWarehouse);
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
                for (WarehouseNextHopsEntity hop : ((WarehouseEntity) nextHop.getHop()).getNextHops()) {
                    if (hop.equals(warehouseNextHopsEntity)) {
                        return (WarehouseEntity) nextHop.getHop();
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

    @Override
    public Collection<Parcel> getStorage() {
        List<Parcel> parcelDtos = new ArrayList<>();
        List<ParcelEntity> parcelEntities = parcelRepository.findAll();

        for (ParcelEntity parcelEntity : parcelEntities) {

            parcelDtos.add(parcelMapper.entityToDto(parcelEntity));
        }
        return parcelDtos;
    }
}
