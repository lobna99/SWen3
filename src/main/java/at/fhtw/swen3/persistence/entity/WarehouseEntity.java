package at.fhtw.swen3.persistence.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
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
    @OneToMany(mappedBy = "hop")
    private List<WarehouseNextHopsEntity> nextHops;
}
