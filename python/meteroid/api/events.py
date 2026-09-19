# this file is @generated

from ..models import (
    IngestEventsRequest,
    IngestEventsResponse,
)
from .common import ApiBaseAsync, ApiBaseSync, decode_response


class EventsAsync(ApiBaseAsync):
    """events API."""

    async def ingest_events(
        self,
        ingest_events_request: IngestEventsRequest,
    ) -> IngestEventsResponse:
        """Ingest usage events for metering and billing purposes.

        Events are deduplicated by `(event_id, customer_id)` — re-sending the same pair will not be
        double-counted. If timestamps differ across duplicates, the event with the latest timestamp is used.

        By default, any invalid event rejects the entire batch. Set `allow_partial_failures` to `true` to ingest valid events and receive per-event failure details in the response body."""
        response = await self._request_asyncio(
            method="post",
            path="/api/v1/events/ingest",
            json_body=ingest_events_request.to_dict(),
        )
        return decode_response(response, IngestEventsResponse)


class Events(ApiBaseSync):
    """events API."""

    def ingest_events(
        self,
        ingest_events_request: IngestEventsRequest,
    ) -> IngestEventsResponse:
        """Ingest usage events for metering and billing purposes.

        Events are deduplicated by `(event_id, customer_id)` — re-sending the same pair will not be
        double-counted. If timestamps differ across duplicates, the event with the latest timestamp is used.

        By default, any invalid event rejects the entire batch. Set `allow_partial_failures` to `true` to ingest valid events and receive per-event failure details in the response body."""
        response = self._request_sync(
            method="post",
            path="/api/v1/events/ingest",
            json_body=ingest_events_request.to_dict(),
        )
        return decode_response(response, IngestEventsResponse)
