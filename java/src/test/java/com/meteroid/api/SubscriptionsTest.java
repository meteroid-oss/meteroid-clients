// this file is @generated
package com.meteroid.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

class SubscriptionsTest {

    @Test
    void list() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"data\":[{\"auto_advance_invoices\":false,\"billing_day_anchor\":2147483647,\"charge_automatically\":false,\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"currency\":\"CNY\",\"current_period_start\":\"1999-12-31\",\"custom_properties\":{\"key\":\"value\",\"count\":3,\"ratio\":0.5,\"flags\":[true,false],\"nested\":{\"ok\":true}},\"customer_id\":\"customer_id_27\",\"customer_name\":\"sample\",\"id\":\"subscription_id_21\",\"mrr_cents\":9007199254740993,\"net_terms\":-2147483648,\"period\":\"MONTHLY\",\"plan_id\":\"plan_id_67\",\"plan_name\":\"sample\",\"plan_version\":123456789,\"plan_version_id\":\"plan_version_id_13\",\"start_date\":\"2024-02-29\",\"status\":\"TRIAL_ACTIVE\"}],\"pagination_meta\":{\"page\":-123456789,\"per_page\":-123456789,\"total_items\":-9007199254740993,\"total_pages\":123456789}}");
        mock.client.subscriptions().list();
        assertEquals(List.of("GET /api/v1/subscriptions"), mock.requests);
    }

    @Test
    void create() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"add_ons\":[{\"fee\":{\"type\":\"RATE\",\"rate\":\"12345.6789\"},\"name\":\"sample\",\"period\":\"SEMIANNUAL\",\"quantity\":123456789}],\"applied_coupons\":[{\"applied_coupon\":{\"coupon_id\":\"coupon_id_87\",\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"id\":\"applied_coupon_id_76\",\"is_active\":true},\"coupon\":{\"code\":\"sample\",\"description\":\"sample\",\"disabled\":true,\"discount\":{\"type\":\"PERCENTAGE\",\"percentage\":\"sample\"},\"id\":\"coupon_id_36\",\"reusable\":false}}],\"auto_advance_invoices\":true,\"billing_day_anchor\":-2147483648,\"charge_automatically\":false,\"components\":[{\"fee\":{\"type\":\"RATE\",\"rate\":\"12345.6789\"},\"name\":\"sample\",\"period\":\"MONTHLY\"}],\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"currency\":\"JOD\",\"current_period_start\":\"1999-12-31\",\"custom_properties\":{\"key\":\"value\",\"count\":3,\"ratio\":0.5,\"flags\":[true,false],\"nested\":{\"ok\":true}},\"customer_id\":\"customer_id_7\",\"customer_name\":\"sample\",\"id\":\"subscription_id_84\",\"mrr_cents\":9007199254740993,\"net_terms\":123456789,\"period\":\"ANNUAL\",\"plan_id\":\"plan_id_80\",\"plan_name\":\"sample\",\"plan_version\":2147483647,\"plan_version_id\":\"plan_version_id_38\",\"start_date\":\"1999-12-31\",\"status\":\"PENDING_ACTIVATION\"}");
        mock.client
                .subscriptions()
                .create(
                        PerseidMock.decode(
                                com.meteroid.models.SubscriptionCreateRequest.class,
                                "{\"activation_condition\":\"ON_CHECKOUT\",\"customer_id_or_alias\":\"sample\",\"plan_id\":\"plan_id_31\",\"start_date\":\"2024-02-29\"}"));
        assertEquals(List.of("POST /api/v1/subscriptions"), mock.requests);
    }

    @Test
    void retrieve() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"add_ons\":[{\"fee\":{\"type\":\"RATE\",\"rate\":\"12345.6789\"},\"name\":\"sample\",\"period\":\"SEMIANNUAL\",\"quantity\":123456789}],\"applied_coupons\":[{\"applied_coupon\":{\"coupon_id\":\"coupon_id_87\",\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"id\":\"applied_coupon_id_76\",\"is_active\":true},\"coupon\":{\"code\":\"sample\",\"description\":\"sample\",\"disabled\":true,\"discount\":{\"type\":\"PERCENTAGE\",\"percentage\":\"sample\"},\"id\":\"coupon_id_36\",\"reusable\":false}}],\"auto_advance_invoices\":true,\"billing_day_anchor\":-2147483648,\"charge_automatically\":false,\"components\":[{\"fee\":{\"type\":\"RATE\",\"rate\":\"12345.6789\"},\"name\":\"sample\",\"period\":\"MONTHLY\"}],\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"currency\":\"JOD\",\"current_period_start\":\"1999-12-31\",\"custom_properties\":{\"key\":\"value\",\"count\":3,\"ratio\":0.5,\"flags\":[true,false],\"nested\":{\"ok\":true}},\"customer_id\":\"customer_id_7\",\"customer_name\":\"sample\",\"id\":\"subscription_id_84\",\"mrr_cents\":9007199254740993,\"net_terms\":123456789,\"period\":\"ANNUAL\",\"plan_id\":\"plan_id_80\",\"plan_name\":\"sample\",\"plan_version\":2147483647,\"plan_version_id\":\"plan_version_id_38\",\"start_date\":\"1999-12-31\",\"status\":\"PENDING_ACTIVATION\"}");
        mock.client.subscriptions().retrieve("subscription_id");
        assertEquals(List.of("GET /api/v1/subscriptions/subscription_id"), mock.requests);
    }

    @Test
    void update() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"subscription\":{\"add_ons\":[{\"fee\":{\"type\":\"RATE\",\"rate\":\"12345.6789\"},\"name\":\"sample\",\"period\":\"ANNUAL\",\"quantity\":2147483647}],\"applied_coupons\":[{\"applied_coupon\":{\"coupon_id\":\"coupon_id_24\",\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"id\":\"applied_coupon_id_73\",\"is_active\":true},\"coupon\":{\"code\":\"sample\",\"description\":\"sample\",\"disabled\":true,\"discount\":{\"type\":\"PERCENTAGE\",\"percentage\":\"sample\"},\"id\":\"coupon_id_81\",\"reusable\":true}}],\"auto_advance_invoices\":true,\"billing_day_anchor\":-2147483648,\"charge_automatically\":true,\"components\":[{\"fee\":{\"type\":\"RATE\",\"rate\":\"-0.000123\"},\"name\":\"sample\",\"period\":\"MONTHLY\"}],\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"currency\":\"ARS\",\"current_period_start\":\"1999-12-31\",\"custom_properties\":{\"key\":\"value\",\"count\":3,\"ratio\":0.5,\"flags\":[true,false],\"nested\":{\"ok\":true}},\"customer_id\":\"customer_id_94\",\"customer_name\":\"sample\",\"id\":\"subscription_id_92\",\"mrr_cents\":-9007199254740993,\"net_terms\":123456789,\"period\":\"SEMIANNUAL\",\"plan_id\":\"plan_id_86\",\"plan_name\":\"sample\",\"plan_version\":-2147483648,\"plan_version_id\":\"plan_version_id_16\",\"start_date\":\"2024-02-29\",\"status\":\"ACTIVE\"}}");
        mock.client
                .subscriptions()
                .update(
                        "subscription_id",
                        PerseidMock.decode(
                                com.meteroid.models.SubscriptionUpdateRequest.class, "{}"));
        assertEquals(List.of("PATCH /api/v1/subscriptions/subscription_id"), mock.requests);
    }

    @Test
    void cancel() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"subscription\":{\"auto_advance_invoices\":false,\"billing_day_anchor\":2147483647,\"charge_automatically\":false,\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"currency\":\"CNY\",\"current_period_start\":\"1999-12-31\",\"custom_properties\":{\"key\":\"value\",\"count\":3,\"ratio\":0.5,\"flags\":[true,false],\"nested\":{\"ok\":true}},\"customer_id\":\"customer_id_27\",\"customer_name\":\"sample\",\"id\":\"subscription_id_21\",\"mrr_cents\":9007199254740993,\"net_terms\":-2147483648,\"period\":\"MONTHLY\",\"plan_id\":\"plan_id_67\",\"plan_name\":\"sample\",\"plan_version\":123456789,\"plan_version_id\":\"plan_version_id_13\",\"start_date\":\"2024-02-29\",\"status\":\"TRIAL_ACTIVE\"}}");
        mock.client
                .subscriptions()
                .cancel(
                        "subscription_id",
                        PerseidMock.decode(
                                com.meteroid.models.CancelSubscriptionRequest.class, "{}"));
        assertEquals(List.of("POST /api/v1/subscriptions/subscription_id/cancel"), mock.requests);
    }

    @Test
    void listEntitlements() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"data\":[{\"feature\":{\"code\":\"sample\",\"id\":\"feature_id_53\",\"name\":\"sample\"},\"value\":{\"type\":\"BOOLEAN\",\"enabled\":false}}]}");
        mock.client.subscriptions().listEntitlements("subscription_id");
        assertEquals(
                List.of("GET /api/v1/subscriptions/subscription_id/entitlements"), mock.requests);
    }

    @Test
    void retrieveSummary() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"auto_advance_invoices\":true,\"billing_day_anchor\":-2147483648,\"charge_automatically\":false,\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"currency\":\"NAD\",\"current_period_start\":\"1999-12-31\",\"custom_properties\":{\"key\":\"value\",\"count\":3,\"ratio\":0.5,\"flags\":[true,false],\"nested\":{\"ok\":true}},\"customer_id\":\"customer_id_26\",\"customer_name\":\"sample\",\"id\":\"subscription_id_17\",\"mrr_cents\":-9007199254740993,\"net_terms\":2147483647,\"period\":\"MONTHLY\",\"plan_id\":\"plan_id_81\",\"plan_name\":\"sample\",\"plan_version\":123456789,\"plan_version_id\":\"plan_version_id_41\",\"start_date\":\"2024-02-29\",\"status\":\"TRIAL_EXPIRED\"}");
        mock.client.subscriptions().retrieveSummary("subscription_id");
        assertEquals(List.of("GET /api/v1/subscriptions/subscription_id/summary"), mock.requests);
    }
}
