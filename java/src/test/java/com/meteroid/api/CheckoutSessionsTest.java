// this file is @generated
package com.meteroid.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

class CheckoutSessionsTest {

    @Test
    void list() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"sessions\":[{\"checkout_type\":\"PLAN_CHANGE\",\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"customer_id\":\"customer_id_47\",\"id\":\"checkout_session_id_39\",\"plan_version_id\":\"plan_version_id_67\",\"status\":\"AWAITING_PAYMENT\"}]}");
        mock.client.checkoutSessions().list();
        assertEquals(List.of("GET /api/v1/checkout-sessions"), mock.requests);
    }

    @Test
    void create() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"session\":{\"checkout_type\":\"PLAN_CHANGE\",\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"customer_id\":\"customer_id_47\",\"id\":\"checkout_session_id_39\",\"plan_version_id\":\"plan_version_id_67\",\"status\":\"AWAITING_PAYMENT\"}}");
        mock.client
                .checkoutSessions()
                .create(
                        PerseidMock.decode(
                                com.meteroid.models.CreateCheckoutSessionRequest.class,
                                "{\"customer_id\":\"sample\",\"plan_version_id\":\"plan_version_id_2\"}"));
        assertEquals(List.of("POST /api/v1/checkout-sessions"), mock.requests);
    }

    @Test
    void retrieve() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"session\":{\"checkout_type\":\"PLAN_CHANGE\",\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"customer_id\":\"customer_id_47\",\"id\":\"checkout_session_id_39\",\"plan_version_id\":\"plan_version_id_67\",\"status\":\"AWAITING_PAYMENT\"}}");
        mock.client.checkoutSessions().retrieve("id");
        assertEquals(List.of("GET /api/v1/checkout-sessions/id"), mock.requests);
    }

    @Test
    void cancel() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"session\":{\"checkout_type\":\"PLAN_CHANGE\",\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"customer_id\":\"customer_id_47\",\"id\":\"checkout_session_id_39\",\"plan_version_id\":\"plan_version_id_67\",\"status\":\"AWAITING_PAYMENT\"}}");
        mock.client.checkoutSessions().cancel("id");
        assertEquals(List.of("POST /api/v1/checkout-sessions/id/cancel"), mock.requests);
    }
}
