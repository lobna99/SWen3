package at.fhtw.swen3.persistence.entity;


import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@Entity
public class TruckEntity extends HopEntity {



    @Column
    private String regionGeoJson;

    @Column
    private String numberPlate;

}
