package com.scribe.routes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.meteroid.Webhook;
import com.scribe.ApiError;
import com.scribe.AppState;
import com.scribe.Dto;
import com.scribe.ErrorCode;
import com.scribe.Json;

import io.javalin.http.Context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.HashMap;

/** {@code POST /api/webhooks/meteroid} — the signed webhook receiver. */
public final class WebhookRoutes {

    private WebhookRoutes() {}

    private static final Logger LOG = LoggerFactory.getLogger(WebhookRoutes.class);

    /**
     * Verify the Standard Webhooks signature over the <b>raw</b> request body, then act on what the
     * demo recognizes and acknowledge the rest.
     *
     * <p>Two rules matter more than anything else here:
     *
     * <ol>
     *   <li><b>Verify the raw body.</b> {@code ctx.body()} is the exact payload Meteroid signed.
     *       Parsing the JSON and re-serializing it before verifying is the classic bug — any
     *       difference in key order or spacing breaks the signature.
     *   <li><b>Never reject a correctly signed body for its shape.</b> Meteroid owns the event
     *       envelope and adds event types over time; a receiver that 400s on an unknown type breaks
     *       the first time the sender ships a new one. {@code 400} is for a bad signature and for a
     *       body that is not JSON at all — nothing else.
     * </ol>
     */
    public static void receiveWebhook(Context ctx, AppState state) {
        String secret = state.config.meteroidWebhookSecret;
        if (secret.isEmpty()) {
            // An operator problem, not a caller problem: never report it as a bad signature.
            throw ApiError.internal(
                    "METEROID_WEBHOOK_SECRET is not set, so inbound webhooks cannot be verified."
                            + " Copy the signing secret from your Meteroid webhook endpoint"
                            + " (examples/CATALOG.md).");
        }

        String rawBody = ctx.body();

        // The SDK accepts both `webhook-*` and `svix-*` headers and enforces the five-minute
        // timestamp tolerance itself.
        try {
            new Webhook(secret).verify(rawBody, headerMap(ctx));
        } catch (RuntimeException | com.standardwebhooks.exceptions.WebhookVerificationException e) {
            throw new ApiError(
                    ErrorCode.WEBHOOK_SIGNATURE_INVALID,
                    "Webhook signature verification failed: " + e.getMessage());
        }

        JsonNode event;
        try {
            event = Json.mapper().readTree(rawBody);
        } catch (JsonProcessingException e) {
            throw new ApiError(
                    ErrorCode.WEBHOOK_SIGNATURE_INVALID,
                    "Webhook body is signed but is not JSON: " + e.getOriginalMessage());
        }

        String eventType = text(event, "type");
        String eventId = text(event, "id");
        if (eventId == null) {
            // `webhook-id` is required and verification just passed, so there is always something
            // to echo.
            eventId = header(ctx, "webhook-id");
            if (eventId == null) {
                eventId = header(ctx, "svix-id");
            }
        }

        // The demo "handles" invoice and subscription events by logging them; the frontend shows
        // the last few in its activity feed. Everything else is acknowledged, ignored, and
        // explicitly reported as unhandled.
        boolean handled =
                eventType != null
                        && (eventType.startsWith("invoice.")
                                || eventType.startsWith("subscription."));

        if (handled) {
            LOG.info("meteroid webhook handled: id={} type={}", eventId, eventType);
        } else {
            LOG.debug("meteroid webhook ignored: id={} type={}", eventId, eventType);
        }

        // 202: the signature verified and the body was accepted. Whether the demo understood the
        // event is what `handled` reports.
        ctx.status(202)
                .json(
                        new Dto.WebhookAck(
                                true, eventId == null ? "" : eventId, eventType, handled));
    }

    private static String text(JsonNode event, String field) {
        JsonNode node = event.get(field);
        return node != null && node.isTextual() ? node.asText() : null;
    }

    private static String header(Context ctx, String name) {
        return ctx.header(name);
    }

    /** The SDK's verifier takes {@code Map<String, List<String>>}; Javalin hands out one value each. */
    private static Map<String, List<String>> headerMap(Context ctx) {
        Map<String, List<String>> headers = new HashMap<>();
        ctx.headerMap()
                .forEach((name, value) -> headers.put(name.toLowerCase(Locale.ROOT), List.of(value)));
        return headers;
    }
}
