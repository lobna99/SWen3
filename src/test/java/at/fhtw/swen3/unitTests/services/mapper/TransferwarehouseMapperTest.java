package at.fhtw.swen3.unitTests.services.mapper;

import at.fhtw.swen3.persistence.entities.TransferwarehouseEntity;
import at.fhtw.swen3.services.dto.Transferwarehouse;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferwarehouseMapperTest {
    /*@Test
    public void testEntityToDto() throws ParseException {
        // Create a TransferwarehouseEntity object
        TransferwarehouseEntity entity = new TransferwarehouseEntity();
        entity.setLogisticsPartner("FHTW");
        entity.setLogisticsPartnerUrl("technikum-wien.at");

        // Convert the entity to a DTO
        Transferwarehouse dto = TransferwarehouseMapper.INSTANCE.entityToDto(entity);

        // Assert that the properties of the DTO match the properties of the entity
        assertEquals(entity.getLogisticsPartner(), dto.getLogisticsPartner());
        assertEquals(entity.getLogisticsPartnerUrl(), dto.getLogisticsPartnerUrl());
    }

    @Test
    public void testDtoToEntity() throws ParseException {
        // Create a Transferwarehouse DTO
        Transferwarehouse dto = new Transferwarehouse();
        dto.setLogisticsPartner("FHTW");
        dto.setLogisticsPartnerUrl("technikum-wien.at");

        // Convert the DTO to an entity
        TransferwarehouseEntity entity = TransferwarehouseMapper.INSTANCE.dtoToEntity(dto);

        // Assert that the properties of the entity match the properties of the DTO
        assertEquals(dto.getLogisticsPartner(), entity.getLogisticsPartner());
        assertEquals(dto.getLogisticsPartnerUrl(), entity.getLogisticsPartnerUrl());
    }

     */

}