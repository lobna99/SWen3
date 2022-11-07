package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.WarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.mapstruct.Mapper;

@Mapper
public interface WarehouseMapper {
    Transferwarehouse entityToDto(WarehouseEntity warehouseEntity);
    WarehouseEntity dtoToEntity(Transferwarehouse transferwarehouse);
}
