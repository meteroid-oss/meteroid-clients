# this file is @generated
import typing as t

from ..models import (
    Feature,
    FeatureListResponse,
    FeatureStatus,
    ProductId,
)
from .common import ApiBaseAsync, ApiBaseSync, serialize_query_params


class FeaturesAsync(ApiBaseAsync):
    """features API."""

    async def list_features(
        self,
        *,
        statuses: t.Optional[t.List[FeatureStatus]] = None,
        product_id: t.Optional[ProductId] = None,
        search: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> FeatureListResponse:
        """:param statuses: Filter by feature status. Repeat the param to select multiple, omit to return all.
        :param product_id: Filter by product. Omit to return features across all products.
        :param search: Search by feature name.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/features",
            query_params=serialize_query_params(
                {
                    "statuses": statuses,
                    "product_id": product_id,
                    "search": search,
                    "page": page,
                    "per_page": per_page,
                },
            ),
        )
        return FeatureListResponse.from_dict(response.json())

    async def get_feature(
        self,
        id_or_code: str,
    ) -> Feature:
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/features/{id_or_code}",
            path_params={
                "id_or_code": id_or_code,
            },
        )
        return Feature.from_dict(response.json())


class Features(ApiBaseSync):
    """features API."""

    def list_features(
        self,
        *,
        statuses: t.Optional[t.List[FeatureStatus]] = None,
        product_id: t.Optional[ProductId] = None,
        search: t.Optional[str] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> FeatureListResponse:
        """:param statuses: Filter by feature status. Repeat the param to select multiple, omit to return all.
        :param product_id: Filter by product. Omit to return features across all products.
        :param search: Search by feature name.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request_sync(
            method="get",
            path="/api/v1/features",
            query_params=serialize_query_params(
                {
                    "statuses": statuses,
                    "product_id": product_id,
                    "search": search,
                    "page": page,
                    "per_page": per_page,
                },
            ),
        )
        return FeatureListResponse.from_dict(response.json())

    def get_feature(
        self,
        id_or_code: str,
    ) -> Feature:
        response = self._request_sync(
            method="get",
            path="/api/v1/features/{id_or_code}",
            path_params={
                "id_or_code": id_or_code,
            },
        )
        return Feature.from_dict(response.json())
