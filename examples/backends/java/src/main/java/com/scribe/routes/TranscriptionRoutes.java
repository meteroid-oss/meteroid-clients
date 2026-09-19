package com.scribe.routes;

import com.meteroid.models.EffectiveEntitlement;
import com.meteroid.models.EffectiveEntitlementValue;
import com.meteroid.models.Event;
import com.meteroid.models.IngestEventsRequest;
import com.meteroid.models.IngestEventsResponse;
import com.meteroid.models.IngestFailure;
import com.meteroid.models.MeteredEffectiveEntitlementValue;
import com.scribe.ApiError;
import com.scribe.AppState;
import com.scribe.Catalog;
import com.scribe.Dto;
import com.scribe.Entitlements;
import com.scribe.ErrorCode;
import com.scribe.Routes;
import com.scribe.SessionToken;
import com.scribe.Upstream;
import com.scribe.Workspaces;

import io.javalin.http.Context;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * {@code GET /api/transcriptions} and {@code POST /api/transcriptions} — the metered action.
 *
 * <p>{@code POST} is the centerpiece of the demo and the reason the whole thing exists: <b>check
 * the entitlement, then report the consumption.</b> Everything else is framing.
 */
public final class TranscriptionRoutes {

    private TranscriptionRoutes() {}

    private static final int MAX_DURATION_SECONDS = 7200;

    /**
     * Demo-local history, newest first. In memory: Meteroid is the source of truth for <i>usage</i>,
     * not for the application objects that produced it.
     */
    public static void listTranscriptions(Context ctx, AppState state) {
        String alias = SessionToken.requireCustomerAlias(ctx, state.config);
        ctx.json(new Dto.TranscriptionListResponse(state.transcriptions.list(alias)));
    }

    public static void createTranscription(Context ctx, AppState state) {
        String alias = SessionToken.requireCustomerAlias(ctx, state.config);

        Dto.CreateTranscriptionRequest request =
                Routes.jsonBody(ctx, Dto.CreateTranscriptionRequest.class);
        String title = Routes.bounded("title", request.title(), 200);
        Integer duration = request.durationSeconds();
        if (duration == null || duration < 1 || duration > MAX_DURATION_SECONDS) {
            throw ApiError.badRequest(
                    "duration_seconds must be between 1 and " + MAX_DURATION_SECONDS + ".");
        }
        BigDecimal minutes = billableMinutes(duration);

        // ---- 1. Read the entitlement ------------------------------------------------
        List<EffectiveEntitlement> effective = Entitlements.fetch(state, alias);
        MeteredEffectiveEntitlementValue metered = findMetered(state, alias, effective);
        Dto.QuotaSnapshot quota = Entitlements.quotaSnapshot(Catalog.TRANSCRIPTION_MINUTES, metered);

        // ---- 2. Gate ----------------------------------------------------------------
        // "Not granted" and "granted but used up" are different answers and get different status
        // codes, so the frontend can tell an upsell from a paywall.
        if (!metered.getSpec().getEnabled()) {
            throw new ApiError(
                            ErrorCode.FEATURE_NOT_ENTITLED,
                            "The "
                                    + Catalog.TRANSCRIPTION_MINUTES
                                    + " entitlement is not enabled for this workspace.")
                    .withUpgrade(Workspaces.upgradeTarget(state, alias));
        }

        BigDecimal remaining =
                Entitlements.remainingBalance(
                        metered.getSpec().getLimit(),
                        metered.getUsage() == null ? null : metered.getUsage().getConsumed(),
                        metered.getUsage() == null ? null : metered.getUsage().getRemaining());
        // A null limit means unlimited and never trips this branch.
        if (remaining != null && minutes.compareTo(remaining) > 0) {
            throw new ApiError(
                            ErrorCode.QUOTA_EXHAUSTED,
                            "This request needs "
                                    + Dto.decimal(minutes)
                                    + " transcription minutes but only "
                                    + Dto.decimal(remaining)
                                    + " remain in the current period.")
                    .withQuota(quota)
                    .withUpgrade(Workspaces.upgradeTarget(state, alias));
        }

        // ---- 3. Do the work and report the consumption ------------------------------
        String id = "tr_" + UUID.randomUUID().toString().replace("-", "");
        String now = Dto.timestamp(OffsetDateTime.now(ZoneOffset.UTC));

        Event event =
                new Event()
                        // The billable metric's code, seeded per examples/CATALOG.md.
                        .code(Catalog.TRANSCRIPTION_MINUTES)
                        // Events accept the customer's *external alias*, so the demo never has to
                        // carry Meteroid ids around.
                        .customerId(alias)
                        // Meteroid deduplicates on (event_id, customer_id). Reusing the
                        // transcription's own id makes a retried ingest idempotent.
                        .eventId(id)
                        // Aggregated by the metric's `aggregation_key`, as a decimal string.
                        .properties(Map.of("minutes", Dto.decimal(minutes)))
                        // Must be within 24h ago .. 1h ahead unless `allow_backfilling` is set,
                        // which this demo never does.
                        .timestamp(now);

        IngestEventsResponse ingested =
                Upstream.call(
                        "POST /api/v1/events/ingest",
                        () ->
                                state.meteroid
                                        .getEvents()
                                        .ingestEvents(
                                                new IngestEventsRequest().events(List.of(event))));

        // With `allow_partial_failures` unset, a bad event rejects the whole batch and the call
        // above already errored — but check anyway rather than silently losing usage.
        List<IngestFailure> failures = ingested == null ? null : ingested.getFailures();
        if (failures != null && !failures.isEmpty()) {
            throw new ApiError(
                    ErrorCode.UPSTREAM_ERROR,
                    "Meteroid rejected the usage event: " + failures.get(0).getReason());
        }

        Dto.Transcription transcription =
                new Dto.Transcription(
                        id, title, duration, Dto.decimal(minutes), transcript(duration), now, id);
        state.transcriptions.record(alias, transcription);

        // The backend's optimistic projection of the entitlement after this call: what it read from
        // Meteroid, minus the minutes it just billed. Meteroid's own counters are eventually
        // consistent, so `GET /api/usage` may briefly disagree — it is the authority once it
        // catches up.
        Routes.created(
                ctx, new Dto.CreateTranscriptionResponse(transcription, quota.minus(minutes)));
    }

    /**
     * Find the metered {@code transcription_minutes} entitlement, or explain why there is none.
     *
     * <p>A <i>missing</i> entitlement is a 403: the workspace's plan does not grant the feature. An
     * entitlement of the <i>wrong type</i> is a seeding error — the feature exists but was created
     * as boolean or config in the dashboard — and gets {@code CATALOG_NOT_SEEDED}, so an operator
     * mistake never masquerades as a customer-facing paywall.
     */
    private static MeteredEffectiveEntitlementValue findMetered(
            AppState state, String alias, List<EffectiveEntitlement> effective) {

        EffectiveEntitlement match =
                effective.stream()
                        .filter(
                                entitlement ->
                                        Catalog.TRANSCRIPTION_MINUTES.equals(
                                                entitlement.getFeature().getCode()))
                        .findFirst()
                        .orElse(null);

        if (match == null) {
            throw new ApiError(
                            ErrorCode.FEATURE_NOT_ENTITLED,
                            "The "
                                    + Catalog.TRANSCRIPTION_MINUTES
                                    + " entitlement is not enabled for this workspace.")
                    .withUpgrade(Workspaces.upgradeTarget(state, alias));
        }
        if (match.getValue() instanceof EffectiveEntitlementValue.Metered metered) {
            return metered.getData();
        }
        throw ApiError.catalogNotSeeded(
                "The feature \""
                        + Catalog.TRANSCRIPTION_MINUTES
                        + "\" exists but is not a metered feature. Recreate it as metered in the"
                        + " Meteroid dashboard; see examples/CATALOG.md.");
    }

    /**
     * {@code duration_seconds / 60}, rounded <b>up</b> to two decimals — the demo always bills at
     * least what it used. Exact decimal arithmetic: a {@code double} here is how a 0.1-minute clip
     * eventually bills wrong.
     */
    static BigDecimal billableMinutes(int durationSeconds) {
        return BigDecimal.valueOf(durationSeconds)
                .divide(BigDecimal.valueOf(60), 2, RoundingMode.CEILING);
    }

    /**
     * The demo does no real speech recognition; it invents a transcript so the metered path has
     * something to return.
     */
    private static String transcript(int durationSeconds) {
        return "[demo transcript] This is simulated output for "
                + durationSeconds
                + " seconds of audio. Scribe does no real speech recognition — the point of this"
                + " endpoint is the entitlement check and the usage event it reports to Meteroid.";
    }
}
