# this file is @generated
# ruff: noqa: I001  (where the package sorts depends on whether it is generated yet)
import unittest

from meteroid.models import ProductFamilyCreateRequest

from perseid_mock import call, decode, mock


class ProductFamiliesTest(unittest.TestCase):
    def test_list(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"data":[{"id":"product_family_id_9","name":"sample"}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
        )
        call(client.product_families.list)
        self.assertEqual(requests, ["GET /api/v1/product_families"])

    def test_create(self) -> None:
        client, requests = mock(
            200, "application/json", '{"id":"product_family_id_35","name":"sample"}'
        )
        call(
            client.product_families.create,
            body=decode(ProductFamilyCreateRequest, '{"name":"sample"}'),
        )
        self.assertEqual(requests, ["POST /api/v1/product_families"])

    def test_retrieve(self) -> None:
        client, requests = mock(
            200, "application/json", '{"id":"product_family_id_35","name":"sample"}'
        )
        call(client.product_families.retrieve, "id_or_alias")
        self.assertEqual(requests, ["GET /api/v1/product_families/id_or_alias"])
