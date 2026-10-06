# this file is @generated
# ruff: noqa: I001  (where the package sorts depends on whether it is generated yet)
import unittest

from meteroid.models import CreateCheckoutSessionRequest

from perseid_mock import call, decode, mock


class CheckoutSessionsTest(unittest.TestCase):
    def test_list(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"sessions":[{"checkout_type":"PLAN_CHANGE","created_at":"2023-12-31T23:59:59.999-05:30","customer_id":"customer_id_47","id":"checkout_session_id_39","plan_version_id":"plan_version_id_67","status":"AWAITING_PAYMENT"}]}',
        )
        call(client.checkout_sessions.list)
        self.assertEqual(requests, ["GET /api/v1/checkout-sessions"])

    def test_create(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"session":{"checkout_type":"PLAN_CHANGE","created_at":"2023-12-31T23:59:59.999-05:30","customer_id":"customer_id_47","id":"checkout_session_id_39","plan_version_id":"plan_version_id_67","status":"AWAITING_PAYMENT"}}',
        )
        call(
            client.checkout_sessions.create,
            body=decode(
                CreateCheckoutSessionRequest,
                '{"customer_id":"sample","plan_version_id":"plan_version_id_2"}',
            ),
        )
        self.assertEqual(requests, ["POST /api/v1/checkout-sessions"])

    def test_retrieve(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"session":{"checkout_type":"PLAN_CHANGE","created_at":"2023-12-31T23:59:59.999-05:30","customer_id":"customer_id_47","id":"checkout_session_id_39","plan_version_id":"plan_version_id_67","status":"AWAITING_PAYMENT"}}',
        )
        call(client.checkout_sessions.retrieve, "id")
        self.assertEqual(requests, ["GET /api/v1/checkout-sessions/id"])

    def test_cancel(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"session":{"checkout_type":"PLAN_CHANGE","created_at":"2023-12-31T23:59:59.999-05:30","customer_id":"customer_id_47","id":"checkout_session_id_39","plan_version_id":"plan_version_id_67","status":"AWAITING_PAYMENT"}}',
        )
        call(client.checkout_sessions.cancel, "id")
        self.assertEqual(requests, ["POST /api/v1/checkout-sessions/id/cancel"])
