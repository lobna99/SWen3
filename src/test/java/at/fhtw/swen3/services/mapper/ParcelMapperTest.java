package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParcelMapperTest {
    @Test
    public void testEntityToDto() {
        // Create a ParcelEntity object
        ParcelEntity entity = new ParcelEntity();
        entity.setWeight(2.0f);
        entity.setRecipient(new RecipientEntity());
        entity.setSender(new RecipientEntity());

        // Convert the entity to a DTO
        Parcel dto = ParcelMapper.INSTANCE.entityToDto(entity);

        // Assert that the properties of the DTO match the properties of the entity
        assertEquals(entity.getWeight(), dto.getWeight());
        assertEquals(entity.getRecipient().getName(), dto.getRecipient().getName());
        assertEquals(entity.getSender().getName(), dto.getSender().getName());
    }

    @Test
    public void testDtoToEntity() {
        // Create a Parcel DTO
        Parcel dto = new Parcel();
        dto.setWeight(2.0f);
        dto.setRecipient(new Recipient());
        dto.setSender(new Recipient());

        // Convert the DTO to an entity
        ParcelEntity entity = ParcelMapper.INSTANCE.dtoToEntity(dto);

        // Assert that the properties of the entity match the properties of the DTO
        assertEquals(dto.getWeight(), entity.getWeight());
        assertEquals(dto.getRecipient().getName(), entity.getRecipient().getName());
        assertEquals(dto.getSender().getName(), entity.getSender().getName());
    }
}