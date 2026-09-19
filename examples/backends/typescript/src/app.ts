/**
 * The router: twelve operations, one table.
 *
 * {@link router} is a pure function from request to response — no socket, no global
 * state — so `main.ts` can put it on a port and the tests can call it directly.
 */

import { ApiError } from "./error.js";
import type { Handle, ScribeRequest, ScribeResponse } from "./http.js";
import { log } from "./log.js";
import { createCheckout } from "./routes/checkout.js";
import { listEntitlements } from "./routes/entitlements.js";
import { getHealth } from "./routes/health.js";
import { type Handler, notFound } from "./routes/index.js";
import { listInvoices } from "./routes/invoices.js";
import { listPlans } from "./routes/plans.js";
import { createPortalSession } from "./routes/portal.js";
import { createSession, getMe } from "./routes/session.js";
import { createTranscription, listTranscriptions } from "./routes/transcriptions.js";
import { getUsage } from "./routes/usage.js";
import { receiveWebhook } from "./routes/webhooks.js";
import type { AppState } from "./state.js";

const ROUTES: Record<string, { GET?: Handler; POST?: Handler }> = {
  "/api/health": { GET: getHealth },
  "/api/session": { POST: createSession },
  "/api/me": { GET: getMe },
  "/api/plans": { GET: listPlans },
  "/api/checkout": { POST: createCheckout },
  "/api/entitlements": { GET: listEntitlements },
  "/api/transcriptions": { GET: listTranscriptions, POST: createTranscription },
  "/api/usage": { GET: getUsage },
  "/api/portal-session": { POST: createPortalSession },
  "/api/invoices": { GET: listInvoices },
  "/api/webhooks/meteroid": { POST: receiveWebhook },
};

// The SPA is served from its own origin (the Vite dev server), so it needs CORS.
// Permissive is fine for a demo; a real backend would name its origins.
const VARY = { vary: "origin, access-control-request-method, access-control-request-headers" };
const CORS = { ...VARY, "access-control-allow-origin": "*", "access-control-expose-headers": "*" };
const PREFLIGHT = {
  ...VARY,
  "access-control-allow-origin": "*",
  "access-control-allow-methods": "*",
  "access-control-allow-headers": "*",
};

export function router(state: AppState): Handle {
  return async (request) => {
    const route = Object.hasOwn(ROUTES, request.path) ? ROUTES[request.path] : undefined;
    const allow = route && [route.GET && "GET,HEAD", route.POST && "POST"].filter(Boolean).join(",");

    // Every OPTIONS is answered as a preflight, whether or not the path exists: the
    // browser only wants to know it may send the real request.
    if (request.method === "OPTIONS") {
      return { status: 200, headers: { ...PREFLIGHT, ...(allow && { allow }) }, body: "" };
    }

    // HEAD is GET without the body; `http.ts` drops the body on the way out.
    const method = request.method === "HEAD" ? "GET" : request.method;
    const handler = route && (method === "GET" || method === "POST") ? route[method] : undefined;

    // A known path with the wrong method. There is no error code for it in the
    // contract, so it is the bare `405` + `Allow` that HTTP itself specifies.
    if (route && allow && handler === undefined) {
      return { status: 405, headers: { ...CORS, allow }, body: "" };
    }

    const { status, body } = await run(state, request, handler);
    return {
      status,
      headers: { ...CORS, "content-type": "application/json" },
      body: JSON.stringify(body),
    };
  };
}

/** Run one handler; whatever goes wrong comes back as the contract's error envelope. */
async function run(
  state: AppState,
  request: ScribeRequest,
  handler: Handler | undefined,
): Promise<Pick<ScribeResponse, "status"> & { body: unknown }> {
  try {
    if (handler === undefined) {
      throw notFound();
    }
    return await handler(state, request);
  } catch (err) {
    if (err instanceof ApiError) {
      if (err.code === "INTERNAL") {
        log.error(`internal error: ${err.message}`);
      }
      return { status: err.status, body: err };
    }
    // A bug in this backend. The detail goes to the log, never to the client.
    log.error(`unhandled error in ${request.method} ${request.path}: ${String(err)}`);
    const internal = ApiError.internal("Unexpected error handling the request.");
    return { status: internal.status, body: internal };
  }
}
