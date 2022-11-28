package at.fhtw.swen3.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class Address {

    private String street;
    private String postalCode;
    private String city;
    private String country;



}
