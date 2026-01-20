// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum CheckoutType implements ToQueryParam {
    SELF_SERVE("SELF_SERVE"),
    SUBSCRIPTION_ACTIVATION("SUBSCRIPTION_ACTIVATION");
    private final String value;

    CheckoutType(String value) {
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
