// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum BatchJobType implements ToQueryParam {
    EVENT_CSV_IMPORT("EVENT_CSV_IMPORT"),
    CUSTOMER_CSV_IMPORT("CUSTOMER_CSV_IMPORT"),
    SUBSCRIPTION_CSV_IMPORT("SUBSCRIPTION_CSV_IMPORT"),
    SUBSCRIPTION_PLAN_MIGRATION("SUBSCRIPTION_PLAN_MIGRATION");
    private final String value;

    BatchJobType(String value) {
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
