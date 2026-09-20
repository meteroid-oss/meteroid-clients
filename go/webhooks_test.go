package meteroid

import (
	"errors"
	"net/http"
	"strconv"
	"testing"
	"time"
)

const testWebhookSecret = "whsec_C2FVsBQIhrscChlQIMV+b5sSYspob7oD"

func signedHeaders(t *testing.T, prefix string, payload []byte, at time.Time) (http.Header, *Webhook) {
	t.Helper()

	wh, err := NewWebhook(testWebhookSecret)
	if err != nil {
		t.Fatalf("NewWebhook: %v", err)
	}

	headers := http.Header{}
	headers.Set(prefix+"-id", "msg_test123")
	headers.Set(prefix+"-timestamp", strconv.FormatInt(at.Unix(), 10))
	headers.Set(prefix+"-signature", wh.Sign("msg_test123", at, payload))
	return headers, wh
}

func TestVerifyStandardHeaders(t *testing.T) {
	payload := []byte(`{"test": "data"}`)
	headers, wh := signedHeaders(t, "webhook", payload, time.Now())

	if err := wh.Verify(payload, headers); err != nil {
		t.Fatalf("Verify: %v", err)
	}
}

func TestVerifySvixHeaders(t *testing.T) {
	payload := []byte(`{"test": "data"}`)
	headers, wh := signedHeaders(t, "svix", payload, time.Now())

	if err := wh.Verify(payload, headers); err != nil {
		t.Fatalf("Verify: %v", err)
	}
}

// Several signatures may be present during a secret rotation; matching any one
// of them is enough.
func TestVerifyAcceptsOneOfSeveralSignatures(t *testing.T) {
	payload := []byte(`{"test": "data"}`)
	now := time.Now()
	headers, wh := signedHeaders(t, "webhook", payload, now)
	headers.Set("webhook-signature", "v1,bogus "+headers.Get("webhook-signature"))

	if err := wh.Verify(payload, headers); err != nil {
		t.Fatalf("Verify: %v", err)
	}
}

func TestVerifyRejectsBadSignature(t *testing.T) {
	payload := []byte(`{"test": "data"}`)
	headers, wh := signedHeaders(t, "webhook", payload, time.Now())
	headers.Set("webhook-signature", "v1,invalid_signature_here")

	if err := wh.Verify(payload, headers); !errors.Is(err, ErrWebhookNoMatchingSignature) {
		t.Fatalf("Verify error = %v, want ErrWebhookNoMatchingSignature", err)
	}
}

func TestVerifyRejectsTamperedPayload(t *testing.T) {
	payload := []byte(`{"test": "data"}`)
	headers, wh := signedHeaders(t, "webhook", payload, time.Now())

	if err := wh.Verify([]byte(`{"test": "tampered"}`), headers); !errors.Is(err, ErrWebhookNoMatchingSignature) {
		t.Fatalf("Verify error = %v, want ErrWebhookNoMatchingSignature", err)
	}
}

func TestVerifyRejectsOldTimestamp(t *testing.T) {
	payload := []byte(`{"test": "data"}`)
	headers, wh := signedHeaders(t, "webhook", payload, time.Now().Add(-10*time.Minute))

	if err := wh.Verify(payload, headers); !errors.Is(err, ErrWebhookTimestampTooOld) {
		t.Fatalf("Verify error = %v, want ErrWebhookTimestampTooOld", err)
	}
}

func TestVerifyRejectsFutureTimestamp(t *testing.T) {
	payload := []byte(`{"test": "data"}`)
	headers, wh := signedHeaders(t, "webhook", payload, time.Now().Add(10*time.Minute))

	if err := wh.Verify(payload, headers); !errors.Is(err, ErrWebhookTimestampTooNew) {
		t.Fatalf("Verify error = %v, want ErrWebhookTimestampTooNew", err)
	}
}

func TestVerifyRejectsMissingHeaders(t *testing.T) {
	wh, err := NewWebhook(testWebhookSecret)
	if err != nil {
		t.Fatalf("NewWebhook: %v", err)
	}

	if err := wh.Verify([]byte(`{}`), http.Header{}); !errors.Is(err, ErrWebhookMissingHeaders) {
		t.Fatalf("Verify error = %v, want ErrWebhookMissingHeaders", err)
	}
}

// The secret is accepted with or without the whsec_ prefix.
func TestSecretPrefixIsOptional(t *testing.T) {
	payload := []byte(`{"test": "data"}`)
	now := time.Now()

	withPrefix, err := NewWebhook(testWebhookSecret)
	if err != nil {
		t.Fatalf("NewWebhook: %v", err)
	}
	withoutPrefix, err := NewWebhook(testWebhookSecret[len(WebhookSecretPrefix):])
	if err != nil {
		t.Fatalf("NewWebhook: %v", err)
	}

	if withPrefix.Sign("msg_1", now, payload) != withoutPrefix.Sign("msg_1", now, payload) {
		t.Error("the whsec_ prefix changed the signature")
	}
}

func TestNewWebhookRejectsInvalidSecret(t *testing.T) {
	if _, err := NewWebhook("whsec_not base64!"); err == nil {
		t.Fatal("expected an error for a non base64 secret")
	}
}
