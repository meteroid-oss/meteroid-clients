"""HTTP-level client tests, mirroring rust/tests/it/wiremock_tests.rs."""

import json

import httpx
import pytest
import respx

from meteroid import (
    ApiException,
    Meteroid,
    MeteroidAsync,
    MeteroidOptions,
    NetworkException,
)
from meteroid.models import (
    BatchJobStatus,
    Currency,
    CustomerCreateRequest,
    ErrorCode,
    OAuthErrorCode,
    OAuthErrorResponse,
    RestErrorResponse,
    TokenRequest,
)

BASE_URL = "https://mock.meteroid.test"

PAGINATION = {"page": 0, "per_page": 10, "total_items": 0, "total_pages": 0}


def make_client(**overrides: object) -> Meteroid:
    options = MeteroidOptions(server_url=BASE_URL, timeout=None, **overrides)  # type: ignore[arg-type]
    return Meteroid("test-api-key", options)


@respx.mock
def test_list_customers() -> None:
    route = respx.get(f"{BASE_URL}/api/v1/customers").mock(
        return_value=httpx.Response(
            200,
            json={
                "data": [
                    {
                        "id": "cust_123",
                        "name": "Test Customer",
                        "currency": "USD",
                        "custom_properties": {},
                        "preferred_locales": [],
                        "custom_taxes": [],
                        "invoicing_emails": [],
                        "invoicing_entity_id": "inv_1",
                    }
                ],
                "pagination_meta": {**PAGINATION, "total_items": 1, "total_pages": 1},
            },
        )
    )

    with make_client() as client:
        response = client.customers.list_customers()

    assert route.called
    request = route.calls.last.request
    assert request.headers["authorization"] == "Bearer test-api-key"
    assert request.headers["user-agent"].startswith("meteroid-python/")

    assert len(response.data) == 1
    assert response.data[0].name == "Test Customer"
    assert response.pagination_meta.total_items == 1


@respx.mock
def test_list_customers_with_pagination() -> None:
    route = respx.get(f"{BASE_URL}/api/v1/customers").mock(
        return_value=httpx.Response(
            200,
            json={
                "data": [],
                "pagination_meta": {
                    "page": 2,
                    "per_page": 10,
                    "total_items": 100,
                    "total_pages": 10,
                },
            },
        )
    )

    with make_client() as client:
        response = client.customers.list_customers(page=2, per_page=10)

    assert dict(route.calls.last.request.url.params) == {"page": "2", "per_page": "10"}
    assert response.pagination_meta.total_items == 100


@respx.mock
def test_unset_query_params_are_omitted() -> None:
    route = respx.get(f"{BASE_URL}/api/v1/customers").mock(
        return_value=httpx.Response(200, json={"data": [], "pagination_meta": PAGINATION})
    )

    with make_client() as client:
        client.customers.list_customers(search="acme")

    assert str(route.calls.last.request.url.params) == "search=acme"


@respx.mock
def test_list_query_params_are_exploded() -> None:
    route = respx.get(f"{BASE_URL}/api/v1/batch-jobs").mock(
        return_value=httpx.Response(200, json={"data": [], "pagination_meta": PAGINATION})
    )

    with make_client() as client:
        client.batch_jobs.list_batch_jobs(
            status=[BatchJobStatus.PENDING, BatchJobStatus.PROCESSING]
        )

    params = route.calls.last.request.url.params
    assert params.get_list("status") == ["PENDING", "PROCESSING"]


@respx.mock
def test_create_customer_sends_json_and_idempotency_key() -> None:
    route = respx.post(f"{BASE_URL}/api/v1/customers").mock(
        return_value=httpx.Response(
            200,
            json={
                "id": "cust_new",
                "name": "New Customer",
                "currency": "USD",
                "custom_properties": {},
                "preferred_locales": [],
                "custom_taxes": [],
                "invoicing_emails": ["billing@new.com"],
                "invoicing_entity_id": "inv_1",
            },
        )
    )

    with make_client() as client:
        customer = client.customers.create_customer(
            CustomerCreateRequest(
                currency=Currency.USD,
                custom_taxes=[],
                invoicing_emails=["billing@new.com"],
                name="New Customer",
            )
        )

    request = route.calls.last.request
    assert request.headers["content-type"] == "application/json"
    assert request.headers["idempotency-key"].startswith("auto_")
    assert customer.id == "cust_new"


@respx.mock
def test_path_params_are_encoded() -> None:
    route = respx.get(f"{BASE_URL}/api/v1/customers/a%2Fb").mock(
        return_value=httpx.Response(
            200,
            json={
                "id": "a/b",
                "name": "N",
                "currency": "USD",
                "custom_properties": {},
                "preferred_locales": [],
                "custom_taxes": [],
                "invoicing_emails": [],
                "invoicing_entity_id": "inv_1",
            },
        )
    )

    with make_client() as client:
        client.customers.get_customer("a/b")

    assert route.called


@respx.mock
def test_no_content_operation_returns_none() -> None:
    route = respx.delete(f"{BASE_URL}/api/v1/customers/cust_1").mock(
        return_value=httpx.Response(204)
    )

    with make_client() as client:
        client.customers.archive_customer("cust_1")

    assert route.called


@respx.mock
def test_binary_response_returns_bytes() -> None:
    respx.get(f"{BASE_URL}/api/v1/invoices/inv_1/download").mock(
        return_value=httpx.Response(200, content=b"%PDF-1.7 fake")
    )

    with make_client() as client:
        assert client.invoices.download_invoice_pdf("inv_1") == b"%PDF-1.7 fake"


NOT_FOUND_BODY = {"code": "NOT_FOUND", "message": "no such customer"}


def make_async_client() -> MeteroidAsync:
    return MeteroidAsync(
        "test-api-key", MeteroidOptions(server_url=BASE_URL, timeout=None)
    )


def assert_rest_not_found(exc: ApiException) -> None:
    assert exc.status_code == 404
    assert isinstance(exc.payload, RestErrorResponse)
    assert exc.rest_error == RestErrorResponse(
        code=ErrorCode.NOT_FOUND, message="no such customer"
    )
    assert exc.oauth_error is None
    assert exc.code is ErrorCode.NOT_FOUND
    assert exc.message == "no such customer"
    assert json.loads(exc.raw_body) == NOT_FOUND_BODY
    assert "NOT_FOUND" in str(exc)


def assert_oauth_invalid_grant(exc: ApiException) -> None:
    assert exc.status_code == 400
    assert isinstance(exc.payload, OAuthErrorResponse)
    assert exc.oauth_error == OAuthErrorResponse(error=OAuthErrorCode.INVALID_GRANT)
    assert exc.rest_error is None
    assert exc.code is OAuthErrorCode.INVALID_GRANT
    assert exc.message is None
    assert exc.raw_body == b'{"error":"invalid_grant"}'


def assert_untyped(exc: ApiException, status: int, body: bytes) -> None:
    assert exc.status_code == status
    assert exc.raw_body == body
    assert exc.body_as_str == body.decode()
    assert exc.payload is None
    assert exc.rest_error is None
    assert exc.oauth_error is None
    assert exc.code is None
    assert exc.message is None


@respx.mock
def test_rest_error_body_parses_to_rest_error_response() -> None:
    respx.get(f"{BASE_URL}/api/v1/customers/missing").mock(
        return_value=httpx.Response(404, json=NOT_FOUND_BODY)
    )

    with make_client() as client:
        with pytest.raises(ApiException) as excinfo:
            client.customers.get_customer("missing")

    assert_rest_not_found(excinfo.value)


@respx.mock
async def test_async_rest_error_body_parses_to_rest_error_response() -> None:
    respx.get(f"{BASE_URL}/api/v1/customers/missing").mock(
        return_value=httpx.Response(404, json=NOT_FOUND_BODY)
    )

    async with make_async_client() as client:
        with pytest.raises(ApiException) as excinfo:
            await client.customers.get_customer("missing")

    assert_rest_not_found(excinfo.value)


@respx.mock
def test_oauth_error_body_parses_to_oauth_error_response() -> None:
    respx.post(f"{BASE_URL}/api/v1/oauth/token").mock(
        return_value=httpx.Response(400, content=b'{"error":"invalid_grant"}')
    )

    with make_client() as client:
        with pytest.raises(ApiException) as excinfo:
            client.o_auth.token_endpoint(TokenRequest(grant_type="refresh_token"))

    assert_oauth_invalid_grant(excinfo.value)


@respx.mock
async def test_async_oauth_error_body_parses_to_oauth_error_response() -> None:
    respx.post(f"{BASE_URL}/api/v1/oauth/token").mock(
        return_value=httpx.Response(400, content=b'{"error":"invalid_grant"}')
    )

    async with make_async_client() as client:
        with pytest.raises(ApiException) as excinfo:
            await client.o_auth.token_endpoint(TokenRequest(grant_type="refresh_token"))

    assert_oauth_invalid_grant(excinfo.value)


@respx.mock
def test_oauth_error_description_is_the_message() -> None:
    respx.post(f"{BASE_URL}/api/v1/oauth/token").mock(
        return_value=httpx.Response(
            401,
            json={"error": "invalid_client", "error_description": "bad secret"},
        )
    )

    with make_client() as client:
        with pytest.raises(ApiException) as excinfo:
            client.o_auth.token_endpoint(TokenRequest(grant_type="refresh_token"))

    assert excinfo.value.code is OAuthErrorCode.INVALID_CLIENT
    assert excinfo.value.message == "bad secret"


@pytest.mark.parametrize(
    ("status", "body"),
    [
        # Not JSON at all.
        (502, b"<html>Bad Gateway</html>"),
        # JSON matching neither error model.
        (400, b'{"code":"not_found","detail":"legacy shape"}'),
        # A 422 goes through the same path as every other status.
        (422, b'{"detail":[{"loc":["body"],"msg":"x","type":"y"}]}'),
        # An `ErrorCode` this SDK does not know: status + raw body still carry it.
        (409, b'{"code":"SOME_FUTURE_CODE","message":"new"}'),
    ],
)
@respx.mock
def test_unrecognised_error_body_keeps_status_and_raw_body(
    status: int, body: bytes
) -> None:
    respx.get(f"{BASE_URL}/api/v1/customers/missing").mock(
        return_value=httpx.Response(status, content=body)
    )

    with make_client(retry_schedule=[]) as client:
        with pytest.raises(ApiException) as excinfo:
            client.customers.get_customer("missing")

    assert_untyped(excinfo.value, status, body)
    assert body.decode() in str(excinfo.value)


@respx.mock
async def test_async_non_json_error_body_keeps_status_and_raw_body() -> None:
    respx.get(f"{BASE_URL}/api/v1/customers/missing").mock(
        return_value=httpx.Response(503, content=b"upstream unavailable")
    )

    async with MeteroidAsync(
        "test-api-key",
        MeteroidOptions(server_url=BASE_URL, timeout=None, retry_schedule=[]),
    ) as client:
        with pytest.raises(ApiException) as excinfo:
            await client.customers.get_customer("missing")

    assert_untyped(excinfo.value, 503, b"upstream unavailable")


@respx.mock
def test_server_errors_are_retried() -> None:
    route = respx.get(f"{BASE_URL}/api/v1/customers").mock(
        side_effect=[
            httpx.Response(
                500, json={"code": "INTERNAL_SERVER_ERROR", "message": "boom"}
            ),
            httpx.Response(200, json={"data": [], "pagination_meta": PAGINATION}),
        ]
    )

    with make_client(retry_schedule=[0.0]) as client:
        response = client.customers.list_customers()

    assert route.call_count == 2
    assert route.calls[1].request.headers["meteroid-retry-count"] == "1"
    assert response.data == []


@respx.mock
def test_client_errors_are_not_retried() -> None:
    route = respx.get(f"{BASE_URL}/api/v1/customers").mock(
        return_value=httpx.Response(400, json={"code": "BAD_REQUEST", "message": "nope"})
    )

    with make_client(retry_schedule=[0.0, 0.0]) as client:
        with pytest.raises(ApiException):
            client.customers.list_customers()

    assert route.call_count == 1


@respx.mock
async def test_async_list_customers() -> None:
    respx.get(f"{BASE_URL}/api/v1/customers").mock(
        return_value=httpx.Response(200, json={"data": [], "pagination_meta": PAGINATION})
    )

    async with MeteroidAsync(
        "test-api-key", MeteroidOptions(server_url=BASE_URL, timeout=None)
    ) as client:
        response = await client.customers.list_customers()

    assert response.data == []


def test_with_token_reuses_connection_pool() -> None:
    with make_client() as client:
        other = client.with_token("another-key")
        assert other._httpx_client is client._httpx_client
        assert other._cfg.bearer_access_token == "another-key"
        assert client._cfg.bearer_access_token == "test-api-key"


@respx.mock
def test_timeout_is_applied_per_request() -> None:
    route = respx.get(f"{BASE_URL}/api/v1/customers").mock(
        return_value=httpx.Response(200, json={"data": [], "pagination_meta": PAGINATION})
    )

    with Meteroid(
        "test-api-key", MeteroidOptions(server_url=BASE_URL, timeout=3.5)
    ) as client:
        client.customers.list_customers()

    assert route.calls.last.request.extensions["timeout"]["read"] == 3.5


@respx.mock
def test_timeout_is_honoured_with_a_caller_supplied_client() -> None:
    """`MeteroidOptions.timeout` must not be silently dropped, as in the Rust SDK."""
    route = respx.get(f"{BASE_URL}/api/v1/customers").mock(
        return_value=httpx.Response(200, json={"data": [], "pagination_meta": PAGINATION})
    )

    # A client whose own timeout differs from the one the options ask for.
    with httpx.Client(timeout=99.0) as httpx_client:
        client = Meteroid(
            "test-api-key",
            MeteroidOptions(server_url=BASE_URL, timeout=3.5),
            httpx_client,
        )
        client.customers.list_customers()

    assert route.calls.last.request.extensions["timeout"]["read"] == 3.5


@respx.mock
async def test_timeout_is_honoured_with_a_caller_supplied_async_client() -> None:
    route = respx.get(f"{BASE_URL}/api/v1/customers").mock(
        return_value=httpx.Response(200, json={"data": [], "pagination_meta": PAGINATION})
    )

    async with httpx.AsyncClient(timeout=99.0) as httpx_client:
        client = MeteroidAsync(
            "test-api-key",
            MeteroidOptions(server_url=BASE_URL, timeout=3.5),
            httpx_client,
        )
        await client.customers.list_customers()

    assert route.calls.last.request.extensions["timeout"]["read"] == 3.5


@respx.mock
def test_timeout_none_disables_the_timeout() -> None:
    route = respx.get(f"{BASE_URL}/api/v1/customers").mock(
        return_value=httpx.Response(200, json={"data": [], "pagination_meta": PAGINATION})
    )

    with httpx.Client(timeout=99.0) as httpx_client:
        client = Meteroid(
            "test-api-key",
            MeteroidOptions(server_url=BASE_URL, timeout=None),
            httpx_client,
        )
        client.customers.list_customers()

    assert route.calls.last.request.extensions["timeout"]["read"] is None


@respx.mock
def test_timeouts_are_retried_and_surface_as_network_exception() -> None:
    """Documented divergence from Rust, which propagates a timeout immediately."""
    route = respx.get(f"{BASE_URL}/api/v1/customers").mock(
        side_effect=httpx.ReadTimeout("timed out")
    )

    with make_client(retry_schedule=[0.0, 0.0]) as client:
        with pytest.raises(NetworkException):
            client.customers.list_customers()

    assert route.call_count == 3
