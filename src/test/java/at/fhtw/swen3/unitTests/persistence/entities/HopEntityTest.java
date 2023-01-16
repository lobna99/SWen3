package at.fhtw.swen3.unitTests.persistence.entities;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.HopEntity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HopEntityTest {

    @Test
    public void testSetId() {
        HopEntity hop = new HopEntity();
        hop.setId(1L);
        assertEquals(1L, hop.getId());
    }

    @Test
    public void testSetHopType() {
        HopEntity hop = new HopEntity();
        hop.setHopType("Pellet");
        assertEquals("Pellet", hop.getHopType());
    }

    @Test
    public void testSetCode() {
        HopEntity hop = new HopEntity();
        hop.setCode("ABCD1234");
        assertEquals("ABCD1234", hop.getCode());
    }


    @Test
    public void testSetDescription() {
        HopEntity hop = new HopEntity();
        hop.setDescription("This is a test hop");
        assertEquals("This is a test hop", hop.getDescription());
    }


    @Test
    public void testSetProcessingDelayMins() {
        HopEntity hop = new HopEntity();
        hop.setProcessingDelayMins(60);
        assertEquals(60, hop.getProcessingDelayMins());
    }

    @Test
    public void testSetLocationName() {
        HopEntity hop = new HopEntity();
        hop.setLocationName("Test Location");
        assertEquals("Test Location", hop.getLocationName());
    }

    @Test
    public void testSetLocationCoordinates() {
        HopEntity hop = new HopEntity();
        GeoCoordinateEntity coordinates = new GeoCoordinateEntity();
        hop.setLocationCoordinates(coordinates);
        assertEquals(coordinates, hop.getLocationCoordinates());
    }
}
