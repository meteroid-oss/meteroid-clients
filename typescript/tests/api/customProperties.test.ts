// this file is @generated
import assert from "node:assert/strict";
import { test } from "node:test";
import {
  parseJson,
  CustomPropertyDefinitionCreateRequestSerializer,
  CustomPropertyDefinitionUpdateRequestSerializer,
} from "../../src/index.js";
import { mock } from "./mock.js";

test("custom_properties.list_custom_property_definitions", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"data":[{"archived":false,"config":{},"display_order":-2147483648,"entity_type":"CUSTOMER","id":"custom_property_definition_id_78","key":"sample","name":"sample","property_type":"JSON","required":false}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
  });
  await client.customProperties.listCustomPropertyDefinitions();
  assert.deepEqual(requests, ["GET /api/v1/custom-property-definitions"]);
});

test("custom_properties.create_custom_property_definition", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"archived":false,"config":{},"display_order":-2147483648,"entity_type":"INVOICE","id":"custom_property_definition_id_13","key":"sample","name":"sample","property_type":"TEXT","required":false}',
  });
  await client.customProperties.createCustomPropertyDefinition(
    CustomPropertyDefinitionCreateRequestSerializer.parse(
      parseJson(
        '{"entity_type":"CREDIT_NOTE","key":"sample","name":"sample","property_type":"TEXT"}'
      )
    )
  );
  assert.deepEqual(requests, ["POST /api/v1/custom-property-definitions"]);
});

test("custom_properties.retrieve_custom_property_definition", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"archived":false,"config":{},"display_order":-2147483648,"entity_type":"INVOICE","id":"custom_property_definition_id_13","key":"sample","name":"sample","property_type":"TEXT","required":false}',
  });
  await client.customProperties.retrieveCustomPropertyDefinition("id");
  assert.deepEqual(requests, ["GET /api/v1/custom-property-definitions/id"]);
});

test("custom_properties.update_custom_property_definition", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"archived":false,"config":{},"display_order":-2147483648,"entity_type":"INVOICE","id":"custom_property_definition_id_13","key":"sample","name":"sample","property_type":"TEXT","required":false}',
  });
  await client.customProperties.updateCustomPropertyDefinition(
    "id",
    CustomPropertyDefinitionUpdateRequestSerializer.parse(parseJson("{}"))
  );
  assert.deepEqual(requests, ["PUT /api/v1/custom-property-definitions/id"]);
});

test("custom_properties.archive_definition", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"archived":false,"config":{},"display_order":-2147483648,"entity_type":"INVOICE","id":"custom_property_definition_id_13","key":"sample","name":"sample","property_type":"TEXT","required":false}',
  });
  await client.customProperties.archiveDefinition("id");
  assert.deepEqual(requests, ["DELETE /api/v1/custom-property-definitions/id"]);
});
