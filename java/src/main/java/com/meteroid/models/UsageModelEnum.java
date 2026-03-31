// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum UsageModelEnum implements ToQueryParam {
    PER_UNIT("PER_UNIT"),
    TIERED("TIERED"),
    VOLUME("VOLUME"),
    PACKAGE("PACKAGE"),
    MATRIX("MATRIX");
    private final String value;

    UsageModelEnum(String value) {
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
