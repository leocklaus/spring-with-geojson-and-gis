package io.github.leocklaus.ze_code_challenge_backend_gis.api.controller;

import io.github.leocklaus.ze_code_challenge_backend_gis.api.dto.NearestPartnerSearch;
import io.github.leocklaus.ze_code_challenge_backend_gis.api.dto.PartnerInput;
import io.github.leocklaus.ze_code_challenge_backend_gis.api.dto.PartnerOutput;
import io.github.leocklaus.ze_code_challenge_backend_gis.domain.service.PartnerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/partner")
@RequiredArgsConstructor
public class PartnerController {

    private final PartnerService partnerService;

    @GetMapping("/{id}")
    public ResponseEntity<PartnerOutput> findPartnerByID(@PathVariable Long id){
        PartnerOutput partner = partnerService.findPartnerById(id);

        return ResponseEntity.ok(partner);
    }

    @GetMapping("/nearest")
    public ResponseEntity<PartnerOutput> findNearestPartner(
            @RequestBody @Valid NearestPartnerSearch nearestPartnerSearch){
        PartnerOutput partner = partnerService.findNearestPartner(nearestPartnerSearch);

        return ResponseEntity
                .ok(partner);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PartnerOutput> addPartner(
            @RequestBody @Valid PartnerInput partnerInput
            ){
        PartnerOutput partner = partnerService.addPartner(partnerInput);
        URI uri = URI.create("/partner/" + partner.id());

        return ResponseEntity.created(uri).body(partner);
    }

}
