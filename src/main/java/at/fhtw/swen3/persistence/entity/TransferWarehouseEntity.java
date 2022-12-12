package at.fhtw.swen3.persistence.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferWarehouseEntity extends HopEntity {


    @Column
    private String regionGeoJson;

    @Column
    private String logisticsPartner;

    @Column
    private String logisticsPartnerUrl;
}
