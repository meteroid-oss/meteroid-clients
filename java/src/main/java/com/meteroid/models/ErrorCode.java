// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum ErrorCode implements ToQueryParam {
    BAD_REQUEST("BAD_REQUEST"),
    NOT_FOUND("NOT_FOUND"),
    CONFLICT("CONFLICT"),
    FORBIDDEN("FORBIDDEN"),
    UNAUTHORIZED("UNAUTHORIZED"),
    TOO_MANY_REQUESTS("TOO_MANY_REQUESTS"),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR");
    private final String value;

    ErrorCode(String value) {
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
