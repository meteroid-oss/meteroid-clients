# this file is @generated
# ruff: noqa: I001  (where the package sorts depends on whether it is generated yet)
import unittest

from meteroid.models import CreateMetricRequest, UpdateMetricRequest

from perseid_mock import call, decode, mock


class MetricsTest(unittest.TestCase):
    def test_list(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"data":[{"aggregation_type":"COUNT","code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","id":"billable_metric_id_78","name":"sample"}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
        )
        call(client.metrics.list)
        self.assertEqual(requests, ["GET /api/v1/metrics"])

    def test_create(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"aggregation_type":"LATEST","code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","id":"billable_metric_id_40","name":"sample","product_family_id":"product_family_id_90"}',
        )
        call(
            client.metrics.create,
            body=decode(
                CreateMetricRequest,
                '{"aggregation_type":"LATEST","code":"sample","name":"sample","product_family_id":"product_family_id_13"}',
            ),
        )
        self.assertEqual(requests, ["POST /api/v1/metrics"])

    def test_retrieve(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"aggregation_type":"LATEST","code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","id":"billable_metric_id_40","name":"sample","product_family_id":"product_family_id_90"}',
        )
        call(client.metrics.retrieve, "metric_id")
        self.assertEqual(requests, ["GET /api/v1/metrics/metric_id"])

    def test_update(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"aggregation_type":"LATEST","code":"sample","created_at":"2023-12-31T23:59:59.999-05:30","id":"billable_metric_id_40","name":"sample","product_family_id":"product_family_id_90"}',
        )
        call(client.metrics.update, "metric_id", body=decode(UpdateMetricRequest, "{}"))
        self.assertEqual(requests, ["PATCH /api/v1/metrics/metric_id"])

    def test_archive(self) -> None:
        client, requests = mock(204, None, "")
        call(client.metrics.archive, "metric_id")
        self.assertEqual(requests, ["POST /api/v1/metrics/metric_id/archive"])

    def test_unarchive(self) -> None:
        client, requests = mock(204, None, "")
        call(client.metrics.unarchive, "metric_id")
        self.assertEqual(requests, ["POST /api/v1/metrics/metric_id/unarchive"])
