package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.mapstruct.Mapper;

@Mapper
public interface TransferwarehouseMapper {
    Transferwarehouse entityToDto(TransferwarehouseEntity transferwarehouseEntity);
    TransferwarehouseEntity dtoToEntity(Transferwarehouse transferwarehouse);
}
