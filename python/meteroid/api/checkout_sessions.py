# this file is @generated
"""Checkout sessions API."""

from __future__ import annotations

import builtins
import typing as t
from datetime import date
from decimal import Decimal

from .. import models as _models
from ..models import (
    CancelCheckoutSessionResponse,
    CheckoutSessionStatus,
    CouponId,
    CreateCheckoutSessionRequest,
    CreateCheckoutSessionResponse,
    CreateSubscriptionAddOn,
    CreateSubscriptionComponents,
    CustomerId,
    GetCheckoutSessionResponse,
    ListCheckoutSessionsResponse,
    PaymentMethodsConfig,
    PlanVersionId,
)
from ..serialization import UNSET, Unset, to_json_value
from ._response import async_to_raw_response_wrapper, to_raw_response_wrapper
from .common import (
    ApiBaseAsync,
    ApiBaseSync,
    ApiRequest,
    Timeout,
    decode_response,
    serialize_query_params,
)


class AsyncCheckoutSessions(ApiBaseAsync):
    """Checkout sessions API, for asyncio."""

    @property
    def with_raw_response(self) -> AsyncCheckoutSessionsWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return AsyncCheckoutSessionsWithRawResponse(self)

    async def list(
        self,
        *,
        customer_id: CustomerId | None = None,
        status: CheckoutSessionStatus | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> ListCheckoutSessionsResponse:
        """List checkout sessions"""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/checkout-sessions",
                query_params=serialize_query_params(
                    {
                        "customer_id": customer_id,
                        "status": status,
                    },
                ),
                error_types={
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )
        return decode_response(response, ListCheckoutSessionsResponse)

    async def create(
        self,
        *,
        customer_id: str,
        plan_version_id: PlanVersionId,
        add_ons: builtins.list[CreateSubscriptionAddOn] | None | Unset = UNSET,
        auto_advance_invoices: bool | None | Unset = UNSET,
        billing_day_anchor: int | None | Unset = UNSET,
        billing_start_date: date | None | Unset = UNSET,
        cancel_url: str | None | Unset = UNSET,
        charge_automatically: bool | None | Unset = UNSET,
        components: CreateSubscriptionComponents | None | Unset = UNSET,
        coupon_code: str | None | Unset = UNSET,
        coupon_ids: builtins.list[CouponId] | None = None,
        end_date: date | None | Unset = UNSET,
        expires_in_hours: int | None | Unset = UNSET,
        invoice_memo: str | None | Unset = UNSET,
        invoice_threshold: Decimal | None | Unset = UNSET,
        metadata: t.Any = None,
        net_terms: int | None | Unset = UNSET,
        payment_methods_config: PaymentMethodsConfig | None | Unset = UNSET,
        purchase_order: str | None | Unset = UNSET,
        success_url: str | None | Unset = UNSET,
        trial_duration_days: int | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CreateCheckoutSessionResponse:
        """Create a checkout session

        :param auto_advance_invoices: If false, invoices will stay in Draft until manually reviewed and finalized. Default is true.
        :param cancel_url: Absolute http(s) URL offered to the customer to leave the checkout without paying.
        :param charge_automatically: Automatically try to charge the customer's configured payment method on finalize. Default is true.
        :param customer_id: Customer ID or alias
        :param expires_in_hours: Session expiry time in hours. Default is 1 hour for self-serve checkout.
        :param success_url: Absolute http(s) URL the customer is sent to after a successful checkout. `checkout_session_id` is appended as a query parameter. Without it the customer stays on the hosted confirmation page."""
        response = await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/checkout-sessions",
                json_body=to_json_value(
                    CreateCheckoutSessionRequest(
                        add_ons=add_ons,
                        auto_advance_invoices=auto_advance_invoices,
                        billing_day_anchor=billing_day_anchor,
                        billing_start_date=billing_start_date,
                        cancel_url=cancel_url,
                        charge_automatically=charge_automatically,
                        components=components,
                        coupon_code=coupon_code,
                        coupon_ids=coupon_ids,
                        customer_id=customer_id,
                        end_date=end_date,
                        expires_in_hours=expires_in_hours,
                        invoice_memo=invoice_memo,
                        invoice_threshold=invoice_threshold,
                        metadata=metadata,
                        net_terms=net_terms,
                        payment_methods_config=payment_methods_config,
                        plan_version_id=plan_version_id,
                        purchase_order=purchase_order,
                        success_url=success_url,
                        trial_duration_days=trial_duration_days,
                    ),
                    CreateCheckoutSessionRequest,
                ),
                error_types={
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )
        return decode_response(response, CreateCheckoutSessionResponse)

    async def retrieve(
        self,
        id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> GetCheckoutSessionResponse:
        """Get a checkout session by ID"""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/checkout-sessions/{id}",
                path_params={
                    "id": id,
                },
                error_types={
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )
        return decode_response(response, GetCheckoutSessionResponse)

    async def cancel(
        self,
        id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CancelCheckoutSessionResponse:
        """Cancel a checkout session"""
        response = await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/checkout-sessions/{id}/cancel",
                path_params={
                    "id": id,
                },
                error_types={
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )
        return decode_response(response, CancelCheckoutSessionResponse)


class AsyncCheckoutSessionsWithRawResponse:
    """The methods of :class:`AsyncCheckoutSessions`, returning an :class:`APIResponse`."""

    def __init__(self, resource: AsyncCheckoutSessions) -> None:
        self.list = async_to_raw_response_wrapper(resource.list)
        self.create = async_to_raw_response_wrapper(resource.create)
        self.retrieve = async_to_raw_response_wrapper(resource.retrieve)
        self.cancel = async_to_raw_response_wrapper(resource.cancel)


class CheckoutSessions(ApiBaseSync):
    """Checkout sessions API."""

    @property
    def with_raw_response(self) -> CheckoutSessionsWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return CheckoutSessionsWithRawResponse(self)

    def list(
        self,
        *,
        customer_id: CustomerId | None = None,
        status: CheckoutSessionStatus | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> ListCheckoutSessionsResponse:
        """List checkout sessions"""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/checkout-sessions",
                query_params=serialize_query_params(
                    {
                        "customer_id": customer_id,
                        "status": status,
                    },
                ),
                error_types={
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )
        return decode_response(response, ListCheckoutSessionsResponse)

    def create(
        self,
        *,
        customer_id: str,
        plan_version_id: PlanVersionId,
        add_ons: builtins.list[CreateSubscriptionAddOn] | None | Unset = UNSET,
        auto_advance_invoices: bool | None | Unset = UNSET,
        billing_day_anchor: int | None | Unset = UNSET,
        billing_start_date: date | None | Unset = UNSET,
        cancel_url: str | None | Unset = UNSET,
        charge_automatically: bool | None | Unset = UNSET,
        components: CreateSubscriptionComponents | None | Unset = UNSET,
        coupon_code: str | None | Unset = UNSET,
        coupon_ids: builtins.list[CouponId] | None = None,
        end_date: date | None | Unset = UNSET,
        expires_in_hours: int | None | Unset = UNSET,
        invoice_memo: str | None | Unset = UNSET,
        invoice_threshold: Decimal | None | Unset = UNSET,
        metadata: t.Any = None,
        net_terms: int | None | Unset = UNSET,
        payment_methods_config: PaymentMethodsConfig | None | Unset = UNSET,
        purchase_order: str | None | Unset = UNSET,
        success_url: str | None | Unset = UNSET,
        trial_duration_days: int | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CreateCheckoutSessionResponse:
        """Create a checkout session

        :param auto_advance_invoices: If false, invoices will stay in Draft until manually reviewed and finalized. Default is true.
        :param cancel_url: Absolute http(s) URL offered to the customer to leave the checkout without paying.
        :param charge_automatically: Automatically try to charge the customer's configured payment method on finalize. Default is true.
        :param customer_id: Customer ID or alias
        :param expires_in_hours: Session expiry time in hours. Default is 1 hour for self-serve checkout.
        :param success_url: Absolute http(s) URL the customer is sent to after a successful checkout. `checkout_session_id` is appended as a query parameter. Without it the customer stays on the hosted confirmation page."""
        response = self._request(
            ApiRequest(
                method="post",
                path="/api/v1/checkout-sessions",
                json_body=to_json_value(
                    CreateCheckoutSessionRequest(
                        add_ons=add_ons,
                        auto_advance_invoices=auto_advance_invoices,
                        billing_day_anchor=billing_day_anchor,
                        billing_start_date=billing_start_date,
                        cancel_url=cancel_url,
                        charge_automatically=charge_automatically,
                        components=components,
                        coupon_code=coupon_code,
                        coupon_ids=coupon_ids,
                        customer_id=customer_id,
                        end_date=end_date,
                        expires_in_hours=expires_in_hours,
                        invoice_memo=invoice_memo,
                        invoice_threshold=invoice_threshold,
                        metadata=metadata,
                        net_terms=net_terms,
                        payment_methods_config=payment_methods_config,
                        plan_version_id=plan_version_id,
                        purchase_order=purchase_order,
                        success_url=success_url,
                        trial_duration_days=trial_duration_days,
                    ),
                    CreateCheckoutSessionRequest,
                ),
                error_types={
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )
        return decode_response(response, CreateCheckoutSessionResponse)

    def retrieve(
        self,
        id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> GetCheckoutSessionResponse:
        """Get a checkout session by ID"""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/checkout-sessions/{id}",
                path_params={
                    "id": id,
                },
                error_types={
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )
        return decode_response(response, GetCheckoutSessionResponse)

    def cancel(
        self,
        id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CancelCheckoutSessionResponse:
        """Cancel a checkout session"""
        response = self._request(
            ApiRequest(
                method="post",
                path="/api/v1/checkout-sessions/{id}/cancel",
                path_params={
                    "id": id,
                },
                error_types={
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )
        return decode_response(response, CancelCheckoutSessionResponse)


class CheckoutSessionsWithRawResponse:
    """The methods of :class:`CheckoutSessions`, returning an :class:`APIResponse`."""

    def __init__(self, resource: CheckoutSessions) -> None:
        self.list = to_raw_response_wrapper(resource.list)
        self.create = to_raw_response_wrapper(resource.create)
        self.retrieve = to_raw_response_wrapper(resource.retrieve)
        self.cancel = to_raw_response_wrapper(resource.cancel)
