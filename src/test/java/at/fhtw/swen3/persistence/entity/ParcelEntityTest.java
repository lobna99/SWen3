package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import org.junit.jupiter.api.Test;

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
    void getId() {
        ParcelEntity parcelEntity = new ParcelEntity();
        parcelEntity.setId((long)100);
        assertEquals(100, parcelEntity.getId());
    }
}