package at.fhtw.swen3.persistence.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@SuperBuilder
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor
public class HopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    @NotBlank
    private String hopType;

    @Column
    @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$")
    private String code;

    @Column
    private String description;

    @Column
    private Integer processingDelayMins;

    @Column
    @NotBlank
    private String locationName;


    @JoinColumn(name="fk_Coordinates")
    @OneToOne (cascade = CascadeType.REMOVE)
    private GeoCoordinateEntity locationCoordinates;
}
