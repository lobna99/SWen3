package at.fhtw.swen3.services;


import at.fhtw.swen3.services.dto.Parcel;

import java.util.Collection;



public interface ParcelService {

   String submitNewParcel(Parcel parcel,String id);
   Collection<Parcel> getStorage();

}    