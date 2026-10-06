# this file is @generated
# ruff: noqa: I001  (where the package sorts depends on whether it is generated yet)
import unittest

from meteroid.models import CreateOAuthAppRequest

from perseid_mock import call, decode, mock


class OauthAppsTest(unittest.TestCase):
    def test_list(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"data":[{"client_id":"sample","client_secret_hint":"sample","created_at":"2024-03-15T10:30:45.123+02:00","id":"o_auth_app_id_90","is_active":false,"name":"sample","organization_id":"organization_id_78","redirect_uris":["sample"],"scopes":["sample"]}]}',
        )
        call(client.oauth_apps.list)
        self.assertEqual(requests, ["GET /api/v1/oauth-apps"])

    def test_create(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"app":{"client_id":"sample","client_secret_hint":"sample","created_at":"2024-03-15T10:30:45.123+02:00","id":"o_auth_app_id_90","is_active":false,"name":"sample","organization_id":"organization_id_78","redirect_uris":["sample"],"scopes":["sample"]},"client_secret":"sample"}',
        )
        call(
            client.oauth_apps.create,
            body=decode(
                CreateOAuthAppRequest, '{"name":"sample","redirect_uris":["sample"]}'
            ),
        )
        self.assertEqual(requests, ["POST /api/v1/oauth-apps"])

    def test_retrieve(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"client_id":"sample","client_secret_hint":"sample","created_at":"2023-12-31T23:59:59.999-05:30","id":"o_auth_app_id_44","is_active":false,"name":"sample","organization_id":"organization_id_13","redirect_uris":["sample"],"scopes":["sample"]}',
        )
        call(client.oauth_apps.retrieve, "id")
        self.assertEqual(requests, ["GET /api/v1/oauth-apps/id"])

    def test_delete(self) -> None:
        client, requests = mock(204, None, "")
        call(client.oauth_apps.delete, "id")
        self.assertEqual(requests, ["DELETE /api/v1/oauth-apps/id"])

    def test_rotate(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"client_secret":"sample","client_secret_hint":"sample"}',
        )
        call(client.oauth_apps.rotate, "id")
        self.assertEqual(requests, ["POST /api/v1/oauth-apps/id/rotate"])
