# this file is @generated
# ruff: noqa: I001  (where the package sorts depends on whether it is generated yet)
import unittest

from meteroid.models import (
    CreatePlanRequest,
    MinimumCommitment,
    ReplacePlanRequest,
    PatchPlanRequest,
)

from perseid_mock import call, decode, mock


class PlansTest(unittest.TestCase):
    def test_list_plan_version_entitlements(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"data":[{"feature":{"code":"sample","id":"feature_id_53","name":"sample"},"value":{"type":"BOOLEAN","enabled":false}}]}',
        )
        call(client.plans.list_plan_version_entitlements, "plan_version_id")
        self.assertEqual(
            requests, ["GET /api/v1/plan-versions/plan_version_id/entitlements"]
        )

    def test_list(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"data":[{"available_parameters":{},"created_at":"2024-03-15T10:30:45.123+02:00","currency":"sample","id":"plan_id_78","name":"sample","net_terms":-2147483648,"plan_type":"FREE","price_components":[{"id":"price_component_id_82","name":"sample"}],"product_family":{"id":"product_family_id_59","name":"sample"},"status":"INACTIVE","version":-2147483648,"version_id":"plan_version_id_31"}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
        )
        call(client.plans.list)
        self.assertEqual(requests, ["GET /api/v1/plans"])

    def test_create(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"available_parameters":{},"created_at":"2023-12-31T23:59:59.999-05:30","currency":"sample","id":"plan_id_13","name":"sample","net_terms":2147483647,"plan_type":"FREE","price_components":[{"id":"price_component_id_38","name":"sample"}],"product_family":{"id":"product_family_id_66","name":"sample"},"status":"ARCHIVED","version":2147483647,"version_id":"plan_version_id_92"}',
        )
        call(
            client.plans.create,
            body=decode(
                CreatePlanRequest,
                '{"components":[{"fee":{"type":"RATE","rates":[{"price":"-0.000123","term":"ANNUAL"}]},"name":"sample"}],"currency":"sample","name":"sample","plan_type":"CUSTOM","product_family_id":"product_family_id_40","status":"INACTIVE"}',
            ),
        )
        self.assertEqual(requests, ["POST /api/v1/plans"])

    def test_update_version_minimum(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"amount":"sample","scope":{"type":"all_components"}}',
        )
        call(
            client.plans.update_version_minimum,
            "plan_version_id",
            body=decode(
                MinimumCommitment,
                '{"amount":"sample","scope":{"type":"all_components"}}',
            ),
        )
        self.assertEqual(
            requests, ["PUT /api/v1/plans/versions/plan_version_id/minimum"]
        )

    def test_delete_version_minimum(self) -> None:
        client, requests = mock(204, None, "")
        call(client.plans.delete_version_minimum, "plan_version_id")
        self.assertEqual(
            requests, ["DELETE /api/v1/plans/versions/plan_version_id/minimum"]
        )

    def test_retrieve(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"available_parameters":{},"created_at":"2023-12-31T23:59:59.999-05:30","currency":"sample","id":"plan_id_13","name":"sample","net_terms":2147483647,"plan_type":"FREE","price_components":[{"id":"price_component_id_38","name":"sample"}],"product_family":{"id":"product_family_id_66","name":"sample"},"status":"ARCHIVED","version":2147483647,"version_id":"plan_version_id_92"}',
        )
        call(client.plans.retrieve, "plan_id")
        self.assertEqual(requests, ["GET /api/v1/plans/plan_id"])

    def test_replace(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"available_parameters":{},"created_at":"2023-12-31T23:59:59.999-05:30","currency":"sample","id":"plan_id_13","name":"sample","net_terms":2147483647,"plan_type":"FREE","price_components":[{"id":"price_component_id_38","name":"sample"}],"product_family":{"id":"product_family_id_66","name":"sample"},"status":"ARCHIVED","version":2147483647,"version_id":"plan_version_id_92"}',
        )
        call(
            client.plans.replace,
            "plan_id",
            body=decode(
                ReplacePlanRequest,
                '{"components":[{"fee":{"type":"RATE","rates":[{"price":"-0.000123","term":"ANNUAL"}]},"name":"sample"}],"currency":"sample","name":"sample"}',
            ),
        )
        self.assertEqual(requests, ["PUT /api/v1/plans/plan_id"])

    def test_update(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"available_parameters":{},"created_at":"2023-12-31T23:59:59.999-05:30","currency":"sample","id":"plan_id_13","name":"sample","net_terms":2147483647,"plan_type":"FREE","price_components":[{"id":"price_component_id_38","name":"sample"}],"product_family":{"id":"product_family_id_66","name":"sample"},"status":"ARCHIVED","version":2147483647,"version_id":"plan_version_id_92"}',
        )
        call(client.plans.update, "plan_id", body=decode(PatchPlanRequest, "{}"))
        self.assertEqual(requests, ["PATCH /api/v1/plans/plan_id"])

    def test_archive(self) -> None:
        client, requests = mock(204, None, "")
        call(client.plans.archive, "plan_id")
        self.assertEqual(requests, ["POST /api/v1/plans/plan_id/archive"])

    def test_publish(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"available_parameters":{},"created_at":"2023-12-31T23:59:59.999-05:30","currency":"sample","id":"plan_id_13","name":"sample","net_terms":2147483647,"plan_type":"FREE","price_components":[{"id":"price_component_id_38","name":"sample"}],"product_family":{"id":"product_family_id_66","name":"sample"},"status":"ARCHIVED","version":2147483647,"version_id":"plan_version_id_92"}',
        )
        call(client.plans.publish, "plan_id")
        self.assertEqual(requests, ["POST /api/v1/plans/plan_id/publish"])

    def test_unarchive(self) -> None:
        client, requests = mock(204, None, "")
        call(client.plans.unarchive, "plan_id")
        self.assertEqual(requests, ["POST /api/v1/plans/plan_id/unarchive"])

    def test_list_versions(self) -> None:
        client, requests = mock(
            200,
            "application/json",
            '{"data":[{"created_at":"2023-12-31T23:59:59.999-05:30","currency":"sample","id":"plan_version_id_2","is_draft":true,"version":-2147483648}],"pagination_meta":{"page":-123456789,"per_page":-123456789,"total_items":-9007199254740993,"total_pages":123456789}}',
        )
        call(client.plans.list_versions, "plan_id")
        self.assertEqual(requests, ["GET /api/v1/plans/plan_id/versions"])
