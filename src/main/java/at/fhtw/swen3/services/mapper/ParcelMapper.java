package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.Parcel;
import at.fhtw.swen3.services.dto.ParcelDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;


@Mapper
public interface ParcelMapper{
    ParcelDTO entityToDto(Parcel parcel);
    Parcel dtoToEntity(ParcelDTO parcelDTO);
}
