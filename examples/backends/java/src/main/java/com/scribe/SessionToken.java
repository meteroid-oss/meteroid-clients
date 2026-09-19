package com.scribe;

import io.javalin.http.Context;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Demo session tokens — the Java twin of the Rust backend's {@code src/session.rs}.
 *
 * <p>There is no real user auth in this demo; that is not what it teaches. A session token is a
 * stateless HMAC over the Meteroid customer alias:
 *
 * <pre>{@code
 * v1.<base64url(alias)>.<base64url(hmac_sha256(SCRIBE_SESSION_SECRET, alias))>
 * }</pre>
 *
 * <p>Stateless and deterministic means every backend that shares the secret mints and accepts the
 * same tokens, so one contract-suite session works against all of them. The Meteroid API key never
 * leaves the backend.
 */
public final class SessionToken {

    private static final Base64.Encoder ENCODER = Base64.getUrlEncoder().withoutPadding();
    private static final Base64.Decoder DECODER = Base64.getUrlDecoder();

    private SessionToken() {}

    public static String mint(String secret, String alias) {
        return "v1."
                + ENCODER.encodeToString(alias.getBytes(StandardCharsets.UTF_8))
                + "."
                + ENCODER.encodeToString(sign(secret, alias));
    }

    /**
     * Returns the customer alias the token is bound to.
     *
     * @throws ApiError {@code 401 UNAUTHORIZED} when the token is malformed or was not signed by
     *     this deployment.
     */
    public static String verify(String secret, String token) {
        String[] parts = token.split("\\.", 3);
        if (parts.length != 3 || !"v1".equals(parts[0])) {
            throw ApiError.unauthorized(
                    "Session token is malformed; expected `v1.<payload>.<signature>`.");
        }

        String alias;
        byte[] signature;
        try {
            alias = new String(DECODER.decode(parts[1]), StandardCharsets.UTF_8);
            signature = DECODER.decode(parts[2]);
        } catch (IllegalArgumentException e) {
            throw ApiError.unauthorized("Session token is not valid base64url.");
        }

        // Constant-time comparison: a length-dependent early exit here leaks the signature one
        // byte at a time.
        if (!MessageDigest.isEqual(sign(secret, alias), signature)) {
            throw ApiError.unauthorized("Session token was not signed by this deployment.");
        }
        return alias;
    }

    /**
     * The Javalin equivalent of the Rust backend's {@code Session} extractor: call this at the top
     * of a handler and the route requires a valid {@code Authorization: Bearer <session_token>}.
     *
     * @return the Meteroid customer alias this workspace maps onto. Every Meteroid call in this
     *     backend passes it where an {@code id_or_alias} is accepted.
     */
    public static String requireCustomerAlias(Context ctx, Config config) {
        String header = ctx.header("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            throw ApiError.unauthorized("Missing Authorization: Bearer <session_token> header.");
        }
        String token = header.substring("Bearer ".length()).trim();
        if (token.isEmpty()) {
            throw ApiError.unauthorized("Missing Authorization: Bearer <session_token> header.");
        }
        return verify(config.sessionSecret, token);
    }

    private static byte[] sign(String secret, String alias) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            return mac.doFinal(alias.getBytes(StandardCharsets.UTF_8));
        } catch (java.security.GeneralSecurityException e) {
            // HmacSHA256 is required of every JRE and accepts a key of any length, so neither
            // branch is reachable in practice.
            throw new IllegalStateException("HmacSHA256 is unavailable", e);
        }
    }
}
