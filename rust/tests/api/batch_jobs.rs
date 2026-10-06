// this file is @generated
use crate::mock;

#[tokio::test]
async fn list() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"data":[{"created_at":"2023-12-31T23:59:59.999-05:30","created_by":"3fa85f64-5717-4562-b3fc-2c963f66afa6","failed_items":2147483647,"id":"batch_job_id_67","job_type":"SUBSCRIPTION_PLAN_MIGRATION","processed_items":-123456789,"status":"CHUNKING"}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}"#,
    );
    client.batch_jobs().list(None).await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["GET /api/v1/batch-jobs"]);
}

#[tokio::test]
async fn retrieve() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"created_at":"2024-03-15T10:30:45.123+02:00","created_by":"00000000-0000-0000-0000-000000000000","failed_items":-2147483648,"failure_count":9007199254740993,"has_error_csv":false,"has_output":true,"id":"batch_job_id_99","job_type":"CUSTOMER_CSV_IMPORT","processed_items":-2147483648,"status":"PROCESSING"}"#,
    );
    client.batch_jobs().retrieve("batch_job_id").await.unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/batch-jobs/batch_job_id"]
    );
}

#[tokio::test]
async fn list_failures() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"data":[{"chunk_id":"batch_job_chunk_id_9","id":"00000000-0000-0000-0000-000000000000","item_index":2147483647,"reason":"sample"}],"total_count":9007199254740993}"#,
    );
    client
        .batch_jobs()
        .list_failures("batch_job_id", None)
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/batch-jobs/batch_job_id/failures"]
    );
}
