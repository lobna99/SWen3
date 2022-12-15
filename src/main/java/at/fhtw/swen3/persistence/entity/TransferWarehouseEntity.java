package at.fhtw.swen3.persistence.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.locationtech.jts.geom.Geometry;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class TransferWarehouseEntity extends HopEntity {


    @Column
    private Geometry regionGeoJson;

    @Column
    private String logisticsPartner;

    @Column
    private String logisticsPartnerUrl;
}
