package at.fhtw.swen3.persistence.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.locationtech.jts.geom.Geometry;

import javax.persistence.*;

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
    private String numberPlate;

}
