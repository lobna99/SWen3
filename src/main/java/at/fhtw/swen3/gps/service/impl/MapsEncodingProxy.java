package at.fhtw.swen3.gps.service.impl;

import at.fhtw.swen3.gps.HttpRequest;
import at.fhtw.swen3.model.Address;
import at.fhtw.swen3.gps.service.GeoEncodingService;
import at.fhtw.swen3.persistence.entity.GeoCoordinateEntity;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class MapsEncodingProxy implements GeoEncodingService {
    @Override
    public GeoCoordinateEntity encodeAddress(Address a) {

        GeoCoordinateEntity geoCoordinateEntity = new GeoCoordinateEntity();
        try {
            JsonNode obj = HttpRequest.getJsonnode(HttpRequest.getResponse(("https://nominatim.openstreetmap.org/?addressdetails=1&q="+a.getStreet()+" "+a.getPostalCode()+" "+a.getCity()+" "+a.getCountry()+"&format=json").replaceAll(" ","%20")));
            if (obj != null) {
                geoCoordinateEntity.setLat(Double.valueOf(obj.get(0).get("lat").textValue()));
                geoCoordinateEntity.setLon(Double.valueOf(obj.get(0).get("lon").textValue()));
                return geoCoordinateEntity;
            }else{
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
