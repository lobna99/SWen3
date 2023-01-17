package at.fhtw.swen3.services;


import at.fhtw.swen3.model.PushNotif;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;


public interface ParcelService {

   String submitNewParcel(Parcel parcel,String id);
   TrackingInformation getParcel(String tracking_id);
   PushNotif reportParcel(String tracking, String code) throws IOException;
   void reportDelivery(String tracking);

}    