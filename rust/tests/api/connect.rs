// this file is @generated
use crate::{decode, mock};

#[tokio::test]
async fn list_connected_accounts() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"data":[{"connection_type":"standard","created_at":"2024-03-15T10:30:45.123+02:00","id":"connected_account_id_67","onboarding_mode":"full","platform_organization_id":"organization_id_23","status":"active"}]}"#,
    );
    client.connect().list_connected_accounts().await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/connected-accounts"]
    );
}

#[tokio::test]
async fn create_connected_account() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"connection_type":"express","created_at":"2024-03-15T10:30:45.123+02:00","id":"connected_account_id_47","onboarding_mode":"express","platform_organization_id":"organization_id_83","status":"active"}"#,
    );
    client
        .connect()
        .create_connected_account(
            decode::<meteroid_rs::models::CreateConnectedAccountRequest>(
                r#"{"connected_organization_id":"00000000-0000-0000-0000-000000000000"}"#,
            ),
        )
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/connected-accounts"]
    );
}

#[tokio::test]
async fn retrieve_connected_account() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"connection_type":"express","created_at":"2024-03-15T10:30:45.123+02:00","id":"connected_account_id_47","onboarding_mode":"express","platform_organization_id":"organization_id_83","status":"active"}"#,
    );
    client
        .connect()
        .retrieve_connected_account("id")
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/connected-accounts/id"]
    );
}

#[tokio::test]
async fn disconnect_account() {
    let (client, requests) = mock(204, None, r#""#);
    client.connect().disconnect_account("id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["DELETE /api/v1/connected-accounts/id"]
    );
}

#[tokio::test]
async fn create_onboarding_link() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"expires_at":"2023-12-31T23:59:59.999-05:30","url":"sample"}"#,
    );
    client
        .connect()
        .create_onboarding_link(
            "id",
            decode::<meteroid_rs::models::CreateOnboardingLinkRequest>(
                r#"{"redirect_url":"sample"}"#,
            ),
        )
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/connected-accounts/id/onboarding"]
    );
}
