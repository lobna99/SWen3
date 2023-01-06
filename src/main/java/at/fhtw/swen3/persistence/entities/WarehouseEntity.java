package at.fhtw.swen3.persistence.entities;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@Entity
public class WarehouseEntity extends HopEntity{


    @Column
    @Min(0)
    private Integer level;

    @Column
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<WarehouseNextHopsEntity> nextHops;
}
