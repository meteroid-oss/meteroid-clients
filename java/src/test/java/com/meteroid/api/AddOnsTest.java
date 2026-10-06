// this file is @generated
package com.meteroid.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

class AddOnsTest {

    @Test
    void list() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"data\":[{\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"id\":\"add_on_id_0\",\"name\":\"sample\",\"price_id\":\"price_id_47\",\"product_id\":\"product_id_67\",\"self_serviceable\":false}],\"pagination_meta\":{\"page\":-123456789,\"per_page\":-123456789,\"total_items\":-9007199254740993,\"total_pages\":123456789}}");
        mock.client.addOns().list();
        assertEquals(List.of("GET /api/v1/addons"), mock.requests);
    }

    @Test
    void create() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"id\":\"add_on_id_90\",\"name\":\"sample\",\"price_id\":\"price_id_99\",\"product_id\":\"product_id_90\",\"self_serviceable\":false}");
        mock.client
                .addOns()
                .create(
                        PerseidMock.decode(
                                com.meteroid.models.CreateAddOnRequest.class,
                                "{\"name\":\"sample\",\"price_id\":\"price_id_44\",\"product_id\":\"product_id_47\"}"));
        assertEquals(List.of("POST /api/v1/addons"), mock.requests);
    }

    @Test
    void retrieve() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"id\":\"add_on_id_90\",\"name\":\"sample\",\"price_id\":\"price_id_99\",\"product_id\":\"product_id_90\",\"self_serviceable\":false}");
        mock.client.addOns().retrieve("addon_id");
        assertEquals(List.of("GET /api/v1/addons/addon_id"), mock.requests);
    }

    @Test
    void update() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"id\":\"add_on_id_90\",\"name\":\"sample\",\"price_id\":\"price_id_99\",\"product_id\":\"product_id_90\",\"self_serviceable\":false}");
        mock.client
                .addOns()
                .update(
                        "addon_id",
                        PerseidMock.decode(com.meteroid.models.UpdateAddOnRequest.class, "{}"));
        assertEquals(List.of("PATCH /api/v1/addons/addon_id"), mock.requests);
    }

    @Test
    void archive() throws Exception {
        PerseidMock mock = new PerseidMock(204, null, "");
        mock.client.addOns().archive("addon_id");
        assertEquals(List.of("POST /api/v1/addons/addon_id/archive"), mock.requests);
    }

    @Test
    void listEntitlements() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"data\":[{\"feature\":{\"code\":\"sample\",\"id\":\"feature_id_53\",\"name\":\"sample\"},\"value\":{\"type\":\"BOOLEAN\",\"enabled\":false}}]}");
        mock.client.addOns().listEntitlements("addon_id");
        assertEquals(List.of("GET /api/v1/addons/addon_id/entitlements"), mock.requests);
    }

    @Test
    void unarchive() throws Exception {
        PerseidMock mock = new PerseidMock(204, null, "");
        mock.client.addOns().unarchive("addon_id");
        assertEquals(List.of("POST /api/v1/addons/addon_id/unarchive"), mock.requests);
    }
}
