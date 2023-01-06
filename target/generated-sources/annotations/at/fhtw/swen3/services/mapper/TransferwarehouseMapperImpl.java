package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity.GeoCoordinateEntityBuilder;
import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity.TransferwarehouseEntityBuilder;
import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import javax.annotation.processing.Generated;
import org.locationtech.jts.io.ParseException;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-05T16:25:58+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class TransferwarehouseMapperImpl implements TransferwarehouseMapper {

    @Override
    public Transferwarehouse entityToDto(TransferwarehouseEntity transferwarehouseEntity) {
        if ( transferwarehouseEntity == null ) {
            return null;
        }

        Transferwarehouse transferwarehouse = new Transferwarehouse();

        transferwarehouse.setRegionGeoJson( mapGeometryToString( transferwarehouseEntity.getRegionGeoJson() ) );
        transferwarehouse.hopType( transferwarehouseEntity.getHopType() );
        transferwarehouse.code( transferwarehouseEntity.getCode() );
        transferwarehouse.description( transferwarehouseEntity.getDescription() );
        transferwarehouse.processingDelayMins( transferwarehouseEntity.getProcessingDelayMins() );
        transferwarehouse.locationName( transferwarehouseEntity.getLocationName() );
        transferwarehouse.locationCoordinates( geoCoordinateEntityToGeoCoordinate( transferwarehouseEntity.getLocationCoordinates() ) );
        transferwarehouse.setLogisticsPartner( transferwarehouseEntity.getLogisticsPartner() );
        transferwarehouse.setLogisticsPartnerUrl( transferwarehouseEntity.getLogisticsPartnerUrl() );

        return transferwarehouse;
    }

    @Override
    public TransferwarehouseEntity dtoToEntity(Transferwarehouse transferwarehouse) {
        if ( transferwarehouse == null ) {
            return null;
        }

        TransferwarehouseEntityBuilder<?, ?> transferwarehouseEntity = TransferwarehouseEntity.builder();

        try {
            transferwarehouseEntity.regionGeoJson( mapStringToGeometry( transferwarehouse.getRegionGeoJson() ) );
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        transferwarehouseEntity.hopType( transferwarehouse.getHopType() );
        transferwarehouseEntity.code( transferwarehouse.getCode() );
        transferwarehouseEntity.description( transferwarehouse.getDescription() );
        transferwarehouseEntity.processingDelayMins( transferwarehouse.getProcessingDelayMins() );
        transferwarehouseEntity.locationName( transferwarehouse.getLocationName() );
        transferwarehouseEntity.locationCoordinates( geoCoordinateToGeoCoordinateEntity( transferwarehouse.getLocationCoordinates() ) );
        transferwarehouseEntity.logisticsPartner( transferwarehouse.getLogisticsPartner() );
        transferwarehouseEntity.logisticsPartnerUrl( transferwarehouse.getLogisticsPartnerUrl() );

        return transferwarehouseEntity.build();
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
