package at.fhtw.swen3.persistence.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SuperBuilder
@NoArgsConstructor
@Entity
public class WarehouseEntity extends HopEntity{


    @Column(name = "level", nullable = false)
    private Integer level;

    @Column
    @OneToMany(mappedBy = "hop")
    private List<WarehouseNextHopsEntity> nextHops;
}
