// this file is @generated
package com.meteroid.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

class ProductsTest {

    @Test
    void list() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"data\":[{\"catalog\":false,\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"fee_structure\":{\"type\":\"RATE\"},\"fee_type\":\"CAPACITY\",\"id\":\"product_id_78\",\"name\":\"sample\",\"product_family_id\":\"product_family_id_47\"}],\"pagination_meta\":{\"page\":-123456789,\"per_page\":-123456789,\"total_items\":-9007199254740993,\"total_pages\":123456789}}");
        mock.client.products().list();
        assertEquals(List.of("GET /api/v1/products"), mock.requests);
    }

    @Test
    void create() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"catalog\":true,\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"fee_structure\":{\"type\":\"RATE\"},\"fee_type\":\"RATE\",\"id\":\"product_id_13\",\"name\":\"sample\",\"product_family_id\":\"product_family_id_99\"}");
        mock.client
                .products()
                .create(
                        PerseidMock.decode(
                                com.meteroid.models.CreateProductRequest.class,
                                "{\"fee_structure\":{\"type\":\"RATE\"},\"name\":\"sample\",\"product_family_id\":\"product_family_id_47\"}"));
        assertEquals(List.of("POST /api/v1/products"), mock.requests);
    }

    @Test
    void retrieve() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"catalog\":true,\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"fee_structure\":{\"type\":\"RATE\"},\"fee_type\":\"RATE\",\"id\":\"product_id_13\",\"name\":\"sample\",\"product_family_id\":\"product_family_id_99\"}");
        mock.client.products().retrieve("product_id");
        assertEquals(List.of("GET /api/v1/products/product_id"), mock.requests);
    }

    @Test
    void update() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"catalog\":true,\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"fee_structure\":{\"type\":\"RATE\"},\"fee_type\":\"RATE\",\"id\":\"product_id_13\",\"name\":\"sample\",\"product_family_id\":\"product_family_id_99\"}");
        mock.client
                .products()
                .update(
                        "product_id",
                        PerseidMock.decode(com.meteroid.models.UpdateProductRequest.class, "{}"));
        assertEquals(List.of("PATCH /api/v1/products/product_id"), mock.requests);
    }

    @Test
    void archive() throws Exception {
        PerseidMock mock = new PerseidMock(204, null, "");
        mock.client.products().archive("product_id");
        assertEquals(List.of("POST /api/v1/products/product_id/archive"), mock.requests);
    }

    @Test
    void listEntitlements() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"data\":[{\"feature\":{\"code\":\"sample\",\"id\":\"feature_id_53\",\"name\":\"sample\"},\"value\":{\"type\":\"BOOLEAN\",\"enabled\":false}}]}");
        mock.client.products().listEntitlements("product_id");
        assertEquals(List.of("GET /api/v1/products/product_id/entitlements"), mock.requests);
    }

    @Test
    void unarchive() throws Exception {
        PerseidMock mock = new PerseidMock(204, null, "");
        mock.client.products().unarchive("product_id");
        assertEquals(List.of("POST /api/v1/products/product_id/unarchive"), mock.requests);
    }
}
