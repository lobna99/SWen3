package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.controller.rest.ParcelApi;
import at.fhtw.swen3.model.PushNotif;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.context.request.NativeWebRequest;

import java.io.IOException;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-19T12:44:39.831116Z[Etc/UTC]")
@Controller
@Slf4j
@CrossOrigin(origins = "http://localhost:8100")
public class ParcelApiController implements ParcelApi {

    //TODO: error handling
    private final NativeWebRequest request;

    @Autowired
    private final ParcelService parcelService;
    @Autowired
    private KafkaTemplate<String, PushNotif> kafkaTemplate;

    @Autowired
    public ParcelApiController(NativeWebRequest request, ParcelService parcelService,KafkaTemplate<String, PushNotif> kafkaTemplate) {
        this.request = request;
        this.parcelService = parcelService;
        this.kafkaTemplate = kafkaTemplate;

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
    public ResponseEntity<Void> reportParcelHop(String trackingId, String code) throws IOException {
            log.info("should send rn");
            PushNotif notif = parcelService.reportParcel(trackingId,code);
            if(notif!=null) {
                kafkaTemplate.send("hopChange", notif);
                return new ResponseEntity<>(HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }


    }

    @Override
    public ResponseEntity<Void> reportParcelDelivery(String trackingId) {
        parcelService.reportDelivery(trackingId);
        kafkaTemplate.send("hopChange",new PushNotif(trackingId,"Destination"));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
