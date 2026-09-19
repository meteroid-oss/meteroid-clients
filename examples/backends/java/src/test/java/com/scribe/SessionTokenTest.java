package com.scribe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

class SessionTokenTest {

    @Test
    void roundTripsAnAlias() {
        String token = SessionToken.mint("s3cret", "scribe-demo-8f2a1c");
        assertEquals("scribe-demo-8f2a1c", SessionToken.verify("s3cret", token));
    }

    @Test
    void rejectsAnotherDeploymentsSecret() {
        String token = SessionToken.mint("s3cret", "scribe-demo-8f2a1c");
        assertThrows(ApiError.class, () -> SessionToken.verify("other", token));
    }

    @Test
    void rejectsATamperedPayload() {
        String token = SessionToken.mint("s3cret", "scribe-demo-8f2a1c");
        String signature = token.substring(token.lastIndexOf('.') + 1);
        String forged =
                "v1."
                        + Base64.getUrlEncoder()
                                .withoutPadding()
                                .encodeToString("someone-else".getBytes(StandardCharsets.UTF_8))
                        + "."
                        + signature;
        assertThrows(ApiError.class, () -> SessionToken.verify("s3cret", forged));
    }

    @Test
    void rejectsAMalformedToken() {
        assertThrows(ApiError.class, () -> SessionToken.verify("s3cret", "not-a-token"));
        assertThrows(ApiError.class, () -> SessionToken.verify("s3cret", "v2.a.b"));
    }

    /**
     * The whole point of the HMAC scheme: Rust and Java mint interchangeable tokens, so one
     * contract-suite session works against every backend. This asserts the exact wire format the
     * contract documents.
     */
    @Test
    void mintsTheWireFormatTheContractDocuments() {
        String token = SessionToken.mint("s3cret", "scribe-demo-8f2a1c");
        String[] parts = token.split("\\.");
        assertEquals(3, parts.length);
        assertEquals("v1", parts[0]);
        assertEquals(
                "scribe-demo-8f2a1c",
                new String(Base64.getUrlDecoder().decode(parts[1]), StandardCharsets.UTF_8));
    }
}
