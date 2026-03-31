// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum ConnectionStatus implements ToQueryParam {
    PENDING("pending"),
    ACTIVE("active"),
    REVOKED("revoked"),
    SUSPENDED("suspended");
    private final String value;

    ConnectionStatus(String value) {
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
