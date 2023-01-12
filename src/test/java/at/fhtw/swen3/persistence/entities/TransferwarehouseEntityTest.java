package at.fhtw.swen3.persistence.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransferwarehouseEntityTest {

    @Test
    public void testLogisticsPartner() {
        TransferwarehouseEntity entity = new TransferwarehouseEntity();
        String partner = "UPS";
        entity.setLogisticsPartner(partner);
        assertEquals(partner, entity.getLogisticsPartner());
    }

    @Test
    public void testLogisticsPartnerUrl() {
        TransferwarehouseEntity entity = new TransferwarehouseEntity();
        String url = "https://www.ups.com";
        entity.setLogisticsPartnerUrl(url);
        assertEquals(url, entity.getLogisticsPartnerUrl());
    }
}

