# this file is @generated
# ruff: noqa: I001  (where the package sorts depends on whether it is generated yet)
import unittest

from perseid_mock import call, mock


class BatchJobsTest(unittest.TestCase):
    def test_list(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"data":[{"created_at":"2023-12-31T23:59:59.999-05:30","created_by":"3fa85f64-5717-4562-b3fc-2c963f66afa6","failed_items":2147483647,"id":"batch_job_id_67","job_type":"SUBSCRIPTION_PLAN_MIGRATION","processed_items":-123456789,"status":"CHUNKING"}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
        )
        call(client.batch_jobs.list)
        self.assertEqual(requests, ["GET /api/v1/batch-jobs"])

    def test_retrieve(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"created_at":"2024-03-15T10:30:45.123+02:00","created_by":"00000000-0000-0000-0000-000000000000","failed_items":-2147483648,"failure_count":9007199254740993,"has_error_csv":false,"has_output":true,"id":"batch_job_id_99","job_type":"CUSTOMER_CSV_IMPORT","processed_items":-2147483648,"status":"PROCESSING"}',
        )
        call(client.batch_jobs.retrieve, "batch_job_id")
        self.assertEqual(requests, ["GET /api/v1/batch-jobs/batch_job_id"])

    def test_list_failures(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"data":[{"chunk_id":"batch_job_chunk_id_9","id":"00000000-0000-0000-0000-000000000000","item_index":2147483647,"reason":"sample"}],"total_count":9007199254740993}',
        )
        call(client.batch_jobs.list_failures, "batch_job_id")
        self.assertEqual(requests, ["GET /api/v1/batch-jobs/batch_job_id/failures"])
