package com.meteroid;

import com.standardwebhooks.exceptions.WebhookVerificationException;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class for verifying Meteroid webhook signatures.
 *
 * <p>This class wraps the standard-webhooks library to provide webhook signature
 * verification for Meteroid webhooks. It supports both Svix-branded headers (svix-*)
 * and standard webhook headers (webhook-*).
 *
 * <p>Header lookup order:
 * <ol>
 *   <li>svix-id, svix-signature, svix-timestamp (Svix branded)</li>
 *   <li>webhook-id, webhook-signature, webhook-timestamp (standard)</li>
 * </ol>
 *
 * <p>Example usage:
 * <pre>{@code
 * Webhook webhook = new Webhook("whsec_your_secret_here");
 *
 * // Verify webhook from HTTP headers
 * webhook.verify(payload, headers);
 * }</pre>
 *
 * @see <a href="https://github.com/standard-webhooks/standard-webhooks">Standard Webhooks</a>
 */
public final class Webhook {
    public static final String SECRET_PREFIX = "whsec_";

    // Svix-branded header keys (primary)
    public static final String SVIX_MSG_ID_KEY = "svix-id";
    public static final String SVIX_MSG_SIGNATURE_KEY = "svix-signature";
    public static final String SVIX_MSG_TIMESTAMP_KEY = "svix-timestamp";

    // Standard webhook header keys (fallback)
    public static final String WEBHOOK_MSG_ID_KEY = "webhook-id";
    public static final String WEBHOOK_MSG_SIGNATURE_KEY = "webhook-signature";
    public static final String WEBHOOK_MSG_TIMESTAMP_KEY = "webhook-timestamp";

    private final com.standardwebhooks.Webhook delegate;

    /**
     * Create a new Webhook verifier with the given secret.
     *
     * @param secret The webhook signing secret. May include the "whsec_" prefix.
     */
    public Webhook(final String secret) {
        this.delegate = new com.standardwebhooks.Webhook(secret);
    }

    /**
     * Create a new Webhook verifier with the given secret as raw bytes.
     *
     * @param secret The webhook signing secret as raw bytes (Base64-decoded).
     */
    public Webhook(final byte[] secret) {
        this.delegate = new com.standardwebhooks.Webhook(secret);
    }

    /**
     * Verify a webhook payload using HttpHeaders.
     *
     * <p>This method validates:
     * <ul>
     *   <li>The timestamp is within the allowed tolerance (5 minutes)</li>
     *   <li>The signature matches the expected HMAC-SHA256 signature</li>
     * </ul>
     *
     * <p>Accepts both svix-* and webhook-* header formats.
     *
     * @param payload The raw webhook payload body as a string
     * @param headers The HTTP headers from the webhook request
     * @throws WebhookVerificationException if verification fails
     */
    public void verify(final String payload, final HttpHeaders headers)
            throws WebhookVerificationException {
        Map<String, List<String>> headerMap = normalizeHeaders(headers.map());
        delegate.verify(payload, headerMap);
    }

    /**
     * Verify a webhook payload using a header map.
     *
     * <p>This method is useful when you have headers as a Map rather than HttpHeaders.
     * Accepts both svix-* and webhook-* header formats.
     *
     * @param payload The raw webhook payload body as a string
     * @param headers Map of header names to lists of header values
     * @throws WebhookVerificationException if verification fails
     */
    public void verify(final String payload, final Map<String, List<String>> headers)
            throws WebhookVerificationException {
        Map<String, List<String>> normalizedHeaders = normalizeHeaders(headers);
        delegate.verify(payload, normalizedHeaders);
    }

    /**
     * Sign a webhook payload (useful for testing).
     *
     * @param msgId The message ID
     * @param timestamp Unix timestamp in seconds
     * @param payload The payload to sign
     * @return The signature in "v1,{base64-signature}" format
     * @throws com.standardwebhooks.exceptions.WebhookSigningException if signing fails
     */
    public String sign(final String msgId, final long timestamp, final String payload)
            throws com.standardwebhooks.exceptions.WebhookSigningException {
        return delegate.sign(msgId, timestamp, payload);
    }

    /**
     * Normalize headers by converting svix-* headers to webhook-* format.
     * If svix-* headers are present, they take precedence over webhook-* headers.
     */
    private Map<String, List<String>> normalizeHeaders(final Map<String, List<String>> headers) {
        Map<String, List<String>> normalized = new HashMap<>();

        // Copy all headers with lowercase keys
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            normalized.put(entry.getKey().toLowerCase(), new ArrayList<>(entry.getValue()));
        }

        // Map svix-* headers to webhook-* headers (svix takes precedence)
        mapHeader(normalized, SVIX_MSG_ID_KEY, WEBHOOK_MSG_ID_KEY);
        mapHeader(normalized, SVIX_MSG_SIGNATURE_KEY, WEBHOOK_MSG_SIGNATURE_KEY);
        mapHeader(normalized, SVIX_MSG_TIMESTAMP_KEY, WEBHOOK_MSG_TIMESTAMP_KEY);

        return normalized;
    }

    /**
     * If the source header exists, copy its value to the target header.
     */
    private void mapHeader(Map<String, List<String>> headers, String source, String target) {
        List<String> sourceValue = headers.get(source);
        if (sourceValue != null && !sourceValue.isEmpty()) {
            headers.put(target, sourceValue);
        }
    }
}
