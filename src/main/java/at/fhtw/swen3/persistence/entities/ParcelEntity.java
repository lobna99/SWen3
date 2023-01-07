package at.fhtw.swen3.persistence.entities;


import at.fhtw.swen3.services.dto.TrackingInformation.StateEnum;
import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_parcel")
public class ParcelEntity { //TODO: tests for every entity


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private Long id;

    @Column
    @NotNull
    private String trackingId;
    @Column
    @Size(message = "weight must be over 0")
    @DecimalMin("0.0")
    private Float weight;

    @NotNull(message = "Recipient cannot be null")
    @ManyToOne
    @JoinColumn(name = "fk_recipient")
    private RecipientEntity recipient;
    @NotNull(message = "Sender cannot be null")
    @ManyToOne
    @JoinColumn(name = "fk_sender")
    private RecipientEntity sender;
    @Column
    private StateEnum state;

    @OneToMany
    private List<HopArrivalEntity> visitedHops;

    @OneToMany
    private List<HopArrivalEntity> futureHops;
}
