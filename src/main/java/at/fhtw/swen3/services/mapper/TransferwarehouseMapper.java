package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.TransferWarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.mapstruct.Mapper;

@Mapper(uses = HopMapper.class)
public interface TransferwarehouseMapper {
    Transferwarehouse entityToDto(TransferWarehouseEntity transferwarehouseEntity);
    TransferWarehouseEntity dtoToEntity(Transferwarehouse transferwarehouse);
}
