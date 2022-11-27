package at.fhtw.swen3.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

public class Address {

    private String street;
    private String postalCode;
    private String city;
    private String country;



}
