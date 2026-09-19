//! `POST /api/webhooks/meteroid` — the signed webhook receiver.

use axum::{body::Bytes, extract::State, http::HeaderMap, http::StatusCode, Json};
use meteroid_rs::webhooks::Webhook;

use crate::{
    dto::WebhookAck,
    error::{ApiError, ApiResult, ErrorCode},
    state::AppState,
};

/// Verify the Standard Webhooks signature over the **raw** request body, then act on
/// what the demo recognizes and acknowledge the rest.
///
/// Two rules matter more than anything else here:
///
/// 1. **Verify the raw bytes.** `body` is the exact payload Meteroid signed. Parsing the
///    JSON and re-serializing it before verifying is the classic bug — any difference in
///    key order or spacing breaks the signature.
/// 2. **Never reject a correctly signed body for its shape.** Meteroid owns the event
///    envelope and adds event types over time; a receiver that 400s on an unknown type
///    breaks the first time the sender ships a new one. `400` is for a bad signature and
///    for a body that is not JSON at all — nothing else.
pub async fn receive_webhook(
    State(state): State<AppState>,
    headers: HeaderMap,
    body: Bytes,
) -> ApiResult<(StatusCode, Json<WebhookAck>)> {
    let secret = &state.config.meteroid_webhook_secret;
    if secret.is_empty() {
        // An operator problem, not a caller problem: never report it as a bad signature.
        return Err(ApiError::internal(
            "METEROID_WEBHOOK_SECRET is not set, so inbound webhooks cannot be verified. \
             Copy the signing secret from your Meteroid webhook endpoint (examples/CATALOG.md).",
        ));
    }

    // The SDK accepts both `webhook-*` and `svix-*` headers and enforces the five-minute
    // timestamp tolerance itself.
    Webhook::new(secret)
        .and_then(|webhook| webhook.verify(&body, &headers))
        .map_err(|err| {
            ApiError::new(
                ErrorCode::WebhookSignatureInvalid,
                format!("Webhook signature verification failed: {err}"),
            )
        })?;

    let event: serde_json::Value = serde_json::from_slice(&body).map_err(|err| {
        ApiError::new(
            ErrorCode::WebhookSignatureInvalid,
            format!("Webhook body is signed but is not JSON: {err}"),
        )
    })?;

    let event_type = event
        .get("type")
        .and_then(serde_json::Value::as_str)
        .map(str::to_string);
    let event_id = event
        .get("id")
        .and_then(serde_json::Value::as_str)
        .map(str::to_string)
        // `webhook-id` is required and verification just passed, so there is always
        // something to echo.
        .or_else(|| {
            headers
                .get("webhook-id")
                .or_else(|| headers.get("svix-id"))
                .and_then(|value| value.to_str().ok())
                .map(str::to_string)
        })
        .unwrap_or_default();

    // The demo "handles" invoice and subscription events by logging them; the frontend
    // shows the last few in its activity feed. Everything else is acknowledged, ignored,
    // and explicitly reported as unhandled.
    let handled = matches!(event_type.as_deref(), Some(kind)
        if kind.starts_with("invoice.") || kind.starts_with("subscription."));

    if handled {
        tracing::info!(event_id = %event_id, event_type = ?event_type, "meteroid webhook handled");
    } else {
        tracing::debug!(event_id = %event_id, event_type = ?event_type, "meteroid webhook ignored");
    }

    // 202: the signature verified and the body was accepted. Whether the demo
    // understood the event is what `handled` reports.
    Ok((
        StatusCode::ACCEPTED,
        Json(WebhookAck {
            received: true,
            event_id,
            kind: event_type,
            handled,
        }),
    ))
}
