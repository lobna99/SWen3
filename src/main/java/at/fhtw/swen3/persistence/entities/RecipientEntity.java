package at.fhtw.swen3.persistence.entities;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "t_recipient")
public class RecipientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column
    private Long id;


    @Column @Pattern(regexp = "^[A-Z]+[a-zA-Z',.\\s-]")@NotNull(message = "Name cannot be null")
    private String name;

    @Column @Pattern(regexp = "\\A(.*?)\\s+(\\d+[a-zA-Z]{0,1}\\s{0,1}[/]{1}\\s{0,1}\\d*[a-zA-Z]{0,1}|\\d+[a-zA-Z-]{0,1}\\d*[a-zA-Z]{0,1})$")@NotNull(message = "Name cannot be null")
    private String street;

    @Column @Pattern(regexp = "^A-[0-9]{4}$") @NotNull(message = "Name cannot be null")
    private String postalCode;

    @Column @Pattern(regexp = "^[A-Z]+[a-zA-Z',.\\s-]")@NotNull(message = "Name cannot be null")
    private String city;

    @Column
    @NotBlank
    private String country;

    @OneToOne (cascade = CascadeType.REMOVE)
    private GeoCoordinateEntity locationCoordinates;
}
