// this file is @generated
package com.meteroid.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

class ProductFamiliesTest {

    @Test
    void list() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"data\":[{\"id\":\"product_family_id_9\",\"name\":\"sample\"}],\"pagination_meta\":{\"page\":-123456789,\"per_page\":-123456789,\"total_items\":-9007199254740993,\"total_pages\":123456789}}");
        mock.client.productFamilies().list();
        assertEquals(List.of("GET /api/v1/product_families"), mock.requests);
    }

    @Test
    void create() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"id\":\"product_family_id_35\",\"name\":\"sample\"}");
        mock.client
                .productFamilies()
                .create(
                        PerseidMock.decode(
                                com.meteroid.models.ProductFamilyCreateRequest.class,
                                "{\"name\":\"sample\"}"));
        assertEquals(List.of("POST /api/v1/product_families"), mock.requests);
    }

    @Test
    void retrieve() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"id\":\"product_family_id_35\",\"name\":\"sample\"}");
        mock.client.productFamilies().retrieve("id_or_alias");
        assertEquals(List.of("GET /api/v1/product_families/id_or_alias"), mock.requests);
    }
}
