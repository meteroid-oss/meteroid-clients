package com.scribe.routes;

import com.meteroid.models.EffectiveEntitlement;
import com.scribe.AppState;
import com.scribe.Dto;
import com.scribe.Entitlements;
import com.scribe.SessionToken;

import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.List;

/** {@code GET /api/entitlements} — the normalized entitlement view the SPA gates on. */
public final class EntitlementRoutes {

    private EntitlementRoutes() {}

    /**
     * One Meteroid call, then a straight projection. The list may legitimately be empty for a
     * workspace that has never subscribed and has no feature-level defaults — that is not an error,
     * and it is why the demo checks the <i>features</i> exist at startup instead of inferring
     * "unseeded tenant" from an empty list here.
     */
    public static void listEntitlements(Context ctx, AppState state) {
        String alias = SessionToken.requireCustomerAlias(ctx, state.config);

        List<EffectiveEntitlement> effective = Entitlements.fetch(state, alias);

        List<Dto.Entitlement> normalized = new ArrayList<>(effective.size());
        for (EffectiveEntitlement entitlement : effective) {
            normalized.add(Entitlements.normalize(state, entitlement));
        }

        ctx.json(new Dto.EntitlementListResponse(normalized));
    }
}
