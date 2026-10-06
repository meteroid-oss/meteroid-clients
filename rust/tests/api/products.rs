// this file is @generated
use crate::{decode, mock};

#[tokio::test]
async fn list() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"data":[{"catalog":false,"created_at":"2024-03-15T10:30:45.123+02:00","fee_structure":{"type":"RATE"},"fee_type":"CAPACITY","id":"product_id_78","name":"sample","product_family_id":"product_family_id_47"}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}"#,
    );
    client.products().list(None).await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["GET /api/v1/products"]);
}

#[tokio::test]
async fn create() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"catalog":true,"created_at":"2023-12-31T23:59:59.999-05:30","fee_structure":{"type":"RATE"},"fee_type":"RATE","id":"product_id_13","name":"sample","product_family_id":"product_family_id_99"}"#,
    );
    client.products().create(decode::<meteroid_rs::models::CreateProductRequest>(r#"{"fee_structure":{"type":"RATE"},"name":"sample","product_family_id":"product_family_id_47"}"#)).await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["POST /api/v1/products"]);
}

#[tokio::test]
async fn retrieve() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"catalog":true,"created_at":"2023-12-31T23:59:59.999-05:30","fee_structure":{"type":"RATE"},"fee_type":"RATE","id":"product_id_13","name":"sample","product_family_id":"product_family_id_99"}"#,
    );
    client.products().retrieve("product_id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/products/product_id"]
    );
}

#[tokio::test]
async fn update() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"catalog":true,"created_at":"2023-12-31T23:59:59.999-05:30","fee_structure":{"type":"RATE"},"fee_type":"RATE","id":"product_id_13","name":"sample","product_family_id":"product_family_id_99"}"#,
    );
    client
        .products()
        .update(
            "product_id",
            decode::<meteroid_rs::models::UpdateProductRequest>(r#"{}"#),
        )
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["PATCH /api/v1/products/product_id"]
    );
}

#[tokio::test]
async fn archive() {
    let (client, requests) = mock(204, None, r#""#);
    client.products().archive("product_id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/products/product_id/archive"]
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
        .products()
        .list_entitlements("product_id")
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/products/product_id/entitlements"]
    );
}

#[tokio::test]
async fn unarchive() {
    let (client, requests) = mock(204, None, r#""#);
    client.products().unarchive("product_id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/products/product_id/unarchive"]
    );
}
