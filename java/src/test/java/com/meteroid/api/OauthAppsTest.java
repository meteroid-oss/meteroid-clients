// this file is @generated
package com.meteroid.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

class OauthAppsTest {

    @Test
    void list() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"data\":[{\"client_id\":\"sample\",\"client_secret_hint\":\"sample\",\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"id\":\"o_auth_app_id_90\",\"is_active\":false,\"name\":\"sample\",\"organization_id\":\"organization_id_78\",\"redirect_uris\":[\"sample\"],\"scopes\":[\"sample\"]}]}");
        mock.client.oauthApps().list();
        assertEquals(List.of("GET /api/v1/oauth-apps"), mock.requests);
    }

    @Test
    void create() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"app\":{\"client_id\":\"sample\",\"client_secret_hint\":\"sample\",\"created_at\":\"2024-03-15T10:30:45.123+02:00\",\"id\":\"o_auth_app_id_90\",\"is_active\":false,\"name\":\"sample\",\"organization_id\":\"organization_id_78\",\"redirect_uris\":[\"sample\"],\"scopes\":[\"sample\"]},\"client_secret\":\"sample\"}");
        mock.client
                .oauthApps()
                .create(
                        PerseidMock.decode(
                                com.meteroid.models.CreateOAuthAppRequest.class,
                                "{\"name\":\"sample\",\"redirect_uris\":[\"sample\"]}"));
        assertEquals(List.of("POST /api/v1/oauth-apps"), mock.requests);
    }

    @Test
    void retrieve() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"client_id\":\"sample\",\"client_secret_hint\":\"sample\",\"created_at\":\"2023-12-31T23:59:59.999-05:30\",\"id\":\"o_auth_app_id_44\",\"is_active\":false,\"name\":\"sample\",\"organization_id\":\"organization_id_13\",\"redirect_uris\":[\"sample\"],\"scopes\":[\"sample\"]}");
        mock.client.oauthApps().retrieve("id");
        assertEquals(List.of("GET /api/v1/oauth-apps/id"), mock.requests);
    }

    @Test
    void delete() throws Exception {
        PerseidMock mock = new PerseidMock(204, null, "");
        mock.client.oauthApps().delete("id");
        assertEquals(List.of("DELETE /api/v1/oauth-apps/id"), mock.requests);
    }

    @Test
    void rotate() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"client_secret\":\"sample\",\"client_secret_hint\":\"sample\"}");
        mock.client.oauthApps().rotate("id");
        assertEquals(List.of("POST /api/v1/oauth-apps/id/rotate"), mock.requests);
    }
}
