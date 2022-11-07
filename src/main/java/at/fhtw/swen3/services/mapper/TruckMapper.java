package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.services.dto.Truck;
import org.mapstruct.Mapper;

@Mapper
public interface TruckMapper {
    Truck entityToDto(at.fhtw.swen3.persistence.entity.Truck truck);
    at.fhtw.swen3.persistence.entity.Truck dtoToDto(Truck truck);
}
