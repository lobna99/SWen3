package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity.ParcelEntityBuilder;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity.RecipientEntityBuilder;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-04T21:13:37+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
public class ParcelMapperImpl implements ParcelMapper {

    @Override
    public Parcel entityToDto(ParcelEntity parcelEntity) {
        if ( parcelEntity == null ) {
            return null;
        }

        Parcel parcel = new Parcel();

        parcel.setWeight( parcelEntity.getWeight() );
        parcel.setRecipient( recipientEntityToRecipient( parcelEntity.getRecipient() ) );
        parcel.setSender( recipientEntityToRecipient( parcelEntity.getSender() ) );

        return parcel;
    }

    @Override
    public ParcelEntity dtoToEntity(Parcel parcel) {
        if ( parcel == null ) {
            return null;
        }

        ParcelEntityBuilder parcelEntity = ParcelEntity.builder();

        parcelEntity.weight( parcel.getWeight() );
        parcelEntity.recipient( recipientToRecipientEntity( parcel.getRecipient() ) );
        parcelEntity.sender( recipientToRecipientEntity( parcel.getSender() ) );

        return parcelEntity.build();
    }

    protected Recipient recipientEntityToRecipient(RecipientEntity recipientEntity) {
        if ( recipientEntity == null ) {
            return null;
        }

        Recipient recipient = new Recipient();

        recipient.setName( recipientEntity.getName() );
        recipient.setStreet( recipientEntity.getStreet() );
        recipient.setPostalCode( recipientEntity.getPostalCode() );
        recipient.setCity( recipientEntity.getCity() );
        recipient.setCountry( recipientEntity.getCountry() );

        return recipient;
    }

    protected RecipientEntity recipientToRecipientEntity(Recipient recipient) {
        if ( recipient == null ) {
            return null;
        }

        RecipientEntityBuilder recipientEntity = RecipientEntity.builder();

        recipientEntity.name( recipient.getName() );
        recipientEntity.street( recipient.getStreet() );
        recipientEntity.postalCode( recipient.getPostalCode() );
        recipientEntity.city( recipient.getCity() );
        recipientEntity.country( recipient.getCountry() );

        return recipientEntity.build();
    }
}
