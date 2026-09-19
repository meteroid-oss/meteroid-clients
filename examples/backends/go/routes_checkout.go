package main

import (
	"context"

	meteroid "github.com/meteroid-oss/meteroid-clients/go"
)

// createCheckout is `POST /api/checkout` — start a hosted Meteroid checkout for a plan.
//
// Used both for the first subscription and for upgrades — Meteroid decides which by
// looking at what the customer already has, and reports it back as CheckoutType.
func (a *app) createCheckout(ctx context.Context, r *request) (*reply, error) {
	session, err := a.requireSession(r)
	if err != nil {
		return nil, err
	}
	body, err := jsonBody(r, decodeCreateCheckoutRequest)
	if err != nil {
		return nil, err
	}
	couponCode := body.CouponCode
	if couponCode != nil {
		trimmed, err := bounded("coupon_code", *couponCode, 64)
		if err != nil {
			return nil, err
		}
		couponCode = &trimmed
	}

	// Which plan version to check out against comes from the seeded catalog; if the plan
	// is missing this fails with CATALOG_NOT_SEEDED naming the plan.
	catalog, err := a.catalog(ctx)
	if err != nil {
		return nil, err
	}
	plan, err := catalog.plan(body.PlanCode)
	if err != nil {
		return nil, err
	}

	response, err := a.meteroid.CheckoutSessions().CreateCheckoutSession(ctx, meteroid.CreateCheckoutSessionRequest{
		// CustomerId takes a Meteroid id *or* an external alias.
		CustomerId:    session.customerAlias,
		PlanVersionId: plan.PlanVersionID,
		CouponCode:    couponCode,
	})
	if err != nil {
		return nil, upstream("POST /api/v1/checkout-sessions", err)
	}
	checkout := response.Session

	// Meteroid may legitimately return a session with no hosted URL (non-self-serve
	// checkout types). That is unusable for this demo, so it becomes an explicit error
	// rather than a null the frontend has to guess about.
	if checkout.CheckoutUrl == nil {
		return nil, newAPIError(codeCheckoutUnavailable,
			"Meteroid returned a checkout session without a hosted URL (checkout_type=%s).", checkout.CheckoutType)
	}

	return replyCreated(CreateCheckoutResponse{
		CheckoutURL:       *checkout.CheckoutUrl,
		CheckoutSessionID: checkout.Id,
		PlanCode:          body.PlanCode,
		PlanVersionID:     checkout.PlanVersionId,
		ExpiresAt:         timestampOpt(checkout.ExpiresAt),
	})
}
