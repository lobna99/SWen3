package at.fhtw.swen3.persistence.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "warehouse",schema = "warehouses")
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

}
