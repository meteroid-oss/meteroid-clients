// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum PaymentStatusEnum implements ToQueryParam {
    READY("Ready"),
    PENDING("Pending"),
    SETTLED("Settled"),
    CANCELLED("Cancelled"),
    FAILED("Failed");
    private final String value;

    PaymentStatusEnum(String value) {
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
