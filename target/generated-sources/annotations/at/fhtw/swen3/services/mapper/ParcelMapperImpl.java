package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.Parcel;
import at.fhtw.swen3.services.dto.ParcelDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-19T17:38:11+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class ParcelMapperImpl implements ParcelMapper {

    @Override
    public ParcelDTO entityToDto(Parcel parcel) {
        if ( parcel == null ) {
            return null;
        }

        ParcelDTO parcelDTO = new ParcelDTO();

        return parcelDTO;
    }

    @Override
    public Parcel dtoToEntity(ParcelDTO parcelDTO) {
        if ( parcelDTO == null ) {
            return null;
        }

        Parcel parcel = new Parcel();

        return parcel;
    }
}
