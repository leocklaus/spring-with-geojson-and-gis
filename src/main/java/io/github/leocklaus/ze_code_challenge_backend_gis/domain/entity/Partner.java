package io.github.leocklaus.ze_code_challenge_backend_gis.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Point;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_partner")
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String tradingName;

    @Column(unique = true, name = "partner_document")
    private String document;

    @Column(name = "coverage_area", columnDefinition = "geometry(MultiPolygon, 4326)", nullable = false)
    private MultiPolygon coverageArea;

    @Column(name = "partner_address", columnDefinition = "geometry(Point, 4326)", nullable = false)
    private Point address;

}
