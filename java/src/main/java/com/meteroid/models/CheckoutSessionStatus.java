// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum CheckoutSessionStatus implements ToQueryParam {
    CREATED("CREATED"),
    AWAITING_PAYMENT("AWAITING_PAYMENT"),
    COMPLETED("COMPLETED"),
    EXPIRED("EXPIRED"),
    CANCELLED("CANCELLED");
    private final String value;

    CheckoutSessionStatus(String value) {
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
