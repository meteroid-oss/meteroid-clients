// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum MetricFilterOperator implements ToQueryParam {
    EQUAL("EQUAL"),
    NOT_EQUAL("NOT_EQUAL"),
    IN("IN"),
    NOT_IN("NOT_IN");
    private final String value;

    MetricFilterOperator(String value) {
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
