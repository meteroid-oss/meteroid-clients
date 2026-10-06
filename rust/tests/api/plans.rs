// this file is @generated
use crate::{decode, mock};

#[tokio::test]
async fn list_plan_version_entitlements() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"data":[{"feature":{"code":"sample","id":"feature_id_53","name":"sample"},"value":{"type":"BOOLEAN","enabled":false}}]}"#,
    );
    client
        .plans()
        .list_plan_version_entitlements("plan_version_id")
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/plan-versions/plan_version_id/entitlements"]
    );
}

#[tokio::test]
async fn list() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"data":[{"available_parameters":{},"created_at":"2024-03-15T10:30:45.123+02:00","currency":"sample","id":"plan_id_78","name":"sample","net_terms":-2147483648,"plan_type":"FREE","price_components":[{"id":"price_component_id_82","name":"sample"}],"product_family":{"id":"product_family_id_59","name":"sample"},"status":"INACTIVE","version":-2147483648,"version_id":"plan_version_id_31"}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}"#,
    );
    client.plans().list(None).await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["GET /api/v1/plans"]);
}

#[tokio::test]
async fn create() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"available_parameters":{},"created_at":"2023-12-31T23:59:59.999-05:30","currency":"sample","id":"plan_id_13","name":"sample","net_terms":2147483647,"plan_type":"FREE","price_components":[{"id":"price_component_id_38","name":"sample"}],"product_family":{"id":"product_family_id_66","name":"sample"},"status":"ARCHIVED","version":2147483647,"version_id":"plan_version_id_92"}"#,
    );
    client.plans().create(decode::<meteroid_rs::models::CreatePlanRequest>(r#"{"components":[{"fee":{"type":"RATE","rates":[{"price":"-0.000123","term":"ANNUAL"}]},"name":"sample"}],"currency":"sample","name":"sample","plan_type":"CUSTOM","product_family_id":"product_family_id_40","status":"INACTIVE"}"#)).await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["POST /api/v1/plans"]);
}

#[tokio::test]
async fn update_version_minimum() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"amount":"sample","scope":{"type":"all_components"}}"#,
    );
    client
        .plans()
        .update_version_minimum(
            "plan_version_id",
            decode::<meteroid_rs::models::MinimumCommitment>(
                r#"{"amount":"sample","scope":{"type":"all_components"}}"#,
            ),
        )
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["PUT /api/v1/plans/versions/plan_version_id/minimum"]
    );
}

#[tokio::test]
async fn delete_version_minimum() {
    let (client, requests) = mock(204, None, r#""#);
    client
        .plans()
        .delete_version_minimum("plan_version_id")
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["DELETE /api/v1/plans/versions/plan_version_id/minimum"]
    );
}

#[tokio::test]
async fn retrieve() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"available_parameters":{},"created_at":"2023-12-31T23:59:59.999-05:30","currency":"sample","id":"plan_id_13","name":"sample","net_terms":2147483647,"plan_type":"FREE","price_components":[{"id":"price_component_id_38","name":"sample"}],"product_family":{"id":"product_family_id_66","name":"sample"},"status":"ARCHIVED","version":2147483647,"version_id":"plan_version_id_92"}"#,
    );
    client.plans().retrieve("plan_id", None).await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["GET /api/v1/plans/plan_id"]);
}

#[tokio::test]
async fn replace() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"available_parameters":{},"created_at":"2023-12-31T23:59:59.999-05:30","currency":"sample","id":"plan_id_13","name":"sample","net_terms":2147483647,"plan_type":"FREE","price_components":[{"id":"price_component_id_38","name":"sample"}],"product_family":{"id":"product_family_id_66","name":"sample"},"status":"ARCHIVED","version":2147483647,"version_id":"plan_version_id_92"}"#,
    );
    client.plans().replace("plan_id", decode::<meteroid_rs::models::ReplacePlanRequest>(r#"{"components":[{"fee":{"type":"RATE","rates":[{"price":"-0.000123","term":"ANNUAL"}]},"name":"sample"}],"currency":"sample","name":"sample"}"#)).await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["PUT /api/v1/plans/plan_id"]);
}

#[tokio::test]
async fn update() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"available_parameters":{},"created_at":"2023-12-31T23:59:59.999-05:30","currency":"sample","id":"plan_id_13","name":"sample","net_terms":2147483647,"plan_type":"FREE","price_components":[{"id":"price_component_id_38","name":"sample"}],"product_family":{"id":"product_family_id_66","name":"sample"},"status":"ARCHIVED","version":2147483647,"version_id":"plan_version_id_92"}"#,
    );
    client
        .plans()
        .update(
            "plan_id",
            decode::<meteroid_rs::models::PatchPlanRequest>(r#"{}"#),
        )
        .await
        .unwrap();
    assert_eq!(*requests.lock().unwrap(), ["PATCH /api/v1/plans/plan_id"]);
}

#[tokio::test]
async fn archive() {
    let (client, requests) = mock(204, None, r#""#);
    client.plans().archive("plan_id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/plans/plan_id/archive"]
    );
}

#[tokio::test]
async fn publish() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"available_parameters":{},"created_at":"2023-12-31T23:59:59.999-05:30","currency":"sample","id":"plan_id_13","name":"sample","net_terms":2147483647,"plan_type":"FREE","price_components":[{"id":"price_component_id_38","name":"sample"}],"product_family":{"id":"product_family_id_66","name":"sample"},"status":"ARCHIVED","version":2147483647,"version_id":"plan_version_id_92"}"#,
    );
    client.plans().publish("plan_id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/plans/plan_id/publish"]
    );
}

#[tokio::test]
async fn unarchive() {
    let (client, requests) = mock(204, None, r#""#);
    client.plans().unarchive("plan_id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/plans/plan_id/unarchive"]
    );
}

#[tokio::test]
async fn list_versions() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"data":[{"created_at":"2023-12-31T23:59:59.999-05:30","currency":"sample","id":"plan_version_id_2","is_draft":true,"version":-2147483648}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}"#,
    );
    client.plans().list_versions("plan_id", None).await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/plans/plan_id/versions"]
    );
}
