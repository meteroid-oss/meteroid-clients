// this file is @generated
package com.meteroid.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

class CustomPropertiesTest {

    @Test
    void listCustomPropertyDefinitions() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"data\":[{\"archived\":false,\"config\":{},\"display_order\":-2147483648,\"entity_type\":\"CUSTOMER\",\"id\":\"custom_property_definition_id_78\",\"key\":\"sample\",\"name\":\"sample\",\"property_type\":\"JSON\",\"required\":false}],\"pagination_meta\":{\"page\":-123456789,\"per_page\":-123456789,\"total_items\":-9007199254740993,\"total_pages\":123456789}}");
        mock.client.customProperties().listCustomPropertyDefinitions();
        assertEquals(List.of("GET /api/v1/custom-property-definitions"), mock.requests);
    }

    @Test
    void createCustomPropertyDefinition() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"archived\":false,\"config\":{},\"display_order\":-2147483648,\"entity_type\":\"INVOICE\",\"id\":\"custom_property_definition_id_13\",\"key\":\"sample\",\"name\":\"sample\",\"property_type\":\"TEXT\",\"required\":false}");
        mock.client
                .customProperties()
                .createCustomPropertyDefinition(
                        PerseidMock.decode(
                                com.meteroid.models.CustomPropertyDefinitionCreateRequest.class,
                                "{\"entity_type\":\"CREDIT_NOTE\",\"key\":\"sample\",\"name\":\"sample\",\"property_type\":\"TEXT\"}"));
        assertEquals(List.of("POST /api/v1/custom-property-definitions"), mock.requests);
    }

    @Test
    void retrieveCustomPropertyDefinition() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"archived\":false,\"config\":{},\"display_order\":-2147483648,\"entity_type\":\"INVOICE\",\"id\":\"custom_property_definition_id_13\",\"key\":\"sample\",\"name\":\"sample\",\"property_type\":\"TEXT\",\"required\":false}");
        mock.client.customProperties().retrieveCustomPropertyDefinition("id");
        assertEquals(List.of("GET /api/v1/custom-property-definitions/id"), mock.requests);
    }

    @Test
    void updateCustomPropertyDefinition() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"archived\":false,\"config\":{},\"display_order\":-2147483648,\"entity_type\":\"INVOICE\",\"id\":\"custom_property_definition_id_13\",\"key\":\"sample\",\"name\":\"sample\",\"property_type\":\"TEXT\",\"required\":false}");
        mock.client
                .customProperties()
                .updateCustomPropertyDefinition(
                        "id",
                        PerseidMock.decode(
                                com.meteroid.models.CustomPropertyDefinitionUpdateRequest.class,
                                "{}"));
        assertEquals(List.of("PUT /api/v1/custom-property-definitions/id"), mock.requests);
    }

    @Test
    void archiveDefinition() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"archived\":false,\"config\":{},\"display_order\":-2147483648,\"entity_type\":\"INVOICE\",\"id\":\"custom_property_definition_id_13\",\"key\":\"sample\",\"name\":\"sample\",\"property_type\":\"TEXT\",\"required\":false}");
        mock.client.customProperties().archiveDefinition("id");
        assertEquals(List.of("DELETE /api/v1/custom-property-definitions/id"), mock.requests);
    }
}
