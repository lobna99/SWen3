package at.fhtw.swen3.persistence.entity;

import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.dto.RecipientDto;
import at.fhtw.swen3.services.dto.TrackingInformation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
@Entity
public class Parcel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private Long id;

    @Column
    private String trackingId;
    @Column @Size(min = 0, message="weight must be over 0")
    private Float weight;
    @Column @NotNull(message = "Recipient cannot be null")
    private transient RecipientDto recipientDto; //Es kennzeichnet Variablen, die bei der Serialisierung eines Objektes nicht mit gespeichert werden sollen. ORM will ignore it during CRUD TODO: find a better way to use Recipient as attribute
    @Column @NotNull(message = "Recipient cannot be null")
    private transient RecipientDto sender;
    @Column
    private TrackingInformation.StateEnum state;

    @Column @NotNull
    private  transient List<HopArrival> visitedHops;

    @Column @NotNull
    private  transient List<HopArrival> futureHops;
}