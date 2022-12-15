package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.*;
import at.fhtw.swen3.services.dto.*;
import lombok.Getter;


import java.util.ArrayList;
import java.util.List;

@Getter
public class WarehouseMapperConverter {

    private final WarehouseMapperImpl warehouseMapper = new WarehouseMapperImpl();
    private final TruckMapperImpl truckMapper = new TruckMapperImpl();
    private final TransferwarehouseMapperImpl transferwarehouseMapper = new TransferwarehouseMapperImpl();



    public WarehouseEntity convert(Warehouse source) {
        WarehouseEntity target = new WarehouseEntity();
        target.setHopType(source.getHopType());
        target.setCode(source.getCode());
        target.setDescription(source.getDescription());
        target.setProcessingDelayMins(source.getProcessingDelayMins());
        target.setLocationName(source.getLocationName());
        target.setLevel(source.getLevel());
        target.setLocationCoordinates( geoCoordinateToGeoCoordinateEntity (source.getLocationCoordinates()));
        target.setNextHops(convertNextHops(source.getNextHops()));

        return target;
    }

    private List<WarehouseNextHopsEntity> convertNextHops(List<WarehouseNextHops> sourceNextHops) {
        // Convert each WarehouseNextHopsEntity in the source list to a WarehouseNextHops object,
        // and add it to the target list.
        List<WarehouseNextHopsEntity> warehouseNextHopsEntities = new ArrayList<>();

        for (WarehouseNextHops hop : sourceNextHops) {


            switch (hop.getHop().getHopType()) {
                case "warehouse":
                    List<WarehouseNextHops> nextHops = ((Warehouse) hop.getHop()).getNextHops();
                    //warehouseNextHopsEntities.add(new WarehouseNextHopsEntity(null, hop.getTraveltimeMins(), warehouseMapper.dtoToEntity((Warehouse) hop.getHop())));
                    Warehouse warehouse = (Warehouse) hop.getHop();
                    WarehouseEntity warehouseEntity = convert(warehouse);
                    warehouseNextHopsEntities.add(new WarehouseNextHopsEntity(null, hop.getTraveltimeMins(),warehouseEntity));
                    break;
                case "truck":
                    TruckEntity truckEntity = truckMapper.dtoToEntity((Truck) hop.getHop());
                    warehouseNextHopsEntities.add(new WarehouseNextHopsEntity(null, hop.getTraveltimeMins(),truckEntity));
                    break;
                case "transferwarehouse":
                    TransferWarehouseEntity transferWarehouseEntity = transferwarehouseMapper.dtoToEntity((Transferwarehouse) hop.getHop());
                    warehouseNextHopsEntities.add(new WarehouseNextHopsEntity(null, hop.getTraveltimeMins(),transferWarehouseEntity ));
                    break;

            }
        }
        return warehouseNextHopsEntities;
    }

    protected GeoCoordinateEntity geoCoordinateToGeoCoordinateEntity(GeoCoordinate geoCoordinate) {
        if ( geoCoordinate == null ) {
            return null;
        }

        GeoCoordinateEntity.GeoCoordinateEntityBuilder geoCoordinateEntity = GeoCoordinateEntity.builder();

        geoCoordinateEntity.lat( geoCoordinate.getLat() );
        geoCoordinateEntity.lon( geoCoordinate.getLon() );

        return geoCoordinateEntity.build();
    }

}
