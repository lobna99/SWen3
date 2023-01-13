package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.services.dto.Hop;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {GeoCoordinateMapper.class})
@DecoratedWith(HopMapperDecorater.class)
public interface HopMapper {
    HopMapper INSTANCE = Mappers.getMapper(HopMapper.class);

    Hop entityToDto(HopEntity hopEntity);
    HopEntity dtoToEntity(Hop hop);
}
