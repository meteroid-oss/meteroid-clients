// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum SubscriptionActivationConditionEnum implements ToQueryParam {
    ON_START("ON_START"),
    ON_CHECKOUT("ON_CHECKOUT"),
    MANUAL("MANUAL");
    private final String value;

    SubscriptionActivationConditionEnum(String value) {
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
