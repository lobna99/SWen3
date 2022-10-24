package at.fhtw.swen3.services.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import javax.annotation.Generated;

/**
 * Recipient
 */
@Builder
@Getter
@Setter
@JsonTypeName("recipient")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-19T12:44:39.831116Z[Etc/UTC]")
public class RecipientDto {

  @JsonProperty("name")
  private String name;

  @JsonProperty("street")
  private String street;

  @JsonProperty("postalCode")
  private String postalCode;

  @JsonProperty("city")
  private String city;

  @JsonProperty("country")
  private String country;

  public RecipientDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of person or company.
   * @return name
  */
  @NotNull 
  @Schema(name = "name", description = "Name of person or company.", required = true)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RecipientDto street(String street) {
    this.street = street;
    return this;
  }

  /**
   * Street
   * @return street
  */
  @NotNull 
  @Schema(name = "street", description = "Street", required = true)
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public RecipientDto postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  /**
   * Postalcode
   * @return postalCode
  */
  @NotNull 
  @Schema(name = "postalCode", description = "Postalcode", required = true)
  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public RecipientDto city(String city) {
    this.city = city;
    return this;
  }

  /**
   * City
   * @return city
  */
  @NotNull 
  @Schema(name = "city", description = "City", required = true)
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public RecipientDto country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Country
   * @return country
  */
  @NotNull 
  @Schema(name = "country", description = "Country", required = true)
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecipientDto recipientDto = (RecipientDto) o;
    return Objects.equals(this.name, recipientDto.name) &&
        Objects.equals(this.street, recipientDto.street) &&
        Objects.equals(this.postalCode, recipientDto.postalCode) &&
        Objects.equals(this.city, recipientDto.city) &&
        Objects.equals(this.country, recipientDto.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, street, postalCode, city, country);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Recipient {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

