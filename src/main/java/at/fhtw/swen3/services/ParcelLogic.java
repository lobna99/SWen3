package at.fhtw.swen3.services;


import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.dto.Parcel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ParcelLogic {

    public String getStorage(Parcel parcel) {
        //TODO: logic for get storage
        return null;
    }
}
