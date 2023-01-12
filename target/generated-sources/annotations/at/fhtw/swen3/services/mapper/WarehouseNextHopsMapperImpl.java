package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity.WarehouseNextHopsEntityBuilder;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-12T12:46:24+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
public class WarehouseNextHopsMapperImpl implements WarehouseNextHopsMapper {

    private final HopMapper hopMapper = Mappers.getMapper( HopMapper.class );

    @Override
    public WarehouseNextHops entityToDto(WarehouseNextHopsEntity warehouseNextHopsEntity) {
        if ( warehouseNextHopsEntity == null ) {
            return null;
        }

        WarehouseNextHops warehouseNextHops = new WarehouseNextHops();

        warehouseNextHops.setTraveltimeMins( warehouseNextHopsEntity.getTraveltimeMins() );
        warehouseNextHops.setHop( hopMapper.entityToDto( warehouseNextHopsEntity.getHop() ) );

        return warehouseNextHops;
    }

    @Override
    public WarehouseNextHopsEntity dtoToEntity(WarehouseNextHops warehouseNextHops) {
        if ( warehouseNextHops == null ) {
            return null;
        }

        WarehouseNextHopsEntityBuilder warehouseNextHopsEntity = WarehouseNextHopsEntity.builder();

        warehouseNextHopsEntity.traveltimeMins( warehouseNextHops.getTraveltimeMins() );
        warehouseNextHopsEntity.hop( hopMapper.dtoToEntity( warehouseNextHops.getHop() ) );

        return warehouseNextHopsEntity.build();
    }
}
