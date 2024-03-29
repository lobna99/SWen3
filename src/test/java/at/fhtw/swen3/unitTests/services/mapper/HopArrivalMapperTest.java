package at.fhtw.swen3.unitTests.services.mapper;

import static org.junit.jupiter.api.Assertions.*;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.mapper.HopArrivalMapper;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

public class HopArrivalMapperTest {

   @Test
    void entityToDtoTest() {
        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();
        hopArrivalEntity.setCode("HJTH8G6OI");
        hopArrivalEntity.setDescription("Warehouse 50-1");
        hopArrivalEntity.setDateTime(OffsetDateTime.now());

        // Convert the entity to a DTO
        HopArrival hopArrival = HopArrivalMapper.INSTANCE.entityToDto(hopArrivalEntity);

        assertEquals(hopArrivalEntity.getCode(), hopArrival.getCode());
        assertEquals(hopArrivalEntity.getDescription(), hopArrival.getDescription());
        assertEquals(hopArrivalEntity.getDateTime(), hopArrival.getDateTime());
    }

    @Test
    void dtoToEntityTest() {
        HopArrival hopArrival = new HopArrival();
        hopArrival.setCode("HJTH8G6OI");
        hopArrival.setDescription("Warehouse 50-1");
        hopArrival.setDateTime(OffsetDateTime.now());

        // Convert the DTO to an entity
        HopArrivalEntity hopArrivalEntity = HopArrivalMapper.INSTANCE.dtoToEntity(hopArrival);


        assertEquals(hopArrival.getCode(), hopArrivalEntity.getCode());
        assertEquals(hopArrival.getDescription(), hopArrivalEntity.getDescription());
        assertEquals(hopArrival.getDateTime(), hopArrivalEntity.getDateTime());
    }

}
