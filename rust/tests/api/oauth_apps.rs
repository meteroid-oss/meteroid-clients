// this file is @generated
use crate::{decode, mock};

#[tokio::test]
async fn list() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"data":[{"client_id":"sample","client_secret_hint":"sample","created_at":"2024-03-15T10:30:45.123+02:00","id":"o_auth_app_id_90","is_active":false,"name":"sample","organization_id":"organization_id_78","redirect_uris":["sample"],"scopes":["sample"]}]}"#,
    );
    client.oauth_apps().list().await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["GET /api/v1/oauth-apps"]);
}

#[tokio::test]
async fn create() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"app":{"client_id":"sample","client_secret_hint":"sample","created_at":"2024-03-15T10:30:45.123+02:00","id":"o_auth_app_id_90","is_active":false,"name":"sample","organization_id":"organization_id_78","redirect_uris":["sample"],"scopes":["sample"]},"client_secret":"sample"}"#,
    );
    client
        .oauth_apps()
        .create(decode::<meteroid_rs::models::CreateOAuthAppRequest>(
            r#"{"name":"sample","redirect_uris":["sample"]}"#,
        ))
        .await
        .unwrap();
    assert_eq!(*requests.lock().unwrap(), ["POST /api/v1/oauth-apps"]);
}

#[tokio::test]
async fn retrieve() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"client_id":"sample","client_secret_hint":"sample","created_at":"2023-12-31T23:59:59.999-05:30","id":"o_auth_app_id_44","is_active":false,"name":"sample","organization_id":"organization_id_13","redirect_uris":["sample"],"scopes":["sample"]}"#,
    );
    client.oauth_apps().retrieve("id").await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["GET /api/v1/oauth-apps/id"]);
}

#[tokio::test]
async fn delete() {
    let (client, requests) = mock(204, None, r#""#);
    client.oauth_apps().delete("id").await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["DELETE /api/v1/oauth-apps/id"]);
}

#[tokio::test]
async fn rotate() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"client_secret":"sample","client_secret_hint":"sample"}"#,
    );
    client.oauth_apps().rotate("id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/oauth-apps/id/rotate"]
    );
}
