package at.fhtw.swen3.persistence.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "warehouse_next_hops")
public class WarehouseNextHopsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    @NotNull
    private Integer traveltimeMins;

    @OneToOne
    private HopEntity hop;

}
