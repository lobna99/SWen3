package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.geojson.GeoJsonReader;
import org.locationtech.jts.io.geojson.GeoJsonWriter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(uses = HopMapper.class)
public interface TransferwarehouseMapper {
    TransferwarehouseMapper INSTANCE = Mappers.getMapper(TransferwarehouseMapper.class);

    @Mapping(target = "regionGeoJson",source = "regionGeoJson",qualifiedByName = "mapGeometryToString")
    Transferwarehouse entityToDto(TransferwarehouseEntity transferwarehouseEntity);
    @Mapping(target = "regionGeoJson",source = "regionGeoJson",qualifiedByName = "mapStringToGeometry")
    TransferwarehouseEntity dtoToEntity(Transferwarehouse transferwarehouse);


    @Named("mapStringToGeometry")
    default Geometry mapStringToGeometry(String geoJson) throws ParseException {
        JsonObject jsonObject = new JsonParser().parse(geoJson).getAsJsonObject();

        String geo = jsonObject.getAsJsonObject("geometry").toString();

// Create a new Point GeoJson string using the geometry object
        return new GeoJsonReader().read(geo);
    }

    @Named("mapGeometryToString")
    default String mapGeometryToString(Geometry geometry) {
        return new GeoJsonWriter().write(geometry);
    }
}
