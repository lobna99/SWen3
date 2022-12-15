package at.fhtw.swen3.gps.service;

import at.fhtw.swen3.model.Address;
import at.fhtw.swen3.persistence.entity.GeoCoordinateEntity;
import org.locationtech.jts.geom.Geometry;
import org.springframework.stereotype.Service;

@Service
public interface GeoEncodingService {
    GeoCoordinateEntity encodeAddress(Address a);
    Geometry wktToGeometry(String Point);
}
