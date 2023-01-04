package at.fhtw.swen3.persistence.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "warehouse_next_hops")
public class WarehouseNextHopsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private Long id;

    @Column
    @NotNull
    private Integer traveltimeMins;

    @OneToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "hop_id")
    private HopEntity hop;

}
