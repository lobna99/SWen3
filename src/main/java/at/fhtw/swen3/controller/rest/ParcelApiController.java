package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.controller.rest.ParcelApi;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-19T12:44:39.831116Z[Etc/UTC]")
@Controller
public class ParcelApiController implements ParcelApi {

    private final NativeWebRequest request;

    @Autowired
    private final ParcelService parcelService;

    @Autowired
    public ParcelApiController(NativeWebRequest request, ParcelService parcelService) {
        this.request = request;
        this.parcelService = parcelService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<NewParcelInfo> submitParcel(Parcel parcel) {

        NewParcelInfo newParcelInfo = new NewParcelInfo();

        newParcelInfo.setTrackingId(parcelService.submitNewParcel(parcel, ""));


        return new ResponseEntity<NewParcelInfo>(newParcelInfo, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<NewParcelInfo> transitionParcel(String trackingId, Parcel parcel) {
        NewParcelInfo newParcelInfo = new NewParcelInfo();

        newParcelInfo.setTrackingId(parcelService.submitNewParcel(parcel, trackingId));

        return new ResponseEntity<NewParcelInfo>(newParcelInfo, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TrackingInformation> trackParcel(String trackingId) {

        return new ResponseEntity<TrackingInformation>(parcelService.getParcel(trackingId),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> reportParcelHop(String trackingId, String code) {
        parcelService.reportParcel(trackingId,code);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> reportParcelDelivery(String trackingId) {
        parcelService.reportDelivery(trackingId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
