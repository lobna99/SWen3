package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.TruckEntity;
import at.fhtw.swen3.services.dto.Truck;
import org.mapstruct.Mapper;

@Mapper
public interface TruckMapper {
    Truck entityToDto(TruckEntity truckEntity);
    TruckEntity dtoToDto(Truck truck);
}
