// this file is @generated
package com.meteroid.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

class MetricsTest {

    @Test
    void list() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"data\":[{\"aggregation_type\":\"COUNT\",\"code\":\"sample\",\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"id\":\"billable_metric_id_78\",\"name\":\"sample\"}],\"pagination_meta\":{\"page\":-123456789,\"per_page\":-123456789,\"total_items\":-9007199254740993,\"total_pages\":123456789}}");
        mock.client.metrics().list();
        assertEquals(List.of("GET /api/v1/metrics"), mock.requests);
    }

    @Test
    void create() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"aggregation_type\":\"LATEST\",\"code\":\"sample\",\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"id\":\"billable_metric_id_40\",\"name\":\"sample\",\"product_family_id\":\"product_family_id_90\"}");
        mock.client
                .metrics()
                .create(
                        PerseidMock.decode(
                                com.meteroid.models.CreateMetricRequest.class,
                                "{\"aggregation_type\":\"LATEST\",\"code\":\"sample\",\"name\":\"sample\",\"product_family_id\":\"product_family_id_13\"}"));
        assertEquals(List.of("POST /api/v1/metrics"), mock.requests);
    }

    @Test
    void retrieve() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"aggregation_type\":\"LATEST\",\"code\":\"sample\",\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"id\":\"billable_metric_id_40\",\"name\":\"sample\",\"product_family_id\":\"product_family_id_90\"}");
        mock.client.metrics().retrieve("metric_id");
        assertEquals(List.of("GET /api/v1/metrics/metric_id"), mock.requests);
    }

    @Test
    void update() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"aggregation_type\":\"LATEST\",\"code\":\"sample\",\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"id\":\"billable_metric_id_40\",\"name\":\"sample\",\"product_family_id\":\"product_family_id_90\"}");
        mock.client
                .metrics()
                .update(
                        "metric_id",
                        PerseidMock.decode(com.meteroid.models.UpdateMetricRequest.class, "{}"));
        assertEquals(List.of("PATCH /api/v1/metrics/metric_id"), mock.requests);
    }

    @Test
    void archive() throws Exception {
        PerseidMock mock = new PerseidMock(204, null, "");
        mock.client.metrics().archive("metric_id");
        assertEquals(List.of("POST /api/v1/metrics/metric_id/archive"), mock.requests);
    }

    @Test
    void unarchive() throws Exception {
        PerseidMock mock = new PerseidMock(204, null, "");
        mock.client.metrics().unarchive("metric_id");
        assertEquals(List.of("POST /api/v1/metrics/metric_id/unarchive"), mock.requests);
    }
}
