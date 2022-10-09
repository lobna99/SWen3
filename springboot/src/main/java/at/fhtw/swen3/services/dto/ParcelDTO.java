package at.fhtw.swen3.services.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import javax.annotation.Generated;

/**
 * Parcel
 */

@JsonTypeName("parcel")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-19T12:44:39.831116Z[Etc/UTC]")
public class ParcelDTO {

  @JsonProperty("weight")
  private Float weight;

  @JsonProperty("recipient")
  private RecipientDto recipientDto;

  @JsonProperty("sender")
  private RecipientDto sender;

  public ParcelDTO weight(Float weight) {
    this.weight = weight;
    return this;
  }

  /**
   * Get weight
   * @return weight
  */
  @NotNull 
  @Schema(name = "weight", required = true)
  public Float getWeight() {
    return weight;
  }

  public void setWeight(Float weight) {
    this.weight = weight;
  }

  public ParcelDTO recipient(RecipientDto recipientDto) {
    this.recipientDto = recipientDto;
    return this;
  }

  /**
   * Get recipient
   * @return recipient
  */
  @NotNull @Valid 
  @Schema(name = "recipient", required = true)
  public RecipientDto getRecipient() {
    return recipientDto;
  }

  public void setRecipient(RecipientDto recipientDto) {
    this.recipientDto = recipientDto;
  }

  public ParcelDTO sender(RecipientDto sender) {
    this.sender = sender;
    return this;
  }

  /**
   * Get sender
   * @return sender
  */
  @NotNull @Valid 
  @Schema(name = "sender", required = true)
  public RecipientDto getSender() {
    return sender;
  }

  public void setSender(RecipientDto sender) {
    this.sender = sender;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParcelDTO parcelDTO = (ParcelDTO) o;
    return Objects.equals(this.weight, parcelDTO.weight) &&
        Objects.equals(this.recipientDto, parcelDTO.recipientDto) &&
        Objects.equals(this.sender, parcelDTO.sender);
  }

  @Override
  public int hashCode() {
    return Objects.hash(weight, recipientDto, sender);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Parcel {\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    recipient: ").append(toIndentedString(recipientDto)).append("\n");
    sb.append("    sender: ").append(toIndentedString(sender)).append("\n");
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

