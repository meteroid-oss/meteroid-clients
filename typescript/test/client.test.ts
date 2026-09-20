import assert from "node:assert/strict";
import { describe, it } from "node:test";
import { API_VERSION } from "../src/apiVersion";
import {
  ApiException,
  ErrorCode,
  Meteroid,
  type MeteroidOptions,
  OAuthErrorCode,
} from "../src/index";
import { InvoiceStatus } from "../src/models/invoiceStatus";

const BASE_URL = "https://mock.meteroid.test";

const PAGINATION = { page: 0, per_page: 10, total_items: 0, total_pages: 0 };

type Call = { url: URL; init: RequestInit & { headers: Record<string, string> } };

/**
 * Build a client whose `fetch` is a recorder returning the canned responses, one
 * per call (the last one is reused once the list runs out).
 */
function mockClient(
  responses: Array<{ status: number; body?: unknown }>,
  options: Partial<MeteroidOptions> = {}
): { client: Meteroid; calls: Call[] } {
  const calls: Call[] = [];
  let index = 0;

  const fetchImpl: typeof fetch = async (input, init) => {
    calls.push({
      url: new URL(String(input)),
      init: (init ?? {}) as Call["init"],
    });
    const canned = responses[Math.min(index, responses.length - 1)];
    index += 1;
    return new Response(canned.body === undefined ? "" : JSON.stringify(canned.body), {
      status: canned.status,
      headers: { "content-type": "application/json" },
    });
  };

  const client = new Meteroid("test-api-key", {
    serverUrl: BASE_URL,
    fetch: fetchImpl,
    ...options,
  } as MeteroidOptions);

  return { client, calls };
}

describe("request wiring", () => {
  it("sends the bearer token and the standard headers", async () => {
    const { client, calls } = mockClient([
      { status: 200, body: { data: [], pagination_meta: PAGINATION } },
    ]);

    await client.invoices.listInvoices();

    assert.equal(calls.length, 1);
    assert.equal(calls[0].url.pathname, "/api/v1/invoices");
    assert.equal(calls[0].init.headers.authorization, "Bearer test-api-key");
    assert.match(calls[0].init.headers["user-agent"], /^meteroid-typescript\//);
    assert.strictEqual(calls[0].init.headers["meteroid-version"], API_VERSION);
  });

  it("explodes array query parameters into repeated keys", async () => {
    const { client, calls } = mockClient([
      { status: 200, body: { data: [], pagination_meta: PAGINATION } },
    ]);

    await client.invoices.listInvoices({
      statuses: [InvoiceStatus.Draft, InvoiceStatus.Finalized],
      page: 2,
    });

    const { searchParams } = calls[0].url;
    assert.deepEqual(searchParams.getAll("statuses"), ["DRAFT", "FINALIZED"]);
    assert.equal(searchParams.get("page"), "2");
    assert.equal(calls[0].url.search, "?statuses=DRAFT&statuses=FINALIZED&page=2");
  });

  it("attaches an auto idempotency key to POSTs only", async () => {
    const { client, calls } = mockClient([
      { status: 200, body: { data: [], pagination_meta: PAGINATION } },
    ]);

    await client.invoices.listInvoices();

    assert.equal(calls[0].init.headers["idempotency-key"], undefined);
  });

  it("logs one line per request and response when debug is on", async () => {
    const { client } = mockClient(
      [{ status: 200, body: { data: [], pagination_meta: PAGINATION } }],
      { debug: true }
    );

    const lines: string[] = [];
    const original = console.error;
    console.error = (...args: unknown[]) => {
      lines.push(args.map(String).join(" "));
    };
    try {
      await client.invoices.listInvoices();
    } finally {
      console.error = original;
    }

    assert.equal(lines.length, 2);
    assert.match(lines[0], /^meteroid: GET .*\/api\/v1\/invoices \(attempt 1\)$/);
    assert.match(lines[1], /^meteroid: GET .*\/api\/v1\/invoices -> 200$/);
  });

  it("logs nothing when debug is off", async () => {
    const { client } = mockClient([
      { status: 200, body: { data: [], pagination_meta: PAGINATION } },
    ]);

    const lines: string[] = [];
    const original = console.error;
    console.error = (...args: unknown[]) => {
      lines.push(args.map(String).join(" "));
    };
    try {
      await client.invoices.listInvoices();
    } finally {
      console.error = original;
    }

    assert.equal(lines.length, 0);
  });

  it("parses a RestErrorResponse body", async () => {
    const { client } = mockClient([
      { status: 404, body: { code: "NOT_FOUND", message: "no such customer" } },
    ]);

    const err = await client.customers
      .getCustomer("nope")
      .then(() => null)
      .catch((e: unknown) => e);

    assert.ok(err instanceof ApiException);
    assert.equal(err.status, 404);
    assert.deepEqual(err.restError, {
      code: ErrorCode.NotFound,
      message: "no such customer",
    });
    assert.equal(err.oauthError, undefined);
    assert.equal(err.body, '{"code":"NOT_FOUND","message":"no such customer"}');
    assert.equal(err.message, "API Error 404: NOT_FOUND: no such customer");
  });

  it("parses an OAuthErrorResponse body", async () => {
    const { client } = mockClient([{ status: 400, body: { error: "invalid_grant" } }]);

    const err = await client.invoices
      .listInvoices()
      .then(() => null)
      .catch((e: unknown) => e);

    assert.ok(err instanceof ApiException);
    assert.equal(err.status, 400);
    assert.equal(err.restError, undefined);
    assert.equal(err.oauthError?.error, OAuthErrorCode.InvalidGrant);
    assert.equal(err.oauthError?.errorDescription, undefined);
    assert.equal(err.body, '{"error":"invalid_grant"}');
  });

  it("handles a 422 like any other status", async () => {
    const { client } = mockClient([
      { status: 422, body: { code: "BAD_REQUEST", message: "invalid page" } },
    ]);

    const err = await client.invoices
      .listInvoices()
      .then(() => null)
      .catch((e: unknown) => e);

    assert.ok(err instanceof ApiException);
    assert.equal(err.status, 422);
    assert.equal(err.restError?.code, ErrorCode.BadRequest);
    assert.equal(err.restError?.message, "invalid page");
  });

  it("leaves the payload untyped for an unknown error code", async () => {
    const { client } = mockClient([
      { status: 409, body: { code: "SOMETHING_NEW", message: "later API version" } },
    ]);

    const err = await client.invoices
      .listInvoices()
      .then(() => null)
      .catch((e: unknown) => e);

    assert.ok(err instanceof ApiException);
    assert.equal(err.status, 409);
    assert.equal(err.restError, undefined);
    assert.equal(err.oauthError, undefined);
    assert.equal(err.body, '{"code":"SOMETHING_NEW","message":"later API version"}');
  });

  it("keeps the status and raw body when an error body is not JSON", async () => {
    const fetchImpl: typeof fetch = async () =>
      new Response("<html>gateway error</html>", {
        status: 400,
        headers: { "x-request-id": "abc" },
      });
    const client = new Meteroid("test-api-key", {
      serverUrl: BASE_URL,
      fetch: fetchImpl,
    });

    const err = await client.invoices
      .listInvoices()
      .then(() => null)
      .catch((e: unknown) => e);

    assert.ok(err instanceof ApiException);
    assert.equal(err.status, 400);
    assert.equal(err.body, "<html>gateway error</html>");
    assert.equal(err.headers["x-request-id"], "abc");
    assert.equal(err.restError, undefined);
    assert.equal(err.oauthError, undefined);
    assert.equal(err.message, "API Error 400");
  });
});

describe("retries", () => {
  it("retries 5xx responses twice by default", async () => {
    const { client, calls } = mockClient([{ status: 500, body: {} }], {
      retryScheduleInMs: [1, 1],
    });

    await client.invoices.listInvoices().catch(() => null);

    assert.equal(calls.length, 3);
  });

  it("does not retry with numRetries: 0", async () => {
    const { client, calls } = mockClient([{ status: 500, body: {} }], {
      numRetries: 0,
    });

    const err = await client.invoices
      .listInvoices()
      .then(() => null)
      .catch((e: unknown) => e);

    assert.equal(calls.length, 1, "numRetries: 0 must produce exactly one attempt");
    assert.ok(err instanceof ApiException);
    assert.equal(err.status, 500);
  });

  it("does not retry with an empty retry schedule", async () => {
    const { client, calls } = mockClient([{ status: 500, body: {} }], {
      retryScheduleInMs: [],
    });

    await client.invoices.listInvoices().catch(() => null);

    assert.equal(calls.length, 1);
  });

  it("honours numRetries: 1", async () => {
    const { client, calls } = mockClient([{ status: 500, body: {} }], {
      numRetries: 1,
    });

    await client.invoices.listInvoices().catch(() => null);

    assert.equal(calls.length, 2);
    assert.equal(calls[1].init.headers["meteroid-retry-count"], "1");
  });

  it("does not retry 4xx responses", async () => {
    const { client, calls } = mockClient([
      { status: 400, body: { code: "x", detail: "y" } },
    ]);

    await client.invoices.listInvoices().catch(() => null);

    assert.equal(calls.length, 1);
  });
});
