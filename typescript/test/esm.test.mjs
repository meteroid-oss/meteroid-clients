// The package is CommonJS only. ESM consumers load it through Node's CJS
// interop, which must expose real named exports (not just a `default`).
//
// Run against the built package (`dist/`) by `npm test`, resolved through the
// package's own name so that the `exports` map in package.json is what gets
// tested.

import assert from "node:assert/strict";
import { createRequire } from "node:module";
import { describe, it } from "node:test";
import * as sdk from "@meteroid/sdk";
import {
  ApiException,
  Currency,
  Meteroid,
  Webhook,
  WebhookVerificationError,
} from "@meteroid/sdk";

describe("ESM import of the CommonJS build", () => {
  it("exposes named exports", () => {
    assert.equal(typeof Meteroid, "function");
    assert.equal(typeof ApiException, "function");
    assert.equal(typeof Webhook, "function");
    assert.equal(typeof WebhookVerificationError, "function");
    assert.equal(Currency.Eur, "EUR");
    assert.equal(sdk.Meteroid, Meteroid);
  });

  it("shares a single copy of the package with require()", () => {
    // Two copies (a dual ESM/CJS build) would break `instanceof` across them.
    const cjs = createRequire(import.meta.url)("@meteroid/sdk");
    assert.equal(cjs.ApiException, ApiException);
    assert.equal(cjs.WebhookVerificationError, WebhookVerificationError);
  });

  it("keeps instanceof working for the exported errors", () => {
    const webhook = new Webhook("whsec_C2FVsBQIhrscChlQIMV+b5sSYspob7oD");
    assert.throws(() => webhook.verify("{}", {}), WebhookVerificationError);

    const err = new ApiException(404, "", new Headers());
    assert.ok(err instanceof ApiException);
    assert.ok(err instanceof Error);
  });

  it("constructs a client", () => {
    const client = new Meteroid("token");
    assert.equal(typeof client.customers.listCustomers, "function");
  });
});
