// this file is @generated
use crate::{decode, mock};

#[tokio::test]
async fn list() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"sessions":[{"checkout_type":"PLAN_CHANGE","created_at":"2023-12-31T23:59:59.999-05:30","customer_id":"customer_id_47","id":"checkout_session_id_39","plan_version_id":"plan_version_id_67","status":"AWAITING_PAYMENT"}]}"#,
    );
    client.checkout_sessions().list(None).await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["GET /api/v1/checkout-sessions"]);
}

#[tokio::test]
async fn create() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"session":{"checkout_type":"PLAN_CHANGE","created_at":"2023-12-31T23:59:59.999-05:30","customer_id":"customer_id_47","id":"checkout_session_id_39","plan_version_id":"plan_version_id_67","status":"AWAITING_PAYMENT"}}"#,
    );
    client
        .checkout_sessions()
        .create(decode::<meteroid_rs::models::CreateCheckoutSessionRequest>(
            r#"{"customer_id":"sample","plan_version_id":"plan_version_id_2"}"#,
        ))
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/checkout-sessions"]
    );
}

#[tokio::test]
async fn retrieve() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"session":{"checkout_type":"PLAN_CHANGE","created_at":"2023-12-31T23:59:59.999-05:30","customer_id":"customer_id_47","id":"checkout_session_id_39","plan_version_id":"plan_version_id_67","status":"AWAITING_PAYMENT"}}"#,
    );
    client.checkout_sessions().retrieve("id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/checkout-sessions/id"]
    );
}

#[tokio::test]
async fn cancel() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"session":{"checkout_type":"PLAN_CHANGE","created_at":"2023-12-31T23:59:59.999-05:30","customer_id":"customer_id_47","id":"checkout_session_id_39","plan_version_id":"plan_version_id_67","status":"AWAITING_PAYMENT"}}"#,
    );
    client.checkout_sessions().cancel("id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/checkout-sessions/id/cancel"]
    );
}
