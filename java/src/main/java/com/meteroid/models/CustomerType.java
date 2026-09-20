// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum CustomerType implements ToQueryParam {
    COMPANY("COMPANY"),
    INDIVIDUAL("INDIVIDUAL");
    private final String value;

    CustomerType(String value) {
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
