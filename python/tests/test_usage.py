# this file is @generated
# ruff: noqa: I001  (where the package sorts depends on whether it is generated yet)
import unittest

from perseid_mock import call, mock


class UsageTest(unittest.TestCase):
    def test_retrieve_subscription(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"period_end":"1999-12-31","period_start":"2024-02-29","usage":[{"grouped_usage":[{"dimensions":{"alpha":"sample"},"value":"12345.6789"}],"metric_code":"sample","metric_id":"billable_metric_id_44","metric_name":"sample","total_value":"12345.6789"}]}',
        )
        call(client.usage.retrieve_subscription, "subscription_id")
        self.assertEqual(requests, ["GET /api/v1/usage/subscription/subscription_id"])
