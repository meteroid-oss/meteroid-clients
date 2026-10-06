# this file is @generated
"""Custom properties API."""

from __future__ import annotations

import typing as t

from .. import models as _models
from ..models import (
    CustomPropertyDefinition,
    CustomPropertyDefinitionCreateRequest,
    CustomPropertyDefinitionListResponse,
    CustomPropertyDefinitionUpdateRequest,
    CustomPropertyEntityType,
    CustomPropertyEntityTypeLiteral,
    CustomPropertyType,
    CustomPropertyTypeLiteral,
    PropertyConfig,
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


class AsyncCustomProperties(ApiBaseAsync):
    """Custom properties API, for asyncio."""

    @property
    def with_raw_response(self) -> AsyncCustomPropertiesWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return AsyncCustomPropertiesWithRawResponse(self)

    async def list_custom_property_definitions(
        self,
        *,
        entity_type: CustomPropertyEntityType | None = None,
        include_archived: bool | None = None,
        page: int | None = None,
        per_page: int | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CustomPropertyDefinitionListResponse:
        """List custom property definitions

        :param entity_type: Filter to a single entity type.
        :param include_archived: Include archived (soft-deleted) definitions. Defaults to false.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = await self._request(
            ApiRequest(
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
        return decode_response(response, CustomPropertyDefinitionListResponse)

    async def create_custom_property_definition(
        self,
        *,
        entity_type: CustomPropertyEntityType | CustomPropertyEntityTypeLiteral,
        key: str,
        name: str,
        property_type: CustomPropertyType | CustomPropertyTypeLiteral,
        config: PropertyConfig | None = None,
        default_value: t.Any = None,
        description: str | None | Unset = UNSET,
        display_order: int | None = None,
        required: bool | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CustomPropertyDefinition:
        """Create a custom property definition

        :param key: Immutable machine name; letters, digits and underscores only. Unique per entity type."""
        response = await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/custom-property-definitions",
                json_body=to_json_value(
                    CustomPropertyDefinitionCreateRequest(
                        config=config,
                        default_value=default_value,
                        description=description,
                        display_order=display_order,
                        entity_type=t.cast("CustomPropertyEntityType", entity_type),
                        key=key,
                        name=name,
                        property_type=t.cast("CustomPropertyType", property_type),
                        required=required,
                    ),
                    CustomPropertyDefinitionCreateRequest,
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
        return decode_response(response, CustomPropertyDefinition)

    async def retrieve_custom_property_definition(
        self,
        id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CustomPropertyDefinition:
        """Get a custom property definition"""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/custom-property-definitions/{id}",
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
        return decode_response(response, CustomPropertyDefinition)

    async def update_custom_property_definition(
        self,
        id: str,
        *,
        config: PropertyConfig | None | Unset = UNSET,
        default_value: t.Any = None,
        description: str | None | Unset = UNSET,
        display_order: int | None | Unset = UNSET,
        name: str | None | Unset = UNSET,
        required: bool | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CustomPropertyDefinition:
        """Update a custom property definition"""
        response = await self._request(
            ApiRequest(
                method="put",
                path="/api/v1/custom-property-definitions/{id}",
                path_params={
                    "id": id,
                },
                json_body=to_json_value(
                    CustomPropertyDefinitionUpdateRequest(
                        config=config,
                        default_value=default_value,
                        description=description,
                        display_order=display_order,
                        name=name,
                        required=required,
                    ),
                    CustomPropertyDefinitionUpdateRequest,
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
        return decode_response(response, CustomPropertyDefinition)

    async def archive_definition(
        self,
        id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CustomPropertyDefinition:
        """Archive a custom property definition

        Soft-deletes the definition. Existing property values on entities are preserved; the definition
        simply stops being enforced on new writes."""
        response = await self._request(
            ApiRequest(
                method="delete",
                path="/api/v1/custom-property-definitions/{id}",
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
        return decode_response(response, CustomPropertyDefinition)


class AsyncCustomPropertiesWithRawResponse:
    """The methods of :class:`AsyncCustomProperties`, returning an :class:`APIResponse`."""

    def __init__(self, resource: AsyncCustomProperties) -> None:
        self.list_custom_property_definitions = async_to_raw_response_wrapper(
            resource.list_custom_property_definitions
        )
        self.create_custom_property_definition = async_to_raw_response_wrapper(
            resource.create_custom_property_definition
        )
        self.retrieve_custom_property_definition = async_to_raw_response_wrapper(
            resource.retrieve_custom_property_definition
        )
        self.update_custom_property_definition = async_to_raw_response_wrapper(
            resource.update_custom_property_definition
        )
        self.archive_definition = async_to_raw_response_wrapper(
            resource.archive_definition
        )


class CustomProperties(ApiBaseSync):
    """Custom properties API."""

    @property
    def with_raw_response(self) -> CustomPropertiesWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return CustomPropertiesWithRawResponse(self)

    def list_custom_property_definitions(
        self,
        *,
        entity_type: CustomPropertyEntityType | None = None,
        include_archived: bool | None = None,
        page: int | None = None,
        per_page: int | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CustomPropertyDefinitionListResponse:
        """List custom property definitions

        :param entity_type: Filter to a single entity type.
        :param include_archived: Include archived (soft-deleted) definitions. Defaults to false.
        :param page: Page number (0-indexed)
        :param per_page: Number of items per page"""
        response = self._request(
            ApiRequest(
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
        return decode_response(response, CustomPropertyDefinitionListResponse)

    def create_custom_property_definition(
        self,
        *,
        entity_type: CustomPropertyEntityType | CustomPropertyEntityTypeLiteral,
        key: str,
        name: str,
        property_type: CustomPropertyType | CustomPropertyTypeLiteral,
        config: PropertyConfig | None = None,
        default_value: t.Any = None,
        description: str | None | Unset = UNSET,
        display_order: int | None = None,
        required: bool | None = None,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CustomPropertyDefinition:
        """Create a custom property definition

        :param key: Immutable machine name; letters, digits and underscores only. Unique per entity type."""
        response = self._request(
            ApiRequest(
                method="post",
                path="/api/v1/custom-property-definitions",
                json_body=to_json_value(
                    CustomPropertyDefinitionCreateRequest(
                        config=config,
                        default_value=default_value,
                        description=description,
                        display_order=display_order,
                        entity_type=t.cast("CustomPropertyEntityType", entity_type),
                        key=key,
                        name=name,
                        property_type=t.cast("CustomPropertyType", property_type),
                        required=required,
                    ),
                    CustomPropertyDefinitionCreateRequest,
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
        return decode_response(response, CustomPropertyDefinition)

    def retrieve_custom_property_definition(
        self,
        id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CustomPropertyDefinition:
        """Get a custom property definition"""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/custom-property-definitions/{id}",
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
        return decode_response(response, CustomPropertyDefinition)

    def update_custom_property_definition(
        self,
        id: str,
        *,
        config: PropertyConfig | None | Unset = UNSET,
        default_value: t.Any = None,
        description: str | None | Unset = UNSET,
        display_order: int | None | Unset = UNSET,
        name: str | None | Unset = UNSET,
        required: bool | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CustomPropertyDefinition:
        """Update a custom property definition"""
        response = self._request(
            ApiRequest(
                method="put",
                path="/api/v1/custom-property-definitions/{id}",
                path_params={
                    "id": id,
                },
                json_body=to_json_value(
                    CustomPropertyDefinitionUpdateRequest(
                        config=config,
                        default_value=default_value,
                        description=description,
                        display_order=display_order,
                        name=name,
                        required=required,
                    ),
                    CustomPropertyDefinitionUpdateRequest,
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
        return decode_response(response, CustomPropertyDefinition)

    def archive_definition(
        self,
        id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> CustomPropertyDefinition:
        """Archive a custom property definition

        Soft-deletes the definition. Existing property values on entities are preserved; the definition
        simply stops being enforced on new writes."""
        response = self._request(
            ApiRequest(
                method="delete",
                path="/api/v1/custom-property-definitions/{id}",
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
        return decode_response(response, CustomPropertyDefinition)


class CustomPropertiesWithRawResponse:
    """The methods of :class:`CustomProperties`, returning an :class:`APIResponse`."""

    def __init__(self, resource: CustomProperties) -> None:
        self.list_custom_property_definitions = to_raw_response_wrapper(
            resource.list_custom_property_definitions
        )
        self.create_custom_property_definition = to_raw_response_wrapper(
            resource.create_custom_property_definition
        )
        self.retrieve_custom_property_definition = to_raw_response_wrapper(
            resource.retrieve_custom_property_definition
        )
        self.update_custom_property_definition = to_raw_response_wrapper(
            resource.update_custom_property_definition
        )
        self.archive_definition = to_raw_response_wrapper(resource.archive_definition)
