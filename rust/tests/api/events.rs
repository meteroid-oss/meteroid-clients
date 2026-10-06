// this file is @generated
use crate::{decode, mock};

#[tokio::test]
async fn ingest() {
    let (client, requests) = mock(200, Some("application/json"), r#"{}"#);
    client.events().ingest(decode::<meteroid_rs::models::IngestEventsRequest>(r#"{"events":[{"code":"sample","customer_id":"sample","event_id":"sample","timestamp":"sample"}]}"#)).await.unwrap();
    assert_eq!(*requests.lock().unwrap(), ["POST /api/v1/events/ingest"]);
}
