// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum InvoiceType implements ToQueryParam {
    RECURRING("RECURRING"),
    ONE_OFF("ONE_OFF"),
    ADJUSTMENT("ADJUSTMENT"),
    USAGE_THRESHOLD("USAGE_THRESHOLD");
    private final String value;

    InvoiceType(String value) {
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
