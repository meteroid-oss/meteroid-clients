use meteroid_rs::api::{
    BatchJobsListBatchJobsOptions, CustomersListCustomersOptions, Meteroid, MeteroidOptions,
};
use meteroid_rs::error::Error;
use meteroid_rs::models::{BatchJobStatus, ErrorCode, OAuthErrorCode, RestErrorResponse};

use wiremock::{
    matchers::{header, method, path, query_param},
    Mock, MockServer, ResponseTemplate,
};

fn create_test_client(server_url: String) -> Meteroid {
    Meteroid::new(
        "test-api-key".to_string(),
        Some(MeteroidOptions {
            server_url: Some(server_url),
            timeout: None, // Disable timeout for tests
            ..Default::default()
        }),
    )
}

fn pagination_json() -> &'static str {
    r#"{"page":0,"per_page":10,"total_items":0,"total_pages":0}"#
}

#[tokio::test]
async fn test_list_customers() {
    let mock_server = MockServer::start().await;

    let json_body = r#"{
            "data": [
                {
                    "id": "cust_123",
                    "name": "Test Customer",
                    "currency": "USD",
                    "custom_properties": {},
                    "custom_taxes": [],
                    "invoicing_emails": [],
                    "invoicing_entity_id": "inv_1"
                }
            ],
            "pagination_meta": {"page":0,"per_page":10,"total_items":1,"total_pages":1}
        }"#
    .to_string();

    Mock::given(method("GET"))
        .and(path("/api/v1/customers"))
        .and(header("authorization", "Bearer test-api-key"))
        .respond_with(ResponseTemplate::new(200).set_body_string(json_body))
        .expect(1)
        .mount(&mock_server)
        .await;

    let client = create_test_client(mock_server.uri());
    let response = client.customers().list_customers(None).await.unwrap();

    assert_eq!(response.data.len(), 1);
    assert_eq!(response.data[0].name, "Test Customer");
    assert_eq!(response.pagination_meta.total_items, 1);

    mock_server.verify().await;
}

#[tokio::test]
async fn test_list_customers_with_pagination() {
    let mock_server = MockServer::start().await;

    let json_body = r#"{"data":[],"pagination_meta":{"page":2,"per_page":10,"total_items":100,"total_pages":10}}"#.to_string();

    Mock::given(method("GET"))
        .and(path("/api/v1/customers"))
        .and(query_param("page", "2"))
        .and(query_param("per_page", "10"))
        .respond_with(ResponseTemplate::new(200).set_body_string(json_body))
        .expect(1)
        .mount(&mock_server)
        .await;

    let client = create_test_client(mock_server.uri());
    let response = client
        .customers()
        .list_customers(Some(CustomersListCustomersOptions {
            page: Some(2),
            per_page: Some(10),
            ..Default::default()
        }))
        .await
        .unwrap();

    assert_eq!(response.pagination_meta.total_items, 100);

    mock_server.verify().await;
}

#[tokio::test]
async fn test_create_customer() {
    let mock_server = MockServer::start().await;

    let json_body = r#"{
        "id": "cust_new",
        "name": "New Customer",
        "currency": "USD",
        "custom_properties": {},
        "custom_taxes": [],
        "invoicing_emails": ["billing@new.com"],
        "invoicing_entity_id": "inv_1"
    }"#;

    Mock::given(method("POST"))
        .and(path("/api/v1/customers"))
        .and(header("content-type", "application/json"))
        .respond_with(ResponseTemplate::new(200).set_body_string(json_body))
        .expect(1)
        .mount(&mock_server)
        .await;

    let client = create_test_client(mock_server.uri());

    let request = meteroid_rs::models::CustomerCreateRequest::new(
        meteroid_rs::models::Currency::Usd,
        vec![],
        vec!["billing@new.com".to_string()],
        "New Customer".to_string(),
    );

    let customer = client.customers().create_customer(request).await.unwrap();

    assert_eq!(customer.id, "cust_new");
    assert_eq!(customer.name, "New Customer");

    mock_server.verify().await;
}

#[tokio::test]
async fn test_archive_customer() {
    let mock_server = MockServer::start().await;

    Mock::given(method("DELETE"))
        .and(path("/api/v1/customers/cust_123"))
        .respond_with(ResponseTemplate::new(204))
        .expect(1)
        .mount(&mock_server)
        .await;

    let client = create_test_client(mock_server.uri());
    client
        .customers()
        .archive_customer("cust_123".to_string())
        .await
        .unwrap();

    mock_server.verify().await;
}

#[tokio::test]
async fn test_idempotency_key_is_sent_for_post_request() {
    let mock_server = MockServer::start().await;

    let json_body = r#"{
        "id": "cust_new",
        "name": "New Customer",
        "currency": "USD",
        "custom_properties": {},
        "custom_taxes": [],
        "invoicing_emails": [],
        "invoicing_entity_id": "inv_1"
    }"#;

    Mock::given(method("POST"))
        .and(path("/api/v1/customers"))
        .respond_with(ResponseTemplate::new(200).set_body_string(json_body))
        .mount(&mock_server)
        .await;

    let client = create_test_client(mock_server.uri());

    let request = meteroid_rs::models::CustomerCreateRequest::new(
        meteroid_rs::models::Currency::Usd,
        vec![],
        vec![],
        "New Customer".to_string(),
    );

    client.customers().create_customer(request).await.unwrap();

    let requests = mock_server
        .received_requests()
        .await
        .expect("should have received a request");

    assert_eq!(requests.len(), 1);
    let idempotency_key = requests[0]
        .headers
        .get("idempotency-key")
        .expect("idempotency-key header should be present");
    assert!(
        idempotency_key.to_str().unwrap().starts_with("auto_"),
        "idempotency key should start with 'auto_', got: {idempotency_key:?}"
    );
}

#[tokio::test]
async fn test_authorization_header_is_sent() {
    let mock_server = MockServer::start().await;

    let json_body = format!(r#"{{"data":[],"pagination_meta":{}}}"#, pagination_json());

    Mock::given(method("GET"))
        .and(path("/api/v1/customers"))
        .and(header("authorization", "Bearer my-secret-key"))
        .respond_with(ResponseTemplate::new(200).set_body_string(json_body))
        .expect(1)
        .mount(&mock_server)
        .await;

    let client = Meteroid::new(
        "my-secret-key".to_string(),
        Some(MeteroidOptions {
            server_url: Some(mock_server.uri()),
            timeout: None,
            ..Default::default()
        }),
    );

    client.customers().list_customers(None).await.unwrap();

    mock_server.verify().await;
}

#[tokio::test]
async fn test_user_agent_is_sent() {
    let mock_server = MockServer::start().await;

    let json_body = format!(r#"{{"data":[],"pagination_meta":{}}}"#, pagination_json());

    Mock::given(method("GET"))
        .and(path("/api/v1/customers"))
        .respond_with(ResponseTemplate::new(200).set_body_string(json_body))
        .expect(1)
        .mount(&mock_server)
        .await;

    let client = create_test_client(mock_server.uri());
    client.customers().list_customers(None).await.unwrap();

    let requests = mock_server.received_requests().await.unwrap();
    let user_agent = requests[0]
        .headers
        .get("user-agent")
        .expect("user-agent should be present");
    assert!(user_agent.to_str().unwrap().starts_with("meteroid-rust/"));

    mock_server.verify().await;
}

#[tokio::test]
async fn test_list_query_param_is_exploded() {
    // `status` on /api/v1/batch-jobs is an array query parameter with no explicit
    // `explode` in the spec, which means it defaults to `explode: true` for
    // `style: form`. The client should emit one `status=...` pair per value
    // (e.g. `?status=CHUNKING&status=PROCESSING`) instead of a comma-joined list.
    let mock_server = MockServer::start().await;

    let json_body =
        r#"{"data":[],"pagination_meta":{"page":0,"per_page":10,"total_items":0,"total_pages":0}}"#;

    Mock::given(method("GET"))
        .and(path("/api/v1/batch-jobs"))
        .and(query_param("status", "CHUNKING"))
        .and(query_param("status", "PROCESSING"))
        .respond_with(ResponseTemplate::new(200).set_body_string(json_body))
        .expect(1)
        .mount(&mock_server)
        .await;

    let client = create_test_client(mock_server.uri());
    client
        .batch_jobs()
        .list_batch_jobs(Some(BatchJobsListBatchJobsOptions {
            status: Some(vec![BatchJobStatus::Chunking, BatchJobStatus::Processing]),
            ..Default::default()
        }))
        .await
        .unwrap();

    mock_server.verify().await;
}

async fn get_customer_error(status: u16, body: &str) -> meteroid_rs::error::Error {
    let mock_server = MockServer::start().await;

    Mock::given(method("GET"))
        .and(path("/api/v1/customers/nonexistent"))
        .respond_with(ResponseTemplate::new(status).set_body_string(body))
        .expect(1)
        .mount(&mock_server)
        .await;

    let client = create_test_client(mock_server.uri());
    let err = client
        .customers()
        .get_customer("nonexistent".to_string())
        .await
        .expect_err("non-2xx response must be an error");

    mock_server.verify().await;
    err
}

#[tokio::test]
async fn test_http_error_is_parsed_as_rest_error_response() {
    let body = r#"{"code":"NOT_FOUND","message":"no such customer"}"#;
    let err = get_customer_error(404, body).await;

    assert_eq!(err.status(), Some(http1::StatusCode::NOT_FOUND));
    assert_eq!(err.code(), Some(ErrorCode::NotFound));
    assert_eq!(err.message(), Some("no such customer"));
    match err {
        Error::Http(content) => {
            assert_eq!(content.status, http1::StatusCode::NOT_FOUND);
            assert_eq!(
                content.payload,
                Some(RestErrorResponse::new(
                    ErrorCode::NotFound,
                    "no such customer".to_string()
                ))
            );
            assert_eq!(content.body_as_str(), body);
        }
        other => panic!("expected Error::Http, got {other:?}"),
    }
}

#[tokio::test]
async fn test_oauth_error_is_parsed_as_oauth_error_response() {
    let body = r#"{"error":"invalid_grant","error_description":"code expired"}"#;
    let err = get_customer_error(400, body).await;

    assert_eq!(err.status(), Some(http1::StatusCode::BAD_REQUEST));
    assert_eq!(err.code(), None);
    assert_eq!(err.message(), None);
    match err {
        Error::OAuth(content) => {
            assert_eq!(content.status, http1::StatusCode::BAD_REQUEST);
            assert_eq!(content.body_as_str(), body);
            let payload = content.payload.expect("OAuth payload");
            assert_eq!(payload.error, OAuthErrorCode::InvalidGrant);
            assert_eq!(payload.error_description.as_deref(), Some("code expired"));
            assert_eq!(payload.error_uri, None);
        }
        other => panic!("expected Error::OAuth, got {other:?}"),
    }
}

#[tokio::test]
async fn test_non_json_error_keeps_status_and_raw_body() {
    let body = "<html>502 Bad Gateway</html>";
    // 502 is retried; the mock answers every attempt.
    let mock_server = MockServer::start().await;
    Mock::given(method("GET"))
        .and(path("/api/v1/customers/nonexistent"))
        .respond_with(ResponseTemplate::new(502).set_body_string(body))
        .mount(&mock_server)
        .await;
    let client = Meteroid::new(
        "test-api-key".to_string(),
        Some(MeteroidOptions {
            server_url: Some(mock_server.uri()),
            timeout: None,
            num_retries: Some(0),
            ..Default::default()
        }),
    );
    let err = client
        .customers()
        .get_customer("nonexistent".to_string())
        .await
        .expect_err("non-2xx response must be an error");

    assert_eq!(err.status(), Some(http1::StatusCode::BAD_GATEWAY));
    assert_eq!(err.code(), None);
    match err {
        Error::Http(content) => {
            assert_eq!(content.status, http1::StatusCode::BAD_GATEWAY);
            assert_eq!(content.payload, None);
            assert_eq!(&content.raw_body[..], body.as_bytes());
        }
        other => panic!("expected Error::Http, got {other:?}"),
    }
}

#[tokio::test]
async fn test_unknown_error_code_has_no_payload() {
    let body = r#"{"code":"SOMETHING_NEW","message":"new server-side code"}"#;
    let err = get_customer_error(409, body).await;

    assert_eq!(err.status(), Some(http1::StatusCode::CONFLICT));
    match err {
        Error::Http(content) => {
            assert_eq!(content.payload, None);
            assert_eq!(content.body_as_str(), body);
        }
        other => panic!("expected Error::Http, got {other:?}"),
    }
}

#[tokio::test]
async fn test_422_goes_through_the_same_path() {
    let body = r#"{"code":"BAD_REQUEST","message":"invalid field"}"#;
    let err = get_customer_error(422, body).await;

    assert_eq!(err.status(), Some(http1::StatusCode::UNPROCESSABLE_ENTITY));
    assert_eq!(err.code(), Some(ErrorCode::BadRequest));
    assert_eq!(err.message(), Some("invalid field"));
    assert!(matches!(err, Error::Http(_)));
}
