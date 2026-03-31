// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum PaymentStatusEnum implements ToQueryParam {
    READY("READY"),
    PENDING("PENDING"),
    SETTLED("SETTLED"),
    CANCELLED("CANCELLED"),
    FAILED("FAILED");
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
