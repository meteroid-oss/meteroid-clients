// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum PaymentStrategy implements ToQueryParam {
    AUTO("AUTO"),
    BANK("BANK"),
    EXTERNAL("EXTERNAL");
    private final String value;

    PaymentStrategy(String value) {
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
