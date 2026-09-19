# this file is @generated

from ..models import (
    CreateOAuthAppRequest,
    OAuthApp,
    OAuthAppsResponse,
    OAuthAppWithSecret,
    RotatedSecret,
)
from .common import ApiBaseAsync, ApiBaseSync


class OAuthAppsAsync(ApiBaseAsync):
    """o auth apps API."""

    async def list_oauth_apps(
        self,
    ) -> OAuthAppsResponse:
        """List all OAuth applications registered for this platform."""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/oauth-apps",
        )
        return OAuthAppsResponse.from_dict(response.json())

    async def create_oauth_app(
        self,
        create_o_auth_app_request: CreateOAuthAppRequest,
    ) -> OAuthAppWithSecret:
        """Register a new OAuth application. Returns the app with its client secret
        (only shown once)."""
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/oauth-apps",
            json_body=create_o_auth_app_request.to_dict(),
        )
        return OAuthAppWithSecret.from_dict(response.json())

    async def get_oauth_app(
        self,
        id: str,
    ) -> OAuthApp:
        """Retrieve an OAuth application by ID."""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/oauth-apps/{id}",
            path_params={
                "id": id,
            },
        )
        return OAuthApp.from_dict(response.json())

    async def delete_oauth_app(
        self,
        id: str,
    ) -> None:
        """Delete an OAuth application and revoke all associated tokens."""
        await self._request_asyncio(
            method="delete",
            path="/api/v1/oauth-apps/{id}",
            path_params={
                "id": id,
            },
        )

    async def rotate_client_secret(
        self,
        id: str,
    ) -> RotatedSecret:
        """Generate a new client secret for an OAuth app. The old secret is
        immediately invalidated."""
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/oauth-apps/{id}/rotate",
            path_params={
                "id": id,
            },
        )
        return RotatedSecret.from_dict(response.json())


class OAuthApps(ApiBaseSync):
    """o auth apps API."""

    def list_oauth_apps(
        self,
    ) -> OAuthAppsResponse:
        """List all OAuth applications registered for this platform."""
        response = self._request_sync(
            method="get",
            path="/api/v1/oauth-apps",
        )
        return OAuthAppsResponse.from_dict(response.json())

    def create_oauth_app(
        self,
        create_o_auth_app_request: CreateOAuthAppRequest,
    ) -> OAuthAppWithSecret:
        """Register a new OAuth application. Returns the app with its client secret
        (only shown once)."""
        response = self._request_sync(
            method="post",
            path="/api/v1/oauth-apps",
            json_body=create_o_auth_app_request.to_dict(),
        )
        return OAuthAppWithSecret.from_dict(response.json())

    def get_oauth_app(
        self,
        id: str,
    ) -> OAuthApp:
        """Retrieve an OAuth application by ID."""
        response = self._request_sync(
            method="get",
            path="/api/v1/oauth-apps/{id}",
            path_params={
                "id": id,
            },
        )
        return OAuthApp.from_dict(response.json())

    def delete_oauth_app(
        self,
        id: str,
    ) -> None:
        """Delete an OAuth application and revoke all associated tokens."""
        self._request_sync(
            method="delete",
            path="/api/v1/oauth-apps/{id}",
            path_params={
                "id": id,
            },
        )

    def rotate_client_secret(
        self,
        id: str,
    ) -> RotatedSecret:
        """Generate a new client secret for an OAuth app. The old secret is
        immediately invalidated."""
        response = self._request_sync(
            method="post",
            path="/api/v1/oauth-apps/{id}/rotate",
            path_params={
                "id": id,
            },
        )
        return RotatedSecret.from_dict(response.json())
