package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.WarehouseEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import org.mapstruct.Mapper;

@Mapper(uses = HopMapper.class)
public interface WarehouseMapper {
    Warehouse entityToDto(WarehouseEntity warehouseEntity);
    WarehouseEntity dtoToEntity(Warehouse warehouse);
}
