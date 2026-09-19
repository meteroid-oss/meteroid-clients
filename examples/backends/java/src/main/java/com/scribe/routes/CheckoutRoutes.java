package com.scribe.routes;

import com.meteroid.models.CheckoutSession;
import com.meteroid.models.CreateCheckoutSessionRequest;
import com.scribe.ApiError;
import com.scribe.AppState;
import com.scribe.Dto;
import com.scribe.ErrorCode;
import com.scribe.Routes;
import com.scribe.SessionToken;
import com.scribe.Upstream;

import io.javalin.http.Context;

/** {@code POST /api/checkout} — start a hosted Meteroid checkout for a plan. */
public final class CheckoutRoutes {

    private CheckoutRoutes() {}

    /**
     * Used both for the first subscription and for upgrades — Meteroid decides which by looking at
     * what the customer already has, and reports it back as {@code checkout_type}.
     */
    public static void createCheckout(Context ctx, AppState state) {
        String alias = SessionToken.requireCustomerAlias(ctx, state.config);
        Dto.CreateCheckoutRequest request = Routes.jsonBody(ctx, Dto.CreateCheckoutRequest.class);
        if (request.planCode() == null) {
            throw ApiError.badRequest("plan_code is required and must be one of free, pro, scale.");
        }
        String couponCode =
                request.couponCode() == null
                        ? null
                        : Routes.bounded("coupon_code", request.couponCode(), 64);

        // Which plan version to check out against comes from the seeded catalog; if the plan is
        // missing this fails with CATALOG_NOT_SEEDED naming the plan.
        Dto.Plan plan = state.catalog().plan(request.planCode());

        CreateCheckoutSessionRequest checkoutRequest =
                new CreateCheckoutSessionRequest()
                        // `customer_id` takes a Meteroid id *or* an external alias.
                        .customerId(alias)
                        .planVersionId(plan.planVersionId())
                        .couponCode(couponCode);

        CheckoutSession checkout =
                Upstream.call(
                                "POST /api/v1/checkout-sessions",
                                () ->
                                        state.meteroid
                                                .getCheckoutSessions()
                                                .createCheckoutSession(checkoutRequest))
                        .getSession();

        // Meteroid may legitimately return a session with no hosted URL (non-self-serve checkout
        // types). That is unusable for this demo, so it becomes an explicit error rather than a
        // null the frontend has to guess about.
        if (checkout.getCheckoutUrl() == null) {
            throw new ApiError(
                    ErrorCode.CHECKOUT_UNAVAILABLE,
                    "Meteroid returned a checkout session without a hosted URL (checkout_type="
                            + checkout.getCheckoutType().getValue()
                            + ").");
        }

        Routes.created(
                ctx,
                new Dto.CreateCheckoutResponse(
                        checkout.getCheckoutUrl(),
                        checkout.getId(),
                        request.planCode(),
                        checkout.getPlanVersionId(),
                        Dto.timestamp(checkout.getExpiresAt())));
    }
}
