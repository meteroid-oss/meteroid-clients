# this file is @generated
# ruff: noqa: I001  (where the package sorts depends on whether it is generated yet)
import unittest

from meteroid.models import CreateProductRequest, UpdateProductRequest

from perseid_mock import call, decode, mock


class ProductsTest(unittest.TestCase):
    def test_list(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"data":[{"catalog":false,"created_at":"2024-03-15T10:30:45.123+02:00","fee_structure":{"type":"RATE"},"fee_type":"CAPACITY","id":"product_id_78","name":"sample","product_family_id":"product_family_id_47"}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
        )
        call(client.products.list)
        self.assertEqual(requests, ["GET /api/v1/products"])

    def test_create(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"catalog":true,"created_at":"2023-12-31T23:59:59.999-05:30","fee_structure":{"type":"RATE"},"fee_type":"RATE","id":"product_id_13","name":"sample","product_family_id":"product_family_id_99"}',
        )
        call(
            client.products.create,
            body=decode(
                CreateProductRequest,
                '{"fee_structure":{"type":"RATE"},"name":"sample","product_family_id":"product_family_id_47"}',
            ),
        )
        self.assertEqual(requests, ["POST /api/v1/products"])

    def test_retrieve(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"catalog":true,"created_at":"2023-12-31T23:59:59.999-05:30","fee_structure":{"type":"RATE"},"fee_type":"RATE","id":"product_id_13","name":"sample","product_family_id":"product_family_id_99"}',
        )
        call(client.products.retrieve, "product_id")
        self.assertEqual(requests, ["GET /api/v1/products/product_id"])

    def test_update(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"catalog":true,"created_at":"2023-12-31T23:59:59.999-05:30","fee_structure":{"type":"RATE"},"fee_type":"RATE","id":"product_id_13","name":"sample","product_family_id":"product_family_id_99"}',
        )
        call(
            client.products.update,
            "product_id",
            body=decode(UpdateProductRequest, "{}"),
        )
        self.assertEqual(requests, ["PATCH /api/v1/products/product_id"])

    def test_archive(self) -> None:
        client, requests = mock(204, None, "")
        call(client.products.archive, "product_id")
        self.assertEqual(requests, ["POST /api/v1/products/product_id/archive"])

    def test_list_entitlements(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"data":[{"feature":{"code":"sample","id":"feature_id_53","name":"sample"},"value":{"type":"BOOLEAN","enabled":false}}]}',
        )
        call(client.products.list_entitlements, "product_id")
        self.assertEqual(requests, ["GET /api/v1/products/product_id/entitlements"])

    def test_unarchive(self) -> None:
        client, requests = mock(204, None, "")
        call(client.products.unarchive, "product_id")
        self.assertEqual(requests, ["POST /api/v1/products/product_id/unarchive"])
