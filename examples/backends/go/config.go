package main

import (
	"fmt"
	"regexp"
	"strconv"
	"strings"
	"time"

	meteroid "github.com/meteroid-oss/meteroid-clients/go"
)

// defaultPort is this backend's own port, so every backend can run side by side.
const defaultPort = 8084

// config is everything the backend needs to start. Read once, at boot, entirely from
// the environment — see examples/.env.example for the full list.
type config struct {
	// meteroidAPIKey may be empty: the process still starts so that GET /api/health
	// can report meteroid_configured=false instead of the operator getting a silent crash.
	meteroidAPIKey  string
	meteroidBaseURL string
	// meteroidWebhookSecret is the signing secret of the Meteroid webhook endpoint
	// (whsec_…). May be empty.
	meteroidWebhookSecret string
	// sessionSecret is the HMAC key for demo session tokens. Not a Meteroid credential.
	sessionSecret string
	// defaultCurrency is what new demo customers are created with. Must match the
	// seeded plans.
	defaultCurrency meteroid.Currency
	port            int
}

// configError is a configuration problem the operator has to fix. Reported at startup,
// never to a client — which is why it reads as a sentence rather than as a Go error.
type configError string

func (e configError) Error() string { return string(e) }

func configErrorf(format string, args ...any) error {
	return configError(fmt.Sprintf(format, args...))
}

var digits = regexp.MustCompile(`^\d+$`)

// configFromEnv takes the lookup function rather than reading os.Getenv itself so the
// tests can hand it a map. Every error it returns is the operator's to fix.
func configFromEnv(getenv func(string) string) (config, error) {
	nonEmpty := func(key, fallback string) string {
		if value := strings.TrimSpace(getenv(key)); value != "" {
			return value
		}
		return fallback
	}

	// PORT is the convention every host uses; SCRIBE_PORT is what examples/.env.example
	// calls it. Accept both, PORT wins.
	rawPort := nonEmpty("PORT", nonEmpty("SCRIBE_PORT", strconv.Itoa(defaultPort)))
	port, err := strconv.Atoi(rawPort)
	if !digits.MatchString(rawPort) || err != nil || port < 1 || port > 65535 {
		return config{}, configErrorf("PORT must be a number between 1 and 65535, got %q", rawPort)
	}

	// The session secret has no safe default: a predictable one would let anyone mint a
	// token for any workspace. Refuse to start without it.
	sessionSecret := nonEmpty("SCRIBE_SESSION_SECRET", "")
	if sessionSecret == "" {
		return config{}, configError("SCRIBE_SESSION_SECRET is not set. It is the HMAC key for demo " +
			"session tokens; generate one with `openssl rand -hex 32`. See examples/.env.example.")
	}

	// Currency is an open string enum in the SDK, so a configuration string gets in by
	// being checked against the values it knows.
	rawCurrency := nonEmpty("SCRIBE_DEFAULT_CURRENCY", "USD")
	currency := meteroid.Currency(strings.ToUpper(rawCurrency))
	if !currency.IsKnown() {
		return config{}, configErrorf("SCRIBE_DEFAULT_CURRENCY=%q is not an ISO 4217 code Meteroid recognizes.", rawCurrency)
	}

	return config{
		meteroidAPIKey:        nonEmpty("METEROID_API_KEY", ""),
		meteroidBaseURL:       nonEmpty("METEROID_BASE_URL", meteroid.DefaultServerURL),
		meteroidWebhookSecret: nonEmpty("METEROID_WEBHOOK_SECRET", ""),
		sessionSecret:         sessionSecret,
		defaultCurrency:       currency,
		port:                  port,
	}, nil
}

// meteroidConfigured is true when the backend has enough credentials to reach
// Meteroid at all.
func (c config) meteroidConfigured() bool {
	return c.meteroidAPIKey != "" && c.meteroidBaseURL != ""
}

// meteroidClient builds the Meteroid SDK client. One client is shared by every handler;
// it is immutable and safe for concurrent use, so sharing it needs no care at all.
func (c config) meteroidClient() *meteroid.Client {
	return meteroid.New(c.meteroidAPIKey, &meteroid.Options{
		ServerURL: c.meteroidBaseURL,
		Timeout:   15 * time.Second,
	})
}
