package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ParcelMapper{
    ParcelMapper INSTANCE = Mappers.getMapper(ParcelMapper.class);

    Parcel entityToDto(ParcelEntity parcelEntity);
    ParcelEntity dtoToEntity(Parcel parcel);
}
