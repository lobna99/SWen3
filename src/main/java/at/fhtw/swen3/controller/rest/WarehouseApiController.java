package at.fhtw.swen3.controller.rest;


import at.fhtw.swen3.services.HopService;
import at.fhtw.swen3.services.WarehouseService;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import org.locationtech.jts.io.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-19T12:44:39.831116Z[Etc/UTC]")
//todo: wieder in controller ändern falls es nicht worked!!
@RestController
@EnableJpaRepositories
public class WarehouseApiController implements WarehouseApi {

    private final NativeWebRequest request;

    @Autowired
    private final WarehouseService warehouseService;

    @Autowired
    private final HopService hopService;

    @Autowired
    public WarehouseApiController(NativeWebRequest request, WarehouseService warehouseService, HopService hopService) {
        this.request = request;
        this.warehouseService = warehouseService;
        this.hopService = hopService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }


    @Override
    public ResponseEntity<Warehouse> exportWarehouses() {
        return new ResponseEntity<Warehouse>(warehouseService.getWarehouse(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> importWarehouses(Warehouse warehouse) {

        try {
            warehouseService.importWarehouse(warehouse);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Hop> getWarehouse(String code) {

        return new ResponseEntity<Hop>( hopService.getHop(code),HttpStatus.OK);
    }
}
