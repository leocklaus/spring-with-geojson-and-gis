package io.github.leocklaus.ze_code_challenge_backend_gis.api.dto;

import jakarta.validation.constraints.NotNull;

public record NearestPartnerSearch(
        @NotNull(message = "longitude is required") Double longitude,
        @NotNull(message = "latitude is required") Double latitude
) {
}
