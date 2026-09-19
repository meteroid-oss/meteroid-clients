//! End-to-end checks that need no Meteroid tenant.
//!
//! Everything reachable without an API key is exercised here against the shapes
//! `examples/openapi.yaml` promises: the health probe, the session-token gate, the
//! error envelope, the 404 fallback, and — the interesting one — webhook signature
//! verification, which works offline because the SDK ships a *signer* as well as a
//! verifier. The contract suite uses the same trick to test the receiver for real.

use axum::{
    body::Body,
    http::{Request, StatusCode},
    Router,
};
use http_body_util::BodyExt;
use meteroid_rs::{models::Currency, webhooks::Webhook};
use serde_json::{json, Value};
use tower::ServiceExt;

use crate::{config::Config, router, session, state::AppState};

/// Any base64 string is a valid Standard Webhooks secret.
const WEBHOOK_SECRET: &str = "c2NyaWJlLWRlbW8td2ViaG9vay1zZWNyZXQ=";
const SESSION_SECRET: &str = "test-session-secret";

fn test_router() -> Router {
    router(AppState::new(Config {
        // No API key: every Meteroid-backed operation is out of scope here.
        meteroid_api_key: String::new(),
        meteroid_base_url: "http://127.0.0.1:1/unreachable".to_string(),
        meteroid_webhook_secret: WEBHOOK_SECRET.to_string(),
        session_secret: SESSION_SECRET.to_string(),
        default_currency: Currency::Usd,
        port: 0,
    }))
}

async fn send(request: Request<Body>) -> (StatusCode, Value) {
    let response = test_router()
        .oneshot(request)
        .await
        .expect("router responds");
    let status = response.status();
    let bytes = response.into_body().collect().await.unwrap().to_bytes();
    let body = serde_json::from_slice(&bytes).unwrap_or(Value::Null);
    (status, body)
}

/// Every error in the contract is the same envelope, with `quota` and
/// `upgrade_plan_code` always present — never absent, `null` when they do not apply.
fn assert_error_envelope(body: &Value, code: &str) {
    assert_eq!(body["code"], code, "body was {body}");
    assert!(body["message"].is_string(), "body was {body}");
    assert!(body.get("quota").is_some(), "quota key missing: {body}");
    assert!(
        body.get("upgrade_plan_code").is_some(),
        "upgrade_plan_code key missing: {body}"
    );
}

#[tokio::test]
async fn health_reports_the_backend_and_its_configuration() {
    let (status, body) = send(Request::get("/api/health").body(Body::empty()).unwrap()).await;

    assert_eq!(status, StatusCode::OK);
    assert_eq!(body["status"], "ok");
    assert_eq!(body["backend"], "rust");
    assert_eq!(body["meteroid_configured"], false);
    assert!(body["version"].is_string());
}

#[tokio::test]
async fn a_missing_session_token_is_401_in_the_standard_envelope() {
    let (status, body) = send(Request::get("/api/me").body(Body::empty()).unwrap()).await;

    assert_eq!(status, StatusCode::UNAUTHORIZED);
    assert_error_envelope(&body, "UNAUTHORIZED");
}

#[tokio::test]
async fn a_token_from_another_deployment_is_rejected() {
    let forged = session::mint("some-other-secret", "scribe-demo-1");
    let (status, body) = send(
        Request::get("/api/me")
            .header("authorization", format!("Bearer {forged}"))
            .body(Body::empty())
            .unwrap(),
    )
    .await;

    assert_eq!(status, StatusCode::UNAUTHORIZED);
    assert_error_envelope(&body, "UNAUTHORIZED");
}

#[tokio::test]
async fn an_unknown_route_is_404_in_the_standard_envelope() {
    let (status, body) = send(Request::get("/api/nope").body(Body::empty()).unwrap()).await;

    assert_eq!(status, StatusCode::NOT_FOUND);
    assert_error_envelope(&body, "NOT_FOUND");
}

#[tokio::test]
async fn a_malformed_body_is_400_in_the_standard_envelope() {
    let token = session::mint(SESSION_SECRET, "scribe-demo-1");
    let (status, body) = send(
        Request::post("/api/transcriptions")
            .header("authorization", format!("Bearer {token}"))
            .header("content-type", "application/json")
            // `duration_seconds` is required, and unknown fields are rejected.
            .body(Body::from(r#"{"title":"x","surprise":true}"#))
            .unwrap(),
    )
    .await;

    assert_eq!(status, StatusCode::BAD_REQUEST);
    assert_error_envelope(&body, "BAD_REQUEST");
}

#[tokio::test]
async fn an_oversized_body_is_413_in_the_standard_envelope() {
    let token = session::mint(SESSION_SECRET, "scribe-demo-1");
    let (status, body) = send(
        Request::post("/api/transcriptions")
            .header("authorization", format!("Bearer {token}"))
            .header("content-type", "application/json")
            .body(Body::from(vec![b' '; 3 * 1024 * 1024]))
            .unwrap(),
    )
    .await;

    assert_eq!(status, StatusCode::PAYLOAD_TOO_LARGE);
    assert_error_envelope(&body, "BAD_REQUEST");
}

#[tokio::test]
async fn an_out_of_range_portal_lifetime_is_rejected_before_meteroid_sees_it() {
    let token = session::mint(SESSION_SECRET, "scribe-demo-1");
    let (status, body) = send(
        Request::post("/api/portal-session")
            .header("authorization", format!("Bearer {token}"))
            .header("content-type", "application/json")
            .body(Body::from(r#"{"expires_in_seconds":5}"#))
            .unwrap(),
    )
    .await;

    assert_eq!(status, StatusCode::BAD_REQUEST);
    assert_error_envelope(&body, "BAD_REQUEST");
}

/// Sign a payload exactly the way Meteroid does, using the SDK's own signer.
fn signed(payload: &[u8], msg_id: &str) -> (String, String) {
    let timestamp = chrono::Utc::now().timestamp();
    let signature = Webhook::new(WEBHOOK_SECRET)
        .unwrap()
        .sign(msg_id, timestamp, payload)
        .unwrap();
    (timestamp.to_string(), signature)
}

#[tokio::test]
async fn a_correctly_signed_event_is_accepted() {
    let payload = json!({
        "id": "evt_123",
        "type": "invoice.paid",
        "timestamp": "2026-09-01T12:00:00Z"
    })
    .to_string();
    let (timestamp, signature) = signed(payload.as_bytes(), "msg_1");

    let (status, body) = send(
        Request::post("/api/webhooks/meteroid")
            .header("content-type", "application/json")
            .header("webhook-id", "msg_1")
            .header("webhook-timestamp", timestamp)
            .header("webhook-signature", signature)
            .body(Body::from(payload))
            .unwrap(),
    )
    .await;

    assert_eq!(status, StatusCode::ACCEPTED);
    assert_eq!(body["received"], true);
    assert_eq!(body["event_id"], "evt_123");
    assert_eq!(body["type"], "invoice.paid");
    assert_eq!(body["handled"], true);
}

#[tokio::test]
async fn an_unknown_event_type_is_acknowledged_not_rejected() {
    // A receiver that 400s on an unrecognized type breaks the first time Meteroid ships
    // a new one — so this must be a 202 with `handled: false`. The body also carries no
    // `timestamp`, which must not matter either.
    let payload = json!({ "id": "evt_9", "type": "something.invented.later" }).to_string();
    let (timestamp, signature) = signed(payload.as_bytes(), "msg_9");

    let (status, body) = send(
        Request::post("/api/webhooks/meteroid")
            .header("content-type", "application/json")
            .header("webhook-id", "msg_9")
            .header("webhook-timestamp", timestamp)
            .header("webhook-signature", signature)
            .body(Body::from(payload))
            .unwrap(),
    )
    .await;

    assert_eq!(status, StatusCode::ACCEPTED);
    assert_eq!(body["handled"], false);
    assert_eq!(body["event_id"], "evt_9");
}

#[tokio::test]
async fn an_event_with_no_id_falls_back_to_the_webhook_id_header() {
    let payload = json!({ "type": "subscription.created" }).to_string();
    let (timestamp, signature) = signed(payload.as_bytes(), "msg_42");

    let (status, body) = send(
        Request::post("/api/webhooks/meteroid")
            .header("content-type", "application/json")
            .header("webhook-id", "msg_42")
            .header("webhook-timestamp", timestamp)
            .header("webhook-signature", signature)
            .body(Body::from(payload))
            .unwrap(),
    )
    .await;

    assert_eq!(status, StatusCode::ACCEPTED);
    assert_eq!(body["event_id"], "msg_42");
    assert_eq!(body["handled"], true);
}

#[tokio::test]
async fn svix_headers_are_accepted_as_aliases() {
    let payload = json!({ "id": "evt_s", "type": "invoice.finalized" }).to_string();
    let (timestamp, signature) = signed(payload.as_bytes(), "msg_s");

    let (status, body) = send(
        Request::post("/api/webhooks/meteroid")
            .header("content-type", "application/json")
            .header("svix-id", "msg_s")
            .header("svix-timestamp", timestamp)
            .header("svix-signature", signature)
            .body(Body::from(payload))
            .unwrap(),
    )
    .await;

    assert_eq!(status, StatusCode::ACCEPTED);
    assert_eq!(body["event_id"], "evt_s");
}

#[tokio::test]
async fn a_body_that_does_not_match_its_signature_is_rejected() {
    let payload = json!({ "id": "evt_1", "type": "invoice.paid" }).to_string();
    let (timestamp, signature) = signed(payload.as_bytes(), "msg_1");

    let (status, body) = send(
        Request::post("/api/webhooks/meteroid")
            .header("content-type", "application/json")
            .header("webhook-id", "msg_1")
            .header("webhook-timestamp", timestamp)
            .header("webhook-signature", signature)
            // One field different from what was signed.
            .body(Body::from(
                json!({ "id": "evt_1", "type": "invoice.void" }).to_string(),
            ))
            .unwrap(),
    )
    .await;

    assert_eq!(status, StatusCode::BAD_REQUEST);
    assert_error_envelope(&body, "WEBHOOK_SIGNATURE_INVALID");
}

#[tokio::test]
async fn an_unsigned_event_is_rejected() {
    let (status, body) = send(
        Request::post("/api/webhooks/meteroid")
            .header("content-type", "application/json")
            .body(Body::from(r#"{"type":"invoice.paid"}"#))
            .unwrap(),
    )
    .await;

    assert_eq!(status, StatusCode::BAD_REQUEST);
    assert_error_envelope(&body, "WEBHOOK_SIGNATURE_INVALID");
}
