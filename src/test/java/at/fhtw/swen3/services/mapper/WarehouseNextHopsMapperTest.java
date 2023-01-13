package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.WarehouseNextHops;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarehouseNextHopsMapperTest {
    @Test
    public void testEntityToDto() {
        // Create a WarehouseNextHopsEntity object
        WarehouseNextHopsEntity entity = new WarehouseNextHopsEntity();
        entity.setTraveltimeMins(10);

        // Convert the entity to a DTO
        WarehouseNextHops dto = WarehouseNextHopsMapper.INSTANCE.entityToDto(entity);

        // Assert that the properties of the DTO match the properties of the entity
        assertEquals(entity.getTraveltimeMins(), dto.getTraveltimeMins());
    }

    @Test
    public void testDtoToEntity() {
        // Create a WarehouseNextHops DTO
        WarehouseNextHops dto = new WarehouseNextHops();
        dto.setTraveltimeMins(60);

        // Convert the DTO to an entity
        WarehouseNextHopsEntity entity = WarehouseNextHopsMapper.INSTANCE.dtoToEntity(dto);

        // Assert that the properties of the entity match the properties of the DTO
        assertEquals(dto.getTraveltimeMins(), entity.getTraveltimeMins());
    }
}