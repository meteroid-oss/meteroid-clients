// This file is @generated
package com.meteroid.models;

import com.fasterxml.jackson.annotation.JsonValue;
import com.meteroid.Utils.ToQueryParam;

public enum OAuthErrorCode implements ToQueryParam {
    INVALID_REQUEST("invalid_request"),
    UNAUTHORIZED_CLIENT("unauthorized_client"),
    ACCESS_DENIED("access_denied"),
    UNSUPPORTED_RESPONSE_TYPE("unsupported_response_type"),
    INVALID_SCOPE("invalid_scope"),
    SERVER_ERROR("server_error"),
    TEMPORARILY_UNAVAILABLE("temporarily_unavailable"),
    INVALID_GRANT("invalid_grant"),
    INVALID_CLIENT("invalid_client"),
    UNSUPPORTED_GRANT_TYPE("unsupported_grant_type");
    private final String value;

    OAuthErrorCode(String value) {
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
