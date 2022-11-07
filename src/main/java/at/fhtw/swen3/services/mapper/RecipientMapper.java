package at.fhtw.swen3.services.mapper;


import at.fhtw.swen3.services.dto.Recipient;
import org.mapstruct.Mapper;

@Mapper
public interface RecipientMapper {
    Recipient entityToDto(at.fhtw.swen3.persistence.entity.Recipient recipient);
    at.fhtw.swen3.persistence.entity.Recipient dtoToEntity(Recipient recipient);
}
