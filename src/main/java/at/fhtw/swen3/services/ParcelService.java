package at.fhtw.swen3.services;


import at.fhtw.swen3.services.dto.Parcel;
import org.springframework.stereotype.Service;

import java.util.Collection;



public interface ParcelService {

   void submitNewParcel(Parcel parcel);
   Collection<Parcel> getStorage();

}    