package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.gps.HttpRequest;
import at.fhtw.swen3.model.Address;
import at.fhtw.swen3.gps.service.GeoEncodingService;
import at.fhtw.swen3.persistence.entity.GeoCoordinateEntity;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Objects;

@Slf4j
public class MapsEncodingProxy implements GeoEncodingService {
    @Override
    public GeoCoordinateEntity encodeAddress(Address a) {

        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity();
        try {
            JsonNode obj = Objects.requireNonNull(HttpRequest.getJsonnode(HttpRequest.getResponse(("https://nominatim.openstreetmap.org/?addressdetails=1&q=" + a.getStreet() + " " + a.getPostalCode() + " " + a.getCity() + " " + a.getCountry() + "&format=json&limit=1").replaceAll(" ", "%20")))).get(0);
            if (obj != null) {
                geoCoordinateEntity.setLat(Double.valueOf(obj.get("lat").textValue()));
                geoCoordinateEntity.setLon(Double.valueOf(obj.get("lon").textValue()));
                log.info("Geo coordinated have been found");
                return geoCoordinateEntity;
            }else{
                log.info("no geo coordinates found");
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
