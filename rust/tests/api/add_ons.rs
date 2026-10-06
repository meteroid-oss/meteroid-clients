// this file is @generated
use crate::{decode, mock};

#[tokio::test]
async fn list() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"data":[{"created_at":"2023-12-31T23:59:59.999-05:30","id":"add_on_id_0","name":"sample","price_id":"price_id_47","product_id":"product_id_67","self_serviceable":false}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}"#,
    );
    client.add_ons().list(None).await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["GET /api/v1/addons"]);
}

#[tokio::test]
async fn create() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"created_at":"2024-03-15T10:30:45.123+02:00","id":"add_on_id_90","name":"sample","price_id":"price_id_99","product_id":"product_id_90","self_serviceable":false}"#,
    );
    client
        .add_ons()
        .create(decode::<meteroid_rs::models::CreateAddOnRequest>(
            r#"{"name":"sample","price_id":"price_id_44","product_id":"product_id_47"}"#,
        ))
        .await
        .unwrap();
    assert_eq!(*requests.lock().unwrap(), ["POST /api/v1/addons"]);
}

#[tokio::test]
async fn retrieve() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"created_at":"2024-03-15T10:30:45.123+02:00","id":"add_on_id_90","name":"sample","price_id":"price_id_99","product_id":"product_id_90","self_serviceable":false}"#,
    );
    client.add_ons().retrieve("addon_id").await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["GET /api/v1/addons/addon_id"]);
}

#[tokio::test]
async fn update() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"created_at":"2024-03-15T10:30:45.123+02:00","id":"add_on_id_90","name":"sample","price_id":"price_id_99","product_id":"product_id_90","self_serviceable":false}"#,
    );
    client
        .add_ons()
        .update(
            "addon_id",
            decode::<meteroid_rs::models::UpdateAddOnRequest>(r#"{}"#),
        )
        .await
        .unwrap();
    assert_eq!(*requests.lock().unwrap(), ["PATCH /api/v1/addons/addon_id"]);
}

#[tokio::test]
async fn archive() {
    let (client, requests) = mock(204, None, r#""#);
    client.add_ons().archive("addon_id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/addons/addon_id/archive"]
    );
}

#[tokio::test]
async fn list_entitlements() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"data":[{"feature":{"code":"sample","id":"feature_id_53","name":"sample"},"value":{"type":"BOOLEAN","enabled":false}}]}"#,
    );
    client
        .add_ons()
        .list_entitlements("addon_id")
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/addons/addon_id/entitlements"]
    );
}

#[tokio::test]
async fn unarchive() {
    let (client, requests) = mock(204, None, r#""#);
    client.add_ons().unarchive("addon_id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/addons/addon_id/unarchive"]
    );
}
