// this file is @generated
package com.meteroid.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

class OauthTest {

    @Test
    void introspect() throws Exception {
        PerseidMock mock = new PerseidMock(200, "application/json", "{\"active\":false}");
        mock.client
                .oauth()
                .introspect(
                        PerseidMock.decode(
                                com.meteroid.models.IntrospectionRequest.class,
                                "{\"token\":\"sample\"}"));
        assertEquals(List.of("POST /api/v1/oauth/introspect"), mock.requests);
    }

    @Test
    void revoke() throws Exception {
        PerseidMock mock = new PerseidMock(204, null, "");
        mock.client
                .oauth()
                .revoke(
                        PerseidMock.decode(
                                com.meteroid.models.RevocationRequest.class,
                                "{\"token\":\"sample\"}"));
        assertEquals(List.of("POST /api/v1/oauth/revoke"), mock.requests);
    }

    @Test
    void token() throws Exception {
        PerseidMock mock =
                new PerseidMock(
                        200,
                        "application/json",
                        "{\"access_token\":\"sample\",\"expires_in\":9007199254740993,\"token_type\":\"sample\"}");
        mock.client
                .oauth()
                .token(
                        PerseidMock.decode(
                                com.meteroid.models.TokenRequest.class,
                                "{\"grant_type\":\"sample\"}"));
        assertEquals(List.of("POST /api/v1/oauth/token"), mock.requests);
    }
}
