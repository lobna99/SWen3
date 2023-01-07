package at.fhtw.swen3.services;


import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;


public interface ParcelService {

   String submitNewParcel(Parcel parcel,String id);
   TrackingInformation getParcel(String tracking_id);
   void reportParcel(String tracking, String code);
   void reportDelivery(String tracking);

}    