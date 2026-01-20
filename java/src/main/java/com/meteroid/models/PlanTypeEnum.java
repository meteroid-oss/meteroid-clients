// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum PlanTypeEnum implements ToQueryParam {
    STANDARD("STANDARD"),
    FREE("FREE"),
    CUSTOM("CUSTOM");
    private final String value;

    PlanTypeEnum(String value) {
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
