# this file is @generated
# ruff: noqa: I001  (where the package sorts depends on whether it is generated yet)
import unittest

from meteroid.models import (
    CustomPropertyDefinitionCreateRequest,
    CustomPropertyDefinitionUpdateRequest,
)

from perseid_mock import call, decode, mock


class CustomPropertiesTest(unittest.TestCase):
    def test_list_custom_property_definitions(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"data":[{"archived":false,"config":{},"display_order":-2147483648,"entity_type":"CUSTOMER","id":"custom_property_definition_id_78","key":"sample","name":"sample","property_type":"JSON","required":false}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
        )
        call(client.custom_properties.list_custom_property_definitions)
        self.assertEqual(requests, ["GET /api/v1/custom-property-definitions"])

    def test_create_custom_property_definition(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"archived":false,"config":{},"display_order":-2147483648,"entity_type":"INVOICE","id":"custom_property_definition_id_13","key":"sample","name":"sample","property_type":"TEXT","required":false}',
        )
        call(
            client.custom_properties.create_custom_property_definition,
            body=decode(
                CustomPropertyDefinitionCreateRequest,
                '{"entity_type":"CREDIT_NOTE","key":"sample","name":"sample","property_type":"TEXT"}',
            ),
        )
        self.assertEqual(requests, ["POST /api/v1/custom-property-definitions"])

    def test_retrieve_custom_property_definition(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"archived":false,"config":{},"display_order":-2147483648,"entity_type":"INVOICE","id":"custom_property_definition_id_13","key":"sample","name":"sample","property_type":"TEXT","required":false}',
        )
        call(client.custom_properties.retrieve_custom_property_definition, "id")
        self.assertEqual(requests, ["GET /api/v1/custom-property-definitions/id"])

    def test_update_custom_property_definition(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"archived":false,"config":{},"display_order":-2147483648,"entity_type":"INVOICE","id":"custom_property_definition_id_13","key":"sample","name":"sample","property_type":"TEXT","required":false}',
        )
        call(
            client.custom_properties.update_custom_property_definition,
            "id",
            body=decode(CustomPropertyDefinitionUpdateRequest, "{}"),
        )
        self.assertEqual(requests, ["PUT /api/v1/custom-property-definitions/id"])

    def test_archive_definition(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"archived":false,"config":{},"display_order":-2147483648,"entity_type":"INVOICE","id":"custom_property_definition_id_13","key":"sample","name":"sample","property_type":"TEXT","required":false}',
        )
        call(client.custom_properties.archive_definition, "id")
        self.assertEqual(requests, ["DELETE /api/v1/custom-property-definitions/id"])
