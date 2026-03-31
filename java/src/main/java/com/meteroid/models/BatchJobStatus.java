// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum BatchJobStatus implements ToQueryParam {
    PENDING("PENDING"),
    CHUNKING("CHUNKING"),
    PROCESSING("PROCESSING"),
    COMPLETED("COMPLETED"),
    COMPLETED_WITH_ERRORS("COMPLETED_WITH_ERRORS"),
    FAILED("FAILED"),
    CANCELLED("CANCELLED");
    private final String value;

    BatchJobStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return this.value;
    }

    @Override
    public String toQueryParam() {
        return this.value;
    }
}
