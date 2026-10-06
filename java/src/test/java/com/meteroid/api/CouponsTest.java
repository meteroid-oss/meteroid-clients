// this file is @generated
package com.meteroid.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

class CouponsTest {

    @Test
    void list() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"data\":[{\"code\":\"sample\",\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"disabled\":false,\"discount\":{\"type\":\"PERCENTAGE\",\"percentage\":\"sample\"},\"id\":\"coupon_id_25\",\"plan_ids\":[\"plan_id_47\"],\"redemption_count\":-2147483648,\"reusable\":false}],\"pagination_meta\":{\"page\":-123456789,\"per_page\":-123456789,\"total_items\":-9007199254740993,\"total_pages\":123456789}}");
        mock.client.coupons().list();
        assertEquals(List.of("GET /api/v1/coupons"), mock.requests);
    }

    @Test
    void create() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"code\":\"sample\",\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"disabled\":false,\"discount\":{\"type\":\"PERCENTAGE\",\"percentage\":\"sample\"},\"id\":\"coupon_id_40\",\"plan_ids\":[\"plan_id_99\"],\"redemption_count\":-123456789,\"reusable\":false}");
        mock.client
                .coupons()
                .create(
                        PerseidMock.decode(
                                com.meteroid.models.CreateCouponRequest.class,
                                "{\"code\":\"sample\",\"discount\":{\"type\":\"PERCENTAGE\",\"percentage\":\"sample\"}}"));
        assertEquals(List.of("POST /api/v1/coupons"), mock.requests);
    }

    @Test
    void retrieve() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"code\":\"sample\",\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"disabled\":false,\"discount\":{\"type\":\"PERCENTAGE\",\"percentage\":\"sample\"},\"id\":\"coupon_id_40\",\"plan_ids\":[\"plan_id_99\"],\"redemption_count\":-123456789,\"reusable\":false}");
        mock.client.coupons().retrieve("coupon_id");
        assertEquals(List.of("GET /api/v1/coupons/coupon_id"), mock.requests);
    }

    @Test
    void update() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"code\":\"sample\",\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"disabled\":false,\"discount\":{\"type\":\"PERCENTAGE\",\"percentage\":\"sample\"},\"id\":\"coupon_id_40\",\"plan_ids\":[\"plan_id_99\"],\"redemption_count\":-123456789,\"reusable\":false}");
        mock.client
                .coupons()
                .update(
                        "coupon_id",
                        PerseidMock.decode(com.meteroid.models.UpdateCouponRequest.class, "{}"));
        assertEquals(List.of("PATCH /api/v1/coupons/coupon_id"), mock.requests);
    }

    @Test
    void archive() throws Exception {
        PerseidMock mock = new PerseidMock(204, null, "");
        mock.client.coupons().archive("coupon_id");
        assertEquals(List.of("POST /api/v1/coupons/coupon_id/archive"), mock.requests);
    }

    @Test
    void disable() throws Exception {
        PerseidMock mock = new PerseidMock(204, null, "");
        mock.client.coupons().disable("coupon_id");
        assertEquals(List.of("POST /api/v1/coupons/coupon_id/disable"), mock.requests);
    }

    @Test
    void enable() throws Exception {
        PerseidMock mock = new PerseidMock(204, null, "");
        mock.client.coupons().enable("coupon_id");
        assertEquals(List.of("POST /api/v1/coupons/coupon_id/enable"), mock.requests);
    }

    @Test
    void unarchive() throws Exception {
        PerseidMock mock = new PerseidMock(204, null, "");
        mock.client.coupons().unarchive("coupon_id");
        assertEquals(List.of("POST /api/v1/coupons/coupon_id/unarchive"), mock.requests);
    }
}
