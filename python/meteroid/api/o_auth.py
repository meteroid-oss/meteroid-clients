# this file is @generated

from ..models import (
    IntrospectionRequest,
    RevocationRequest,
    TokenIntrospectionResponse,
    TokenRequest,
    TokenResponse,
)
from .common import ApiBaseAsync, ApiBaseSync


class OAuthAsync(ApiBaseAsync):
    """o auth API."""

    async def introspect_endpoint(
        self,
        introspection_request: IntrospectionRequest,
    ) -> TokenIntrospectionResponse:
        """Token introspection endpoint (RFC 7662). Requires client credentials
        via HTTP Basic auth."""
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/oauth/introspect",
            form_body=introspection_request.to_dict(),
        )
        return TokenIntrospectionResponse.from_dict(response.json())

    async def revoke_endpoint(
        self,
        revocation_request: RevocationRequest,
    ) -> None:
        """Token revocation endpoint (RFC 7009). Always returns 200 per spec.
        Requires client credentials via HTTP Basic auth."""
        await self._request_asyncio(
            method="post",
            path="/api/v1/oauth/revoke",
            form_body=revocation_request.to_dict(),
        )

    async def token_endpoint(
        self,
        token_request: TokenRequest,
    ) -> TokenResponse:
        """OAuth 2.0 token endpoint. Supports two grant types:
        - `authorization_code`: Exchange an authorization code for tokens
        - `refresh_token`: Refresh an access token

        Authenticate via HTTP Basic auth (`client_id:client_secret`) or body parameters."""
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/oauth/token",
            form_body=token_request.to_dict(),
        )
        return TokenResponse.from_dict(response.json())


class OAuth(ApiBaseSync):
    """o auth API."""

    def introspect_endpoint(
        self,
        introspection_request: IntrospectionRequest,
    ) -> TokenIntrospectionResponse:
        """Token introspection endpoint (RFC 7662). Requires client credentials
        via HTTP Basic auth."""
        response = self._request_sync(
            method="post",
            path="/api/v1/oauth/introspect",
            form_body=introspection_request.to_dict(),
        )
        return TokenIntrospectionResponse.from_dict(response.json())

    def revoke_endpoint(
        self,
        revocation_request: RevocationRequest,
    ) -> None:
        """Token revocation endpoint (RFC 7009). Always returns 200 per spec.
        Requires client credentials via HTTP Basic auth."""
        self._request_sync(
            method="post",
            path="/api/v1/oauth/revoke",
            form_body=revocation_request.to_dict(),
        )

    def token_endpoint(
        self,
        token_request: TokenRequest,
    ) -> TokenResponse:
        """OAuth 2.0 token endpoint. Supports two grant types:
        - `authorization_code`: Exchange an authorization code for tokens
        - `refresh_token`: Refresh an access token

        Authenticate via HTTP Basic auth (`client_id:client_secret`) or body parameters."""
        response = self._request_sync(
            method="post",
            path="/api/v1/oauth/token",
            form_body=token_request.to_dict(),
        )
        return TokenResponse.from_dict(response.json())
