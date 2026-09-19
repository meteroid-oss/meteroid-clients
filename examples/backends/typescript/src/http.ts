/**
 * The whole HTTP layer: plain `node:http`, no framework.
 *
 * A web framework would be the largest thing in this backend, and the point of the
 * demo is the Meteroid call inside each handler. What a handler needs is small — the
 * method and path, the headers, and the **raw** body bytes (webhook signatures are
 * computed over bytes, so nothing may parse the body first) — and it fits in the two
 * types below. `app.ts` turns a {@link ScribeRequest} into a {@link ScribeResponse}
 * with no socket involved, which is also what lets the tests drive the router
 * in-process.
 */

import { createServer, type IncomingMessage, type Server } from "node:http";

import { ApiError } from "./error.js";

/** What `axum` buffers by default, so an oversized body is refused at the same size. */
export const MAX_BODY_BYTES = 2 * 1024 * 1024;

export interface ScribeRequest {
  method: string;
  path: string;
  query: URLSearchParams;
  /** Lower-cased names; repeated headers joined with `", "`, as `node:http` does. */
  headers: Record<string, string>;
  /** The request body exactly as it arrived, or `null` if it exceeded {@link MAX_BODY_BYTES}. */
  body: Buffer | null;
}

export interface ScribeResponse {
  status: number;
  headers: Record<string, string>;
  /** Already-serialized JSON, or `""` for the few bodiless answers. */
  body: string;
}

/** What a handler returns: a status and the contract object to serialize. */
export interface Reply<T> {
  status: number;
  body: T;
}

export const ok = <T>(body: T): Reply<T> => ({ status: 200, body });
export const created = <T>(body: T): Reply<T> => ({ status: 201, body });
export const accepted = <T>(body: T): Reply<T> => ({ status: 202, body });

/**
 * The raw request body, for the handlers that read one. Refusing an oversized body
 * here rather than on arrival keeps the order of checks the same as the other
 * backends: a request with no session token is a 401 whatever its body looks like.
 */
export function rawBody(request: ScribeRequest): Buffer {
  if (request.body === null) {
    throw ApiError.badRequest(
      `The request body exceeds the ${MAX_BODY_BYTES}-byte limit.`,
    ).withStatus(413);
  }
  return request.body;
}

export type Handle = (request: ScribeRequest) => Promise<ScribeResponse>;

/** Put a {@link Handle} on a socket. */
export function serve(handle: Handle): Server {
  return createServer((incoming, outgoing) => {
    void readRequest(incoming)
      .then(handle)
      .then((response) => {
        outgoing.writeHead(response.status, response.headers);
        outgoing.end(incoming.method === "HEAD" ? undefined : response.body);
      })
      // `handle` never rejects; this only fires when the client went away mid-request.
      .catch(() => outgoing.destroy());
  });
}

async function readRequest(incoming: IncomingMessage): Promise<ScribeRequest> {
  const url = parseTarget(incoming.url ?? "/");

  const headers: Record<string, string> = {};
  for (const [name, value] of Object.entries(incoming.headers)) {
    if (value !== undefined) {
      headers[name] = Array.isArray(value) ? value.join(", ") : value;
    }
  }

  // An oversized body is still read to the end, just not kept: answering before the
  // client has finished sending makes most clients report a broken pipe, not the 413.
  const chunks: Buffer[] = [];
  let size = 0;
  for await (const chunk of incoming as AsyncIterable<Buffer>) {
    size += chunk.length;
    if (size <= MAX_BODY_BYTES) {
      chunks.push(chunk);
    }
  }

  return {
    method: incoming.method ?? "GET",
    path: url.path,
    query: url.query,
    headers,
    body: size <= MAX_BODY_BYTES ? Buffer.concat(chunks) : null,
  };
}

/** A request target `URL` cannot parse is simply a path nothing is routed on: a 404. */
function parseTarget(target: string): { path: string; query: URLSearchParams } {
  try {
    // The host is irrelevant: only the path and the query are ever looked at.
    const url = new URL(target, "http://localhost");
    return { path: url.pathname, query: url.searchParams };
  } catch {
    return { path: target, query: new URLSearchParams() };
  }
}
