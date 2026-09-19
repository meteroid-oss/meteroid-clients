"""`GET /api/transcriptions` and `POST /api/transcriptions` — the metered action.

`POST` is the centerpiece of the demo and the reason the whole thing exists:
**check the entitlement, then report the consumption.** Everything else is framing.
"""

import json
import uuid
from datetime import UTC, datetime
from decimal import Decimal

from meteroid.models import (
    EffectiveEntitlement,
    Event,
    IngestEventsRequest,
    MeteredEffectiveEntitlementValue,
)

from ..catalog import TRANSCRIPTION_MINUTES
from ..decimals import add, billable_minutes, render, subtract
from ..dto import (
    CreateTranscriptionResponse,
    PlanCode,
    QuotaSnapshot,
    Transcription,
    TranscriptionListResponse,
    decode_create_transcription_request,
)
from ..entitlements import fetch_entitlements, quota_snapshot
from ..error import ApiError, upstream
from ..http import Reply, ScribeRequest, created, ok
from ..session import require_session
from ..state import AppState
from ..workspace import upgrade_target
from . import bounded, json_body


async def list_transcriptions(
    state: AppState, request: ScribeRequest
) -> Reply[TranscriptionListResponse]:
    """Demo-local history, newest first. In memory: Meteroid is the source of truth for
    *usage*, not for the application objects that produced it.
    """
    session = require_session(state, request)

    return ok({"transcriptions": state.transcriptions.history(session.customer_alias)})


async def create_transcription(
    state: AppState, request: ScribeRequest
) -> Reply[CreateTranscriptionResponse]:
    alias = require_session(state, request).customer_alias
    body = json_body(request, decode_create_transcription_request)
    title = bounded("title", body.title, 200)
    if not 1 <= body.duration_seconds <= 7200:
        raise ApiError.bad_request("duration_seconds must be between 1 and 7200.")
    minutes = billable_minutes(body.duration_seconds)

    # ---- 1. Read the entitlement ------------------------------------------------
    effective = await fetch_entitlements(state, alias)
    metered = await _find_metered(state, alias, effective)
    quota = quota_snapshot(TRANSCRIPTION_MINUTES, metered)

    # ---- 2. Gate ----------------------------------------------------------------
    # "Not granted" and "granted but used up" are different answers and get different
    # status codes, so the frontend can tell an upsell from a paywall.
    if not metered.spec.enabled:
        raise _not_entitled(await upgrade_target(state, alias))

    # A null limit means unlimited — `remaining` is then None and never trips this
    # branch. The comparison is numeric, not textual: the snapshot holds rendered
    # strings, and `Decimal(str)` of one is exact.
    remaining = quota["remaining"]
    if remaining is not None and minutes > Decimal(remaining):
        raise (
            ApiError(
                "QUOTA_EXHAUSTED",
                f"This request needs {render(minutes)} transcription minutes but only "
                f"{remaining} remain in the current period.",
            )
            .with_quota(quota)
            .with_upgrade(await upgrade_target(state, alias))
        )

    # ---- 3. Do the work and report the consumption ------------------------------
    transcription_id = f"tr_{uuid.uuid4().hex}"
    # Whole seconds: sub-second precision means nothing for a usage event.
    now = datetime.now(UTC).strftime("%Y-%m-%dT%H:%M:%SZ")

    with upstream("POST /api/v1/events/ingest"):
        response = await state.meteroid.events.ingest_events(
            IngestEventsRequest(
                events=[
                    Event(
                        # The billable metric's code, seeded per examples/CATALOG.md.
                        code=TRANSCRIPTION_MINUTES,
                        # Events accept the customer's *external alias*, so the demo never
                        # has to carry Meteroid ids around.
                        customer_id=alias,
                        # Meteroid deduplicates on (event_id, customer_id). Reusing the
                        # transcription's own id makes a retried ingest idempotent.
                        event_id=transcription_id,
                        # Aggregated by the metric's `aggregation_key`, as a decimal string.
                        properties={"minutes": render(minutes)},
                        # Must be within 24h ago .. 1h ahead unless `allow_backfilling` is
                        # set, which this demo never does.
                        timestamp=now,
                    )
                ]
            )
        )

    # With `allow_partial_failures` unset, a bad event rejects the whole batch and the
    # call above already raised — but check anyway rather than silently losing usage.
    if response.failures:
        failures = json.dumps([failure.to_dict() for failure in response.failures])
        raise ApiError("UPSTREAM_ERROR", f"Meteroid rejected the usage event: {failures}")

    transcription: Transcription = {
        "id": transcription_id,
        "title": title,
        "duration_seconds": body.duration_seconds,
        "minutes_billed": render(minutes),
        "text": _transcript(body.duration_seconds),
        "created_at": now,
        "event_id": transcription_id,
    }
    state.transcriptions.record(alias, transcription)

    return created({"transcription": transcription, "quota": project_quota(quota, minutes)})


async def _find_metered(
    state: AppState, alias: str, effective: list[EffectiveEntitlement]
) -> MeteredEffectiveEntitlementValue:
    """Find the metered `transcription_minutes` entitlement, or explain why there is none.

    A *missing* entitlement is a 403: the workspace's plan does not grant the feature. An
    entitlement of the *wrong type* is a seeding error — the feature exists but was
    created as boolean or config in the dashboard — and gets `CATALOG_NOT_SEEDED`, so an
    operator mistake never masquerades as a customer-facing paywall.
    """
    entitlement = next(
        (candidate for candidate in effective if candidate.feature.code == TRANSCRIPTION_MINUTES),
        None,
    )

    if entitlement is None:
        raise _not_entitled(await upgrade_target(state, alias))
    if not isinstance(entitlement.value.content, MeteredEffectiveEntitlementValue):
        raise ApiError.catalog_not_seeded(
            f'The feature "{TRANSCRIPTION_MINUTES}" exists but is not a metered feature. '
            "Recreate it as metered in the Meteroid dashboard; see examples/CATALOG.md."
        )
    return entitlement.value.content


def _not_entitled(upgrade: PlanCode | None) -> ApiError:
    return ApiError(
        "FEATURE_NOT_ENTITLED",
        f"The {TRANSCRIPTION_MINUTES} entitlement is not enabled for this workspace.",
    ).with_upgrade(upgrade)


def project_quota(quota: QuotaSnapshot, minutes: Decimal) -> QuotaSnapshot:
    """The backend's optimistic projection of the entitlement after this call: what it
    read from Meteroid, plus the minutes it just billed. Meteroid's own counters are
    eventually consistent, so `GET /api/usage` may briefly disagree — it is the authority
    once it catches up.
    """
    consumed, remaining = quota["consumed"], quota["remaining"]
    return {
        **quota,
        "consumed": render(minutes if consumed is None else add(Decimal(consumed), minutes)),
        "remaining": None if remaining is None else render(subtract(Decimal(remaining), minutes)),
    }


def _transcript(duration_seconds: int) -> str:
    """The demo does no real speech recognition; it invents a transcript so the metered
    path has something to return.
    """
    return (
        f"[demo transcript] This is simulated output for {duration_seconds} seconds of audio. "
        "Scribe does no real speech recognition — the point of this endpoint is the "
        "entitlement check and the usage event it reports to Meteroid."
    )
