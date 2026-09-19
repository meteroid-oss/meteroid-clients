package main

import (
	"context"
	"encoding/json"
	"fmt"
	"time"

	meteroid "github.com/meteroid-oss/meteroid-clients/go"
)

// `GET /api/transcriptions` and `POST /api/transcriptions` — the metered action.
//
// POST is the centerpiece of the demo and the reason the whole thing exists:
// **check the entitlement, then report the consumption.** Everything else is framing.

// listTranscriptions is the demo-local history, newest first. In memory: Meteroid is
// the source of truth for *usage*, not for the application objects that produced it.
func (a *app) listTranscriptions(_ context.Context, r *request) (*reply, error) {
	session, err := a.requireSession(r)
	if err != nil {
		return nil, err
	}

	return replyOK(TranscriptionListResponse{Transcriptions: a.transcriptions.list(session.customerAlias)})
}

func (a *app) createTranscription(ctx context.Context, r *request) (*reply, error) {
	session, err := a.requireSession(r)
	if err != nil {
		return nil, err
	}
	alias := session.customerAlias

	body, err := jsonBody(r, decodeCreateTranscriptionRequest)
	if err != nil {
		return nil, err
	}
	title, err := bounded("title", body.Title, 200)
	if err != nil {
		return nil, err
	}
	if body.DurationSeconds < 1 || body.DurationSeconds > 7200 {
		return nil, badRequest("duration_seconds must be between 1 and 7200.")
	}
	minutes := billableMinutes(body.DurationSeconds)

	// ---- 1. Read the entitlement ------------------------------------------------
	effective, err := a.fetchEntitlements(ctx, alias)
	if err != nil {
		return nil, err
	}
	metered, err := a.findMetered(ctx, alias, effective)
	if err != nil {
		return nil, err
	}
	quota, err := quotaSnapshot(transcriptionMinutes, metered)
	if err != nil {
		return nil, err
	}

	// ---- 2. Gate ----------------------------------------------------------------
	// "Not granted" and "granted but used up" are different answers and get different
	// status codes, so the frontend can tell an upsell from a paywall.
	if !metered.Spec.Enabled {
		return nil, notEntitled(a.upgradeTarget(ctx, alias))
	}

	// A nil limit means unlimited — `remaining` is then nil and never trips this branch.
	if quota.Remaining != nil {
		exceeds, err := decimalGreaterThan(minutes, *quota.Remaining)
		if err != nil {
			return nil, err
		}
		if exceeds {
			return nil, newAPIError(codeQuotaExhausted,
				"This request needs %s transcription minutes but only %s remain in the current period.",
				minutes, *quota.Remaining).
				withQuota(quota).
				withUpgrade(a.upgradeTarget(ctx, alias))
		}
	}

	// ---- 3. Do the work and report the consumption ------------------------------
	id := "tr_" + randomID()
	// Whole seconds: sub-second precision means nothing for a usage event.
	now := time.Now().UTC().Format(time.RFC3339)

	response, err := a.meteroid.Events().IngestEvents(ctx, meteroid.IngestEventsRequest{
		Events: []meteroid.Event{{
			// The billable metric's code, seeded per examples/CATALOG.md.
			Code: transcriptionMinutes,
			// Events accept the customer's *external alias*, so the demo never has to
			// carry Meteroid ids around.
			CustomerId: alias,
			// Meteroid deduplicates on (EventId, CustomerId). Reusing the transcription's
			// own id makes a retried ingest idempotent.
			EventId: id,
			// Aggregated by the metric's `aggregation_key`, as a decimal string.
			Properties: map[string]string{"minutes": minutes},
			// Must be within 24h ago .. 1h ahead unless AllowBackfilling is set, which
			// this demo never does.
			Timestamp: now,
		}},
	})
	if err != nil {
		return nil, upstream("POST /api/v1/events/ingest", err)
	}

	// With AllowPartialFailures unset, a bad event rejects the whole batch and the call
	// above already failed — but check anyway rather than silently losing usage.
	if len(response.Failures) > 0 {
		failures, _ := json.Marshal(response.Failures)
		return nil, newAPIError(codeUpstreamError, "Meteroid rejected the usage event: %s", failures)
	}

	transcription := Transcription{
		ID:              id,
		Title:           title,
		DurationSeconds: body.DurationSeconds,
		MinutesBilled:   minutes,
		Text:            transcript(body.DurationSeconds),
		CreatedAt:       now,
		EventID:         id,
	}
	a.transcriptions.record(alias, transcription)

	projected, err := projectQuota(quota, minutes)
	if err != nil {
		return nil, err
	}
	return replyCreated(CreateTranscriptionResponse{Transcription: transcription, Quota: projected})
}

// findMetered finds the metered `transcription_minutes` entitlement, or explains why
// there is none.
//
// A *missing* entitlement is a 403: the workspace's plan does not grant the feature. An
// entitlement of the *wrong type* is a seeding error — the feature exists but was
// created as boolean or config in the dashboard — and gets CATALOG_NOT_SEEDED, so an
// operator mistake never masquerades as a customer-facing paywall.
func (a *app) findMetered(ctx context.Context, alias string, effective []meteroid.EffectiveEntitlement) (*meteroid.MeteredEffectiveEntitlementValue, error) {
	for _, entitlement := range effective {
		if entitlement.Feature.Code != transcriptionMinutes {
			continue
		}
		if entitlement.Value.Type != meteroid.EffectiveEntitlementValueMetered {
			return nil, catalogNotSeeded("The feature %q exists but is not a metered feature. Recreate it as "+
				"metered in the Meteroid dashboard; see examples/CATALOG.md.", transcriptionMinutes)
		}
		return entitlement.Value.Metered, nil
	}
	return nil, notEntitled(a.upgradeTarget(ctx, alias))
}

func notEntitled(upgrade *PlanCode) *apiError {
	return newAPIError(codeFeatureNotEntitled,
		"The %s entitlement is not enabled for this workspace.", transcriptionMinutes).
		withUpgrade(upgrade)
}

// projectQuota is the backend's optimistic projection of the entitlement after this
// call: what it read from Meteroid, minus the minutes it just billed. Meteroid's own
// counters are eventually consistent, so GET /api/usage may briefly disagree — it is the
// authority once it catches up.
func projectQuota(quota QuotaSnapshot, minutes string) (QuotaSnapshot, error) {
	consumed := minutes
	if quota.Consumed != nil {
		var err error
		if consumed, err = addDecimal(*quota.Consumed, minutes); err != nil {
			return QuotaSnapshot{}, err
		}
	}
	quota.Consumed = &consumed

	if quota.Remaining != nil {
		remaining, err := subtractDecimal(*quota.Remaining, minutes)
		if err != nil {
			return QuotaSnapshot{}, err
		}
		quota.Remaining = &remaining
	}
	return quota, nil
}

// transcript: the demo does no real speech recognition; it invents a transcript so the
// metered path has something to return.
func transcript(durationSeconds int32) string {
	return fmt.Sprintf("[demo transcript] This is simulated output for %d seconds of audio. "+
		"Scribe does no real speech recognition — the point of this endpoint is the "+
		"entitlement check and the usage event it reports to Meteroid.", durationSeconds)
}
