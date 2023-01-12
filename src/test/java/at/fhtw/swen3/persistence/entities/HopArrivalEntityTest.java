package at.fhtw.swen3.persistence.entities;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class HopArrivalEntityTest {

    @Test
    void setCode() {
        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();
        hopArrivalEntity.setCode("ABCD1234");
        assertEquals("ABCD1234", hopArrivalEntity.getCode());
    }

    @Test
    void setDescription() {
        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();
        hopArrivalEntity.setDescription("Test Description");
        assertEquals("Test Description", hopArrivalEntity.getDescription());
    }

    @Test
    void setDateTime() {
        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();
        OffsetDateTime dateTime = OffsetDateTime.now();
        hopArrivalEntity.setDateTime(dateTime);
        assertEquals(dateTime, hopArrivalEntity.getDateTime());

    }
}
