# this file is @generated
"""Subscriptions API."""

from __future__ import annotations

import builtins
import typing as t
from datetime import date

from .. import models as _models
from ..models import (
    CancelSubscriptionRequest,
    CancelSubscriptionResponse,
    CreateSubscriptionAddOn,
    CreateSubscriptionComponents,
    EffectiveEntitlementListResponse,
    PaymentMethodsConfig,
    PlanId,
    Subscription,
    SubscriptionActivationConditionEnum,
    SubscriptionActivationConditionEnumLiteral,
    SubscriptionCreateRequest,
    SubscriptionDetails,
    SubscriptionListResponse,
    SubscriptionStatusEnum,
    SubscriptionUpdateRequest,
    SubscriptionUpdateResponse,
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


class AsyncSubscriptions(ApiBaseAsync):
    """Subscriptions API, for asyncio."""

    @property
    def with_raw_response(self) -> AsyncSubscriptionsWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return AsyncSubscriptionsWithRawResponse(self)

    async def list(
        self,
        *,
        customer_id: str | None = None,
        plan_id: PlanId | None = None,
        statuses: builtins.list[SubscriptionStatusEnum] | None = None,
        order_by: str | None = None,
        page: int | None = None,
        per_page: int | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> SubscriptionListResponse:
        """List subscriptions with optional filtering by customer or plan.

        :param customer_id: Filter by customer ID or alias
        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `customer_name`, `plan_name`, `mrr_cents`, `billing_start_date`, `end_date`, `status`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/subscriptions",
                query_params=serialize_query_params(
                    {
                        "customer_id": customer_id,
                        "plan_id": plan_id,
                        "statuses": statuses,
                        "order_by": order_by,
                        "page": page,
                        "per_page": per_page,
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
        return decode_response(response, SubscriptionListResponse)

    async def create(
        self,
        *,
        activation_condition: SubscriptionActivationConditionEnum
        | SubscriptionActivationConditionEnumLiteral,
        customer_id_or_alias: str,
        plan_id: PlanId,
        start_date: date,
        add_ons: builtins.list[CreateSubscriptionAddOn] | None = None,
        auto_advance_invoices: bool | None = None,
        backdate_invoices: bool | None = None,
        billing_day_anchor: int | None | Unset = UNSET,
        charge_automatically: bool | None = None,
        coupon_codes: builtins.list[str] | None = None,
        custom_properties: t.Any = None,
        end_date: date | None = None,
        invoice_memo: str | None = None,
        net_terms: int | None = None,
        payment_methods_config: PaymentMethodsConfig | None = None,
        price_components: CreateSubscriptionComponents | None = None,
        purchase_order: str | None | Unset = UNSET,
        skip_past_invoices: bool | None = None,
        trial_days: int | None = None,
        version: int | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> SubscriptionDetails:
        """Create subscription

        Create a new subscription for a customer with a specific plan.

        :param backdate_invoices: Historical import mode: when true, invoices finalized for this subscription keep their billing-period date as the invoice date instead of being stamped with the emission date.
        :param custom_properties: User-defined custom property values, keyed by definition `key`. Validated against the tenant's subscription definitions.
        :param payment_methods_config: Payment methods configuration. If not specified, inherits from the invoicing entity.
        :param skip_past_invoices: Migration mode: when true with a past start_date, skip creating invoices for past cycles. The subscription will be set to the current billing period with correct cycle_index."""
        response = await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/subscriptions",
                json_body=to_json_value(
                    SubscriptionCreateRequest(
                        activation_condition=t.cast(
                            "SubscriptionActivationConditionEnum", activation_condition
                        ),
                        add_ons=add_ons,
                        auto_advance_invoices=auto_advance_invoices,
                        backdate_invoices=backdate_invoices,
                        billing_day_anchor=billing_day_anchor,
                        charge_automatically=charge_automatically,
                        coupon_codes=coupon_codes,
                        custom_properties=custom_properties,
                        customer_id_or_alias=customer_id_or_alias,
                        end_date=end_date,
                        invoice_memo=invoice_memo,
                        net_terms=net_terms,
                        payment_methods_config=payment_methods_config,
                        plan_id=plan_id,
                        price_components=price_components,
                        purchase_order=purchase_order,
                        skip_past_invoices=skip_past_invoices,
                        start_date=start_date,
                        trial_days=trial_days,
                        version=version,
                    ),
                    SubscriptionCreateRequest,
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
        return decode_response(response, SubscriptionDetails)

    async def retrieve(
        self,
        subscription_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> SubscriptionDetails:
        """Get subscription details

        Retrieve detailed information about a subscription including price components and schedules."""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/subscriptions/{subscription_id}",
                path_params={
                    "subscription_id": subscription_id,
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
        return decode_response(response, SubscriptionDetails)

    async def update(
        self,
        subscription_id: str,
        *,
        auto_advance_invoices: bool | None | Unset = UNSET,
        charge_automatically: bool | None | Unset = UNSET,
        custom_properties: t.Any = None,
        invoice_memo: str | None | Unset = UNSET,
        net_terms: int | None | Unset = UNSET,
        payment_methods_config: PaymentMethodsConfig | None | Unset = UNSET,
        purchase_order: str | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> SubscriptionUpdateResponse:
        """Update subscription settings like payment configuration, billing options, etc.

        :param auto_advance_invoices: If false, invoices will stay in Draft until manually reviewed and finalized.
        :param charge_automatically: Automatically try to charge the customer's configured payment method on finalize.
        :param custom_properties: Partial update of custom property values (merge; send a key with `null` to remove it). Validated against the tenant's `SUBSCRIPTION` property definitions. Omit to leave unchanged.
        :param invoice_memo: Default memo for invoices
        :param net_terms: Payment terms in days (0 = due on issue)
        :param purchase_order: Purchase order number"""
        response = await self._request(
            ApiRequest(
                method="patch",
                path="/api/v1/subscriptions/{subscription_id}",
                path_params={
                    "subscription_id": subscription_id,
                },
                json_body=to_json_value(
                    SubscriptionUpdateRequest(
                        auto_advance_invoices=auto_advance_invoices,
                        charge_automatically=charge_automatically,
                        custom_properties=custom_properties,
                        invoice_memo=invoice_memo,
                        net_terms=net_terms,
                        payment_methods_config=payment_methods_config,
                        purchase_order=purchase_order,
                    ),
                    SubscriptionUpdateRequest,
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
        return decode_response(response, SubscriptionUpdateResponse)

    async def cancel(
        self,
        subscription_id: str,
        *,
        effective_date: date | None | Unset = UNSET,
        reason: str | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CancelSubscriptionResponse:
        """Cancel subscription

        Cancel a subscription either immediately or at the end of the billing period.

        :param effective_date: If not provided, the cancellation will be effective at the end of the current billing or committed period."""
        response = await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/subscriptions/{subscription_id}/cancel",
                path_params={
                    "subscription_id": subscription_id,
                },
                json_body=to_json_value(
                    CancelSubscriptionRequest(
                        effective_date=effective_date,
                        reason=reason,
                    ),
                    CancelSubscriptionRequest,
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
        return decode_response(response, CancelSubscriptionResponse)

    async def list_entitlements(
        self,
        subscription_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> EffectiveEntitlementListResponse:
        """List subscription entitlements"""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/subscriptions/{subscription_id}/entitlements",
                path_params={
                    "subscription_id": subscription_id,
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
        return decode_response(response, EffectiveEntitlementListResponse)

    async def retrieve_summary(
        self,
        subscription_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Subscription:
        """Get subscription summary

        Retrieve a subscription without its components, add-ons, coupons and entitlements: the same
        shape as list items, for callers that only need status and billing dates."""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/subscriptions/{subscription_id}/summary",
                path_params={
                    "subscription_id": subscription_id,
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
        return decode_response(response, Subscription)


class AsyncSubscriptionsWithRawResponse:
    """The methods of :class:`AsyncSubscriptions`, returning an :class:`APIResponse`."""

    def __init__(self, resource: AsyncSubscriptions) -> None:
        self.list = async_to_raw_response_wrapper(resource.list)
        self.create = async_to_raw_response_wrapper(resource.create)
        self.retrieve = async_to_raw_response_wrapper(resource.retrieve)
        self.update = async_to_raw_response_wrapper(resource.update)
        self.cancel = async_to_raw_response_wrapper(resource.cancel)
        self.list_entitlements = async_to_raw_response_wrapper(
            resource.list_entitlements
        )
        self.retrieve_summary = async_to_raw_response_wrapper(resource.retrieve_summary)


class Subscriptions(ApiBaseSync):
    """Subscriptions API."""

    @property
    def with_raw_response(self) -> SubscriptionsWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return SubscriptionsWithRawResponse(self)

    def list(
        self,
        *,
        customer_id: str | None = None,
        plan_id: PlanId | None = None,
        statuses: builtins.list[SubscriptionStatusEnum] | None = None,
        order_by: str | None = None,
        page: int | None = None,
        per_page: int | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> SubscriptionListResponse:
        """List subscriptions with optional filtering by customer or plan.

        :param customer_id: Filter by customer ID or alias
        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `customer_name`, `plan_name`, `mrr_cents`, `billing_start_date`, `end_date`, `status`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/subscriptions",
                query_params=serialize_query_params(
                    {
                        "customer_id": customer_id,
                        "plan_id": plan_id,
                        "statuses": statuses,
                        "order_by": order_by,
                        "page": page,
                        "per_page": per_page,
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
        return decode_response(response, SubscriptionListResponse)

    def create(
        self,
        *,
        activation_condition: SubscriptionActivationConditionEnum
        | SubscriptionActivationConditionEnumLiteral,
        customer_id_or_alias: str,
        plan_id: PlanId,
        start_date: date,
        add_ons: builtins.list[CreateSubscriptionAddOn] | None = None,
        auto_advance_invoices: bool | None = None,
        backdate_invoices: bool | None = None,
        billing_day_anchor: int | None | Unset = UNSET,
        charge_automatically: bool | None = None,
        coupon_codes: builtins.list[str] | None = None,
        custom_properties: t.Any = None,
        end_date: date | None = None,
        invoice_memo: str | None = None,
        net_terms: int | None = None,
        payment_methods_config: PaymentMethodsConfig | None = None,
        price_components: CreateSubscriptionComponents | None = None,
        purchase_order: str | None | Unset = UNSET,
        skip_past_invoices: bool | None = None,
        trial_days: int | None = None,
        version: int | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> SubscriptionDetails:
        """Create subscription

        Create a new subscription for a customer with a specific plan.

        :param backdate_invoices: Historical import mode: when true, invoices finalized for this subscription keep their billing-period date as the invoice date instead of being stamped with the emission date.
        :param custom_properties: User-defined custom property values, keyed by definition `key`. Validated against the tenant's subscription definitions.
        :param payment_methods_config: Payment methods configuration. If not specified, inherits from the invoicing entity.
        :param skip_past_invoices: Migration mode: when true with a past start_date, skip creating invoices for past cycles. The subscription will be set to the current billing period with correct cycle_index."""
        response = self._request(
            ApiRequest(
                method="post",
                path="/api/v1/subscriptions",
                json_body=to_json_value(
                    SubscriptionCreateRequest(
                        activation_condition=t.cast(
                            "SubscriptionActivationConditionEnum", activation_condition
                        ),
                        add_ons=add_ons,
                        auto_advance_invoices=auto_advance_invoices,
                        backdate_invoices=backdate_invoices,
                        billing_day_anchor=billing_day_anchor,
                        charge_automatically=charge_automatically,
                        coupon_codes=coupon_codes,
                        custom_properties=custom_properties,
                        customer_id_or_alias=customer_id_or_alias,
                        end_date=end_date,
                        invoice_memo=invoice_memo,
                        net_terms=net_terms,
                        payment_methods_config=payment_methods_config,
                        plan_id=plan_id,
                        price_components=price_components,
                        purchase_order=purchase_order,
                        skip_past_invoices=skip_past_invoices,
                        start_date=start_date,
                        trial_days=trial_days,
                        version=version,
                    ),
                    SubscriptionCreateRequest,
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
        return decode_response(response, SubscriptionDetails)

    def retrieve(
        self,
        subscription_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> SubscriptionDetails:
        """Get subscription details

        Retrieve detailed information about a subscription including price components and schedules."""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/subscriptions/{subscription_id}",
                path_params={
                    "subscription_id": subscription_id,
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
        return decode_response(response, SubscriptionDetails)

    def update(
        self,
        subscription_id: str,
        *,
        auto_advance_invoices: bool | None | Unset = UNSET,
        charge_automatically: bool | None | Unset = UNSET,
        custom_properties: t.Any = None,
        invoice_memo: str | None | Unset = UNSET,
        net_terms: int | None | Unset = UNSET,
        payment_methods_config: PaymentMethodsConfig | None | Unset = UNSET,
        purchase_order: str | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> SubscriptionUpdateResponse:
        """Update subscription settings like payment configuration, billing options, etc.

        :param auto_advance_invoices: If false, invoices will stay in Draft until manually reviewed and finalized.
        :param charge_automatically: Automatically try to charge the customer's configured payment method on finalize.
        :param custom_properties: Partial update of custom property values (merge; send a key with `null` to remove it). Validated against the tenant's `SUBSCRIPTION` property definitions. Omit to leave unchanged.
        :param invoice_memo: Default memo for invoices
        :param net_terms: Payment terms in days (0 = due on issue)
        :param purchase_order: Purchase order number"""
        response = self._request(
            ApiRequest(
                method="patch",
                path="/api/v1/subscriptions/{subscription_id}",
                path_params={
                    "subscription_id": subscription_id,
                },
                json_body=to_json_value(
                    SubscriptionUpdateRequest(
                        auto_advance_invoices=auto_advance_invoices,
                        charge_automatically=charge_automatically,
                        custom_properties=custom_properties,
                        invoice_memo=invoice_memo,
                        net_terms=net_terms,
                        payment_methods_config=payment_methods_config,
                        purchase_order=purchase_order,
                    ),
                    SubscriptionUpdateRequest,
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
        return decode_response(response, SubscriptionUpdateResponse)

    def cancel(
        self,
        subscription_id: str,
        *,
        effective_date: date | None | Unset = UNSET,
        reason: str | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CancelSubscriptionResponse:
        """Cancel subscription

        Cancel a subscription either immediately or at the end of the billing period.

        :param effective_date: If not provided, the cancellation will be effective at the end of the current billing or committed period."""
        response = self._request(
            ApiRequest(
                method="post",
                path="/api/v1/subscriptions/{subscription_id}/cancel",
                path_params={
                    "subscription_id": subscription_id,
                },
                json_body=to_json_value(
                    CancelSubscriptionRequest(
                        effective_date=effective_date,
                        reason=reason,
                    ),
                    CancelSubscriptionRequest,
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
        return decode_response(response, CancelSubscriptionResponse)

    def list_entitlements(
        self,
        subscription_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> EffectiveEntitlementListResponse:
        """List subscription entitlements"""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/subscriptions/{subscription_id}/entitlements",
                path_params={
                    "subscription_id": subscription_id,
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
        return decode_response(response, EffectiveEntitlementListResponse)

    def retrieve_summary(
        self,
        subscription_id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> Subscription:
        """Get subscription summary

        Retrieve a subscription without its components, add-ons, coupons and entitlements: the same
        shape as list items, for callers that only need status and billing dates."""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/subscriptions/{subscription_id}/summary",
                path_params={
                    "subscription_id": subscription_id,
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
        return decode_response(response, Subscription)


class SubscriptionsWithRawResponse:
    """The methods of :class:`Subscriptions`, returning an :class:`APIResponse`."""

    def __init__(self, resource: Subscriptions) -> None:
        self.list = to_raw_response_wrapper(resource.list)
        self.create = to_raw_response_wrapper(resource.create)
        self.retrieve = to_raw_response_wrapper(resource.retrieve)
        self.update = to_raw_response_wrapper(resource.update)
        self.cancel = to_raw_response_wrapper(resource.cancel)
        self.list_entitlements = to_raw_response_wrapper(resource.list_entitlements)
        self.retrieve_summary = to_raw_response_wrapper(resource.retrieve_summary)
