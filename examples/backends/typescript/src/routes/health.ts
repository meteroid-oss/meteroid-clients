/** `GET /api/health` — unauthenticated liveness and configuration probe. */

import { readFileSync } from "node:fs";

import { meteroidConfigured } from "../config.js";
import type { Health } from "../dto.js";
import { ok, type Reply } from "../http.js";
import type { AppState } from "../state.js";

const { version } = JSON.parse(
  readFileSync(new URL("../../package.json", import.meta.url), "utf8"),
) as { version?: string };

export async function getHealth(state: AppState): Promise<Reply<Health>> {
  return ok({
    status: "ok",
    backend: "typescript",
    // False means METEROID_API_KEY (or the base URL) is missing, and every
    // Meteroid-backed operation below will fail with UPSTREAM_UNAUTHORIZED.
    // Reporting it here is what turns a wall of 502s into one clear message.
    meteroid_configured: meteroidConfigured(state.config),
    version: version ?? null,
  });
}
