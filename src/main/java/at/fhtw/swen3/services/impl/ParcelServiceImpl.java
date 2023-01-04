package at.fhtw.swen3.services.impl;


import at.fhtw.swen3.gps.service.impl.MapsEncodingProxy;
import at.fhtw.swen3.model.Address;
import at.fhtw.swen3.persistence.entities.GeoCoordinateEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.GeoCoordinateRepository;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.mapper.ParcelMapperImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private final ParcelRepository parcelRepository;

    @Autowired
    private final RecipientRepository recipientRepository;

    private final ParcelMapperImpl parcelMapper = new ParcelMapperImpl();


    @Autowired
    private final GeoCoordinateRepository geoCoordinateRepository;



    @Override
    public String submitNewParcel(Parcel parcel,String id) {

        UUID uuid = UUID.randomUUID();

        MapsEncodingProxy mapsEncodingProxy = new MapsEncodingProxy();

        if(id.equals("")) id = uuid.toString();

        ParcelEntity parcelEntity = parcelMapper.dtoToEntity(parcel);

        parcelEntity.setTrackingId(id);
        parcelEntity.setState(TrackingInformation.StateEnum.PICKUP);
        GeoCoordinateEntity geoCoordinateEntityR=mapsEncodingProxy.encodeAddress(new Address(parcelEntity.getRecipient().getStreet(),parcelEntity.getRecipient().getPostalCode(),parcelEntity.getRecipient().getCity(),parcelEntity.getRecipient().getCountry()));
        GeoCoordinateEntity geoCoordinateEntityS=mapsEncodingProxy.encodeAddress(new Address(parcelEntity.getSender().getStreet(),parcelEntity.getSender().getPostalCode(),parcelEntity.getSender().getCity(),parcelEntity.getSender().getCountry()));

        parcelEntity.getRecipient().setLocationCoordinates(geoCoordinateEntityR);
        parcelEntity.getSender().setLocationCoordinates(geoCoordinateEntityS);

        geoCoordinateRepository.save(geoCoordinateEntityR);
        geoCoordinateRepository.save(geoCoordinateEntityS);
        recipientRepository.save(parcelEntity.getRecipient());
        recipientRepository.save(parcelEntity.getSender());
        parcelRepository.save(parcelEntity);
        log.info("parcel has been submit");

        return parcelEntity.getTrackingId();
    }

    @Override
    public Collection<Parcel> getStorage() {
        List<Parcel> parcelDtos = new ArrayList<>();
        List<ParcelEntity> parcelEntities = parcelRepository.findAll();

        for(ParcelEntity parcelEntity : parcelEntities) {

            parcelDtos.add(parcelMapper.entityToDto(parcelEntity));
        }
        return parcelDtos;
    }
}
