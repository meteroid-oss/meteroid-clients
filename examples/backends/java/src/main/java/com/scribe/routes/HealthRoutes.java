package com.scribe.routes;

import com.scribe.AppState;
import com.scribe.Dto;
import com.scribe.Main;

import io.javalin.http.Context;

/** {@code GET /api/health} — unauthenticated liveness and configuration probe. */
public final class HealthRoutes {

    private HealthRoutes() {}

    public static void getHealth(Context ctx, AppState state) {
        ctx.json(
                new Dto.Health(
                        "ok",
                        "java",
                        // False means METEROID_API_KEY (or the base URL) is missing, and every
                        // Meteroid-backed operation below will fail with UPSTREAM_UNAUTHORIZED.
                        // Reporting it here is what turns a wall of 502s into one clear message.
                        state.config.meteroidConfigured(),
                        Main.VERSION));
    }
}
