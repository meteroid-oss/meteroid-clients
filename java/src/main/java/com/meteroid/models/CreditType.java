// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum CreditType implements ToQueryParam {
    CREDIT_TO_BALANCE("CREDIT_TO_BALANCE"),
    REFUND("REFUND"),
    DEBT_CANCELLATION("DEBT_CANCELLATION");
    private final String value;

    CreditType(String value) {
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
