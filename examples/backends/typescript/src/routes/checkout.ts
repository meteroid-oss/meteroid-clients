/** `POST /api/checkout` — start a hosted Meteroid checkout for a plan. */

import {
  type CreateCheckoutResponse,
  decodeCreateCheckoutRequest,
  timestampOpt,
} from "../dto.js";
import { ApiError, upstream } from "../error.js";
import { created, type Reply, type ScribeRequest } from "../http.js";
import { requireSession } from "../session.js";
import type { AppState } from "../state.js";
import { bounded, jsonBody } from "./index.js";

/**
 * Used both for the first subscription and for upgrades — Meteroid decides which by
 * looking at what the customer already has, and reports it back as `checkoutType`.
 */
export async function createCheckout(
  state: AppState,
  request: ScribeRequest,
): Promise<Reply<CreateCheckoutResponse>> {
  const session = requireSession(state, request);
  const body = jsonBody(request, decodeCreateCheckoutRequest);
  const couponCode = body.coupon_code === null ? null : bounded("coupon_code", body.coupon_code, 64);

  // Which plan version to check out against comes from the seeded catalog; if the plan
  // is missing this fails with CATALOG_NOT_SEEDED naming the plan.
  const catalog = await state.catalog();
  const plan = catalog.plan(body.plan_code);

  const response = await state.meteroid.checkoutSessions
    .createCheckoutSession({
      // `customerId` takes a Meteroid id *or* an external alias.
      customerId: session.customerAlias,
      planVersionId: plan.plan_version_id,
      couponCode,
    })
    .catch(upstream("POST /api/v1/checkout-sessions"));

  const checkout = response.session;

  // Meteroid may legitimately return a session with no hosted URL (non-self-serve
  // checkout types). That is unusable for this demo, so it becomes an explicit error
  // rather than a null the frontend has to guess about.
  if (checkout.checkoutUrl == null) {
    throw new ApiError(
      "CHECKOUT_UNAVAILABLE",
      "Meteroid returned a checkout session without a hosted URL " +
        `(checkout_type=${checkout.checkoutType}).`,
    );
  }

  return created({
    checkout_url: checkout.checkoutUrl,
    checkout_session_id: checkout.id,
    plan_code: body.plan_code,
    plan_version_id: checkout.planVersionId,
    expires_at: timestampOpt(checkout.expiresAt),
  });
}
