// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum FeatureStatus implements ToQueryParam {
    ACTIVE("ACTIVE"),
    DISABLED("DISABLED"),
    ARCHIVED("ARCHIVED");
    private final String value;

    FeatureStatus(String value) {
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
