// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum InvoiceType implements ToQueryParam {
    RECURRING("Recurring"),
    ONE_OFF("OneOff"),
    ADJUSTMENT("Adjustment"),
    USAGE_THRESHOLD("UsageThreshold");
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
