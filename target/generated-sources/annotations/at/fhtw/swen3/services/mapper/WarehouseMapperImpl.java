package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.Warehouse;
import at.fhtw.swen3.services.dto.TransferwarehouseDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-24T14:15:24+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class WarehouseMapperImpl implements WarehouseMapper {

    @Override
    public TransferwarehouseDto entityToDto(Warehouse warehouse) {
        if ( warehouse == null ) {
            return null;
        }

        TransferwarehouseDto transferwarehouseDto = new TransferwarehouseDto();

        return transferwarehouseDto;
    }

    @Override
    public Warehouse dtoToEntity(TransferwarehouseDto transferwarehouseDto) {
        if ( transferwarehouseDto == null ) {
            return null;
        }

        Warehouse warehouse = new Warehouse();

        return warehouse;
    }
}
