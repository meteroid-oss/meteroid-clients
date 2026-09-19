package com.scribe.routes;

import com.meteroid.models.CustomerPortalTokenRequest;
import com.meteroid.models.CustomerPortalTokenResponse;
import com.scribe.ApiError;
import com.scribe.AppState;
import com.scribe.Dto;
import com.scribe.Routes;
import com.scribe.SessionToken;
import com.scribe.Upstream;

import io.javalin.http.Context;

/** {@code POST /api/portal-session} — mint a Meteroid customer-portal token. */
public final class PortalRoutes {

    private PortalRoutes() {}

    /** Meteroid's default lifetime, in seconds. */
    private static final int DEFAULT_EXPIRY = 86_400;

    private static final int MIN_EXPIRY = 60;
    private static final int MAX_EXPIRY = 2_592_000;

    private static final Dto.CreatePortalSessionRequest NO_BODY =
            new Dto.CreatePortalSessionRequest(null);

    /**
     * The portal is where the visitor manages their payment method and downloads invoices, so the
     * demo does not have to implement any of it. The frontend opens {@code portal_url} with the
     * {@code token}.
     */
    public static void createPortalSession(Context ctx, AppState state) {
        String alias = SessionToken.requireCustomerAlias(ctx, state.config);
        Dto.CreatePortalSessionRequest request =
                Routes.optionalJsonBody(ctx, Dto.CreatePortalSessionRequest.class, NO_BODY);

        // Meteroid documents 60..2592000 but types the field as a plain int32, so the range is
        // validated here rather than forwarding a value Meteroid would reject.
        int expiresInSeconds =
                request.expiresInSeconds() == null ? DEFAULT_EXPIRY : request.expiresInSeconds();
        if (expiresInSeconds < MIN_EXPIRY || expiresInSeconds > MAX_EXPIRY) {
            throw ApiError.badRequest(
                    "expires_in_seconds must be between " + MIN_EXPIRY + " and " + MAX_EXPIRY + ".");
        }

        CustomerPortalTokenResponse portal =
                Upstream.call(
                        "POST /api/v1/customers/" + alias + "/portal-token",
                        () ->
                                state.meteroid
                                        .getCustomers()
                                        .createPortalToken(
                                                alias,
                                                new CustomerPortalTokenRequest()
                                                        .expiresInSeconds(expiresInSeconds)));

        Routes.created(
                ctx,
                new Dto.CreatePortalSessionResponse(
                        portal.getPortalUrl(),
                        portal.getToken(),
                        // Meteroid returns only `{ token, portal_url }`, so this echoes what was
                        // asked for rather than pretending to read it back out of the JWT.
                        expiresInSeconds));
    }
}
