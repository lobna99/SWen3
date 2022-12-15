package at.fhtw.swen3.persistence.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseEntityTest {

    @Test
    void getCode() {
        WarehouseEntity warehouseEntity = new WarehouseEntity();
        warehouseEntity.setCode("Warehouse 12");
        assertEquals("Warehouse 12", warehouseEntity.getCode());
    }

    @Test
    void getDescription() {
        WarehouseEntity warehouseEntity = new WarehouseEntity();
        warehouseEntity.setDescription("this is a warehouse");
        assertEquals("this is a warehouse", warehouseEntity.getDescription());
    }

    @Test
    void getId() {
        WarehouseEntity warehouseEntity = new WarehouseEntity();
        warehouseEntity.setId((long)10);
        assertEquals(10, warehouseEntity.getId());
    }

    @Test
    void getRequest() {
        WarehouseEntity warehouseEntity = new WarehouseEntity();
        warehouseEntity.setLocationName("Vienna");
        assertEquals("Vienna", warehouseEntity.getLocationName());
    }
}