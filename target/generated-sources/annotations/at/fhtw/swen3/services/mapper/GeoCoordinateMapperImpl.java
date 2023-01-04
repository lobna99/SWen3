package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity.GeoCoordinateEntityBuilder;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-04T21:13:37+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class GeoCoordinateMapperImpl implements GeoCoordinateMapper {

    @Override
    public GeoCoordinate entityToDto(GeoCoordinateEntity geoCoordinateEntity) {
        if ( geoCoordinateEntity == null ) {
            return null;
        }

        GeoCoordinate geoCoordinate = new GeoCoordinate();

        geoCoordinate.setLat( geoCoordinateEntity.getLat() );
        geoCoordinate.setLon( geoCoordinateEntity.getLon() );

        return geoCoordinate;
    }

    @Override
    public GeoCoordinateEntity dtoToDto(GeoCoordinate geoCoordinate) {
        if ( geoCoordinate == null ) {
            return null;
        }

        GeoCoordinateEntityBuilder geoCoordinateEntity = GeoCoordinateEntity.builder();

        geoCoordinateEntity.lat( geoCoordinate.getLat() );
        geoCoordinateEntity.lon( geoCoordinate.getLon() );

        return geoCoordinateEntity.build();
    }
}
