package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.HopArrivalEntity;
import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.mapper.HopArrivalMapperImpl;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;


public class HopArrivalMapperTest {

  /*  @Test
    void entityToDtoTest() {
        HopArrivalEntity hopArrivalEntity = new HopArrivalEntity();
        hopArrivalEntity.setCode("HJTH8G6OI");
        hopArrivalEntity.setDescription("Warehouse 50-1");
        hopArrivalEntity.setDateTime(OffsetDateTime.now());

        HopArrivalMapperImpl hopArrivalMapper = new HopArrivalMapperImpl();
        HopArrival hopArrival = hopArrivalMapper.entityToDto(hopArrivalEntity);

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

        HopArrivalMapperImpl hopArrivalMapper = new HopArrivalMapperImpl();
        HopArrivalEntity hopArrivalEntity = hopArrivalMapper.dtoToEntity(hopArrival);

        assertEquals(hopArrival.getCode(), hopArrivalEntity.getCode());
        assertEquals(hopArrival.getDescription(), hopArrivalEntity.getDescription());
        assertEquals(hopArrival.getDateTime(), hopArrivalEntity.getDateTime());
    }*/

}
