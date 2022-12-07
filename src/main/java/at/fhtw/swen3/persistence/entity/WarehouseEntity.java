package at.fhtw.swen3.persistence.entity;


import at.fhtw.swen3.services.dto.Hop;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "warehouse")
public class WarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private Long id;


    @Column @Pattern(regexp = "\\A(.*?)\\s+(\\d+[a-zA-Z]{0,1}\\s{0,1}[/]{1}\\s{0,1}\\d*[a-zA-Z]{0,1}|\\d+[a-zA-Z-]{0,1}\\d*[a-zA-Z]{0,1})$")
    private String description;

    @Column
    private String code;

    @Column
    private String hopType;

    @Column
    private String locationName;

    @OneToOne
    @JoinColumn
    private GeoCoordinateEntity locationCoordinates;

    @Column
    private Integer level;

    @Column
    @NotNull
    @OneToMany
    private List<WarehouseNextHopsEntity> nextHops;



}
