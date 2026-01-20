// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum BillingMetricAggregateEnum implements ToQueryParam {
    COUNT("COUNT"),
    LATEST("LATEST"),
    MAX("MAX"),
    MIN("MIN"),
    MEAN("MEAN"),
    SUM("SUM"),
    COUNT_DISTINCT("COUNT_DISTINCT");
    private final String value;

    BillingMetricAggregateEnum(String value) {
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
