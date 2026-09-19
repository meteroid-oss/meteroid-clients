package com.scribe;

import com.meteroid.Meteroid;
import com.meteroid.MeteroidOptions;
import com.meteroid.models.Currency;

/**
 * Configuration, entirely from the environment. Nothing here is ever hard-coded — see
 * {@code examples/.env.example} for the full list and {@code README.md} for how to set it.
 *
 * <p>This is the Java twin of the Rust backend's {@code src/config.rs}; the two read exactly the
 * same variables so one {@code .env} drives either.
 */
public final class Config {

    /**
     * Meteroid API key. May be empty: the process still starts so that {@code GET /api/health} can
     * report {@code meteroid_configured: false} instead of the operator getting a silent crash.
     */
    public final String meteroidApiKey;

    public final String meteroidBaseUrl;

    /** Signing secret of the Meteroid webhook endpoint ({@code whsec_…}). May be empty. */
    public final String meteroidWebhookSecret;

    /** HMAC key for demo session tokens. Not a Meteroid credential. */
    public final String sessionSecret;

    /** Currency new demo customers are created with. Must match the seeded plans. */
    public final Currency defaultCurrency;

    public final int port;

    private Config(
            String meteroidApiKey,
            String meteroidBaseUrl,
            String meteroidWebhookSecret,
            String sessionSecret,
            Currency defaultCurrency,
            int port) {
        this.meteroidApiKey = meteroidApiKey;
        this.meteroidBaseUrl = meteroidBaseUrl;
        this.meteroidWebhookSecret = meteroidWebhookSecret;
        this.sessionSecret = sessionSecret;
        this.defaultCurrency = defaultCurrency;
        this.port = port;
    }

    /** A configuration problem the operator has to fix. Reported at startup, never to a client. */
    public static final class ConfigException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public ConfigException(String message) {
            super(message);
        }
    }

    public static Config fromEnv() {
        String baseUrl = nonEmpty("METEROID_BASE_URL");
        if (baseUrl == null) {
            baseUrl = MeteroidOptions.DEFAULT_URL;
        }

        // `PORT` is the convention every host uses; `SCRIBE_PORT` is what examples/.env.example
        // calls it. Accept both, `PORT` wins.
        String rawPort = nonEmpty("PORT");
        if (rawPort == null) {
            rawPort = nonEmpty("SCRIBE_PORT");
        }
        if (rawPort == null) {
            rawPort = "8081";
        }
        int port;
        try {
            port = Integer.parseInt(rawPort);
        } catch (NumberFormatException e) {
            throw new ConfigException(
                    "PORT must be a number between 1 and 65535, got \"" + rawPort + "\"");
        }
        if (port < 1 || port > 65535) {
            throw new ConfigException(
                    "PORT must be a number between 1 and 65535, got \"" + rawPort + "\"");
        }

        String currencyCode = nonEmpty("SCRIBE_DEFAULT_CURRENCY");
        Currency defaultCurrency = parseCurrency(currencyCode == null ? "USD" : currencyCode);

        // The session secret has no safe default: a predictable one would let anyone mint a token
        // for any workspace. Refuse to start without it.
        String sessionSecret = nonEmpty("SCRIBE_SESSION_SECRET");
        if (sessionSecret == null) {
            throw new ConfigException(
                    "SCRIBE_SESSION_SECRET is not set. It is the HMAC key for demo session tokens; "
                            + "generate one with `openssl rand -hex 32`. See examples/.env.example.");
        }

        String apiKey = nonEmpty("METEROID_API_KEY");
        String webhookSecret = nonEmpty("METEROID_WEBHOOK_SECRET");

        return new Config(
                apiKey == null ? "" : apiKey,
                baseUrl,
                webhookSecret == null ? "" : webhookSecret,
                sessionSecret,
                defaultCurrency,
                port);
    }

    /**
     * Test seam: a configuration with no Meteroid credentials, so {@code meteroidConfigured()} is
     * false and the offline tests exercise the contract without touching the environment. The port
     * is irrelevant — the tests bind an ephemeral one.
     */
    public static Config forTests(String sessionSecret, String webhookSecret) {
        return new Config(
                "", MeteroidOptions.DEFAULT_URL, webhookSecret, sessionSecret, Currency.USD, 0);
    }

    /** True when the backend has enough credentials to reach Meteroid at all. */
    public boolean meteroidConfigured() {
        return !meteroidApiKey.isEmpty() && !meteroidBaseUrl.isEmpty();
    }

    /**
     * Build the Meteroid SDK client. One client is shared by every handler: it owns an OkHttp
     * connection pool, so building one per request would throw away keep-alive and TLS session
     * reuse. Every method on it is thread-safe.
     */
    public Meteroid meteroidClient() {
        MeteroidOptions options = new MeteroidOptions();
        options.setServerUrl(meteroidBaseUrl);
        return new Meteroid(meteroidApiKey, options);
    }

    private static String nonEmpty(String key) {
        String value = System.getenv(key);
        if (value == null) {
            return null;
        }
        value = value.trim();
        return value.isEmpty() ? null : value;
    }

    /** {@code Currency} is a closed enum in the SDK whose constant names are the ISO codes. */
    private static Currency parseCurrency(String code) {
        try {
            return Currency.valueOf(code.toUpperCase(java.util.Locale.ROOT));
        } catch (IllegalArgumentException e) {
            throw new ConfigException(
                    "SCRIBE_DEFAULT_CURRENCY=\""
                            + code
                            + "\" is not an ISO 4217 code Meteroid recognizes.");
        }
    }
}
