package io.github.leocklaus.ze_code_challenge_backend_gis.api.dto;

import jakarta.validation.constraints.NotNull;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Point;

public record PartnerInput(
        @NotNull(message = "Name is required") String tradingName,
        @NotNull(message = "Document is required") String document,
        @NotNull(message = "Coverage area is required") MultiPolygon coverageArea,
        @NotNull(message = "Address is required") Point address
) {
}
