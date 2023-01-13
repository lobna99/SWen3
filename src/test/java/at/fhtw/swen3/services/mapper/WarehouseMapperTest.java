package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.WarehouseEntity;
import at.fhtw.swen3.services.dto.Warehouse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarehouseMapperTest {
    @Test
    public void testEntityToDto() {
        // Create a WarehouseEntity object
        WarehouseEntity entity = new WarehouseEntity();
        entity.setCode("Shj3G");
        entity.setHopType("Warehouse");
        entity.setLocationName("Vienna");

        // Convert the entity to a DTO
        Warehouse dto = WarehouseMapper.INSTANCE.entityToDto(entity);

        // Assert that the properties of the DTO match the properties of the entity
        assertEquals(entity.getCode(), dto.getCode());
        assertEquals(entity.getHopType(), dto.getHopType());
        assertEquals(entity.getLocationName(), dto.getLocationName());
    }

    @Test
    public void testDtoToEntity() {
        // Create a Warehouse DTO
        Warehouse dto = new Warehouse();
        dto.setCode("Shj3G");
        dto.setHopType("Warehouse");
        dto.setLocationName("Vienna");

        // Convert the DTO to an entity
        WarehouseEntity entity = WarehouseMapper.INSTANCE.dtoToEntity(dto);

        // Assert that the properties of the entity match the properties of the DTO
        assertEquals(dto.getCode(), entity.getCode());
        assertEquals(dto.getHopType(), entity.getHopType());
        assertEquals(dto.getLocationName(), entity.getLocationName());
    }


}