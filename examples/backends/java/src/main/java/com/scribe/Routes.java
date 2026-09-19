package com.scribe;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.javalin.http.Context;

/**
 * Small helpers shared by every handler — the Java twin of the Rust backend's {@code
 * src/routes/mod.rs}.
 *
 * <p>Each handler in {@code com.scribe.routes} is shaped the same way: parse and validate the
 * request, make <b>one obvious Meteroid SDK call</b>, then project the result onto the contract's
 * wire type. The SDK call is the line worth reading.
 */
public final class Routes {

    private Routes() {}

    /**
     * Parse a <b>required</b> JSON request body.
     *
     * <p>Javalin's own {@code ctx.bodyAsClass} rejection renders a plain-text page, which would
     * break the contract's promise that every non-2xx response is an {@code Error} object — hence
     * the explicit parse.
     */
    public static <T> T jsonBody(Context ctx, Class<T> type) {
        String body = ctx.body();
        if (body.isEmpty()) {
            throw ApiError.badRequest("A JSON request body is required.");
        }
        return parse(body, type);
    }

    /**
     * Parse an <b>optional</b> JSON request body.
     *
     * <p>The contract states that for these operations no body, an empty body, {@code {}} and
     * {@code {"field": null}} all mean the same thing: use the defaults. That rule is literally
     * this method.
     */
    public static <T> T optionalJsonBody(Context ctx, Class<T> type, T empty) {
        String body = ctx.body();
        if (body.isBlank()) {
            return empty;
        }
        return parse(body, type);
    }

    private static <T> T parse(String body, Class<T> type) {
        try {
            return Json.mapper().readValue(body, type);
        } catch (JsonProcessingException e) {
            throw ApiError.badRequest("Invalid body: " + e.getOriginalMessage());
        }
    }

    /** Same idea for the query string: keep the error envelope instead of Javalin's default. */
    public static int intQueryParam(Context ctx, String name, int fallback, int min, int max) {
        String raw = ctx.queryParam(name);
        if (raw == null || raw.isBlank()) {
            return fallback;
        }
        int value;
        try {
            value = Integer.parseInt(raw.trim());
        } catch (NumberFormatException e) {
            throw ApiError.badRequest(name + " must be an integer.");
        }
        if (value < min || value > max) {
            throw ApiError.badRequest(name + " must be between " + min + " and " + max + ".");
        }
        return value;
    }

    /** Trim a string field and reject it when it is empty or too long. */
    public static String bounded(String field, String value, int max) {
        String trimmed = value == null ? "" : value.trim();
        if (trimmed.isEmpty()) {
            throw ApiError.badRequest(field + " must not be empty.");
        }
        if (trimmed.codePointCount(0, trimmed.length()) > max) {
            throw ApiError.badRequest(field + " must be at most " + max + " characters.");
        }
        return trimmed;
    }

    /** Shorthand for the {@code 201 Created} the contract asks for on every POST but the webhook. */
    public static void created(Context ctx, Object body) {
        ctx.status(201).json(body);
    }
}
