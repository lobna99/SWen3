package at.fhtw.swen3.unitTests.services.mapper;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.mapper.HopMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HopMapperTest {
    @Test
    public void testEntityToDto() {
        // Create a HopEntity object
        HopEntity entity = new HopEntity();
        entity.setCode("SjGH3");
        entity.setProcessingDelayMins(5);
        entity.setLocationName("Vienna");

        // Convert the entity to a DTO
        Hop dto = HopMapper.INSTANCE.entityToDto(entity);

        // Assert that the properties of the DTO match the properties of the entity
        assertEquals(entity.getCode(), dto.getCode());
        assertEquals(entity.getProcessingDelayMins(), dto.getProcessingDelayMins());
        assertEquals(entity.getLocationName(), dto.getLocationName());
    }

    @Test
    public void testDtoToEntity() {
        // Create a Hop DTO
        Hop dto = new Hop();
        dto.setCode("SjGH3");
        dto.setProcessingDelayMins(5);
        dto.setLocationName("Vienna");

        // Convert the DTO to an entity
        HopEntity entity = HopMapper.INSTANCE.dtoToEntity(dto);

        // Assert that the properties of the entity match the properties of the DTO
        assertEquals(dto.getCode(), entity.getCode());
        assertEquals(dto.getProcessingDelayMins(), entity.getProcessingDelayMins());
        assertEquals(dto.getLocationName(), entity.getLocationName());
    }

}