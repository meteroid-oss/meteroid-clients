// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum PaymentTypeEnum implements ToQueryParam {
    PAYMENT("Payment"),
    REFUND("Refund");
    private final String value;

    PaymentTypeEnum(String value) {
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
