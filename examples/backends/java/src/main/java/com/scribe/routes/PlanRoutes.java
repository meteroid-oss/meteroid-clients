package com.scribe.routes;

import com.scribe.AppState;
import com.scribe.Dto;

import io.javalin.http.Context;

/** {@code GET /api/plans} — the pricing table, straight from the seeded Meteroid catalog. */
public final class PlanRoutes {

    private PlanRoutes() {}

    /**
     * Unauthenticated: the pricing page is public.
     *
     * <p>All the work happens in {@link com.scribe.Catalog}, which resolves each plan by its exact
     * seeded name, flattens its price components and turns the plan version's entitlements into
     * marketing bullets. The result is cached for the life of the process.
     */
    public static void listPlans(Context ctx, AppState state) {
        ctx.json(new Dto.PlanListResponse(state.catalog().plans()));
    }
}
