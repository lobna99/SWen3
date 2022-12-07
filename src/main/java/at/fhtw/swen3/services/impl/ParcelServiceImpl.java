package at.fhtw.swen3.services.impl;


import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.persistence.repositories.RecipientRepository;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import at.fhtw.swen3.services.mapper.ParcelMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ParcelServiceImpl implements ParcelService {

    @Autowired
    private final ParcelRepository parcelRepository;

    @Autowired
    private final RecipientRepository recipientRepository;

    @Override
    public void submitNewParcel(Parcel parcel) {

        ParcelMapperImpl parcelMapper = new ParcelMapperImpl();

        ParcelEntity parcelEntity = parcelMapper.dtoToEntity(parcel);

        recipientRepository.save(parcelEntity.getRecipient());
        recipientRepository.save(parcelEntity.getSender());
        parcelRepository.save(parcelEntity);
    }

    @Override
    public Collection<Parcel> getStorage() {
        List<Parcel> parcelDtos = new ArrayList<>();
        List<ParcelEntity> parcelEntities = parcelRepository.findAll();
        ParcelMapperImpl parcelMapper = new ParcelMapperImpl();

        for(ParcelEntity parcelEntity : parcelEntities) {

            parcelDtos.add(parcelMapper.entityToDto(parcelEntity));
        }
        return parcelDtos;
    }
}
