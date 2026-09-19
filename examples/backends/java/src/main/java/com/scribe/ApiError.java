package com.scribe;

import com.meteroid.exceptions.ApiException;

/**
 * The single error envelope of {@code examples/openapi.yaml} — the Java twin of the Rust backend's
 * {@code src/error.rs}.
 *
 * <p>Every non-2xx response in this backend is an {@code ApiError}. {@code quota} and {@code
 * upgrade_plan_code} are always serialized, {@code null} where they do not apply, so a strict
 * client never has to tell an absent key from a null one.
 *
 * <p>It is an unchecked exception so a handler can {@code throw} it from anywhere and one Javalin
 * exception mapper renders it — see {@link Main}.
 */
public final class ApiError extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private static final int MAX_UPSTREAM_BODY = 300;

    private final ErrorCode code;
    private final String detail;
    private Dto.QuotaSnapshot quota;
    private PlanCode upgradePlanCode;

    public ApiError(ErrorCode code, String message) {
        super(message);
        this.code = code;
        this.detail = message;
    }

    public ApiError withQuota(Dto.QuotaSnapshot snapshot) {
        this.quota = snapshot;
        return this;
    }

    public ApiError withUpgrade(PlanCode plan) {
        this.upgradePlanCode = plan;
        return this;
    }

    // --- the serialized envelope -------------------------------------------------

    /**
     * What actually goes on the wire.
     *
     * <p>The exception itself is deliberately never handed to Jackson: {@link Throwable} carries
     * {@code cause}, {@code stackTrace} and {@code suppressed} getters, and the contract's error
     * schema is {@code additionalProperties: false}.
     *
     * @param code machine-readable identifier; clients switch on this, never on {@code message}
     * @param message human-readable explanation, safe to show in the demo UI
     * @param quota live quota snapshot, populated only for {@code QUOTA_EXHAUSTED}
     * @param upgradePlanCode the plan to offer as the fix, for {@code 402} and {@code 403}
     */
    public record Envelope(
            ErrorCode code, String message, Dto.QuotaSnapshot quota, PlanCode upgradePlanCode) {}

    public Envelope envelope() {
        return new Envelope(code, detail, quota, upgradePlanCode);
    }

    public ErrorCode code() {
        return code;
    }

    public int status() {
        return code.status();
    }

    // --- constructors for the common cases ---------------------------------------

    public static ApiError badRequest(String message) {
        return new ApiError(ErrorCode.BAD_REQUEST, message);
    }

    public static ApiError unauthorized(String message) {
        return new ApiError(ErrorCode.UNAUTHORIZED, message);
    }

    public static ApiError catalogNotSeeded(String message) {
        return new ApiError(ErrorCode.CATALOG_NOT_SEEDED, message);
    }

    public static ApiError internal(String message) {
        return new ApiError(ErrorCode.INTERNAL, message);
    }

    /**
     * Translate an SDK failure into this contract's envelope.
     *
     * <p>The SDK reports the upstream status on {@link ApiException#getCode()}, which is what
     * separates "your API key is wrong" (an operator problem) from "Meteroid is throttling" (retry)
     * from everything else.
     */
    public static ApiError upstream(String context, ApiException e) {
        int status = e.getCode();
        ErrorCode code;
        if (status == 401 || status == 403) {
            code = ErrorCode.UPSTREAM_UNAUTHORIZED;
        } else if (status == 429) {
            code = ErrorCode.RATE_LIMITED;
        } else {
            code = ErrorCode.UPSTREAM_ERROR;
        }

        String message;
        switch (code) {
            case UPSTREAM_UNAUTHORIZED:
                message =
                        "Meteroid rejected the API key on "
                                + context
                                + " (HTTP "
                                + status
                                + "). Check METEROID_API_KEY.";
                break;
            case RATE_LIMITED:
                message = "Meteroid responded 429 to " + context + ". Retry shortly.";
                break;
            default:
                message =
                        "Meteroid responded "
                                + status
                                + " to "
                                + context
                                + ": "
                                + truncate(e.getResponseBody());
                break;
        }
        return new ApiError(code, message);
    }

    /** The SDK throws {@link java.io.IOException} when it cannot reach Meteroid at all. */
    public static ApiError unreachable(String context, java.io.IOException e) {
        return new ApiError(
                ErrorCode.UPSTREAM_ERROR, "Could not reach Meteroid for " + context + ": " + e);
    }

    /**
     * True when the SDK error is an upstream 404 — "this object does not exist", which for a
     * catalog lookup means "not seeded" rather than "Meteroid is broken".
     */
    public static boolean isNotFound(ApiException e) {
        return e.getCode() == 404;
    }

    private static String truncate(String body) {
        if (body == null) {
            return "";
        }
        return body.length() <= MAX_UPSTREAM_BODY
                ? body
                : body.substring(0, MAX_UPSTREAM_BODY) + "…";
    }
}
