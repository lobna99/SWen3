package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.services.dto.Parcel;
import org.mapstruct.Mapper;


@Mapper
public interface ParcelMapper{
    Parcel entityToDto(at.fhtw.swen3.persistence.entity.Parcel parcel);
    at.fhtw.swen3.persistence.entity.Parcel dtoToEntity(Parcel parcel);
}
