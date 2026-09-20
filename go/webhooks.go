package meteroid

import (
	"crypto/hmac"
	"crypto/sha256"
	"encoding/base64"
	"errors"
	"fmt"
	"net/http"
	"strconv"
	"strings"
	"time"
)

// Webhook verifies the signature of incoming Meteroid webhooks.
//
// Meteroid signs webhooks following the Standard Webhooks specification
// (https://www.standardwebhooks.com). Both the standard `webhook-*` headers and
// the Svix-branded `svix-*` headers are accepted; the standard ones win when
// both are present.
//
//	wh, err := meteroid.NewWebhook(os.Getenv("METEROID_WEBHOOK_SECRET"))
//	if err != nil {
//		return err
//	}
//	if err := wh.Verify(body, r.Header); err != nil {
//		http.Error(w, "invalid signature", http.StatusBadRequest)
//		return
//	}
type Webhook struct {
	key []byte
}

// WebhookSecretPrefix is the optional prefix Meteroid uses for webhook secrets.
const WebhookSecretPrefix = "whsec_"

// WebhookTolerance is how far the signed timestamp may drift from the current
// time before verification fails.
const WebhookTolerance = 5 * time.Minute

// Errors returned by Webhook.Verify.
var (
	// ErrWebhookMissingHeaders is returned when the request carries no
	// recognizable webhook id, timestamp or signature header.
	ErrWebhookMissingHeaders = errors.New("meteroid: missing webhook signature headers")
	// ErrWebhookInvalidTimestamp is returned when the timestamp header is not a
	// Unix timestamp.
	ErrWebhookInvalidTimestamp = errors.New("meteroid: invalid webhook timestamp header")
	// ErrWebhookTimestampTooOld is returned when the signed timestamp is older
	// than WebhookTolerance.
	ErrWebhookTimestampTooOld = errors.New("meteroid: webhook timestamp is too old")
	// ErrWebhookTimestampTooNew is returned when the signed timestamp is further
	// than WebhookTolerance in the future.
	ErrWebhookTimestampTooNew = errors.New("meteroid: webhook timestamp is too far in the future")
	// ErrWebhookNoMatchingSignature is returned when none of the signatures in
	// the request matches the expected one.
	ErrWebhookNoMatchingSignature = errors.New("meteroid: no matching webhook signature")
)

// Header names inspected during verification, in precedence order.
var (
	webhookIDHeaders        = []string{"webhook-id", "svix-id"}
	webhookTimestampHeaders = []string{"webhook-timestamp", "svix-timestamp"}
	webhookSignatureHeaders = []string{"webhook-signature", "svix-signature"}
)

// NewWebhook builds a verifier from a signing secret. The secret may carry the
// "whsec_" prefix; the remainder is base64 encoded.
func NewWebhook(secret string) (*Webhook, error) {
	key, err := base64.StdEncoding.DecodeString(strings.TrimPrefix(secret, WebhookSecretPrefix))
	if err != nil {
		return nil, fmt.Errorf("meteroid: webhook secret is not valid base64: %w", err)
	}
	return &Webhook{key: key}, nil
}

// NewWebhookRaw builds a verifier from an already decoded signing key.
func NewWebhookRaw(key []byte) *Webhook {
	return &Webhook{key: append([]byte(nil), key...)}
}

// Verify checks the signature of a webhook payload. It returns nil when the
// payload is authentic and was signed within WebhookTolerance.
//
// payload must be the exact bytes of the request body, before any parsing.
func (w *Webhook) Verify(payload []byte, headers http.Header) error {
	msgID := firstHeader(headers, webhookIDHeaders)
	msgTimestamp := firstHeader(headers, webhookTimestampHeaders)
	msgSignature := firstHeader(headers, webhookSignatureHeaders)
	if msgID == "" || msgTimestamp == "" || msgSignature == "" {
		return ErrWebhookMissingHeaders
	}

	seconds, err := strconv.ParseInt(msgTimestamp, 10, 64)
	if err != nil {
		return ErrWebhookInvalidTimestamp
	}
	timestamp := time.Unix(seconds, 0)
	now := time.Now()
	if timestamp.Before(now.Add(-WebhookTolerance)) {
		return ErrWebhookTimestampTooOld
	}
	if timestamp.After(now.Add(WebhookTolerance)) {
		return ErrWebhookTimestampTooNew
	}

	expected := w.signature(msgID, seconds, payload)

	// The header holds a space separated list of `version,signature` pairs so
	// that secrets can be rotated without downtime.
	for _, part := range strings.Fields(msgSignature) {
		version, signature, ok := strings.Cut(part, ",")
		if !ok || version != "v1" {
			continue
		}
		if hmac.Equal([]byte(signature), []byte(expected)) {
			return nil
		}
	}

	return ErrWebhookNoMatchingSignature
}

// Sign produces the value of the webhook-signature header for a payload. It is
// mainly useful to exercise webhook handling in tests.
func (w *Webhook) Sign(msgID string, timestamp time.Time, payload []byte) string {
	return "v1," + w.signature(msgID, timestamp.Unix(), payload)
}

func (w *Webhook) signature(msgID string, timestamp int64, payload []byte) string {
	mac := hmac.New(sha256.New, w.key)
	mac.Write([]byte(msgID))
	mac.Write([]byte("."))
	mac.Write([]byte(strconv.FormatInt(timestamp, 10)))
	mac.Write([]byte("."))
	mac.Write(payload)
	return base64.StdEncoding.EncodeToString(mac.Sum(nil))
}

func firstHeader(headers http.Header, names []string) string {
	for _, name := range names {
		if value := headers.Get(name); value != "" {
			return value
		}
	}
	return ""
}
