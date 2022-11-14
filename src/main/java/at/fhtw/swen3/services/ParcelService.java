package at.fhtw.swen3.services;

import at.fhtw.swen3.services.dto.Parcel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
public class ParcelService {


    private final ParcelLogic parcelLogic;

    public String getStorage(Parcel parcel) {
        return parcelLogic.getStorage(parcel);
    }
}    