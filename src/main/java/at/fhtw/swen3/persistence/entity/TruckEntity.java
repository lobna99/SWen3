package at.fhtw.swen3.persistence.entity;


import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class TruckEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private Long id;


    @Column
    private String regionGeoJson;

    @Column
    private String numberPlate;

}
