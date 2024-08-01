package io.github.leocklaus.ze_code_challenge_backend_gis.domain.repository;

import io.github.leocklaus.ze_code_challenge_backend_gis.domain.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    @Query(value = "WITH points AS (" +
            "    SELECT *, " +
            "           ST_Distance(partner_address, ST_SetSRID(ST_MakePoint(:longitude, :latitude), 4326)) AS distance " +
            "    FROM tb_partner " +
            "    WHERE ST_Contains(coverage_area, ST_SetSRID(ST_MakePoint(:longitude, :latitude), 4326))" +
            ")" +
            "SELECT * " +
            "FROM points " +
            "ORDER BY distance " +
            "LIMIT 1", nativeQuery = true)
    Optional<Partner> findNearestPartner(@Param("longitude") double longitude, @Param("latitude") double latitude);

}
