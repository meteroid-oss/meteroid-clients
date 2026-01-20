// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum SubscriptionFeeBillingPeriodEnum implements ToQueryParam {
    ONE_TIME("ONE_TIME"),
    MONTHLY("MONTHLY"),
    QUARTERLY("QUARTERLY"),
    SEMIANNUAL("SEMIANNUAL"),
    ANNUAL("ANNUAL");
    private final String value;

    SubscriptionFeeBillingPeriodEnum(String value) {
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
