// this file is @generated
import assert from "node:assert/strict";
import { test } from "node:test";
import { parseJson, InvoiceCustomPropertiesRequestSerializer } from "../../src/index.js";
import { mock } from "./mock.js";

test("invoices.list", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"data":[{"amount_due":-9007199254740993,"applied_credits":-9007199254740993,"coupons":[{"coupon_id":"sample","name":"sample","total":-9007199254740993}],"created_at":"2024-03-15T10:30:45.123+02:00","currency":"CNY","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"customer_details":{"id":"customer_id_39","name":"sample","snapshot_at":"2023-12-31T23:59:59.999-05:30"},"customer_id":"customer_id_67","id":"invoice_id_67","invoice_date":"1999-12-31","invoice_number":"sample","invoice_type":"RECURRING","line_items":[{"amount_total":9007199254740993,"end_date":"2024-02-29","name":"sample","start_date":"2024-02-29","sub_line_items":[{"id":"sample","name":"sample","quantity":"-0.000123","total":-9007199254740993,"unit_price":"-0.000123"}],"tax_rate":"12345.6789"}],"net_terms":-2147483648,"payment_status":"PARTIALLY_PAID","status":"FINALIZED","subtotal":-9007199254740993,"subtotal_recurring":9007199254740993,"tax_amount":9007199254740993,"tax_breakdown":[{"name":"sample","tax_amount":-9007199254740993,"tax_rate":"12345.6789","taxable_amount":9007199254740993}],"total":-9007199254740993,"transactions":[{"amount":-9007199254740993,"currency":"sample","id":"payment_transaction_id_40","payment_type":"PAYMENT","status":"CANCELLED"}]}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
  });
  await client.invoices.list();
  assert.deepEqual(requests, ["GET /api/v1/invoices"]);
});

test("invoices.retrieve", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"amount_due":-9007199254740993,"applied_credits":9007199254740993,"coupons":[{"coupon_id":"sample","name":"sample","total":-9007199254740993}],"created_at":"2024-03-15T10:30:45.123+02:00","currency":"NAD","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"customer_details":{"id":"customer_id_62","name":"sample","snapshot_at":"2024-03-15T10:30:45.123+02:00"},"customer_id":"customer_id_90","id":"invoice_id_31","invoice_date":"1999-12-31","invoice_number":"sample","invoice_type":"ONE_OFF","line_items":[{"amount_total":9007199254740993,"end_date":"1999-12-31","name":"sample","start_date":"1999-12-31","sub_line_items":[{"id":"sample","name":"sample","quantity":"-0.000123","total":-9007199254740993,"unit_price":"-0.000123"}],"tax_rate":"-0.000123"}],"net_terms":-2147483648,"payment_status":"UNPAID","status":"DRAFT","subtotal":9007199254740993,"subtotal_recurring":9007199254740993,"tax_amount":-9007199254740993,"tax_breakdown":[{"name":"sample","tax_amount":9007199254740993,"tax_rate":"-0.000123","taxable_amount":9007199254740993}],"total":9007199254740993,"transactions":[{"amount":9007199254740993,"currency":"sample","id":"payment_transaction_id_56","payment_type":"REFUND","status":"CANCELLED"}]}',
  });
  await client.invoices.retrieve("invoice_id");
  assert.deepEqual(requests, ["GET /api/v1/invoices/invoice_id"]);
});

test("invoices.update_custom_properties", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"amount_due":-9007199254740993,"applied_credits":9007199254740993,"coupons":[{"coupon_id":"sample","name":"sample","total":-9007199254740993}],"created_at":"2024-03-15T10:30:45.123+02:00","currency":"NAD","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"customer_details":{"id":"customer_id_62","name":"sample","snapshot_at":"2024-03-15T10:30:45.123+02:00"},"customer_id":"customer_id_90","id":"invoice_id_31","invoice_date":"1999-12-31","invoice_number":"sample","invoice_type":"ONE_OFF","line_items":[{"amount_total":9007199254740993,"end_date":"1999-12-31","name":"sample","start_date":"1999-12-31","sub_line_items":[{"id":"sample","name":"sample","quantity":"-0.000123","total":-9007199254740993,"unit_price":"-0.000123"}],"tax_rate":"-0.000123"}],"net_terms":-2147483648,"payment_status":"UNPAID","status":"DRAFT","subtotal":9007199254740993,"subtotal_recurring":9007199254740993,"tax_amount":-9007199254740993,"tax_breakdown":[{"name":"sample","tax_amount":9007199254740993,"tax_rate":"-0.000123","taxable_amount":9007199254740993}],"total":9007199254740993,"transactions":[{"amount":9007199254740993,"currency":"sample","id":"payment_transaction_id_56","payment_type":"REFUND","status":"CANCELLED"}]}',
  });
  await client.invoices.updateCustomProperties(
    "invoice_id",
    InvoiceCustomPropertiesRequestSerializer.parse(
      parseJson(
        '{"custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}}}'
      )
    )
  );
  assert.deepEqual(requests, ["PATCH /api/v1/invoices/invoice_id/custom-properties"]);
});

test("invoices.download", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/octet-stream",
    body: "sample",
  });
  await client.invoices.download("invoice_id");
  assert.deepEqual(requests, ["GET /api/v1/invoices/invoice_id/download"]);
});

test("invoices.refresh", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/json",
    body: '{"amount_due":-9007199254740993,"applied_credits":9007199254740993,"coupons":[{"coupon_id":"sample","name":"sample","total":-9007199254740993}],"created_at":"2024-03-15T10:30:45.123+02:00","currency":"NAD","custom_properties":{"key":"value","count":3,"ratio":0.5,"flags":[true,false],"nested":{"ok":true}},"customer_details":{"id":"customer_id_62","name":"sample","snapshot_at":"2024-03-15T10:30:45.123+02:00"},"customer_id":"customer_id_90","id":"invoice_id_31","invoice_date":"1999-12-31","invoice_number":"sample","invoice_type":"ONE_OFF","line_items":[{"amount_total":9007199254740993,"end_date":"1999-12-31","name":"sample","start_date":"1999-12-31","sub_line_items":[{"id":"sample","name":"sample","quantity":"-0.000123","total":-9007199254740993,"unit_price":"-0.000123"}],"tax_rate":"-0.000123"}],"net_terms":-2147483648,"payment_status":"UNPAID","status":"DRAFT","subtotal":9007199254740993,"subtotal_recurring":9007199254740993,"tax_amount":-9007199254740993,"tax_breakdown":[{"name":"sample","tax_amount":9007199254740993,"tax_rate":"-0.000123","taxable_amount":9007199254740993}],"total":9007199254740993,"transactions":[{"amount":9007199254740993,"currency":"sample","id":"payment_transaction_id_56","payment_type":"REFUND","status":"CANCELLED"}]}',
  });
  await client.invoices.refresh("invoice_id");
  assert.deepEqual(requests, ["POST /api/v1/invoices/invoice_id/refresh"]);
});

test("invoices.download_xml", async () => {
  const { client, requests } = mock({
    status: 200,
    contentType: "application/octet-stream",
    body: "sample",
  });
  await client.invoices.downloadXml("invoice_id");
  assert.deepEqual(requests, ["GET /api/v1/invoices/invoice_id/xml"]);
});
