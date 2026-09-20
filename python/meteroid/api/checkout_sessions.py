# this file is @generated
import typing as t

from ..models import (
    CancelCheckoutSessionResponse,
    CheckoutSessionStatus,
    CreateCheckoutSessionRequest,
    CreateCheckoutSessionResponse,
    CustomerId,
    GetCheckoutSessionResponse,
    ListCheckoutSessionsResponse,
)
from .common import ApiBaseAsync, ApiBaseSync, decode_response, serialize_query_params


class CheckoutSessionsAsync(ApiBaseAsync):
    """checkout sessions API."""

    async def list_checkout_sessions(
        self,
        *,
        customer_id: t.Optional[CustomerId] = None,
        status: t.Optional[CheckoutSessionStatus] = None,
    ) -> ListCheckoutSessionsResponse:
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/checkout-sessions",
            query_params=serialize_query_params(
                {
                    "customer_id": customer_id,
                    "status": status,
                },
            ),
        )
        return decode_response(response, ListCheckoutSessionsResponse)

    async def create_checkout_session(
        self,
        create_checkout_session_request: CreateCheckoutSessionRequest,
    ) -> CreateCheckoutSessionResponse:
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/checkout-sessions",
            json_body=create_checkout_session_request.to_dict(),
        )
        return decode_response(response, CreateCheckoutSessionResponse)

    async def get_checkout_session(
        self,
        id: str,
    ) -> GetCheckoutSessionResponse:
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/checkout-sessions/{id}",
            path_params={
                "id": id,
            },
        )
        return decode_response(response, GetCheckoutSessionResponse)

    async def cancel_checkout_session(
        self,
        id: str,
    ) -> CancelCheckoutSessionResponse:
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/checkout-sessions/{id}/cancel",
            path_params={
                "id": id,
            },
        )
        return decode_response(response, CancelCheckoutSessionResponse)


class CheckoutSessions(ApiBaseSync):
    """checkout sessions API."""

    def list_checkout_sessions(
        self,
        *,
        customer_id: t.Optional[CustomerId] = None,
        status: t.Optional[CheckoutSessionStatus] = None,
    ) -> ListCheckoutSessionsResponse:
        response = self._request_sync(
            method="get",
            path="/api/v1/checkout-sessions",
            query_params=serialize_query_params(
                {
                    "customer_id": customer_id,
                    "status": status,
                },
            ),
        )
        return decode_response(response, ListCheckoutSessionsResponse)

    def create_checkout_session(
        self,
        create_checkout_session_request: CreateCheckoutSessionRequest,
    ) -> CreateCheckoutSessionResponse:
        response = self._request_sync(
            method="post",
            path="/api/v1/checkout-sessions",
            json_body=create_checkout_session_request.to_dict(),
        )
        return decode_response(response, CreateCheckoutSessionResponse)

    def get_checkout_session(
        self,
        id: str,
    ) -> GetCheckoutSessionResponse:
        response = self._request_sync(
            method="get",
            path="/api/v1/checkout-sessions/{id}",
            path_params={
                "id": id,
            },
        )
        return decode_response(response, GetCheckoutSessionResponse)

    def cancel_checkout_session(
        self,
        id: str,
    ) -> CancelCheckoutSessionResponse:
        response = self._request_sync(
            method="post",
            path="/api/v1/checkout-sessions/{id}/cancel",
            path_params={
                "id": id,
            },
        )
        return decode_response(response, CancelCheckoutSessionResponse)
