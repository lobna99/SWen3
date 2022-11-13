package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.WarehouseEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-13T23:31:09+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class WarehouseMapperImpl implements WarehouseMapper {

    @Override
    public Warehouse entityToDto(WarehouseEntity warehouseEntity) {
        if ( warehouseEntity == null ) {
            return null;
        }

        Warehouse warehouse = new Warehouse();

        return warehouse;
    }

    @Override
    public WarehouseEntity dtoToEntity(Warehouse warehouse) {
        if ( warehouse == null ) {
            return null;
        }

        WarehouseEntity warehouseEntity = new WarehouseEntity();

        return warehouseEntity;
    }
}
