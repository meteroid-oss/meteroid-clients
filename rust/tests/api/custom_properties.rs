// this file is @generated
use crate::{decode, mock};

#[tokio::test]
async fn list_custom_property_definitions() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"data":[{"archived":false,"config":{},"display_order":-2147483648,"entity_type":"CUSTOMER","id":"custom_property_definition_id_78","key":"sample","name":"sample","property_type":"JSON","required":false}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}"#,
    );
    client
        .custom_properties()
        .list_custom_property_definitions(None)
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/custom-property-definitions"]
    );
}

#[tokio::test]
async fn create_custom_property_definition() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"archived":false,"config":{},"display_order":-2147483648,"entity_type":"INVOICE","id":"custom_property_definition_id_13","key":"sample","name":"sample","property_type":"TEXT","required":false}"#,
    );
    client.custom_properties().create_custom_property_definition(decode::<meteroid_rs::models::CustomPropertyDefinitionCreateRequest>(r#"{"entity_type":"CREDIT_NOTE","key":"sample","name":"sample","property_type":"TEXT"}"#)).await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/custom-property-definitions"]
    );
}

#[tokio::test]
async fn retrieve_custom_property_definition() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"archived":false,"config":{},"display_order":-2147483648,"entity_type":"INVOICE","id":"custom_property_definition_id_13","key":"sample","name":"sample","property_type":"TEXT","required":false}"#,
    );
    client
        .custom_properties()
        .retrieve_custom_property_definition("id")
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/custom-property-definitions/id"]
    );
}

#[tokio::test]
async fn update_custom_property_definition() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"archived":false,"config":{},"display_order":-2147483648,"entity_type":"INVOICE","id":"custom_property_definition_id_13","key":"sample","name":"sample","property_type":"TEXT","required":false}"#,
    );
    client
        .custom_properties()
        .update_custom_property_definition(
            "id",
            decode::<meteroid_rs::models::CustomPropertyDefinitionUpdateRequest>(r#"{}"#),
        )
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["PUT /api/v1/custom-property-definitions/id"]
    );
}

#[tokio::test]
async fn archive_definition() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"archived":false,"config":{},"display_order":-2147483648,"entity_type":"INVOICE","id":"custom_property_definition_id_13","key":"sample","name":"sample","property_type":"TEXT","required":false}"#,
    );
    client
        .custom_properties()
        .archive_definition("id")
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["DELETE /api/v1/custom-property-definitions/id"]
    );
}
