package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.controller.rest.ParcelApi;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.TrackingInformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.io.IOException;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-19T12:44:39.831116Z[Etc/UTC]")
@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:8100")
@EnableJpaRepositories
public class ParcelApiController implements ParcelApi {

    //TODO: error handling
    private final NativeWebRequest request;

    @Autowired
    private final ParcelService parcelService;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public ParcelApiController(NativeWebRequest request, ParcelService parcelService,KafkaTemplate<String, String> kafkaTemplate) {
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
    public ResponseEntity<Void> reportParcelHop(String trackingId, String code) {
        try {//TODO: exception handling
            kafkaTemplate.send("hopChange", "Hello World");
            log.info("should send rn");
            parcelService.reportParcel(trackingId,code);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<Void> reportParcelDelivery(String trackingId) {
        parcelService.reportDelivery(trackingId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
