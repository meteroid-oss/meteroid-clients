# this file is @generated
# ruff: noqa: I001  (where the package sorts depends on whether it is generated yet)
import unittest

from meteroid.models import IntrospectionRequest, RevocationRequest, TokenRequest

from perseid_mock import call, decode, mock


class OauthTest(unittest.TestCase):
    def test_introspect(self) -> None:
        client, requests = mock(200, "application/json", '{"active":false}')
        call(
            client.oauth.introspect,
            body=decode(IntrospectionRequest, '{"token":"sample"}'),
        )
        self.assertEqual(requests, ["POST /api/v1/oauth/introspect"])

    def test_revoke(self) -> None:
        client, requests = mock(204, None, "")
        call(client.oauth.revoke, body=decode(RevocationRequest, '{"token":"sample"}'))
        self.assertEqual(requests, ["POST /api/v1/oauth/revoke"])

    def test_token(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"access_token":"sample","expires_in":9007199254740993,"token_type":"sample"}',
        )
        call(client.oauth.token, body=decode(TokenRequest, '{"grant_type":"sample"}'))
        self.assertEqual(requests, ["POST /api/v1/oauth/token"])
