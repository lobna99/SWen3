package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.Truck;
import at.fhtw.swen3.services.dto.TruckDto;
import org.mapstruct.Mapper;

@Mapper
public interface TruckMapper {
    TruckDto entityToDto(Truck truck);
    Truck dtoToDto(TruckDto truckDto);
}
