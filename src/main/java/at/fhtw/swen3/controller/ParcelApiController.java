package at.fhtw.swen3.controller;


import at.fhtw.swen3.controller.rest.ParcelApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-19T12:44:39.831116Z[Etc/UTC]")
@Controller
public class ParcelApiController implements ParcelApi {

    private final NativeWebRequest request;

    @Autowired
    public ParcelApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
