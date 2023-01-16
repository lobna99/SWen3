package at.fhtw.swen3.unitTests.persistence.entities;

import static org.assertj.core.api.Assertions.assertThat;

import at.fhtw.swen3.persistence.entities.HopEntity;
import at.fhtw.swen3.persistence.entities.WarehouseNextHopsEntity;
import org.junit.Test;

public class WarehouseNextHopsEntityTest {
    @Test
    public void testId() {
        WarehouseNextHopsEntity entity = new WarehouseNextHopsEntity();
        entity.setId(1L);
        assertThat(entity.getId()).isEqualTo(1L);
    }

    @Test
    public void testTraveltimeMins() {
        WarehouseNextHopsEntity entity = new WarehouseNextHopsEntity();
        entity.setTraveltimeMins(60);
        assertThat(entity.getTraveltimeMins()).isEqualTo(60);
    }

    @Test
    public void testHop() {
        WarehouseNextHopsEntity entity = new WarehouseNextHopsEntity();
        HopEntity hop = new HopEntity();
        entity.setHop(hop);
        assertThat(entity.getHop()).isEqualTo(hop);
    }
}