package main

import (
	"context"
	"encoding/json"
	"log/slog"
	"strings"
	"unicode/utf8"

	meteroid "github.com/meteroid-oss/meteroid-clients/go"
)

// receiveWebhook is `POST /api/webhooks/meteroid` — the signed webhook receiver.
//
// It verifies the Standard Webhooks signature over the **raw** request body, then acts
// on what the demo recognizes and acknowledges the rest. Two rules matter more than
// anything else here:
//
//  1. **Verify the raw bytes.** r.rawBody() is the exact payload Meteroid signed.
//     Parsing the JSON and re-serializing it before verifying is the classic bug — any
//     difference in key order or spacing breaks the signature.
//  2. **Never reject a correctly signed body for its shape.** Meteroid owns the event
//     envelope and adds event types over time; a receiver that 400s on an unknown type
//     breaks the first time the sender ships a new one. 400 is for a bad signature and
//     for a body that is not JSON at all — nothing else.
func (a *app) receiveWebhook(_ context.Context, r *request) (*reply, error) {
	secret := a.config.meteroidWebhookSecret
	if secret == "" {
		// An operator problem, not a caller problem: never report it as a bad signature.
		return nil, internalError("METEROID_WEBHOOK_SECRET is not set, so inbound webhooks cannot be verified. " +
			"Copy the signing secret from your Meteroid webhook endpoint (examples/CATALOG.md).")
	}
	body, err := r.rawBody()
	if err != nil {
		return nil, err
	}

	// The SDK accepts both `webhook-*` and `svix-*` headers and enforces the five-minute
	// timestamp tolerance itself.
	webhook, err := meteroid.NewWebhook(secret)
	if err == nil {
		err = webhook.Verify(body, r.header)
	}
	if err != nil {
		return nil, newAPIError(codeWebhookSignatureInvalid, "Webhook signature verification failed: %v", err)
	}

	// Verify says the bytes are authentic, not that they are JSON.
	var event any
	if !utf8.Valid(body) {
		return nil, newAPIError(codeWebhookSignatureInvalid, "Webhook body is signed but is not JSON: it is not valid UTF-8")
	}
	if err := json.Unmarshal(body, &event); err != nil {
		return nil, newAPIError(codeWebhookSignatureInvalid, "Webhook body is signed but is not JSON: %v", err)
	}

	// Only an object has fields, and only a string is an id or a type.
	field := func(name string) *string {
		object, _ := event.(map[string]any)
		if value, ok := object[name].(string); ok {
			return &value
		}
		return nil
	}

	eventType := field("type")
	// `webhook-id` is required and verification just passed, so there is always
	// something to echo.
	eventID := r.header.Get("webhook-id")
	if eventID == "" {
		eventID = r.header.Get("svix-id")
	}
	if id := field("id"); id != nil {
		eventID = *id
	}

	// The demo "handles" invoice and subscription events by logging them; the frontend
	// shows the last few in its activity feed. Everything else is acknowledged, ignored,
	// and explicitly reported as unhandled.
	handled := eventType != nil &&
		(strings.HasPrefix(*eventType, "invoice.") || strings.HasPrefix(*eventType, "subscription."))
	if handled {
		slog.Info("meteroid webhook handled", "event_id", eventID, "event_type", *eventType)
	}

	// 202: the signature verified and the body was accepted. Whether the demo understood
	// the event is what `handled` reports.
	return replyAccepted(WebhookAck{Received: true, EventID: eventID, Type: eventType, Handled: handled})
}
