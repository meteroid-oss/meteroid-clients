/**
 * Scribe — the TypeScript backend for the Meteroid SDK demo.
 *
 * Implements every operation of `examples/openapi.yaml` on top of `@meteroid/sdk`. Read
 * the handlers in `src/routes/`; each one is written so that the Meteroid SDK call is
 * the line worth reading, and everything around it is framing.
 *
 * Start here:
 *
 * - `routes/transcriptions.ts` — the metered action: check the entitlement, then report
 *   the consumption. This is what the demo exists to show.
 * - `entitlements.ts` — normalizing Meteroid's three-way entitlement union.
 * - `catalog.ts` — resolving a catalog the demo never creates.
 * - `routes/webhooks.ts` — verifying a Standard Webhooks signature over raw bytes.
 */

import { router } from "./app.js";
import { type Config, ConfigError, configFromEnv, meteroidConfigured } from "./config.js";
import { serve } from "./http.js";
import { log } from "./log.js";
import { AppState } from "./state.js";

// A configuration error is the operator's to fix and there is nothing useful to serve
// without it, so say what is wrong and stop.
let config: Config;
try {
  config = configFromEnv();
} catch (err) {
  if (!(err instanceof ConfigError)) throw err;
  log.error(err.message);
  process.exit(1);
}

if (!meteroidConfigured(config)) {
  log.warn(
    "METEROID_API_KEY is not set. The server will start and GET /api/health will report " +
      "meteroid_configured=false, but every Meteroid-backed operation will fail. " +
      "See examples/.env.example.",
  );
}

const state = new AppState(config);
const server = serve(router(state));

server.on("error", (err) => {
  log.error(`Cannot bind 0.0.0.0:${config.port}: ${err.message}`);
  process.exit(1);
});

server.listen(config.port, "0.0.0.0", () => {
  log.info(`Scribe (typescript) listening on http://localhost:${config.port}`);

  // Probe the catalog once the port is open rather than before binding: an unreachable
  // Meteroid would otherwise hold it closed for the length of the SDK's retry schedule,
  // and `GET /api/health` is exactly what you want answering during that.
  void probeCatalog(state);
});

for (const signal of ["SIGINT", "SIGTERM"] as const) {
  process.on(signal, () => {
    log.info("Shutting down.");
    server.close(() => process.exit(0));
    // Keep-alive connections would otherwise hold `close` open indefinitely.
    server.closeIdleConnections();
  });
}

/**
 * Resolve the seeded catalog once at boot.
 *
 * This is not a hard requirement to start — the process stays up so that
 * `GET /api/health` answers and so that seeding the tenant fixes things without a
 * restart — but it turns "my first transcription says I'm not entitled" into an
 * unmissable startup error naming the object that is missing.
 */
async function probeCatalog(state: AppState): Promise<void> {
  if (!meteroidConfigured(state.config)) {
    return;
  }
  try {
    const { plans } = await state.catalog();
    log.info(
      `Meteroid catalog resolved: ${plans.length} plans (${plans.map((plan) => plan.name).join(", ")}).`,
    );
  } catch (err) {
    log.error(
      `Meteroid catalog is not usable yet: ${err instanceof Error ? err.message : String(err)}\n` +
        "The demo never creates catalog objects — seed them once, by hand, as described in " +
        "examples/CATALOG.md. Requests that need the catalog will keep returning " +
        "503 CATALOG_NOT_SEEDED until it is there.",
    );
  }
}
