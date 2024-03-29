package at.fhtw.swen3.persistence.entities;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.locationtech.jts.geom.Geometry;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@SuperBuilder
@Entity
public class TruckEntity extends HopEntity {



    @Column
    private Geometry regionGeoJson;

    @Column
    @NotBlank
    private String numberPlate;

}
