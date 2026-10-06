// this file is @generated
package com.meteroid.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

class ConnectTest {

    @Test
    void listConnectedAccounts() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"data\":[{\"connection_type\":\"standard\",\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"id\":\"connected_account_id_67\",\"onboarding_mode\":\"full\",\"platform_organization_id\":\"organization_id_23\",\"status\":\"active\"}]}");
        mock.client.connect().listConnectedAccounts();
        assertEquals(List.of("GET /api/v1/connected-accounts"), mock.requests);
    }

    @Test
    void createConnectedAccount() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"connection_type\":\"express\",\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"id\":\"connected_account_id_47\",\"onboarding_mode\":\"express\",\"platform_organization_id\":\"organization_id_83\",\"status\":\"active\"}");
        mock.client
                .connect()
                .createConnectedAccount(
                        PerseidMock.decode(
                                com.meteroid.models.CreateConnectedAccountRequest.class,
                                "{\"connected_organization_id\":\"00000000-0000-0000-0000-000000000000\"}"));
        assertEquals(List.of("POST /api/v1/connected-accounts"), mock.requests);
    }

    @Test
    void retrieveConnectedAccount() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"connection_type\":\"express\",\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"id\":\"connected_account_id_47\",\"onboarding_mode\":\"express\",\"platform_organization_id\":\"organization_id_83\",\"status\":\"active\"}");
        mock.client.connect().retrieveConnectedAccount("id");
        assertEquals(List.of("GET /api/v1/connected-accounts/id"), mock.requests);
    }

    @Test
    void disconnectAccount() throws Exception {
        PerseidMock mock = new PerseidMock(204, null, "");
        mock.client.connect().disconnectAccount("id");
        assertEquals(List.of("DELETE /api/v1/connected-accounts/id"), mock.requests);
    }

    @Test
    void createOnboardingLink() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"expires_at\":\"2023-12-31T23:59:59.999-05:30\",\"url\":\"sample\"}");
        mock.client
                .connect()
                .createOnboardingLink(
                        "id",
                        PerseidMock.decode(
                                com.meteroid.models.CreateOnboardingLinkRequest.class,
                                "{\"redirect_url\":\"sample\"}"));
        assertEquals(List.of("POST /api/v1/connected-accounts/id/onboarding"), mock.requests);
    }
}
