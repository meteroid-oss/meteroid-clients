// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum CustomPropertyType implements ToQueryParam {
    TEXT("TEXT"),
    NUMBER("NUMBER"),
    BOOLEAN("BOOLEAN"),
    DATE("DATE"),
    DATETIME("DATETIME"),
    SINGLE_SELECT("SINGLE_SELECT"),
    MULTI_SELECT("MULTI_SELECT"),
    JSON("JSON"),
    URL("URL"),
    EMAIL("EMAIL");
    private final String value;

    CustomPropertyType(String value) {
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
