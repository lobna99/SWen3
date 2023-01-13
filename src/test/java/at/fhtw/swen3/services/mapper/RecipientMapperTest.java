package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipientMapperTest {
    @Test
    public void testEntityToDto() {
        // Create a RecipientEntity object
        RecipientEntity entity = new RecipientEntity();
        entity.setName("John Doe");
        entity.setStreet("123 Main St");
        entity.setPostalCode("1020");

        // Convert the entity to a DTO
        Recipient dto = RecipientMapper.INSTANCE.entityToDto(entity);

        // Assert that the properties of the DTO match the properties of the entity
        assertEquals(entity.getName(), dto.getName());
        assertEquals(entity.getStreet(), dto.getStreet());
        assertEquals(entity.getPostalCode(), dto.getPostalCode());
    }

    @Test
    public void testDtoToEntity() {
        // Create a Recipient DTO
        Recipient dto = new Recipient();
        dto.setName("John Doe");
        dto.setStreet("123 Main St");
        dto.setPostalCode("1020");

        // Convert the DTO to an entity
        RecipientEntity entity = RecipientMapper.INSTANCE.dtoToEntity(dto);

        // Assert that the properties of the entity match the properties of the DTO
        assertEquals(dto.getName(), entity.getName());
        assertEquals(dto.getStreet(), entity.getStreet());
        assertEquals(dto.getPostalCode(), entity.getPostalCode());
    }
}