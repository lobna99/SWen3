package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entity.Recipient;
import at.fhtw.swen3.services.dto.RecipientDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-24T14:15:24+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class RecipientMapperImpl implements RecipientMapper {

    @Override
    public RecipientDto entityToDto(Recipient recipient) {
        if ( recipient == null ) {
            return null;
        }

        RecipientDto recipientDto = new RecipientDto();

        return recipientDto;
    }

    @Override
    public Recipient dtoToEntity(RecipientDto recipientDto) {
        if ( recipientDto == null ) {
            return null;
        }

        Recipient recipient = new Recipient();

        return recipient;
    }
}
