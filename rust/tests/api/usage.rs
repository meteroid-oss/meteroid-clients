// this file is @generated
use crate::mock;

#[tokio::test]
async fn retrieve_subscription() {
    let (client, requests) = mock(
        200,
        Some("application/json"),
        r#"{"period_end":"1999-12-31","period_start":"2024-02-29","usage":[{"grouped_usage":[{"dimensions":{"alpha":"sample"},"value":"12345.6789"}],"metric_code":"sample","metric_id":"billable_metric_id_44","metric_name":"sample","total_value":"12345.6789"}]}"#,
    );
    client
        .usage()
        .retrieve_subscription("subscription_id", None)
        .await
        .unwrap();
    assert_eq!(
        *requests.lock().unwrap(),
        ["GET /api/v1/usage/subscription/subscription_id"]
    );
}
