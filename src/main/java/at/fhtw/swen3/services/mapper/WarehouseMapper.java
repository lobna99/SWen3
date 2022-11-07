package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.Warehouse;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.mapstruct.Mapper;

@Mapper
public interface WarehouseMapper {
    Transferwarehouse entityToDto(Warehouse warehouse);
    Warehouse dtoToEntity(Transferwarehouse transferwarehouse);
}
