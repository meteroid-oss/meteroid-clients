// this file is @generated
package com.meteroid.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

class UsageTest {

    @Test
    void retrieveSubscription() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"period_end\":\"1999-12-31\",\"period_start\":\"2024-02-29\",\"usage\":[{\"grouped_usage\":[{\"dimensions\":{\"alpha\":\"sample\"},\"value\":\"12345.6789\"}],\"metric_code\":\"sample\",\"metric_id\":\"billable_metric_id_44\",\"metric_name\":\"sample\",\"total_value\":\"12345.6789\"}]}");
        mock.client.usage().retrieveSubscription("subscription_id");
        assertEquals(List.of("GET /api/v1/usage/subscription/subscription_id"), mock.requests);
    }
}
