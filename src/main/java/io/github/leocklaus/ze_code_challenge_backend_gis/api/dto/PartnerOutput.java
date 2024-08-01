package io.github.leocklaus.ze_code_challenge_backend_gis.api.dto;

import io.github.leocklaus.ze_code_challenge_backend_gis.domain.entity.Partner;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Point;

public record PartnerOutput(
        Long id,
        String tradingName,
        String document,
        MultiPolygon coverageArea,
        Point address
) {

    public PartnerOutput(Partner partner){
        this(
                partner.getId(),
                partner.getTradingName(),
                partner.getDocument(),
                partner.getCoverageArea(),
                partner.getAddress());
    }

}
