package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.Warehouse;
import at.fhtw.swen3.services.dto.TransferwarehouseDto;
import org.mapstruct.Mapper;

@Mapper
public interface WarehouseMapper {
    TransferwarehouseDto entityToDto(Warehouse warehouse);
    Warehouse dtoToEntity(TransferwarehouseDto transferwarehouseDto);
}
