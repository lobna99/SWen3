package at.fhtw.swen3.persistence.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@SuperBuilder
@Entity
public class TruckEntity extends HopEntity {



    @Transient
    private String regionGeoJson;

    @Column
    private String numberPlate;

}
