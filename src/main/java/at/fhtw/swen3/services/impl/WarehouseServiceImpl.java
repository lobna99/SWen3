package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.persistence.repositories.*;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.mapper.WarehouseMapperImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final WarehouseNextHopsRepository warehouseNextHopsRepository;

    @Autowired
    private final GeoCoordinateRepository geoCoordinateRepository;


    @Override
    public Warehouse getWarehouse() {
        WarehouseEntity warehouseEntity = warehouseRepository.findByLevel(0);
        WarehouseMapperImpl warehouseMapper = new WarehouseMapperImpl();

        return warehouseMapper.entityToDto(warehouseEntity);

    }

    @Override
    public void importWarehouse(Warehouse warehouse) {

        warehouseRepository.deleteAll();
        transferwarehouseRepository.deleteAll();
        truckRepository.deleteAll();

        WarehouseMapperImpl warehouseMapper = new WarehouseMapperImpl();
        WarehouseEntity warehouseEntity = warehouseMapper.dtoToEntity(warehouse);

        //TODO: exception handling
        try {
        saveAllHops(warehouseEntity.getNextHops());
        geoCoordinateRepository.save(warehouseEntity.getLocationCoordinates());
        warehouseRepository.save(warehouseEntity);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private void saveAllHops(List<WarehouseNextHopsEntity> warehouseNextHopsEntity) throws ParseException {


        for (WarehouseNextHopsEntity warehouseNextHop: warehouseNextHopsEntity){
            switch (warehouseNextHop.getHop().getHopType()) {
                case "warehouse" -> {
                    warehouseNextHop.getHop().getLocationCoordinates().setPoint(new WKTReader().read("POINT (" + warehouseNextHop.getHop().getLocationCoordinates().getLon() + " " + warehouseNextHop.getHop().getLocationCoordinates().getLat() + ")"));
                    geoCoordinateRepository.save(warehouseNextHop.getHop().getLocationCoordinates());
                    saveAllHops(((WarehouseEntity) warehouseNextHop.getHop()).getNextHops());
                }
                case "truck" -> {
                    warehouseNextHop.getHop().getLocationCoordinates().setPoint(new WKTReader().read("POINT (" + warehouseNextHop.getHop().getLocationCoordinates().getLon() + " " + warehouseNextHop.getHop().getLocationCoordinates().getLat() + ")"));
                    geoCoordinateRepository.save(warehouseNextHop.getHop().getLocationCoordinates());
                    truckRepository.save((TruckEntity) warehouseNextHop.getHop());
                }
                case "transferwarehouse" -> {
                    warehouseNextHop.getHop().getLocationCoordinates().setPoint(new WKTReader().read("POINT (" + warehouseNextHop.getHop().getLocationCoordinates().getLon() + " " + warehouseNextHop.getHop().getLocationCoordinates().getLat() + ")"));
                    geoCoordinateRepository.save(warehouseNextHop.getHop().getLocationCoordinates());
                    transferwarehouseRepository.save((TransferwarehouseEntity) warehouseNextHop.getHop());
                }
            }
            warehouseNextHopsRepository.save(warehouseNextHop);

        }

    }


 }
