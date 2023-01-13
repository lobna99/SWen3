package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HopArrivalMapper {

    HopArrivalMapper INSTANCE = Mappers.getMapper(HopArrivalMapper.class);

    HopArrival entityToDto(HopArrivalEntity hopArrivalEntity);
    HopArrivalEntity dtoToEntity(HopArrival hopArrival);
}
