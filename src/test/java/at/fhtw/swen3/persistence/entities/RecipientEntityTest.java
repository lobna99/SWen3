package at.fhtw.swen3.persistence.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipientEntityTest {
    @Test
    public void testSetId() {
        RecipientEntity recipient = new RecipientEntity();
        recipient.setId(1L);
        assertEquals(1L, recipient.getId());
    }

    @Test
    public void testSetName() {
        RecipientEntity recipient = new RecipientEntity();
        recipient.setName("John Doe");
        assertEquals("John Doe", recipient.getName());
    }

    @Test
    public void testSetStreet() {
        RecipientEntity recipient = new RecipientEntity();
        recipient.setStreet("123 Main St");
        assertEquals("123 Main St", recipient.getStreet());
    }

    @Test
    public void testSetPostalCode() {
        RecipientEntity recipient = new RecipientEntity();
        recipient.setPostalCode("A-1234");
        assertEquals("A-1234", recipient.getPostalCode());
    }

    @Test
    public void testSetCity() {
        RecipientEntity recipient = new RecipientEntity();
        recipient.setCity("Test City");
        assertEquals("Test City", recipient.getCity());
    }

    @Test
    public void testSetCountry() {
        RecipientEntity recipient = new RecipientEntity();
        recipient.setCountry("Test Country");
        assertEquals("Test Country", recipient.getCountry());
    }

    @Test
    public void testSetLocationCoordinates() {
        RecipientEntity recipient = new RecipientEntity();
        GeoCoordinateEntity coordinates = new GeoCoordinateEntity();
        recipient.setLocationCoordinates(coordinates);
        assertEquals(coordinates, recipient.getLocationCoordinates());
    }
}
