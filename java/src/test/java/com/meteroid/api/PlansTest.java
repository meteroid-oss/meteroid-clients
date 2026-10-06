// this file is @generated
package com.meteroid.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

class PlansTest {

    @Test
    void listPlanVersionEntitlements() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"data\":[{\"feature\":{\"code\":\"sample\",\"id\":\"feature_id_53\",\"name\":\"sample\"},\"value\":{\"type\":\"BOOLEAN\",\"enabled\":false}}]}");
        mock.client.plans().listPlanVersionEntitlements("plan_version_id");
        assertEquals(
                List.of("GET /api/v1/plan-versions/plan_version_id/entitlements"), mock.requests);
    }

    @Test
    void list() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"data\":[{\"available_parameters\":{},\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"currency\":\"sample\",\"id\":\"plan_id_78\",\"name\":\"sample\",\"net_terms\":-2147483648,\"plan_type\":\"FREE\",\"price_components\":[{\"id\":\"price_component_id_82\",\"name\":\"sample\"}],\"product_family\":{\"id\":\"product_family_id_59\",\"name\":\"sample\"},\"status\":\"INACTIVE\",\"version\":-2147483648,\"version_id\":\"plan_version_id_31\"}],\"pagination_meta\":{\"page\":-123456789,\"per_page\":-123456789,\"total_items\":-9007199254740993,\"total_pages\":123456789}}");
        mock.client.plans().list();
        assertEquals(List.of("GET /api/v1/plans"), mock.requests);
    }

    @Test
    void create() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"available_parameters\":{},\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"currency\":\"sample\",\"id\":\"plan_id_13\",\"name\":\"sample\",\"net_terms\":2147483647,\"plan_type\":\"FREE\",\"price_components\":[{\"id\":\"price_component_id_38\",\"name\":\"sample\"}],\"product_family\":{\"id\":\"product_family_id_66\",\"name\":\"sample\"},\"status\":\"ARCHIVED\",\"version\":2147483647,\"version_id\":\"plan_version_id_92\"}");
        mock.client
                .plans()
                .create(
                        PerseidMock.decode(
                                com.meteroid.models.CreatePlanRequest.class,
                                "{\"components\":[{\"fee\":{\"type\":\"RATE\",\"rates\":[{\"price\":\"-0.000123\",\"term\":\"ANNUAL\"}]},\"name\":\"sample\"}],\"currency\":\"sample\",\"name\":\"sample\",\"plan_type\":\"CUSTOM\",\"product_family_id\":\"product_family_id_40\",\"status\":\"INACTIVE\"}"));
        assertEquals(List.of("POST /api/v1/plans"), mock.requests);
    }

    @Test
    void updateVersionMinimum() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"amount\":\"sample\",\"scope\":{\"type\":\"all_components\"}}");
        mock.client
                .plans()
                .updateVersionMinimum(
                        "plan_version_id",
                        PerseidMock.decode(
                                com.meteroid.models.MinimumCommitment.class,
                                "{\"amount\":\"sample\",\"scope\":{\"type\":\"all_components\"}}"));
        assertEquals(List.of("PUT /api/v1/plans/versions/plan_version_id/minimum"), mock.requests);
    }

    @Test
    void deleteVersionMinimum() throws Exception {
        PerseidMock mock = new PerseidMock(204, null, "");
        mock.client.plans().deleteVersionMinimum("plan_version_id");
        assertEquals(
                List.of("DELETE /api/v1/plans/versions/plan_version_id/minimum"), mock.requests);
    }

    @Test
    void retrieve() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"available_parameters\":{},\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"currency\":\"sample\",\"id\":\"plan_id_13\",\"name\":\"sample\",\"net_terms\":2147483647,\"plan_type\":\"FREE\",\"price_components\":[{\"id\":\"price_component_id_38\",\"name\":\"sample\"}],\"product_family\":{\"id\":\"product_family_id_66\",\"name\":\"sample\"},\"status\":\"ARCHIVED\",\"version\":2147483647,\"version_id\":\"plan_version_id_92\"}");
        mock.client.plans().retrieve("plan_id");
        assertEquals(List.of("GET /api/v1/plans/plan_id"), mock.requests);
    }

    @Test
    void replace() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"available_parameters\":{},\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"currency\":\"sample\",\"id\":\"plan_id_13\",\"name\":\"sample\",\"net_terms\":2147483647,\"plan_type\":\"FREE\",\"price_components\":[{\"id\":\"price_component_id_38\",\"name\":\"sample\"}],\"product_family\":{\"id\":\"product_family_id_66\",\"name\":\"sample\"},\"status\":\"ARCHIVED\",\"version\":2147483647,\"version_id\":\"plan_version_id_92\"}");
        mock.client
                .plans()
                .replace(
                        "plan_id",
                        PerseidMock.decode(
                                com.meteroid.models.ReplacePlanRequest.class,
                                "{\"components\":[{\"fee\":{\"type\":\"RATE\",\"rates\":[{\"price\":\"-0.000123\",\"term\":\"ANNUAL\"}]},\"name\":\"sample\"}],\"currency\":\"sample\",\"name\":\"sample\"}"));
        assertEquals(List.of("PUT /api/v1/plans/plan_id"), mock.requests);
    }

    @Test
    void update() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"available_parameters\":{},\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"currency\":\"sample\",\"id\":\"plan_id_13\",\"name\":\"sample\",\"net_terms\":2147483647,\"plan_type\":\"FREE\",\"price_components\":[{\"id\":\"price_component_id_38\",\"name\":\"sample\"}],\"product_family\":{\"id\":\"product_family_id_66\",\"name\":\"sample\"},\"status\":\"ARCHIVED\",\"version\":2147483647,\"version_id\":\"plan_version_id_92\"}");
        mock.client
                .plans()
                .update(
                        "plan_id",
                        PerseidMock.decode(com.meteroid.models.PatchPlanRequest.class, "{}"));
        assertEquals(List.of("PATCH /api/v1/plans/plan_id"), mock.requests);
    }

    @Test
    void archive() throws Exception {
        PerseidMock mock = new PerseidMock(204, null, "");
        mock.client.plans().archive("plan_id");
        assertEquals(List.of("POST /api/v1/plans/plan_id/archive"), mock.requests);
    }

    @Test
    void publish() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"available_parameters\":{},\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"currency\":\"sample\",\"id\":\"plan_id_13\",\"name\":\"sample\",\"net_terms\":2147483647,\"plan_type\":\"FREE\",\"price_components\":[{\"id\":\"price_component_id_38\",\"name\":\"sample\"}],\"product_family\":{\"id\":\"product_family_id_66\",\"name\":\"sample\"},\"status\":\"ARCHIVED\",\"version\":2147483647,\"version_id\":\"plan_version_id_92\"}");
        mock.client.plans().publish("plan_id");
        assertEquals(List.of("POST /api/v1/plans/plan_id/publish"), mock.requests);
    }

    @Test
    void unarchive() throws Exception {
        PerseidMock mock = new PerseidMock(204, null, "");
        mock.client.plans().unarchive("plan_id");
        assertEquals(List.of("POST /api/v1/plans/plan_id/unarchive"), mock.requests);
    }

    @Test
    void listVersions() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"data\":[{\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"currency\":\"sample\",\"id\":\"plan_version_id_2\",\"is_draft\":true,\"version\":-2147483648}],\"pagination_meta\":{\"page\":-123456789,\"per_page\":-123456789,\"total_items\":-9007199254740993,\"total_pages\":123456789}}");
        mock.client.plans().listVersions("plan_id");
        assertEquals(List.of("GET /api/v1/plans/plan_id/versions"), mock.requests);
    }
}
