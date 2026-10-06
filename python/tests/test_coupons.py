# this file is @generated
# ruff: noqa: I001  (where the package sorts depends on whether it is generated yet)
import unittest

from meteroid.models import CreateCouponRequest, UpdateCouponRequest

from perseid_mock import call, decode, mock


class CouponsTest(unittest.TestCase):
    def test_list(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"data":[{"code":"sample","created_at":"2024-03-15T10:30:45.123+02:00","disabled":false,"discount":{"type":"PERCENTAGE","percentage":"sample"},"id":"coupon_id_25","plan_ids":["plan_id_47"],"redemption_count":-2147483648,"reusable":false}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
        )
        call(client.coupons.list)
        self.assertEqual(requests, ["GET /api/v1/coupons"])

    def test_create(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","disabled":false,"discount":{"type":"PERCENTAGE","percentage":"sample"},"id":"coupon_id_40","plan_ids":["plan_id_99"],"redemption_count":-123456789,"reusable":false}',
        )
        call(
            client.coupons.create,
            body=decode(
                CreateCouponRequest,
                '{"code":"sample","discount":{"type":"PERCENTAGE","percentage":"sample"}}',
            ),
        )
        self.assertEqual(requests, ["POST /api/v1/coupons"])

    def test_retrieve(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","disabled":false,"discount":{"type":"PERCENTAGE","percentage":"sample"},"id":"coupon_id_40","plan_ids":["plan_id_99"],"redemption_count":-123456789,"reusable":false}',
        )
        call(client.coupons.retrieve, "coupon_id")
        self.assertEqual(requests, ["GET /api/v1/coupons/coupon_id"])

    def test_update(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","disabled":false,"discount":{"type":"PERCENTAGE","percentage":"sample"},"id":"coupon_id_40","plan_ids":["plan_id_99"],"redemption_count":-123456789,"reusable":false}',
        )
        call(client.coupons.update, "coupon_id", body=decode(UpdateCouponRequest, "{}"))
        self.assertEqual(requests, ["PATCH /api/v1/coupons/coupon_id"])

    def test_archive(self) -> None:
        client, requests = mock(204, None, "")
        call(client.coupons.archive, "coupon_id")
        self.assertEqual(requests, ["POST /api/v1/coupons/coupon_id/archive"])

    def test_disable(self) -> None:
        client, requests = mock(204, None, "")
        call(client.coupons.disable, "coupon_id")
        self.assertEqual(requests, ["POST /api/v1/coupons/coupon_id/disable"])

    def test_enable(self) -> None:
        client, requests = mock(204, None, "")
        call(client.coupons.enable, "coupon_id")
        self.assertEqual(requests, ["POST /api/v1/coupons/coupon_id/enable"])

    def test_unarchive(self) -> None:
        client, requests = mock(204, None, "")
        call(client.coupons.unarchive, "coupon_id")
        self.assertEqual(requests, ["POST /api/v1/coupons/coupon_id/unarchive"])
