package at.fhtw.swen3.persistence.entities;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;

class ParcelEntityTest {

    @Test
    void getTrackingId() {
        ParcelEntity parcelEntity = new ParcelEntity();
        parcelEntity.setTrackingId("HJTH8G6OI");
        assertEquals("HJTH8G6OI", parcelEntity.getTrackingId());
    }

    @Test
    void getWeight() {
        ParcelEntity parcelEntity = new ParcelEntity();
        parcelEntity.setWeight(3.5f);
        assertEquals(3.5f, parcelEntity.getWeight());
    }

    @Test
    void WeightTooLow() { //todo: why does this work?
        ParcelEntity parcelEntity = new ParcelEntity();
        parcelEntity.setWeight(-1.5f);
        assertEquals(-1.5f, parcelEntity.getWeight());
    }

    @Test
    void setRecipent() {
        RecipientEntity recipient = new RecipientEntity();
        recipient.setName("Hans Schneider");
        recipient.setCity("Mödling");
        recipient.setCountry("Austria");
        recipient.setPostalCode("2340");
        assertEquals("Hans Schneider", recipient.getName());
        assertEquals("Mödling", recipient.getCity());
        assertEquals("Austria", recipient.getCountry());
        assertEquals("2340", recipient.getPostalCode());
    }

    @Test
    void getId() {
        ParcelEntity parcelEntity = new ParcelEntity();
        parcelEntity.setId((long)100);
        assertEquals(100, parcelEntity.getId());
    }

    @Test
    void getEmptyList() {
        ParcelEntity parcelEntity = new ParcelEntity();
        assertNull(parcelEntity.getFutureHops());
        assertNull(parcelEntity.getVisitedHops());
    }
}
