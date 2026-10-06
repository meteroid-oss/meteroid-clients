# this file is @generated
"""Oauth apps API."""

from __future__ import annotations

import builtins
import typing as t

from .. import models as _models
from ..models import (
    CreateOAuthAppRequest,
    OAuthApp,
    OAuthAppsResponse,
    OAuthAppWithSecret,
    RotatedSecret,
)
from ..serialization import UNSET, Unset, to_json_value
from ._response import async_to_raw_response_wrapper, to_raw_response_wrapper
from .common import (
    ApiBaseAsync,
    ApiBaseSync,
    ApiRequest,
    Timeout,
    decode_response,
)


class AsyncOauthApps(ApiBaseAsync):
    """Oauth apps API, for asyncio."""

    @property
    def with_raw_response(self) -> AsyncOauthAppsWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return AsyncOauthAppsWithRawResponse(self)

    async def list(
        self,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> OAuthAppsResponse:
        """List OAuth apps

        List all OAuth applications registered for this platform."""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/oauth-apps",
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
        return decode_response(response, OAuthAppsResponse)

    async def create(
        self,
        *,
        name: str,
        redirect_uris: builtins.list[str],
        scopes: builtins.list[str] | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> OAuthAppWithSecret:
        """Create OAuth app

        Register a new OAuth application. Returns the app with its client secret
        (only shown once)."""
        response = await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/oauth-apps",
                json_body=to_json_value(
                    CreateOAuthAppRequest(
                        name=name,
                        redirect_uris=redirect_uris,
                        scopes=scopes,
                    ),
                    CreateOAuthAppRequest,
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
        return decode_response(response, OAuthAppWithSecret)

    async def retrieve(
        self,
        id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> OAuthApp:
        """Get OAuth app

        Retrieve an OAuth application by ID."""
        response = await self._request(
            ApiRequest(
                method="get",
                path="/api/v1/oauth-apps/{id}",
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
        return decode_response(response, OAuthApp)

    async def delete(
        self,
        id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Delete OAuth app

        Delete an OAuth application and revoke all associated tokens."""
        await self._request(
            ApiRequest(
                method="delete",
                path="/api/v1/oauth-apps/{id}",
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

    async def rotate(
        self,
        id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> RotatedSecret:
        """Rotate client secret

        Generate a new client secret for an OAuth app. The old secret is
        immediately invalidated."""
        response = await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/oauth-apps/{id}/rotate",
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
        return decode_response(response, RotatedSecret)


class AsyncOauthAppsWithRawResponse:
    """The methods of :class:`AsyncOauthApps`, returning an :class:`APIResponse`."""

    def __init__(self, resource: AsyncOauthApps) -> None:
        self.list = async_to_raw_response_wrapper(resource.list)
        self.create = async_to_raw_response_wrapper(resource.create)
        self.retrieve = async_to_raw_response_wrapper(resource.retrieve)
        self.delete = async_to_raw_response_wrapper(resource.delete)
        self.rotate = async_to_raw_response_wrapper(resource.rotate)


class OauthApps(ApiBaseSync):
    """Oauth apps API."""

    @property
    def with_raw_response(self) -> OauthAppsWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return OauthAppsWithRawResponse(self)

    def list(
        self,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> OAuthAppsResponse:
        """List OAuth apps

        List all OAuth applications registered for this platform."""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/oauth-apps",
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
        return decode_response(response, OAuthAppsResponse)

    def create(
        self,
        *,
        name: str,
        redirect_uris: builtins.list[str],
        scopes: builtins.list[str] | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> OAuthAppWithSecret:
        """Create OAuth app

        Register a new OAuth application. Returns the app with its client secret
        (only shown once)."""
        response = self._request(
            ApiRequest(
                method="post",
                path="/api/v1/oauth-apps",
                json_body=to_json_value(
                    CreateOAuthAppRequest(
                        name=name,
                        redirect_uris=redirect_uris,
                        scopes=scopes,
                    ),
                    CreateOAuthAppRequest,
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
        return decode_response(response, OAuthAppWithSecret)

    def retrieve(
        self,
        id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> OAuthApp:
        """Get OAuth app

        Retrieve an OAuth application by ID."""
        response = self._request(
            ApiRequest(
                method="get",
                path="/api/v1/oauth-apps/{id}",
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
        return decode_response(response, OAuthApp)

    def delete(
        self,
        id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Delete OAuth app

        Delete an OAuth application and revoke all associated tokens."""
        self._request(
            ApiRequest(
                method="delete",
                path="/api/v1/oauth-apps/{id}",
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

    def rotate(
        self,
        id: str,
        *,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> RotatedSecret:
        """Rotate client secret

        Generate a new client secret for an OAuth app. The old secret is
        immediately invalidated."""
        response = self._request(
            ApiRequest(
                method="post",
                path="/api/v1/oauth-apps/{id}/rotate",
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
        return decode_response(response, RotatedSecret)


class OauthAppsWithRawResponse:
    """The methods of :class:`OauthApps`, returning an :class:`APIResponse`."""

    def __init__(self, resource: OauthApps) -> None:
        self.list = to_raw_response_wrapper(resource.list)
        self.create = to_raw_response_wrapper(resource.create)
        self.retrieve = to_raw_response_wrapper(resource.retrieve)
        self.delete = to_raw_response_wrapper(resource.delete)
        self.rotate = to_raw_response_wrapper(resource.rotate)
