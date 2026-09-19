// The README's Express example, against a real Node HTTP server.
//
// Express types `req.headers` as Node's `IncomingHttpHeaders` (from
// `@types/node`), whose values are `string | string[] | undefined`. This file
// is compiled under `strict` by `npm test`, so it fails to build if
// `Webhook.verify` stops accepting them.

import assert from "node:assert/strict";
import { createServer, type IncomingHttpHeaders, type IncomingMessage } from "node:http";
import type { AddressInfo } from "node:net";
import { describe, it } from "node:test";
import { Webhook, WebhookVerificationError } from "../src/webhook";

const SECRET = "whsec_C2FVsBQIhrscChlQIMV+b5sSYspob7oD";

// The README handler, minus Express: `req.body` is what `express.raw()` puts
// there, a Buffer holding the raw body.
function handle(
  webhook: Webhook,
  req: { body: Buffer; headers: IncomingHttpHeaders }
): { status: number; event?: unknown } {
  try {
    const event = webhook.verify(req.body, req.headers);
    return { status: 200, event };
  } catch (err) {
    if (err instanceof WebhookVerificationError) {
      return { status: 400 };
    }
    throw err;
  }
}

function readBody(req: IncomingMessage): Promise<Buffer> {
  return new Promise((resolve, reject) => {
    const chunks: Buffer[] = [];
    req.on("data", (chunk: Buffer) => chunks.push(chunk));
    req.on("end", () => resolve(Buffer.concat(chunks)));
    req.on("error", reject);
  });
}

async function post(
  body: string,
  headers: Record<string, string>
): Promise<{ status: number; event?: unknown }> {
  const webhook = new Webhook(SECRET);
  let result: { status: number; event?: unknown } | undefined;
  const server = createServer(async (req, res) => {
    result = handle(webhook, { body: await readBody(req), headers: req.headers });
    res.statusCode = result.status;
    res.end();
  });
  await new Promise<void>((resolve) => server.listen(0, "127.0.0.1", resolve));
  try {
    const { port } = server.address() as AddressInfo;
    const res = await fetch(`http://127.0.0.1:${port}/webhooks/meteroid`, {
      method: "POST",
      headers,
      body,
    });
    await res.arrayBuffer();
    assert.ok(result !== undefined);
    assert.equal(res.status, result.status);
    return result;
  } finally {
    await new Promise<void>((resolve) => server.close(() => resolve()));
  }
}

describe("Webhook.verify with Node's IncomingHttpHeaders", () => {
  const body = '{"type":"customer.created","data":{"id":"cust_1"}}';

  function signedHeaders(payload: string): Record<string, string> {
    const now = new Date();
    return {
      "Content-Type": "application/json",
      "Webhook-Id": "msg_1",
      "Webhook-Signature": new Webhook(SECRET).sign("msg_1", now, payload),
      "Webhook-Timestamp": Math.floor(now.getTime() / 1000).toString(),
    };
  }

  it("verifies a correctly signed request", async () => {
    const result = await post(body, signedHeaders(body));
    assert.equal(result.status, 200);
    assert.deepEqual(result.event, { type: "customer.created", data: { id: "cust_1" } });
  });

  it("rejects a tampered body", async () => {
    const result = await post(`${body} `, signedHeaders(body));
    assert.equal(result.status, 400);
  });
});
