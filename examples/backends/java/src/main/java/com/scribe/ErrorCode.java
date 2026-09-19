package com.scribe;

import com.fasterxml.jackson.annotation.JsonValue;

/** The machine-readable error identifiers of {@code examples/openapi.yaml}, with their statuses. */
public enum ErrorCode {
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    /** Reserved by the contract; no operation in this demo requires a subscription. */
    NO_SUBSCRIPTION(409),
    FEATURE_NOT_ENTITLED(403),
    QUOTA_EXHAUSTED(402),
    CHECKOUT_UNAVAILABLE(409),
    CATALOG_NOT_SEEDED(503),
    WEBHOOK_SIGNATURE_INVALID(400),
    UPSTREAM_UNAUTHORIZED(502),
    UPSTREAM_ERROR(502),
    RATE_LIMITED(429),
    INTERNAL(500);

    private final int status;

    ErrorCode(int status) {
        this.status = status;
    }

    public int status() {
        return status;
    }

    @JsonValue
    public String wireValue() {
        return name();
    }
}
