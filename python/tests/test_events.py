# this file is @generated
# ruff: noqa: I001  (where the package sorts depends on whether it is generated yet)
import unittest

from meteroid.models import IngestEventsRequest

from perseid_mock import call, decode, mock


class EventsTest(unittest.TestCase):
    def test_ingest(self) -> None:
        client, requests = mock(200, "application/json", "{}")
        call(
            client.events.ingest,
            body=decode(
                IngestEventsRequest,
                '{"events":[{"code":"sample","customer_id":"sample","event_id":"sample","timestamp":"sample"}]}',
            ),
        )
        self.assertEqual(requests, ["POST /api/v1/events/ingest"])
