// this file is @generated
use crate::{decode, mock};

#[tokio::test]
async fn list() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"data":[{"aggregation_type":"COUNT","code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","id":"billable_metric_id_78","name":"sample"}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}"#,
    );
    client.metrics().list(None).await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["GET /api/v1/metrics"]);
}

#[tokio::test]
async fn create() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"aggregation_type":"LATEST","code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","id":"billable_metric_id_40","name":"sample","product_family_id":"product_family_id_90"}"#,
    );
    client.metrics().create(decode::<meteroid_rs::models::CreateMetricRequest>(r#"{"aggregation_type":"LATEST","code":"sample","name":"sample","product_family_id":"product_family_id_13"}"#)).await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["POST /api/v1/metrics"]);
}

#[tokio::test]
async fn retrieve() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"aggregation_type":"LATEST","code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","id":"billable_metric_id_40","name":"sample","product_family_id":"product_family_id_90"}"#,
    );
    client.metrics().retrieve("metric_id").await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["GET /api/v1/metrics/metric_id"]);
}

#[tokio::test]
async fn update() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"aggregation_type":"LATEST","code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","id":"billable_metric_id_40","name":"sample","product_family_id":"product_family_id_90"}"#,
    );
    client
        .metrics()
        .update(
            "metric_id",
            decode::<meteroid_rs::models::UpdateMetricRequest>(r#"{}"#),
        )
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["PATCH /api/v1/metrics/metric_id"]
    );
}

#[tokio::test]
async fn archive() {
    let (client, requests) = mock(204, None, r#""#);
    client.metrics().archive("metric_id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/metrics/metric_id/archive"]
    );
}

#[tokio::test]
async fn unarchive() {
    let (client, requests) = mock(204, None, r#""#);
    client.metrics().unarchive("metric_id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["POST /api/v1/metrics/metric_id/unarchive"]
    );
}
