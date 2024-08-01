package io.github.leocklaus.ze_code_challenge_backend_gis.domain.service;

import io.github.leocklaus.ze_code_challenge_backend_gis.api.dto.NearestPartnerSearch;
import io.github.leocklaus.ze_code_challenge_backend_gis.api.dto.PartnerInput;
import io.github.leocklaus.ze_code_challenge_backend_gis.api.dto.PartnerOutput;
import io.github.leocklaus.ze_code_challenge_backend_gis.domain.entity.Partner;
import io.github.leocklaus.ze_code_challenge_backend_gis.domain.exception.PartnerNotFoundException;
import io.github.leocklaus.ze_code_challenge_backend_gis.domain.repository.PartnerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PartnerService {

    private final PartnerRepository partnerRepository;

    public PartnerOutput findPartnerById(Long id){
        Partner partner = partnerRepository.findById(id)
                .orElseThrow(() -> new PartnerNotFoundException("Partner not found with id: " + id));

        return new PartnerOutput(partner);
    }

    @Transactional
    public PartnerOutput addPartner(PartnerInput partnerInput){

        Partner partner = Partner.builder()
                .tradingName(partnerInput.tradingName())
                .document(partnerInput.document())
                .coverageArea(partnerInput.coverageArea())
                .address(partnerInput.address())
                .build();

        partner = partnerRepository.save(partner);

        return new PartnerOutput(partner);
    }

    public PartnerOutput findNearestPartner(NearestPartnerSearch nearestPartnerSearch){

        Partner partner = partnerRepository.findNearestPartner(
                    nearestPartnerSearch.longitude(),
                    nearestPartnerSearch.latitude()
                )
                .orElseThrow(() -> new PartnerNotFoundException(
                        "We couldn't find any partner close to your location"
                ));


        return new PartnerOutput(partner);
    }

}
