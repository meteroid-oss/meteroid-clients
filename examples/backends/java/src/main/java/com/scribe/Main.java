package com.scribe;

import com.scribe.routes.CheckoutRoutes;
import com.scribe.routes.EntitlementRoutes;
import com.scribe.routes.HealthRoutes;
import com.scribe.routes.InvoiceRoutes;
import com.scribe.routes.PlanRoutes;
import com.scribe.routes.PortalRoutes;
import com.scribe.routes.SessionRoutes;
import com.scribe.routes.TranscriptionRoutes;
import com.scribe.routes.UsageRoutes;
import com.scribe.routes.WebhookRoutes;

import io.javalin.Javalin;
import io.javalin.json.JavalinJackson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;

/**
 * Scribe — the Java reference backend for the Meteroid SDK demo.
 *
 * <p>Implements every operation of {@code examples/openapi.yaml} on top of {@code meteroid-java}.
 * Read the handlers in {@code src/main/java/com/scribe/routes/}; each one is written so that the
 * Meteroid SDK call is the line worth reading, and everything around it is framing.
 *
 * <p>Start here:
 *
 * <ul>
 *   <li>{@code routes/TranscriptionRoutes} — the metered action: check the entitlement, then report
 *       the consumption. This is what the demo exists to show.
 *   <li>{@link Entitlements} — normalizing Meteroid's three-way entitlement union.
 *   <li>{@link Catalog} — resolving a catalog the demo never creates.
 *   <li>{@code routes/WebhookRoutes} — verifying a Standard Webhooks signature over the raw body.
 * </ul>
 *
 * <p>The file layout deliberately mirrors {@code examples/backends/rust/src/}, so the two
 * implementations can be read side by side.
 */
public final class Main {

    /** Backend build version reported by {@code GET /api/health}. Matches {@code build.gradle}. */
    public static final String VERSION = "1.0.0";

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    private static final long MAX_BODY_BYTES = 2L * 1024 * 1024;

    private Main() {}

    public static void main(String[] args) {
        // A configuration error is the operator's to fix and there is nothing useful to serve
        // without it, so say what is wrong and stop.
        Config config;
        try {
            config = Config.fromEnv();
        } catch (Config.ConfigException e) {
            LOG.error("{}", e.getMessage());
            System.exit(1);
            return;
        }

        if (!config.meteroidConfigured()) {
            LOG.warn(
                    "METEROID_API_KEY is not set. The server will start and GET /api/health will"
                        + " report meteroid_configured=false, but every Meteroid-backed operation"
                        + " will fail. See examples/.env.example.");
        }

        AppState state = new AppState(config);
        Javalin app = router(state);

        // Probe the catalog on a background thread rather than before binding: an unreachable
        // Meteroid would otherwise hold the port closed for the length of the SDK's retry schedule,
        // and `GET /api/health` is exactly what you want answering during that.
        Thread probe = new Thread(() -> probeCatalog(state), "catalog-probe");
        probe.setDaemon(true);
        probe.start();

        app.start(config.port);
        LOG.info("Scribe (java) listening on http://localhost:{}", config.port);
        Runtime.getRuntime().addShutdownHook(new Thread(app::stop, "shutdown"));
    }

    /** Wire every operation of the contract. Package-visible so the tests can drive it in-process. */
    public static Javalin router(AppState state) {
        Javalin app =
                Javalin.create(
                        cfg -> {
                            cfg.showJavalinBanner = false;
                            // The contract's own ObjectMapper: snake_case, nulls included, unknown
                            // request fields rejected.
                            cfg.jsonMapper(new JavalinJackson(Json.mapper(), false));
                            // The SPA is served from its own origin (the Vite dev server), so it
                            // needs CORS. Permissive is fine for a demo; a real backend would name
                            // its origins.
                            cfg.bundledPlugins.enableCors(cors -> cors.addRule(it -> it.anyHost()));
                            // Same 2 MiB ceiling as the other backends; Javalin's default is 1 MB.
                            cfg.http.maxRequestSize = MAX_BODY_BYTES;
                        });

        app.get("/api/health", ctx -> HealthRoutes.getHealth(ctx, state));
        app.post("/api/session", ctx -> SessionRoutes.createSession(ctx, state));
        app.get("/api/me", ctx -> SessionRoutes.getMe(ctx, state));
        app.get("/api/plans", ctx -> PlanRoutes.listPlans(ctx, state));
        app.post("/api/checkout", ctx -> CheckoutRoutes.createCheckout(ctx, state));
        app.get("/api/entitlements", ctx -> EntitlementRoutes.listEntitlements(ctx, state));
        app.get("/api/transcriptions", ctx -> TranscriptionRoutes.listTranscriptions(ctx, state));
        app.post("/api/transcriptions", ctx -> TranscriptionRoutes.createTranscription(ctx, state));
        app.get("/api/usage", ctx -> UsageRoutes.getUsage(ctx, state));
        app.post("/api/portal-session", ctx -> PortalRoutes.createPortalSession(ctx, state));
        app.get("/api/invoices", ctx -> InvoiceRoutes.listInvoices(ctx, state));
        app.post("/api/webhooks/meteroid", ctx -> WebhookRoutes.receiveWebhook(ctx, state));

        // Every non-2xx response in this backend is the contract's one error envelope — including
        // the ones the framework would otherwise render as HTML.
        app.exception(
                ApiError.class,
                (error, ctx) -> {
                    if (error.code() == ErrorCode.INTERNAL) {
                        LOG.error("internal error: {}", error.getMessage());
                    }
                    ctx.status(error.status()).json(error.envelope());
                });
        app.exception(
                Exception.class,
                (error, ctx) -> {
                    LOG.error("unhandled error", error);
                    ApiError internal = ApiError.internal("Unexpected error handling the request.");
                    ctx.status(internal.status()).json(internal.envelope());
                });
        // A 404 still arrives in the contract's error envelope. No operation in the contract takes
        // a path parameter, so this only ever fires on a typo.
        app.error(
                404,
                ctx -> {
                    ApiError notFound =
                            new ApiError(
                                    ErrorCode.NOT_FOUND,
                                    "No such endpoint. See examples/openapi.yaml for the operations"
                                            + " this demo serves.");
                    ctx.json(notFound.envelope());
                });

        // Javalin rejects an oversized body itself, in plain text. The contract says every
        // error is the envelope; BAD_REQUEST is the closest code it has, and the 413 stays.
        app.error(
                413,
                ctx -> {
                    ApiError tooLarge =
                            ApiError.badRequest(
                                    "The request body exceeds the "
                                            + MAX_BODY_BYTES
                                            + "-byte limit.");
                    ctx.json(tooLarge.envelope());
                });

        return app;
    }

    /**
     * Resolve the seeded catalog once at boot.
     *
     * <p>This is not a hard requirement to start — the process stays up so that {@code
     * GET /api/health} answers and so that seeding the tenant fixes things without a restart — but
     * it turns "my first transcription says I'm not entitled" into an unmissable startup error
     * naming the object that is missing.
     */
    private static void probeCatalog(AppState state) {
        if (!state.config.meteroidConfigured()) {
            return;
        }
        try {
            Catalog catalog = state.catalog();
            LOG.info(
                    "Meteroid catalog resolved: {} plans ({}).",
                    catalog.plans().size(),
                    catalog.plans().stream().map(Dto.Plan::name).collect(Collectors.joining(", ")));
        } catch (RuntimeException e) {
            LOG.error(
                    "Meteroid catalog is not usable yet: {}\nThe demo never creates catalog objects"
                        + " — seed them once, by hand, as described in examples/CATALOG.md."
                        + " Requests that need the catalog will keep returning 503"
                        + " CATALOG_NOT_SEEDED until it is there.",
                    e.getMessage());
        }
    }
}
