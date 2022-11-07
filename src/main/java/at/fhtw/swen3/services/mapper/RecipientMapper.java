package at.fhtw.swen3.services.mapper;


import at.fhtw.swen3.persistence.entity.RecipientEntity;
import at.fhtw.swen3.services.dto.Recipient;
import org.mapstruct.Mapper;

@Mapper
public interface RecipientMapper {
    Recipient entityToDto(RecipientEntity recipientEntity);
    RecipientEntity dtoToEntity(Recipient recipient);
}
