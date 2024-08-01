package io.github.leocklaus.ze_code_challenge_backend_gis.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ExceptionType {

    PARTNER_NOT_FOUND("We could´t find any partner", "/partner-not-found"),
    INVALID_DATA("Data is invalid", "/invalid-data"),
    RESOURCE_NOT_FOUND("Resource not found", "/resource-not-found"),
    DOCUMENT_ALREADY_TAKEN("Choose a different document", "/document-already-taken");

    private String title;
    private String URI;

    ExceptionType(String title, String URI){
        this.title = title;
        this.URI = URI;
    }
}
