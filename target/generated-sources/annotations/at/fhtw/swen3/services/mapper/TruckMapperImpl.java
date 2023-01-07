package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity.GeoCoordinateEntityBuilder;
import at.fhtw.swen3.persistence.entities.TruckEntity;
import at.fhtw.swen3.persistence.entities.TruckEntity.TruckEntityBuilder;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Truck;
import javax.annotation.processing.Generated;
import org.locationtech.jts.io.ParseException;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-07T02:58:17+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class TruckMapperImpl implements TruckMapper {

    @Override
    public Truck entityToDto(TruckEntity truckEntity) {
        if ( truckEntity == null ) {
            return null;
        }

        Truck truck = new Truck();

        truck.setRegionGeoJson( mapGeometryToString( truckEntity.getRegionGeoJson() ) );
        truck.hopType( truckEntity.getHopType() );
        truck.code( truckEntity.getCode() );
        truck.description( truckEntity.getDescription() );
        truck.processingDelayMins( truckEntity.getProcessingDelayMins() );
        truck.locationName( truckEntity.getLocationName() );
        truck.locationCoordinates( geoCoordinateEntityToGeoCoordinate( truckEntity.getLocationCoordinates() ) );
        truck.setNumberPlate( truckEntity.getNumberPlate() );

        return truck;
    }

    @Override
    public TruckEntity dtoToEntity(Truck truck) {
        if ( truck == null ) {
            return null;
        }

        TruckEntityBuilder<?, ?> truckEntity = TruckEntity.builder();

        try {
            truckEntity.regionGeoJson( mapStringToGeometry( truck.getRegionGeoJson() ) );
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        truckEntity.hopType( truck.getHopType() );
        truckEntity.code( truck.getCode() );
        truckEntity.description( truck.getDescription() );
        truckEntity.processingDelayMins( truck.getProcessingDelayMins() );
        truckEntity.locationName( truck.getLocationName() );
        truckEntity.locationCoordinates( geoCoordinateToGeoCoordinateEntity( truck.getLocationCoordinates() ) );
        truckEntity.numberPlate( truck.getNumberPlate() );

        return truckEntity.build();
    }

    protected GeoCoordinate geoCoordinateEntityToGeoCoordinate(GeoCoordinateEntity geoCoordinateEntity) {
        if ( geoCoordinateEntity == null ) {
            return null;
        }

        GeoCoordinate geoCoordinate = new GeoCoordinate();

        geoCoordinate.setLat( geoCoordinateEntity.getLat() );
        geoCoordinate.setLon( geoCoordinateEntity.getLon() );

        return geoCoordinate;
    }

    protected GeoCoordinateEntity geoCoordinateToGeoCoordinateEntity(GeoCoordinate geoCoordinate) {
        if ( geoCoordinate == null ) {
            return null;
        }

        GeoCoordinateEntityBuilder geoCoordinateEntity = GeoCoordinateEntity.builder();

        geoCoordinateEntity.lat( geoCoordinate.getLat() );
        geoCoordinateEntity.lon( geoCoordinate.getLon() );

        return geoCoordinateEntity.build();
    }
}
