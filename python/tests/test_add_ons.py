# this file is @generated
# ruff: noqa: I001  (where the package sorts depends on whether it is generated yet)
import unittest

from meteroid.models import CreateAddOnRequest, UpdateAddOnRequest

from perseid_mock import call, decode, mock


class AddOnsTest(unittest.TestCase):
    def test_list(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"data":[{"created_at":"2023-12-31T23:59:59.999-05:30","id":"add_on_id_0","name":"sample","price_id":"price_id_47","product_id":"product_id_67","self_serviceable":false}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
        )
        call(client.add_ons.list)
        self.assertEqual(requests, ["GET /api/v1/addons"])

    def test_create(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"created_at":"2024-03-15T10:30:45.123+02:00","id":"add_on_id_90","name":"sample","price_id":"price_id_99","product_id":"product_id_90","self_serviceable":false}',
        )
        call(
            client.add_ons.create,
            body=decode(
                CreateAddOnRequest,
                '{"name":"sample","price_id":"price_id_44","product_id":"product_id_47"}',
            ),
        )
        self.assertEqual(requests, ["POST /api/v1/addons"])

    def test_retrieve(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"created_at":"2024-03-15T10:30:45.123+02:00","id":"add_on_id_90","name":"sample","price_id":"price_id_99","product_id":"product_id_90","self_serviceable":false}',
        )
        call(client.add_ons.retrieve, "addon_id")
        self.assertEqual(requests, ["GET /api/v1/addons/addon_id"])

    def test_update(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"created_at":"2024-03-15T10:30:45.123+02:00","id":"add_on_id_90","name":"sample","price_id":"price_id_99","product_id":"product_id_90","self_serviceable":false}',
        )
        call(client.add_ons.update, "addon_id", body=decode(UpdateAddOnRequest, "{}"))
        self.assertEqual(requests, ["PATCH /api/v1/addons/addon_id"])

    def test_archive(self) -> None:
        client, requests = mock(204, None, "")
        call(client.add_ons.archive, "addon_id")
        self.assertEqual(requests, ["POST /api/v1/addons/addon_id/archive"])

    def test_list_entitlements(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"data":[{"feature":{"code":"sample","id":"feature_id_53","name":"sample"},"value":{"type":"BOOLEAN","enabled":false}}]}',
        )
        call(client.add_ons.list_entitlements, "addon_id")
        self.assertEqual(requests, ["GET /api/v1/addons/addon_id/entitlements"])

    def test_unarchive(self) -> None:
        client, requests = mock(204, None, "")
        call(client.add_ons.unarchive, "addon_id")
        self.assertEqual(requests, ["POST /api/v1/addons/addon_id/unarchive"])
