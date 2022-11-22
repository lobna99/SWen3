package at.fhtw.swen3.services;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import at.fhtw.swen3.services.dto.Parcel;
import org.springframework.stereotype.Service;

import java.util.Collection;



public interface ParcelService {

   void submitNewParcel(ParcelEntity parcelEntity);
   Collection<Parcel> getStorage();

}    