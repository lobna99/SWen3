package at.fhtw.swen3.persistence.entity;


import lombok.*;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.WKTReader;


import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_geocoordinate")
public class GeoCoordinateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private Double lat;

    @Column
    private Double lon;

    @Column
    private Point point;
}