package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.Truck;
import at.fhtw.swen3.services.dto.TruckDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-19T17:38:11+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class TruckMapperImpl implements TruckMapper {

    @Override
    public TruckDto entityToDto(Truck truck) {
        if ( truck == null ) {
            return null;
        }

        TruckDto truckDto = new TruckDto();

        return truckDto;
    }

    @Override
    public Truck dtoToDto(TruckDto truckDto) {
        if ( truckDto == null ) {
            return null;
        }

        Truck truck = new Truck();

        return truck;
    }
}
