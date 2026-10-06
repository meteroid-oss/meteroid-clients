// this file is @generated
import assert from "node:assert/strict";
import { test } from "node:test";
import {
  parseJson,
  CreditNoteCustomPropertiesRequestSerializer,
} from "../../src/index.js";
import { mock } from "./mock.js";

test("credit_notes.list", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"data":[{"created_at":"2023-12-31T23:59:59.999-05:30","credit_note_number":"sample","credit_type":"DEBT_CANCELLATION","credited_amount_cents":9007199254740993,"currency":"TMT","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"customer_id":"customer_id_78","id":"credit_note_id_47","invoice_id":"invoice_id_67","invoice_number":"sample","line_items":[{"amount_total":-9007199254740993,"end_date":"2024-02-29","name":"sample","start_date":"2024-02-29","sub_line_items":[{"id":"sample","name":"sample","quantity":"-0.000123","total":9007199254740993,"unit_price":"-0.000123"}],"tax_rate":"-0.000123"}],"refunded_amount_cents":9007199254740993,"status":"DRAFT","subtotal":-9007199254740993,"tax_amount":9007199254740993,"tax_breakdown":[{"name":"sample","tax_amount":-9007199254740993,"tax_rate":"-0.000123","taxable_amount":-9007199254740993}],"total":-9007199254740993}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
  });
  await client.creditNotes.list();
  assert.deepEqual(requests, ["GET /api/v1/credit-notes"]);
});

test("credit_notes.retrieve", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"created_at":"2023-12-31T23:59:59.999-05:30","credit_note_number":"sample","credit_type":"REFUND","credited_amount_cents":9007199254740993,"currency":"MMK","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"customer_id":"customer_id_13","id":"credit_note_id_99","invoice_id":"invoice_id_90","invoice_number":"sample","line_items":[{"amount_total":-9007199254740993,"end_date":"2024-02-29","name":"sample","start_date":"1999-12-31","sub_line_items":[{"id":"sample","name":"sample","quantity":"12345.6789","total":-9007199254740993,"unit_price":"12345.6789"}],"tax_rate":"-0.000123"}],"refunded_amount_cents":-9007199254740993,"status":"DRAFT","subtotal":9007199254740993,"tax_amount":9007199254740993,"tax_breakdown":[{"name":"sample","tax_amount":9007199254740993,"tax_rate":"12345.6789","taxable_amount":9007199254740993}],"total":-9007199254740993}',
  });
  await client.creditNotes.retrieve("credit_note_id");
  assert.deepEqual(requests, ["GET /api/v1/credit-notes/credit_note_id"]);
});

test("credit_notes.update_custom_properties", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"created_at":"2023-12-31T23:59:59.999-05:30","credit_note_number":"sample","credit_type":"REFUND","credited_amount_cents":9007199254740993,"currency":"MMK","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"customer_id":"customer_id_13","id":"credit_note_id_99","invoice_id":"invoice_id_90","invoice_number":"sample","line_items":[{"amount_total":-9007199254740993,"end_date":"2024-02-29","name":"sample","start_date":"1999-12-31","sub_line_items":[{"id":"sample","name":"sample","quantity":"12345.6789","total":-9007199254740993,"unit_price":"12345.6789"}],"tax_rate":"-0.000123"}],"refunded_amount_cents":-9007199254740993,"status":"DRAFT","subtotal":9007199254740993,"tax_amount":9007199254740993,"tax_breakdown":[{"name":"sample","tax_amount":9007199254740993,"tax_rate":"12345.6789","taxable_amount":9007199254740993}],"total":-9007199254740993}',
  });
  await client.creditNotes.updateCustomProperties(
    "credit_note_id",
    CreditNoteCustomPropertiesRequestSerializer.parse(
      parseJson(
        '{"custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}}}'
      )
    )
  );
  assert.deepEqual(requests, [
    "PATCH /api/v1/credit-notes/credit_note_id/custom-properties",
  ]);
});

test("credit_notes.download", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/octet-stream",
    body: "sample",
  });
  await client.creditNotes.download("credit_note_id");
  assert.deepEqual(requests, ["GET /api/v1/credit-notes/credit_note_id/download"]);
});

test("credit_notes.download_xml", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/octet-stream",
    body: "sample",
  });
  await client.creditNotes.downloadXml("credit_note_id");
  assert.deepEqual(requests, ["GET /api/v1/credit-notes/credit_note_id/xml"]);
});
