package at.fhtw.swen3.services.mapper;


import at.fhtw.swen3.persistence.entity.Recipient;
import at.fhtw.swen3.services.dto.RecipientDto;
import org.mapstruct.Mapper;

@Mapper
public interface RecipientMapper {
    RecipientDto entityToDto(Recipient recipient);
    Recipient dtoToEntity(RecipientDto recipientDto);
}
