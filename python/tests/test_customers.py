# this file is @generated
# ruff: noqa: I001  (where the package sorts depends on whether it is generated yet)
import unittest

from meteroid.models import (
    CustomerCreateRequest,
    CustomerUpdateRequest,
    CustomerPatchRequest,
    CustomerPortalTokenRequest,
)

from perseid_mock import call, decode, mock


class CustomersTest(unittest.TestCase):
    def test_list(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"data":[{"currency":"TMT","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"custom_taxes":[{"name":"sample","rate":"sample","tax_code":"sample"}],"id":"customer_id_67","invoicing_emails":["sample"],"invoicing_entity_id":"invoicing_entity_id_27","name":"sample","preferred_locales":["sample"]}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
        )
        call(client.customers.list)
        self.assertEqual(requests, ["GET /api/v1/customers"])

    def test_create(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"currency":"MMK","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"custom_taxes":[{"name":"sample","rate":"sample","tax_code":"sample"}],"id":"customer_id_90","invoicing_emails":["sample"],"invoicing_entity_id":"invoicing_entity_id_26","name":"sample","preferred_locales":["sample"]}',
        )
        call(
            client.customers.create,
            body=decode(
                CustomerCreateRequest,
                '{"currency":"MMK","custom_taxes":[{"name":"sample","rate":"sample","tax_code":"sample"}],"invoicing_emails":["sample"]}',
            ),
        )
        self.assertEqual(requests, ["POST /api/v1/customers"])

    def test_retrieve(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"currency":"MMK","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"custom_taxes":[{"name":"sample","rate":"sample","tax_code":"sample"}],"id":"customer_id_90","invoicing_emails":["sample"],"invoicing_entity_id":"invoicing_entity_id_26","name":"sample","preferred_locales":["sample"]}',
        )
        call(client.customers.retrieve, "id_or_alias")
        self.assertEqual(requests, ["GET /api/v1/customers/id_or_alias"])

    def test_replace(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"currency":"MMK","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"custom_taxes":[{"name":"sample","rate":"sample","tax_code":"sample"}],"id":"customer_id_90","invoicing_emails":["sample"],"invoicing_entity_id":"invoicing_entity_id_26","name":"sample","preferred_locales":["sample"]}',
        )
        call(
            client.customers.replace,
            "id_or_alias",
            body=decode(
                CustomerUpdateRequest,
                '{"currency":"COP","custom_taxes":[{"name":"sample","rate":"sample","tax_code":"sample"}],"invoicing_emails":["sample"],"invoicing_entity_id":"invoicing_entity_id_1"}',
            ),
        )
        self.assertEqual(requests, ["PUT /api/v1/customers/id_or_alias"])

    def test_archive(self) -> None:
        client, requests = mock(204, None, "")
        call(client.customers.archive, "id_or_alias")
        self.assertEqual(requests, ["DELETE /api/v1/customers/id_or_alias"])

    def test_update(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"currency":"MMK","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"custom_taxes":[{"name":"sample","rate":"sample","tax_code":"sample"}],"id":"customer_id_90","invoicing_emails":["sample"],"invoicing_entity_id":"invoicing_entity_id_26","name":"sample","preferred_locales":["sample"]}',
        )
        call(
            client.customers.update,
            "id_or_alias",
            body=decode(CustomerPatchRequest, "{}"),
        )
        self.assertEqual(requests, ["PATCH /api/v1/customers/id_or_alias"])

    def test_list_entitlements(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"data":[{"feature":{"code":"sample","id":"feature_id_53","name":"sample"},"value":{"type":"BOOLEAN","enabled":false}}]}',
        )
        call(client.customers.list_entitlements, "id_or_alias")
        self.assertEqual(requests, ["GET /api/v1/customers/id_or_alias/entitlements"])

    def test_create_portal_token(self) -> None:
        client, requests = mock(
            200, "application/json", '{"portal_url":"sample","token":"sample"}'
        )
        call(
            client.customers.create_portal_token,
            "id_or_alias",
            body=decode(CustomerPortalTokenRequest, "{}"),
        )
        self.assertEqual(requests, ["POST /api/v1/customers/id_or_alias/portal-token"])

    def test_unarchive(self) -> None:
        client, requests = mock(204, None, "")
        call(client.customers.unarchive, "id_or_alias")
        self.assertEqual(requests, ["POST /api/v1/customers/id_or_alias/unarchive"])
