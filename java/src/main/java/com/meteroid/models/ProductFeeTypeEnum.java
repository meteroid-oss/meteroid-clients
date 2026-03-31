// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum ProductFeeTypeEnum implements ToQueryParam {
    RATE("RATE"),
    SLOT("SLOT"),
    CAPACITY("CAPACITY"),
    USAGE("USAGE"),
    EXTRA_RECURRING("EXTRA_RECURRING"),
    ONE_TIME("ONE_TIME");
    private final String value;

    ProductFeeTypeEnum(String value) {
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
