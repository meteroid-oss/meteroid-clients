# this file is @generated

from ..models import (
    ConnectedAccount,
    ConnectedAccountsResponse,
    CreateConnectedAccountRequest,
    CreateOnboardingLinkRequest,
    OnboardingLinkResponse,
)
from .common import ApiBaseAsync, ApiBaseSync


class ConnectAsync(ApiBaseAsync):
    """connect API."""

    async def list_connected_accounts(
        self,
    ) -> ConnectedAccountsResponse:
        """List all connected accounts for this platform."""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/connected-accounts",
        )
        return ConnectedAccountsResponse.from_dict(response.json())

    async def create_connected_account(
        self,
        create_connected_account_request: CreateConnectedAccountRequest,
    ) -> ConnectedAccount:
        """Create a new connected account (Express flow). Returns the account
        and an onboarding link for the user to complete setup."""
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/connected-accounts",
            json_body=create_connected_account_request.to_dict(),
        )
        return ConnectedAccount.from_dict(response.json())

    async def get_connected_account(
        self,
        id: str,
    ) -> ConnectedAccount:
        """Retrieve a connected account by ID."""
        response = await self._request_asyncio(
            method="get",
            path="/api/v1/connected-accounts/{id}",
            path_params={
                "id": id,
            },
        )
        return ConnectedAccount.from_dict(response.json())

    async def disconnect_account(
        self,
        id: str,
    ) -> None:
        """Revoke a connected account. All associated tokens are invalidated."""
        await self._request_asyncio(
            method="delete",
            path="/api/v1/connected-accounts/{id}",
            path_params={
                "id": id,
            },
        )

    async def create_onboarding_link(
        self,
        id: str,
        create_onboarding_link_request: CreateOnboardingLinkRequest,
    ) -> OnboardingLinkResponse:
        """Generate a new onboarding link for a connected account. Any existing
        unused link is invalidated. The link expires after a configured duration."""
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/connected-accounts/{id}/onboarding",
            path_params={
                "id": id,
            },
            json_body=create_onboarding_link_request.to_dict(),
        )
        return OnboardingLinkResponse.from_dict(response.json())


class Connect(ApiBaseSync):
    """connect API."""

    def list_connected_accounts(
        self,
    ) -> ConnectedAccountsResponse:
        """List all connected accounts for this platform."""
        response = self._request_sync(
            method="get",
            path="/api/v1/connected-accounts",
        )
        return ConnectedAccountsResponse.from_dict(response.json())

    def create_connected_account(
        self,
        create_connected_account_request: CreateConnectedAccountRequest,
    ) -> ConnectedAccount:
        """Create a new connected account (Express flow). Returns the account
        and an onboarding link for the user to complete setup."""
        response = self._request_sync(
            method="post",
            path="/api/v1/connected-accounts",
            json_body=create_connected_account_request.to_dict(),
        )
        return ConnectedAccount.from_dict(response.json())

    def get_connected_account(
        self,
        id: str,
    ) -> ConnectedAccount:
        """Retrieve a connected account by ID."""
        response = self._request_sync(
            method="get",
            path="/api/v1/connected-accounts/{id}",
            path_params={
                "id": id,
            },
        )
        return ConnectedAccount.from_dict(response.json())

    def disconnect_account(
        self,
        id: str,
    ) -> None:
        """Revoke a connected account. All associated tokens are invalidated."""
        self._request_sync(
            method="delete",
            path="/api/v1/connected-accounts/{id}",
            path_params={
                "id": id,
            },
        )

    def create_onboarding_link(
        self,
        id: str,
        create_onboarding_link_request: CreateOnboardingLinkRequest,
    ) -> OnboardingLinkResponse:
        """Generate a new onboarding link for a connected account. Any existing
        unused link is invalidated. The link expires after a configured duration."""
        response = self._request_sync(
            method="post",
            path="/api/v1/connected-accounts/{id}/onboarding",
            path_params={
                "id": id,
            },
            json_body=create_onboarding_link_request.to_dict(),
        )
        return OnboardingLinkResponse.from_dict(response.json())
