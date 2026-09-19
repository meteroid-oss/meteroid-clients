# this file is @generated
import typing as t

from ..models import (
    CreatePlanRequest,
    MinimumCommitment,
    PatchPlanRequest,
    Plan,
    PlanListResponse,
    PlanStatusEnum,
    PlanTypeEnum,
    PlanVersionListResponse,
    ProductFamilyId,
    ReplacePlanRequest,
    ResolvedEntitlementListResponse,
)
from .common import ApiBaseAsync, ApiBaseSync, serialize_query_params


class PlansAsync(ApiBaseAsync):
    """plans API."""

    async def list_plan_version_entitlements(
        self,
        plan_version_id: str,
    ) -> ResolvedEntitlementListResponse:
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/plan-versions/{plan_version_id}/entitlements",
            path_params={
                "plan_version_id": plan_version_id,
            },
        )
        return ResolvedEntitlementListResponse.from_dict(response.json())

    async def list_plans(
        self,
        *,
        product_family_id: t.Optional[ProductFamilyId] = None,
        search: t.Optional[str] = None,
        status: t.Optional[t.List[PlanStatusEnum]] = None,
        plan_type: t.Optional[t.List[PlanTypeEnum]] = None,
        order_by: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> PlanListResponse:
        """:param search: Search by plan name
        :param status: Filter by plan status (can be repeated)
        :param plan_type: Filter by plan type (can be repeated)
        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `name`, `status`, `plan_type`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/plans",
            query_params=serialize_query_params(
                {
                    "product_family_id": product_family_id,
                    "search": search,
                    "status": status,
                    "plan_type": plan_type,
                    "order_by": order_by,
                    "page": page,
                    "per_page": per_page,
                },
            ),
        )
        return PlanListResponse.from_dict(response.json())

    async def create_plan(
        self,
        create_plan_request: CreatePlanRequest,
    ) -> Plan:
        """Create a new plan with components and pricing. Set `status` to `ACTIVE` to
        publish immediately, or `DRAFT` to stage for review."""
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/plans",
            json_body=create_plan_request.to_dict(),
        )
        return Plan.from_dict(response.json())

    async def set_plan_minimum(
        self,
        plan_version_id: str,
        minimum_commitment: MinimumCommitment,
    ) -> MinimumCommitment:
        response = await self._request_asyncio(
            method="put",
            path="/api/v1/plans/versions/{plan_version_id}/minimum",
            path_params={
                "plan_version_id": plan_version_id,
            },
            json_body=minimum_commitment.to_dict(),
        )
        return MinimumCommitment.from_dict(response.json())

    async def delete_plan_minimum(
        self,
        plan_version_id: str,
    ) -> None:
        await self._request_asyncio(
            method="delete",
            path="/api/v1/plans/versions/{plan_version_id}/minimum",
            path_params={
                "plan_version_id": plan_version_id,
            },
        )

    async def get_plan_details(
        self,
        plan_id: str,
        *,
        version: t.Optional[str] = None,
    ) -> Plan:
        """Retrieve a specific plan. Use `?version=draft` for the draft version,
        `?version=2` for a specific version number, or omit for the active version.

        :param version: Filter by version: "draft", a version number, or omitted for active"""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/plans/{plan_id}",
            path_params={
                "plan_id": plan_id,
            },
            query_params=serialize_query_params(
                {
                    "version": version,
                },
            ),
        )
        return Plan.from_dict(response.json())

    async def replace_plan(
        self,
        plan_id: str,
        replace_plan_request: ReplacePlanRequest,
    ) -> Plan:
        """Full replacement of a plan's version. On a draft plan, updates in-place.
        On a published plan, creates a new version. Set `status` to `DRAFT` to
        stage as a new draft without publishing."""
        response = await self._request_asyncio(
            method="put",
            path="/api/v1/plans/{plan_id}",
            path_params={
                "plan_id": plan_id,
            },
            json_body=replace_plan_request.to_dict(),
        )
        return Plan.from_dict(response.json())

    async def patch_plan(
        self,
        plan_id: str,
        patch_plan_request: PatchPlanRequest,
    ) -> Plan:
        """Partially update plan-level fields (name, description, self_service_rank).
        Does not modify version-level configuration or components."""
        response = await self._request_asyncio(
            method="patch",
            path="/api/v1/plans/{plan_id}",
            path_params={
                "plan_id": plan_id,
            },
            json_body=patch_plan_request.to_dict(),
        )
        return Plan.from_dict(response.json())

    async def archive_plan(
        self,
        plan_id: str,
    ) -> None:
        await self._request_asyncio(
            method="post",
            path="/api/v1/plans/{plan_id}/archive",
            path_params={
                "plan_id": plan_id,
            },
        )

    async def publish_plan(
        self,
        plan_id: str,
    ) -> Plan:
        """Publishes the current draft version, making it the active version."""
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/plans/{plan_id}/publish",
            path_params={
                "plan_id": plan_id,
            },
        )
        return Plan.from_dict(response.json())

    async def unarchive_plan(
        self,
        plan_id: str,
    ) -> None:
        await self._request_asyncio(
            method="post",
            path="/api/v1/plans/{plan_id}/unarchive",
            path_params={
                "plan_id": plan_id,
            },
        )

    async def list_plan_versions(
        self,
        plan_id: str,
        *,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> PlanVersionListResponse:
        """:param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/plans/{plan_id}/versions",
            path_params={
                "plan_id": plan_id,
            },
            query_params=serialize_query_params(
                {
                    "page": page,
                    "per_page": per_page,
                },
            ),
        )
        return PlanVersionListResponse.from_dict(response.json())


class Plans(ApiBaseSync):
    """plans API."""

    def list_plan_version_entitlements(
        self,
        plan_version_id: str,
    ) -> ResolvedEntitlementListResponse:
        response = self._request_sync(
            method="get",
            path="/api/v1/plan-versions/{plan_version_id}/entitlements",
            path_params={
                "plan_version_id": plan_version_id,
            },
        )
        return ResolvedEntitlementListResponse.from_dict(response.json())

    def list_plans(
        self,
        *,
        product_family_id: t.Optional[ProductFamilyId] = None,
        search: t.Optional[str] = None,
        status: t.Optional[t.List[PlanStatusEnum]] = None,
        plan_type: t.Optional[t.List[PlanTypeEnum]] = None,
        order_by: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> PlanListResponse:
        """:param search: Search by plan name
        :param status: Filter by plan status (can be repeated)
        :param plan_type: Filter by plan type (can be repeated)
        :param order_by: Sort order. Format: `column.direction`. Allowed columns: `name`, `status`, `plan_type`, `created_at`. Direction: `asc` or `desc`. Default: `created_at.desc`.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request_sync(
            method="get",
            path="/api/v1/plans",
            query_params=serialize_query_params(
                {
                    "product_family_id": product_family_id,
                    "search": search,
                    "status": status,
                    "plan_type": plan_type,
                    "order_by": order_by,
                    "page": page,
                    "per_page": per_page,
                },
            ),
        )
        return PlanListResponse.from_dict(response.json())

    def create_plan(
        self,
        create_plan_request: CreatePlanRequest,
    ) -> Plan:
        """Create a new plan with components and pricing. Set `status` to `ACTIVE` to
        publish immediately, or `DRAFT` to stage for review."""
        response = self._request_sync(
            method="post",
            path="/api/v1/plans",
            json_body=create_plan_request.to_dict(),
        )
        return Plan.from_dict(response.json())

    def set_plan_minimum(
        self,
        plan_version_id: str,
        minimum_commitment: MinimumCommitment,
    ) -> MinimumCommitment:
        response = self._request_sync(
            method="put",
            path="/api/v1/plans/versions/{plan_version_id}/minimum",
            path_params={
                "plan_version_id": plan_version_id,
            },
            json_body=minimum_commitment.to_dict(),
        )
        return MinimumCommitment.from_dict(response.json())

    def delete_plan_minimum(
        self,
        plan_version_id: str,
    ) -> None:
        self._request_sync(
            method="delete",
            path="/api/v1/plans/versions/{plan_version_id}/minimum",
            path_params={
                "plan_version_id": plan_version_id,
            },
        )

    def get_plan_details(
        self,
        plan_id: str,
        *,
        version: t.Optional[str] = None,
    ) -> Plan:
        """Retrieve a specific plan. Use `?version=draft` for the draft version,
        `?version=2` for a specific version number, or omit for the active version.

        :param version: Filter by version: "draft", a version number, or omitted for active"""
        response = self._request_sync(
            method="get",
            path="/api/v1/plans/{plan_id}",
            path_params={
                "plan_id": plan_id,
            },
            query_params=serialize_query_params(
                {
                    "version": version,
                },
            ),
        )
        return Plan.from_dict(response.json())

    def replace_plan(
        self,
        plan_id: str,
        replace_plan_request: ReplacePlanRequest,
    ) -> Plan:
        """Full replacement of a plan's version. On a draft plan, updates in-place.
        On a published plan, creates a new version. Set `status` to `DRAFT` to
        stage as a new draft without publishing."""
        response = self._request_sync(
            method="put",
            path="/api/v1/plans/{plan_id}",
            path_params={
                "plan_id": plan_id,
            },
            json_body=replace_plan_request.to_dict(),
        )
        return Plan.from_dict(response.json())

    def patch_plan(
        self,
        plan_id: str,
        patch_plan_request: PatchPlanRequest,
    ) -> Plan:
        """Partially update plan-level fields (name, description, self_service_rank).
        Does not modify version-level configuration or components."""
        response = self._request_sync(
            method="patch",
            path="/api/v1/plans/{plan_id}",
            path_params={
                "plan_id": plan_id,
            },
            json_body=patch_plan_request.to_dict(),
        )
        return Plan.from_dict(response.json())

    def archive_plan(
        self,
        plan_id: str,
    ) -> None:
        self._request_sync(
            method="post",
            path="/api/v1/plans/{plan_id}/archive",
            path_params={
                "plan_id": plan_id,
            },
        )

    def publish_plan(
        self,
        plan_id: str,
    ) -> Plan:
        """Publishes the current draft version, making it the active version."""
        response = self._request_sync(
            method="post",
            path="/api/v1/plans/{plan_id}/publish",
            path_params={
                "plan_id": plan_id,
            },
        )
        return Plan.from_dict(response.json())

    def unarchive_plan(
        self,
        plan_id: str,
    ) -> None:
        self._request_sync(
            method="post",
            path="/api/v1/plans/{plan_id}/unarchive",
            path_params={
                "plan_id": plan_id,
            },
        )

    def list_plan_versions(
        self,
        plan_id: str,
        *,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> PlanVersionListResponse:
        """:param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request_sync(
            method="get",
            path="/api/v1/plans/{plan_id}/versions",
            path_params={
                "plan_id": plan_id,
            },
            query_params=serialize_query_params(
                {
                    "page": page,
                    "per_page": per_page,
                },
            ),
        )
        return PlanVersionListResponse.from_dict(response.json())
