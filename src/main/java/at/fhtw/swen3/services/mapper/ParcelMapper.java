package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;
import org.mapstruct.Mapper;


@Mapper
public interface ParcelMapper{
    Parcel entityToDto(ParcelEntity parcelEntity);
    ParcelEntity dtoToEntity(Parcel parcel);
}
