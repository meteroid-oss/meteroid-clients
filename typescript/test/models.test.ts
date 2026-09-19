import assert from "node:assert/strict";
import { describe, it } from "node:test";
import { type ConfigValue, ConfigValueSerializer } from "../src/models/configValue";
import { Currency, CurrencySerializer } from "../src/models/currency";
import { type Invoice, InvoiceSerializer } from "../src/models/invoice";
import {
  type InvoiceListResponse,
  InvoiceListResponseSerializer,
} from "../src/models/invoiceListResponse";
import { InvoicePaymentStatus } from "../src/models/invoicePaymentStatus";
import { InvoiceStatus } from "../src/models/invoiceStatus";
import { InvoiceType } from "../src/models/invoiceType";

const INVOICE_JSON = {
  amount_due: 1000,
  applied_credits: 0,
  billing_period_start: "2025-01-01",
  coupons: [],
  created_at: "2025-01-01T00:00:00.000Z",
  currency: "USD",
  custom_properties: { po: "PO-1" },
  customer_details: {
    id: "cust_123",
    name: "Test Customer",
    snapshot_at: "2025-01-01T00:00:00.000Z",
  },
  customer_id: "cust_123",
  id: "inv_123",
  invoice_date: "2025-01-02",
  invoice_number: "INV-0001",
  invoice_type: "RECURRING",
  line_items: [],
  net_terms: 30,
  payment_status: "UNPAID",
  status: "DRAFT",
  subtotal: 900,
  subtotal_recurring: 900,
  tax_amount: 100,
  tax_breakdown: [],
  total: 1000,
  transactions: [],
};

describe("enum serializers", () => {
  it("round-trips Currency", () => {
    assert.equal(CurrencySerializer._toJsonObject(Currency.Usd), "USD");
    assert.equal(CurrencySerializer._fromJsonObject("EUR"), Currency.Eur);
  });

  it("uses the wire spelling for statuses", () => {
    assert.equal(InvoiceStatus.Draft, "DRAFT");
    assert.equal(InvoiceStatus.Void, "VOID");
    assert.equal(InvoicePaymentStatus.PartiallyPaid, "PARTIALLY_PAID");
    assert.equal(InvoiceType.OneOff, "ONE_OFF");
  });
});

describe("Invoice (plain struct)", () => {
  it("deserializes from the wire shape", () => {
    const invoice = InvoiceSerializer._fromJsonObject(INVOICE_JSON);

    assert.equal(invoice.id, "inv_123");
    assert.equal(invoice.invoiceNumber, "INV-0001");
    assert.equal(invoice.amountDue, 1000);
    assert.equal(invoice.netTerms, 30);
    assert.equal(invoice.currency, Currency.Usd);
    assert.equal(invoice.status, InvoiceStatus.Draft);
    assert.equal(invoice.paymentStatus, InvoicePaymentStatus.Unpaid);
    assert.equal(invoice.invoiceType, InvoiceType.Recurring);
    assert.ok(invoice.createdAt instanceof Date);
    assert.equal(invoice.createdAt.toISOString(), "2025-01-01T00:00:00.000Z");
    assert.equal(invoice.customerDetails.name, "Test Customer");
    // Absent optionals stay absent rather than becoming `null`.
    assert.equal(invoice.memo, undefined);
    assert.equal(invoice.finalizedAt, undefined);
  });

  it("round-trips back to the same JSON", () => {
    const invoice = InvoiceSerializer._fromJsonObject(INVOICE_JSON);
    const wire = JSON.parse(JSON.stringify(InvoiceSerializer._toJsonObject(invoice)));

    assert.deepEqual(wire, INVOICE_JSON);
  });

  it("keeps snake_case keys on the wire", () => {
    const invoice: Invoice = InvoiceSerializer._fromJsonObject(INVOICE_JSON);
    const wire = InvoiceSerializer._toJsonObject(invoice);

    assert.ok("invoice_number" in wire);
    assert.ok("payment_status" in wire);
    assert.ok(!("invoiceNumber" in wire));
  });

  it("parses a paginated list response", () => {
    const response: InvoiceListResponse = InvoiceListResponseSerializer._fromJsonObject({
      data: [INVOICE_JSON],
      pagination_meta: { page: 1, per_page: 10, total_items: 42, total_pages: 5 },
    });

    assert.equal(response.data.length, 1);
    assert.equal(response.data[0].invoiceNumber, "INV-0001");
    assert.equal(response.paginationMeta.perPage, 10);
    assert.equal(response.paginationMeta.totalItems, 42);
  });
});

describe("ConfigValue (tagged union)", () => {
  it("deserializes each variant by its discriminant", () => {
    const number = ConfigValueSerializer._fromJsonObject({
      kind: "NUMBER",
      value: "12.50",
    });
    assert.equal(number.kind, "NUMBER");
    assert.equal(number.kind === "NUMBER" ? number.value : null, "12.50");

    const boolean = ConfigValueSerializer._fromJsonObject({
      kind: "BOOLEAN",
      value: true,
    });
    assert.equal(boolean.kind, "BOOLEAN");
    assert.equal(boolean.kind === "BOOLEAN" ? boolean.value : null, true);

    const text = ConfigValueSerializer._fromJsonObject({ kind: "TEXT", value: "hi" });
    assert.equal(text.kind, "TEXT");

    const json = ConfigValueSerializer._fromJsonObject({
      kind: "JSON",
      value: { a: 1 },
    });
    assert.equal(json.kind, "JSON");
  });

  it("round-trips each variant", () => {
    const cases: unknown[] = [
      { kind: "NUMBER", value: "12.50" },
      { kind: "BOOLEAN", value: false },
      { kind: "TEXT", value: "hello" },
      { kind: "JSON", value: { nested: [1, 2, 3] } },
    ];

    for (const wire of cases) {
      const parsed: ConfigValue = ConfigValueSerializer._fromJsonObject(wire);
      assert.deepEqual(ConfigValueSerializer._toJsonObject(parsed), wire);
    }
  });

  it("rejects an unknown discriminant", () => {
    assert.throws(
      () => ConfigValueSerializer._fromJsonObject({ kind: "NOPE" }),
      /Unexpected kind for ConfigValue: NOPE/
    );
  });
});
