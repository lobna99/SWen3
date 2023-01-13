package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.persistence.entities.WarehouseEntity.WarehouseEntityBuilder;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-12T23:19:50+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
public class WarehouseMapperImpl implements WarehouseMapper {

    private final GeoCoordinateMapper geoCoordinateMapper = Mappers.getMapper( GeoCoordinateMapper.class );
    private final WarehouseNextHopsMapper warehouseNextHopsMapper = Mappers.getMapper( WarehouseNextHopsMapper.class );

    @Override
    public Warehouse entityToDto(WarehouseEntity warehouseEntity) {
        if ( warehouseEntity == null ) {
            return null;
        }

        Warehouse warehouse = new Warehouse();

        warehouse.hopType( warehouseEntity.getHopType() );
        warehouse.code( warehouseEntity.getCode() );
        warehouse.description( warehouseEntity.getDescription() );
        warehouse.processingDelayMins( warehouseEntity.getProcessingDelayMins() );
        warehouse.locationName( warehouseEntity.getLocationName() );
        warehouse.locationCoordinates( geoCoordinateMapper.entityToDto( warehouseEntity.getLocationCoordinates() ) );
        warehouse.setLevel( warehouseEntity.getLevel() );
        warehouse.setNextHops( warehouseNextHopsEntityListToWarehouseNextHopsList( warehouseEntity.getNextHops() ) );

        return warehouse;
    }

    @Override
    public WarehouseEntity dtoToEntity(Warehouse warehouse) {
        if ( warehouse == null ) {
            return null;
        }

        WarehouseEntityBuilder<?, ?> warehouseEntity = WarehouseEntity.builder();

        warehouseEntity.hopType( warehouse.getHopType() );
        warehouseEntity.code( warehouse.getCode() );
        warehouseEntity.description( warehouse.getDescription() );
        warehouseEntity.processingDelayMins( warehouse.getProcessingDelayMins() );
        warehouseEntity.locationName( warehouse.getLocationName() );
        warehouseEntity.locationCoordinates( geoCoordinateMapper.dtoToDto( warehouse.getLocationCoordinates() ) );
        warehouseEntity.level( warehouse.getLevel() );
        warehouseEntity.nextHops( warehouseNextHopsListToWarehouseNextHopsEntityList( warehouse.getNextHops() ) );

        return warehouseEntity.build();
    }

    protected List<WarehouseNextHops> warehouseNextHopsEntityListToWarehouseNextHopsList(List<WarehouseNextHopsEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<WarehouseNextHops> list1 = new ArrayList<WarehouseNextHops>( list.size() );
        for ( WarehouseNextHopsEntity warehouseNextHopsEntity : list ) {
            list1.add( warehouseNextHopsMapper.entityToDto( warehouseNextHopsEntity ) );
        }

        return list1;
    }

    protected List<WarehouseNextHopsEntity> warehouseNextHopsListToWarehouseNextHopsEntityList(List<WarehouseNextHops> list) {
        if ( list == null ) {
            return null;
        }

        List<WarehouseNextHopsEntity> list1 = new ArrayList<WarehouseNextHopsEntity>( list.size() );
        for ( WarehouseNextHops warehouseNextHops : list ) {
            list1.add( warehouseNextHopsMapper.dtoToEntity( warehouseNextHops ) );
        }

        return list1;
    }
}
