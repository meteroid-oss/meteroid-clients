// this file is @generated
package com.meteroid.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

class FeaturesTest {

    @Test
    void list() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"data\":[{\"code\":\"sample\",\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"feature_type\":{\"type\":\"BOOLEAN\"},\"id\":\"feature_id_0\",\"name\":\"sample\",\"status\":\"DISABLED\"}],\"pagination_meta\":{\"page\":-123456789,\"per_page\":-123456789,\"total_items\":-9007199254740993,\"total_pages\":123456789}}");
        mock.client.features().list();
        assertEquals(List.of("GET /api/v1/features"), mock.requests);
    }

    @Test
    void retrieve() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"code\":\"sample\",\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"feature_type\":{\"type\":\"BOOLEAN\"},\"id\":\"feature_id_90\",\"name\":\"sample\",\"status\":\"ARCHIVED\"}");
        mock.client.features().retrieve("id_or_code");
        assertEquals(List.of("GET /api/v1/features/id_or_code"), mock.requests);
    }
}
