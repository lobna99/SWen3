package at.fhtw.swen3.services.mapper;


import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GeoCoordinateMapper {
    GeoCoordinate INSTANCE = Mappers.getMapper(GeoCoordinate.class);

    GeoCoordinate entityToDto(GeoCoordinateEntity geoCoordinateEntity);
    GeoCoordinateEntity dtoToDto(GeoCoordinate geoCoordinate);
}
