package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;
import org.mapstruct.Mapper;


@Mapper
public interface ParcelMapper{
    Parcel entityToDto(ParcelEntity parcelEntity);
    ParcelEntity dtoToEntity(Parcel parcel);
}
