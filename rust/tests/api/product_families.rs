// this file is @generated
use crate::{decode, mock};

#[tokio::test]
async fn list() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"data":[{"id":"product_family_id_9","name":"sample"}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}"#,
    );
    client.product_families().list(None).await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["GET /api/v1/product_families"]);
}

#[tokio::test]
async fn create() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"id":"product_family_id_35","name":"sample"}"#,
    );
    client
        .product_families()
        .create(decode::<meteroid_rs::models::ProductFamilyCreateRequest>(
            r#"{"name":"sample"}"#,
        ))
        .await
        .unwrap();
    assert_eq!(*requests.lock().unwrap(), ["POST /api/v1/product_families"]);
}

#[tokio::test]
async fn retrieve() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"id":"product_family_id_35","name":"sample"}"#,
    );
    client
        .product_families()
        .retrieve("id_or_alias")
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/product_families/id_or_alias"]
    );
}
