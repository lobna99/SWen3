package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-22T13:46:16+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
public class TransferwarehouseMapperImpl implements TransferwarehouseMapper {

    @Override
    public Transferwarehouse entityToDto(TransferwarehouseEntity transferwarehouseEntity) {
        if ( transferwarehouseEntity == null ) {
            return null;
        }

        Transferwarehouse transferwarehouse = new Transferwarehouse();

        return transferwarehouse;
    }

    @Override
    public TransferwarehouseEntity dtoToEntity(Transferwarehouse transferwarehouse) {
        if ( transferwarehouse == null ) {
            return null;
        }

        TransferwarehouseEntity transferwarehouseEntity = new TransferwarehouseEntity();

        return transferwarehouseEntity;
    }
}
