package io.github.leocklaus.ze_code_challenge_backend_gis.domain.exception;

public class PartnerNotFoundException extends RuntimeException{
    public PartnerNotFoundException(String msg){
        super(msg);
    }
}
