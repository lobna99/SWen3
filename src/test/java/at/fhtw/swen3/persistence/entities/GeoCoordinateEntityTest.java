package at.fhtw.swen3.persistence.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GeoCoordinateEntityTest {

    @Test
    void setCoordinates() {
        GeoCoordinateEntity geo = new GeoCoordinateEntity();
        geo.setLat(48.2089988);
        geo.setLon(16.3449887);
        assertEquals(48.2089988, geo.getLat());
        assertEquals(16.3449887, geo.getLon());
    }
}
