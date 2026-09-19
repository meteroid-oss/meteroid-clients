# this file is @generated
import typing as t

from ..models import (
    CancelSubscriptionRequest,
    CancelSubscriptionResponse,
    EffectiveEntitlementListResponse,
    PlanId,
    Subscription,
    SubscriptionCreateRequest,
    SubscriptionDetails,
    SubscriptionListResponse,
    SubscriptionStatusEnum,
    SubscriptionUpdateRequest,
    SubscriptionUpdateResponse,
)
from .common import ApiBaseAsync, ApiBaseSync, serialize_query_params


class SubscriptionsAsync(ApiBaseAsync):
    """subscriptions API."""

    async def list_subscriptions(
        self,
        *,
        customer_id: t.Optional[str] = None,
        plan_id: t.Optional[PlanId] = None,
        statuses: t.Optional[t.List[SubscriptionStatusEnum]] = None,
        order_by: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> SubscriptionListResponse:
        """List subscriptions with optional filtering by customer or plan.

        :param customer_id: Filter by customer ID or alias
        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `customer_name`, `plan_name`, `mrr_cents`, `billing_start_date`, `end_date`, `status`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request_asyncio(
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
        )
        return SubscriptionListResponse.from_dict(response.json())

    async def create_subscription(
        self,
        subscription_create_request: SubscriptionCreateRequest,
    ) -> SubscriptionDetails:
        """Create a new subscription for a customer with a specific plan."""
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/subscriptions",
            json_body=subscription_create_request.to_dict(),
        )
        return SubscriptionDetails.from_dict(response.json())

    async def subscription_details(
        self,
        subscription_id: str,
    ) -> SubscriptionDetails:
        """Retrieve detailed information about a subscription including price components and schedules."""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/subscriptions/{subscription_id}",
            path_params={
                "subscription_id": subscription_id,
            },
        )
        return SubscriptionDetails.from_dict(response.json())

    async def update_subscription(
        self,
        subscription_id: str,
        subscription_update_request: SubscriptionUpdateRequest,
    ) -> SubscriptionUpdateResponse:
        """Update subscription settings like payment configuration, billing options, etc."""
        response = await self._request_asyncio(
            method="patch",
            path="/api/v1/subscriptions/{subscription_id}",
            path_params={
                "subscription_id": subscription_id,
            },
            json_body=subscription_update_request.to_dict(),
        )
        return SubscriptionUpdateResponse.from_dict(response.json())

    async def cancel_subscription(
        self,
        subscription_id: str,
        cancel_subscription_request: CancelSubscriptionRequest,
    ) -> CancelSubscriptionResponse:
        """Cancel a subscription either immediately or at the end of the billing period."""
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/subscriptions/{subscription_id}/cancel",
            path_params={
                "subscription_id": subscription_id,
            },
            json_body=cancel_subscription_request.to_dict(),
        )
        return CancelSubscriptionResponse.from_dict(response.json())

    async def list_subscription_entitlements(
        self,
        subscription_id: str,
    ) -> EffectiveEntitlementListResponse:
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/subscriptions/{subscription_id}/entitlements",
            path_params={
                "subscription_id": subscription_id,
            },
        )
        return EffectiveEntitlementListResponse.from_dict(response.json())

    async def subscription_summary(
        self,
        subscription_id: str,
    ) -> Subscription:
        """Retrieve a subscription without its components, add-ons, coupons and entitlements: the same
        shape as list items, for callers that only need status and billing dates."""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/subscriptions/{subscription_id}/summary",
            path_params={
                "subscription_id": subscription_id,
            },
        )
        return Subscription.from_dict(response.json())


class Subscriptions(ApiBaseSync):
    """subscriptions API."""

    def list_subscriptions(
        self,
        *,
        customer_id: t.Optional[str] = None,
        plan_id: t.Optional[PlanId] = None,
        statuses: t.Optional[t.List[SubscriptionStatusEnum]] = None,
        order_by: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> SubscriptionListResponse:
        """List subscriptions with optional filtering by customer or plan.

        :param customer_id: Filter by customer ID or alias
        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `customer_name`, `plan_name`, `mrr_cents`, `billing_start_date`, `end_date`, `status`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request_sync(
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
        )
        return SubscriptionListResponse.from_dict(response.json())

    def create_subscription(
        self,
        subscription_create_request: SubscriptionCreateRequest,
    ) -> SubscriptionDetails:
        """Create a new subscription for a customer with a specific plan."""
        response = self._request_sync(
            method="post",
            path="/api/v1/subscriptions",
            json_body=subscription_create_request.to_dict(),
        )
        return SubscriptionDetails.from_dict(response.json())

    def subscription_details(
        self,
        subscription_id: str,
    ) -> SubscriptionDetails:
        """Retrieve detailed information about a subscription including price components and schedules."""
        response = self._request_sync(
            method="get",
            path="/api/v1/subscriptions/{subscription_id}",
            path_params={
                "subscription_id": subscription_id,
            },
        )
        return SubscriptionDetails.from_dict(response.json())

    def update_subscription(
        self,
        subscription_id: str,
        subscription_update_request: SubscriptionUpdateRequest,
    ) -> SubscriptionUpdateResponse:
        """Update subscription settings like payment configuration, billing options, etc."""
        response = self._request_sync(
            method="patch",
            path="/api/v1/subscriptions/{subscription_id}",
            path_params={
                "subscription_id": subscription_id,
            },
            json_body=subscription_update_request.to_dict(),
        )
        return SubscriptionUpdateResponse.from_dict(response.json())

    def cancel_subscription(
        self,
        subscription_id: str,
        cancel_subscription_request: CancelSubscriptionRequest,
    ) -> CancelSubscriptionResponse:
        """Cancel a subscription either immediately or at the end of the billing period."""
        response = self._request_sync(
            method="post",
            path="/api/v1/subscriptions/{subscription_id}/cancel",
            path_params={
                "subscription_id": subscription_id,
            },
            json_body=cancel_subscription_request.to_dict(),
        )
        return CancelSubscriptionResponse.from_dict(response.json())

    def list_subscription_entitlements(
        self,
        subscription_id: str,
    ) -> EffectiveEntitlementListResponse:
        response = self._request_sync(
            method="get",
            path="/api/v1/subscriptions/{subscription_id}/entitlements",
            path_params={
                "subscription_id": subscription_id,
            },
        )
        return EffectiveEntitlementListResponse.from_dict(response.json())

    def subscription_summary(
        self,
        subscription_id: str,
    ) -> Subscription:
        """Retrieve a subscription without its components, add-ons, coupons and entitlements: the same
        shape as list items, for callers that only need status and billing dates."""
        response = self._request_sync(
            method="get",
            path="/api/v1/subscriptions/{subscription_id}/summary",
            path_params={
                "subscription_id": subscription_id,
            },
        )
        return Subscription.from_dict(response.json())
