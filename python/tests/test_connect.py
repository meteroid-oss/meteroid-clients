# this file is @generated
# ruff: noqa: I001  (where the package sorts depends on whether it is generated yet)
import unittest

from meteroid.models import CreateConnectedAccountRequest, CreateOnboardingLinkRequest

from perseid_mock import call, decode, mock


class ConnectTest(unittest.TestCase):
    def test_list_connected_accounts(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"data":[{"connection_type":"standard","created_at":"2024-03-15T10:30:45.123+02:00","id":"connected_account_id_67","onboarding_mode":"full","platform_organization_id":"organization_id_23","status":"active"}]}',
        )
        call(client.connect.list_connected_accounts)
        self.assertEqual(requests, ["GET /api/v1/connected-accounts"])

    def test_create_connected_account(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"connection_type":"express","created_at":"2024-03-15T10:30:45.123+02:00","id":"connected_account_id_47","onboarding_mode":"express","platform_organization_id":"organization_id_83","status":"active"}',
        )
        call(
            client.connect.create_connected_account,
            body=decode(
                CreateConnectedAccountRequest,
                '{"connected_organization_id":"00000000-0000-0000-0000-000000000000"}',
            ),
        )
        self.assertEqual(requests, ["POST /api/v1/connected-accounts"])

    def test_retrieve_connected_account(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"connection_type":"express","created_at":"2024-03-15T10:30:45.123+02:00","id":"connected_account_id_47","onboarding_mode":"express","platform_organization_id":"organization_id_83","status":"active"}',
        )
        call(client.connect.retrieve_connected_account, "id")
        self.assertEqual(requests, ["GET /api/v1/connected-accounts/id"])

    def test_disconnect_account(self) -> None:
        client, requests = mock(204, None, "")
        call(client.connect.disconnect_account, "id")
        self.assertEqual(requests, ["DELETE /api/v1/connected-accounts/id"])

    def test_create_onboarding_link(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"expires_at":"2023-12-31T23:59:59.999-05:30","url":"sample"}',
        )
        call(
            client.connect.create_onboarding_link,
            "id",
            body=decode(CreateOnboardingLinkRequest, '{"redirect_url":"sample"}'),
        )
        self.assertEqual(requests, ["POST /api/v1/connected-accounts/id/onboarding"])
