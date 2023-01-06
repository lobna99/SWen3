package at.fhtw.swen3.configuration;

import at.fhtw.swen3.persistence.repositories.*;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.impl.ParcelServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ParcelServiceImpl parcelService(ParcelRepository parcelRepository, RecipientRepository recipientRepository, GeoCoordinateRepository geoCoordinateRepository, WarehouseRepository warehouseRepository, TruckRepository truckRepository,TransferwarehouseRepository transferwarehouseRepository) {
        return new ParcelServiceImpl(parcelRepository,recipientRepository,geoCoordinateRepository,warehouseRepository,truckRepository,transferwarehouseRepository);
    }

}