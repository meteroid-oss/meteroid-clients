// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum CustomPropertyEntityType implements ToQueryParam {
    CUSTOMER("CUSTOMER"),
    SUBSCRIPTION("SUBSCRIPTION"),
    INVOICE("INVOICE"),
    CREDIT_NOTE("CREDIT_NOTE");
    private final String value;

    CustomPropertyEntityType(String value) {
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
