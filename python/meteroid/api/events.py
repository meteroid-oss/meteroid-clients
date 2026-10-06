# this file is @generated
"""Events API."""

from __future__ import annotations

import typing as t

from .. import models as _models
from ..models import (
    Event,
    IngestEventsRequest,
    IngestEventsResponse,
)
from ..serialization import UNSET, Unset, to_json_value
from ._response import async_to_raw_response_wrapper, to_raw_response_wrapper
from .common import (
    ApiBaseAsync,
    ApiBaseSync,
    ApiRequest,
    Timeout,
    decode_response,
)


class AsyncEvents(ApiBaseAsync):
    """Events API, for asyncio."""

    @property
    def with_raw_response(self) -> AsyncEventsWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return AsyncEventsWithRawResponse(self)

    async def ingest(
        self,
        *,
        events: list[Event],
        allow_backfilling: bool | None | Unset = UNSET,
        allow_partial_failures: bool | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> IngestEventsResponse:
        """Ingest events

        Ingest usage events for metering and billing purposes.

        Events are deduplicated by `(event_id, customer_id)` — re-sending the same pair will not be
        double-counted. If timestamps differ across duplicates, the event with the latest timestamp is used.

        By default, any invalid event rejects the entire batch. Set `allow_partial_failures` to `true` to ingest valid events and receive per-event failure details in the response body.

        :param allow_backfilling: Allow events with timestamps more than 1 day in the past. Defaults to `false`.
        :param allow_partial_failures: Accept the batch even if some events fail validation. Defaults to `false`. When `true`, valid events are ingested and failures are reported in the response body. When `false` (default), any invalid event rejects the entire batch.
        :param events: 1–100 events per request."""
        response = await self._request(
            ApiRequest(
                method="post",
                path="/api/v1/events/ingest",
                json_body=to_json_value(
                    IngestEventsRequest(
                        allow_backfilling=allow_backfilling,
                        allow_partial_failures=allow_partial_failures,
                        events=events,
                    ),
                    IngestEventsRequest,
                ),
                error_types={
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )
        return decode_response(response, IngestEventsResponse)


class AsyncEventsWithRawResponse:
    """The methods of :class:`AsyncEvents`, returning an :class:`APIResponse`."""

    def __init__(self, resource: AsyncEvents) -> None:
        self.ingest = async_to_raw_response_wrapper(resource.ingest)


class Events(ApiBaseSync):
    """Events API."""

    @property
    def with_raw_response(self) -> EventsWithRawResponse:
        """These methods, returning an :class:`APIResponse` with the status and headers."""
        return EventsWithRawResponse(self)

    def ingest(
        self,
        *,
        events: list[Event],
        allow_backfilling: bool | None | Unset = UNSET,
        allow_partial_failures: bool | None | Unset = UNSET,
        extra_headers: t.Mapping[str, str] | None = None,
        extra_query: t.Mapping[str, object] | None = None,
        extra_body: t.Mapping[str, object] | None = None,
        timeout: Timeout | Unset = UNSET,
        max_retries: int | None = None,
    ) -> IngestEventsResponse:
        """Ingest events

        Ingest usage events for metering and billing purposes.

        Events are deduplicated by `(event_id, customer_id)` — re-sending the same pair will not be
        double-counted. If timestamps differ across duplicates, the event with the latest timestamp is used.

        By default, any invalid event rejects the entire batch. Set `allow_partial_failures` to `true` to ingest valid events and receive per-event failure details in the response body.

        :param allow_backfilling: Allow events with timestamps more than 1 day in the past. Defaults to `false`.
        :param allow_partial_failures: Accept the batch even if some events fail validation. Defaults to `false`. When `true`, valid events are ingested and failures are reported in the response body. When `false` (default), any invalid event rejects the entire batch.
        :param events: 1–100 events per request."""
        response = self._request(
            ApiRequest(
                method="post",
                path="/api/v1/events/ingest",
                json_body=to_json_value(
                    IngestEventsRequest(
                        allow_backfilling=allow_backfilling,
                        allow_partial_failures=allow_partial_failures,
                        events=events,
                    ),
                    IngestEventsRequest,
                ),
                error_types={
                    "default": _models.RestErrorResponse,
                },
                extra_headers=extra_headers,
                extra_query=extra_query,
                extra_body=extra_body,
                timeout=timeout,
                max_retries=max_retries,
            )
        )
        return decode_response(response, IngestEventsResponse)


class EventsWithRawResponse:
    """The methods of :class:`Events`, returning an :class:`APIResponse`."""

    def __init__(self, resource: Events) -> None:
        self.ingest = to_raw_response_wrapper(resource.ingest)
