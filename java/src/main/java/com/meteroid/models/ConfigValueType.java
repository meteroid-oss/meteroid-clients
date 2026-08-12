// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum ConfigValueType implements ToQueryParam {
    NUMBER("NUMBER"),
    BOOLEAN("BOOLEAN"),
    TEXT("TEXT"),
    MAP("MAP"),
    JSON("JSON"),
    SELECT("SELECT");
    private final String value;

    ConfigValueType(String value) {
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
