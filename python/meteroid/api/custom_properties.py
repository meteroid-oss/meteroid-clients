# this file is @generated
import typing as t

from ..models import (
    CustomPropertyDefinition,
    CustomPropertyDefinitionCreateRequest,
    CustomPropertyDefinitionListResponse,
    CustomPropertyDefinitionUpdateRequest,
    CustomPropertyEntityType,
)
from .common import ApiBaseAsync, ApiBaseSync, decode_response, serialize_query_params


class CustomPropertiesAsync(ApiBaseAsync):
    """custom properties API."""

    async def list_definitions(
        self,
        *,
        entity_type: t.Optional[CustomPropertyEntityType] = None,
        include_archived: t.Optional[bool] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> CustomPropertyDefinitionListResponse:
        """:param entity_type: Filter to a single entity type.
        :param include_archived: Include archived (soft-deleted) definitions. Defaults to false.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/custom-property-definitions",
            query_params=serialize_query_params(
                {
                    "entity_type": entity_type,
                    "include_archived": include_archived,
                    "page": page,
                    "per_page": per_page,
                },
            ),
        )
        return decode_response(response, CustomPropertyDefinitionListResponse)

    async def create_definition(
        self,
        custom_property_definition_create_request: CustomPropertyDefinitionCreateRequest,
    ) -> CustomPropertyDefinition:
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/custom-property-definitions",
            json_body=custom_property_definition_create_request.to_dict(),
        )
        return decode_response(response, CustomPropertyDefinition)

    async def get_definition(
        self,
        id: str,
    ) -> CustomPropertyDefinition:
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/custom-property-definitions/{id}",
            path_params={
                "id": id,
            },
        )
        return decode_response(response, CustomPropertyDefinition)

    async def update_definition(
        self,
        id: str,
        custom_property_definition_update_request: CustomPropertyDefinitionUpdateRequest,
    ) -> CustomPropertyDefinition:
        response = await self._request_asyncio(
            method="put",
            path="/api/v1/custom-property-definitions/{id}",
            path_params={
                "id": id,
            },
            json_body=custom_property_definition_update_request.to_dict(),
        )
        return decode_response(response, CustomPropertyDefinition)

    async def archive_definition(
        self,
        id: str,
    ) -> CustomPropertyDefinition:
        """Soft-deletes the definition. Existing property values on entities are preserved; the definition
        simply stops being enforced on new writes."""
        response = await self._request_asyncio(
            method="delete",
            path="/api/v1/custom-property-definitions/{id}",
            path_params={
                "id": id,
            },
        )
        return decode_response(response, CustomPropertyDefinition)


class CustomProperties(ApiBaseSync):
    """custom properties API."""

    def list_definitions(
        self,
        *,
        entity_type: t.Optional[CustomPropertyEntityType] = None,
        include_archived: t.Optional[bool] = None,
        page: t.Optional[int] = None,
        per_page: t.Optional[int] = None,
    ) -> CustomPropertyDefinitionListResponse:
        """:param entity_type: Filter to a single entity type.
        :param include_archived: Include archived (soft-deleted) definitions. Defaults to false.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request_sync(
            method="get",
            path="/api/v1/custom-property-definitions",
            query_params=serialize_query_params(
                {
                    "entity_type": entity_type,
                    "include_archived": include_archived,
                    "page": page,
                    "per_page": per_page,
                },
            ),
        )
        return decode_response(response, CustomPropertyDefinitionListResponse)

    def create_definition(
        self,
        custom_property_definition_create_request: CustomPropertyDefinitionCreateRequest,
    ) -> CustomPropertyDefinition:
        response = self._request_sync(
            method="post",
            path="/api/v1/custom-property-definitions",
            json_body=custom_property_definition_create_request.to_dict(),
        )
        return decode_response(response, CustomPropertyDefinition)

    def get_definition(
        self,
        id: str,
    ) -> CustomPropertyDefinition:
        response = self._request_sync(
            method="get",
            path="/api/v1/custom-property-definitions/{id}",
            path_params={
                "id": id,
            },
        )
        return decode_response(response, CustomPropertyDefinition)

    def update_definition(
        self,
        id: str,
        custom_property_definition_update_request: CustomPropertyDefinitionUpdateRequest,
    ) -> CustomPropertyDefinition:
        response = self._request_sync(
            method="put",
            path="/api/v1/custom-property-definitions/{id}",
            path_params={
                "id": id,
            },
            json_body=custom_property_definition_update_request.to_dict(),
        )
        return decode_response(response, CustomPropertyDefinition)

    def archive_definition(
        self,
        id: str,
    ) -> CustomPropertyDefinition:
        """Soft-deletes the definition. Existing property values on entities are preserved; the definition
        simply stops being enforced on new writes."""
        response = self._request_sync(
            method="delete",
            path="/api/v1/custom-property-definitions/{id}",
            path_params={
                "id": id,
            },
        )
        return decode_response(response, CustomPropertyDefinition)
