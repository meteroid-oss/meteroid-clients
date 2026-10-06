// this file is @generated
use crate::{decode, mock};

#[tokio::test]
async fn list() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"data":[{"currency":"TMT","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"custom_taxes":[{"name":"sample","rate":"sample","tax_code":"sample"}],"id":"customer_id_67","invoicing_emails":["sample"],"invoicing_entity_id":"invoicing_entity_id_27","name":"sample","preferred_locales":["sample"]}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}"#,
    );
    client.customers().list(None).await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["GET /api/v1/customers"]);
}

#[tokio::test]
async fn create() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"currency":"MMK","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"custom_taxes":[{"name":"sample","rate":"sample","tax_code":"sample"}],"id":"customer_id_90","invoicing_emails":["sample"],"invoicing_entity_id":"invoicing_entity_id_26","name":"sample","preferred_locales":["sample"]}"#,
    );
    client.customers().create(decode::<meteroid_rs::models::CustomerCreateRequest>(r#"{"currency":"MMK","custom_taxes":[{"name":"sample","rate":"sample","tax_code":"sample"}],"invoicing_emails":["sample"]}"#)).await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["POST /api/v1/customers"]);
}

#[tokio::test]
async fn retrieve() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"currency":"MMK","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"custom_taxes":[{"name":"sample","rate":"sample","tax_code":"sample"}],"id":"customer_id_90","invoicing_emails":["sample"],"invoicing_entity_id":"invoicing_entity_id_26","name":"sample","preferred_locales":["sample"]}"#,
    );
    client.customers().retrieve("id_or_alias").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/customers/id_or_alias"]
    );
}

#[tokio::test]
async fn replace() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"currency":"MMK","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"custom_taxes":[{"name":"sample","rate":"sample","tax_code":"sample"}],"id":"customer_id_90","invoicing_emails":["sample"],"invoicing_entity_id":"invoicing_entity_id_26","name":"sample","preferred_locales":["sample"]}"#,
    );
    client.customers().replace("id_or_alias", decode::<meteroid_rs::models::CustomerUpdateRequest>(r#"{"currency":"COP","custom_taxes":[{"name":"sample","rate":"sample","tax_code":"sample"}],"invoicing_emails":["sample"],"invoicing_entity_id":"invoicing_entity_id_1"}"#)).await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["PUT /api/v1/customers/id_or_alias"]
    );
}

#[tokio::test]
async fn archive() {
    let (client, requests) = mock(204, None, r#""#);
    client.customers().archive("id_or_alias").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["DELETE /api/v1/customers/id_or_alias"]
    );
}

#[tokio::test]
async fn update() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"currency":"MMK","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"custom_taxes":[{"name":"sample","rate":"sample","tax_code":"sample"}],"id":"customer_id_90","invoicing_emails":["sample"],"invoicing_entity_id":"invoicing_entity_id_26","name":"sample","preferred_locales":["sample"]}"#,
    );
    client
        .customers()
        .update(
            "id_or_alias",
            decode::<meteroid_rs::models::CustomerPatchRequest>(r#"{}"#),
        )
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["PATCH /api/v1/customers/id_or_alias"]
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
        .customers()
        .list_entitlements("id_or_alias")
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/customers/id_or_alias/entitlements"]
    );
}

#[tokio::test]
async fn create_portal_token() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"portal_url":"sample","token":"sample"}"#,
    );
    client
        .customers()
        .create_portal_token(
            "id_or_alias",
            decode::<meteroid_rs::models::CustomerPortalTokenRequest>(r#"{}"#),
        )
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/customers/id_or_alias/portal-token"]
    );
}

#[tokio::test]
async fn unarchive() {
    let (client, requests) = mock(204, None, r#""#);
    client.customers().unarchive("id_or_alias").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/customers/id_or_alias/unarchive"]
    );
}
