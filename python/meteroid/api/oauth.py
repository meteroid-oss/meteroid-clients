# this file is @generated
"""Oauth API."""

from __future__ import annotations

import typing as t

from .. import models as _models
from ..models import (
    IntrospectionRequest,
    RevocationRequest,
    TokenIntrospectionResponse,
    TokenRequest,
    TokenResponse,
)
from ..serialization import UNSET, Unset, to_json_value
from ._response import async_to_raw_response_wrapper, to_raw_response_wrapper
from .common import (
    ApiBaseAsync,
    ApiBaseSync,
    ApiRequest,
    Timeout,
    decode_response,
    serialize_form_body,
)


class AsyncOauth(ApiBaseAsync):
    """Oauth API, for asyncio."""

    @property
    def with_raw_response(self) -> AsyncOauthWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return AsyncOauthWithRawResponse(self)

    async def introspect(
        self,
        *,
        token: str,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> TokenIntrospectionResponse:
        """Introspect token

        Token introspection endpoint (RFC 7662). Requires client credentials
        via HTTP Basic auth.

        :param token: The token to introspect"""
        response = await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/oauth/introspect",
                security=[],
                form_body=serialize_form_body(
                    to_json_value(
                        IntrospectionRequest(
                            token=token,
                        ),
                        IntrospectionRequest,
                    ),
                ),
                error_types={
                    "401": _models.OAuthErrorResponse,
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )
        return decode_response(response, TokenIntrospectionResponse)

    async def revoke(
        self,
        *,
        token: str,
        token_type_hint: str | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Revoke token

        Token revocation endpoint (RFC 7009). Always returns 200 per spec.
        Requires client credentials via HTTP Basic auth.

        :param token: The token to revoke
        :param token_type_hint: Optional hint about the token type (access_token or refresh_token)"""
        await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/oauth/revoke",
                security=[],
                form_body=serialize_form_body(
                    to_json_value(
                        RevocationRequest(
                            token=token,
                            token_type_hint=token_type_hint,
                        ),
                        RevocationRequest,
                    ),
                ),
                error_types={
                    "401": _models.OAuthErrorResponse,
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )

    async def token(
        self,
        *,
        grant_type: str,
        client_id: str | None | Unset = UNSET,
        client_secret: str | None | Unset = UNSET,
        code: str | None | Unset = UNSET,
        code_verifier: str | None | Unset = UNSET,
        redirect_uri: str | None | Unset = UNSET,
        refresh_token: str | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> TokenResponse:
        """Exchange tokens

        OAuth 2.0 token endpoint. Supports two grant types:
        - `authorization_code`: Exchange an authorization code for tokens
        - `refresh_token`: Refresh an access token

        Authenticate via HTTP Basic auth (`client_id:client_secret`) or body parameters.

        :param client_id: Client ID (if not using HTTP Basic auth)
        :param client_secret: Client secret (if not using HTTP Basic auth)
        :param code: Authorization code (for authorization_code grant)
        :param code_verifier: PKCE code verifier (for authorization_code grant with PKCE)
        :param grant_type: Grant type: "authorization_code" or "refresh_token"
        :param redirect_uri: Redirect URI (for authorization_code grant, must match the one used in /authorize)
        :param refresh_token: Refresh token (for refresh_token grant)"""
        response = await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/oauth/token",
                security=[],
                form_body=serialize_form_body(
                    to_json_value(
                        TokenRequest(
                            client_id=client_id,
                            client_secret=client_secret,
                            code=code,
                            code_verifier=code_verifier,
                            grant_type=grant_type,
                            redirect_uri=redirect_uri,
                            refresh_token=refresh_token,
                        ),
                        TokenRequest,
                    ),
                ),
                error_types={
                    "400": _models.OAuthErrorResponse,
                    "401": _models.OAuthErrorResponse,
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )
        return decode_response(response, TokenResponse)


class AsyncOauthWithRawResponse:
    """The methods of :class:`AsyncOauth`, returning an :class:`APIResponse`."""

    def __init__(self, resource: AsyncOauth) -> None:
        self.introspect = async_to_raw_response_wrapper(resource.introspect)
        self.revoke = async_to_raw_response_wrapper(resource.revoke)
        self.token = async_to_raw_response_wrapper(resource.token)


class Oauth(ApiBaseSync):
    """Oauth API."""

    @property
    def with_raw_response(self) -> OauthWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return OauthWithRawResponse(self)

    def introspect(
        self,
        *,
        token: str,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> TokenIntrospectionResponse:
        """Introspect token

        Token introspection endpoint (RFC 7662). Requires client credentials
        via HTTP Basic auth.

        :param token: The token to introspect"""
        response = self._request(
            ApiRequest(
                method="post",
                path="/api/v1/oauth/introspect",
                security=[],
                form_body=serialize_form_body(
                    to_json_value(
                        IntrospectionRequest(
                            token=token,
                        ),
                        IntrospectionRequest,
                    ),
                ),
                error_types={
                    "401": _models.OAuthErrorResponse,
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )
        return decode_response(response, TokenIntrospectionResponse)

    def revoke(
        self,
        *,
        token: str,
        token_type_hint: str | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> None:
        """Revoke token

        Token revocation endpoint (RFC 7009). Always returns 200 per spec.
        Requires client credentials via HTTP Basic auth.

        :param token: The token to revoke
        :param token_type_hint: Optional hint about the token type (access_token or refresh_token)"""
        self._request(
            ApiRequest(
                method="post",
                path="/api/v1/oauth/revoke",
                security=[],
                form_body=serialize_form_body(
                    to_json_value(
                        RevocationRequest(
                            token=token,
                            token_type_hint=token_type_hint,
                        ),
                        RevocationRequest,
                    ),
                ),
                error_types={
                    "401": _models.OAuthErrorResponse,
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )

    def token(
        self,
        *,
        grant_type: str,
        client_id: str | None | Unset = UNSET,
        client_secret: str | None | Unset = UNSET,
        code: str | None | Unset = UNSET,
        code_verifier: str | None | Unset = UNSET,
        redirect_uri: str | None | Unset = UNSET,
        refresh_token: str | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> TokenResponse:
        """Exchange tokens

        OAuth 2.0 token endpoint. Supports two grant types:
        - `authorization_code`: Exchange an authorization code for tokens
        - `refresh_token`: Refresh an access token

        Authenticate via HTTP Basic auth (`client_id:client_secret`) or body parameters.

        :param client_id: Client ID (if not using HTTP Basic auth)
        :param client_secret: Client secret (if not using HTTP Basic auth)
        :param code: Authorization code (for authorization_code grant)
        :param code_verifier: PKCE code verifier (for authorization_code grant with PKCE)
        :param grant_type: Grant type: "authorization_code" or "refresh_token"
        :param redirect_uri: Redirect URI (for authorization_code grant, must match the one used in /authorize)
        :param refresh_token: Refresh token (for refresh_token grant)"""
        response = self._request(
            ApiRequest(
                method="post",
                path="/api/v1/oauth/token",
                security=[],
                form_body=serialize_form_body(
                    to_json_value(
                        TokenRequest(
                            client_id=client_id,
                            client_secret=client_secret,
                            code=code,
                            code_verifier=code_verifier,
                            grant_type=grant_type,
                            redirect_uri=redirect_uri,
                            refresh_token=refresh_token,
                        ),
                        TokenRequest,
                    ),
                ),
                error_types={
                    "400": _models.OAuthErrorResponse,
                    "401": _models.OAuthErrorResponse,
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )
        return decode_response(response, TokenResponse)


class OauthWithRawResponse:
    """The methods of :class:`Oauth`, returning an :class:`APIResponse`."""

    def __init__(self, resource: Oauth) -> None:
        self.introspect = to_raw_response_wrapper(resource.introspect)
        self.revoke = to_raw_response_wrapper(resource.revoke)
        self.token = to_raw_response_wrapper(resource.token)
