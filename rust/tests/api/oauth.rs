// this file is @generated
use crate::{decode, mock};

#[tokio::test]
async fn introspect() {
    let (client, requests) = mock(200, Some("application/json"), r#"{"active":false}"#);
    client
        .oauth()
        .introspect(decode::<meteroid_rs::models::IntrospectionRequest>(
            r#"{"token":"sample"}"#,
        ))
        .await
        .unwrap();
    assert_eq!(*requests.lock().unwrap(), ["POST /api/v1/oauth/introspect"]);
}

#[tokio::test]
async fn revoke() {
    let (client, requests) = mock(204, None, r#""#);
    client
        .oauth()
        .revoke(decode::<meteroid_rs::models::RevocationRequest>(
            r#"{"token":"sample"}"#,
        ))
        .await
        .unwrap();
    assert_eq!(*requests.lock().unwrap(), ["POST /api/v1/oauth/revoke"]);
}

#[tokio::test]
async fn token() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"access_token":"sample","expires_in":9007199254740993,"token_type":"sample"}"#,
    );
    client
        .oauth()
        .token(decode::<meteroid_rs::models::TokenRequest>(
            r#"{"grant_type":"sample"}"#,
        ))
        .await
        .unwrap();
    assert_eq!(*requests.lock().unwrap(), ["POST /api/v1/oauth/token"]);
}
