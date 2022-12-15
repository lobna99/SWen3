package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entity.TransferWarehouseEntity;
import at.fhtw.swen3.persistence.entity.TruckEntity;
import at.fhtw.swen3.persistence.entity.WarehouseEntity;
import at.fhtw.swen3.persistence.entity.WarehouseNextHopsEntity;
import at.fhtw.swen3.persistence.repositories.*;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.mapper.WarehouseMapperConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private final WarehouseRepository warehouseRepository;

    @Autowired
    private final TruckRepository truckRepository;

    @Autowired
    private final TransferwarehouseRepository transferwarehouseRepository;

    @Autowired
    private final GeoCoordinateRepository geoCoordinateRepository;


    @Override
    public Warehouse getWarehouse() {
/*        List<Warehouse> warehouseList = new ArrayList<>();
        List<WarehouseEntity> warehouseEntities = warehouseRepository.findAll();
        WarehouseMapperImpl warehouseMapper = new WarehouseMapperImpl();

        for (WarehouseEntity warehouseEntity : warehouseEntities){
            warehouseList.add(warehouseMapper.entityToDto(warehouseEntity));
        }

        return warehouseList.get(0);*/
        return null;
    }

    @Override
    public void importWarehouse(Warehouse warehouse) {

        warehouseRepository.deleteAll();
        transferwarehouseRepository.deleteAll();
        truckRepository.deleteAll();
        geoCoordinateRepository.deleteAll();

        WarehouseMapperConverter warehouseMapperConverter = new WarehouseMapperConverter();


        WarehouseEntity warehouseEntity = warehouseMapperConverter.convert(warehouse);

        //TODO: exception handling
        try {
        warehouseEntity.getLocationCoordinates().setPoint((Point) new WKTReader().read("POINT ("+warehouseEntity.getLocationCoordinates().getLon()+" "+warehouseEntity.getLocationCoordinates().getLat()+")"));
        geoCoordinateRepository.save(warehouseEntity.getLocationCoordinates());
        warehouseRepository.save(warehouseEntity);
            saveAllHops(warehouseEntity.getNextHops());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private void saveAllHops(List<WarehouseNextHopsEntity> warehouseNextHopsEntity) throws ParseException {

        for (WarehouseNextHopsEntity warehouseNextHops: warehouseNextHopsEntity){

            switch (warehouseNextHops.getHop().getHopType()){
                case "warehouse":
                    warehouseNextHops.getHop().getLocationCoordinates().setPoint((Point) new WKTReader().read("POINT ("+warehouseNextHops.getHop().getLocationCoordinates().getLon()+" "+warehouseNextHops.getHop().getLocationCoordinates().getLat()+")"));
                    geoCoordinateRepository.save(warehouseNextHops.getHop().getLocationCoordinates());
                    warehouseRepository.save((WarehouseEntity) warehouseNextHops.getHop());
                    saveAllHops(((WarehouseEntity) warehouseNextHops.getHop()).getNextHops());
                    break;
                case "truck":
                    warehouseNextHops.getHop().getLocationCoordinates().setPoint((Point) new WKTReader().read("POINT ("+warehouseNextHops.getHop().getLocationCoordinates().getLon()+" "+warehouseNextHops.getHop().getLocationCoordinates().getLat()+")"));
                    geoCoordinateRepository.save(warehouseNextHops.getHop().getLocationCoordinates());
                    truckRepository.save((TruckEntity) warehouseNextHops.getHop());
                    break;
                case "transferwarehouse":
                    warehouseNextHops.getHop().getLocationCoordinates().setPoint((Point) new WKTReader().read("POINT ("+warehouseNextHops.getHop().getLocationCoordinates().getLon()+" "+warehouseNextHops.getHop().getLocationCoordinates().getLat()+")"));
                    geoCoordinateRepository.save(warehouseNextHops.getHop().getLocationCoordinates());
                    transferwarehouseRepository.save((TransferWarehouseEntity) warehouseNextHops.getHop());
                    break;
            }

        }

    }




 }
