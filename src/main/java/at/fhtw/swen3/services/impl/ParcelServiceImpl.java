package at.fhtw.swen3.services.impl;

import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.ParcelLogic;
import at.fhtw.swen3.services.ParcelService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class ParcelServiceImpl extends ParcelService {
    public ParcelServiceImpl(ParcelLogic parcelLogic) {
        super(parcelLogic);
    }
/*    public ParcelLogic(ParcelRepository repo) {

    }

    public submitNewParcel(..) {
        //...
        repo.save(p);
    }*/
}
