package at.fhtw.swen3.services;

import at.fhtw.swen3.services.dto.Warehouse;
import org.locationtech.jts.io.ParseException;

import java.util.Collection;

public interface WarehouseService {
    Warehouse getWarehouse();
    void importWarehouse(Warehouse warehouse) throws ParseException;
}
