/**
 * The pricing table, and the upgrade path.
 *
 * Every number here comes from Meteroid: `GET /api/plans` resolves each seeded plan to its
 * published version, flattens the price components, and derives the bullet list from the plan
 * version's entitlements — so the marketing page and the enforcement path cannot drift apart.
 *
 * "Upgrade" is a redirect to Meteroid's hosted checkout. The app remembers which plan it sent you
 * to buy, so the return trip can wait for the subscription to land (see `state/app.tsx`).
 */
import { useState } from "react";
import type { ApiError } from "../api/client";
import type { BillingPeriod, Plan, PlanCode, PlanPrice } from "../api/types";
import { ErrorNotice } from "../components/ErrorNotice";
import { formatPrice } from "../lib/format";
import { useApp } from "../state/app";

const CADENCE: Record<BillingPeriod, string> = {
  MONTHLY: "/mo",
  QUARTERLY: "/quarter",
  SEMIANNUAL: "/6 mo",
  ANNUAL: "/yr",
};

/** The number that goes in big type: the recurring fee, if the plan has one. */
function headlinePrice(plan: Plan): PlanPrice | undefined {
  return plan.prices.find(
    (price) => (price.kind === "RATE" || price.kind === "SLOT") && price.amount !== null,
  );
}

/** One line of the small print under a plan — every component, in the order Meteroid returned. */
function priceLine(price: PlanPrice, plan: Plan): string {
  if (price.unit_amount !== null) {
    return `${formatPrice(price.unit_amount, plan.currency)} / ${price.unit_name ?? "unit"}`;
  }
  if (price.amount !== null) {
    return `${formatPrice(price.amount, plan.currency)}${price.cadence ? CADENCE[price.cadence] : ""}`;
  }
  return price.pricing_model ?? price.kind;
}

/** Cheapest-first order, so "is this an upgrade?" is a comparison rather than a rule. */
const LADDER: PlanCode[] = ["free", "pro", "scale"];

export function Plans() {
  const { plans, me, checkout } = useApp();
  const [pending, setPending] = useState<PlanCode | null>(null);
  const [error, setError] = useState<ApiError | null>(null);

  const currentPlan = me.data?.subscription?.plan_code ?? null;

  async function start(planCode: PlanCode) {
    setPending(planCode);
    setError(null);
    try {
      await checkout(planCode);
    } catch (caught) {
      setError(caught as ApiError);
      setPending(null);
    }
  }

  return (
    <>
      <header className="screen-head">
        <h1 className="screen-title">Plans</h1>
        <p className="screen-sub">
          Seeded once in the Meteroid dashboard and read back at request time — the demo never
          creates catalog objects. Checkout is Meteroid&apos;s hosted page; you come back here when
          it finishes.
        </p>
      </header>

      {error && <ErrorNotice error={error} />}
      {plans.error && <ErrorNotice error={plans.error} />}

      {/* `pricing-table` and `checkout-<code>` are the e2e suite's entry points — see
          tests/e2e/support/selectors.ts, where these ids are documented as API. */}
      <div className="plans" data-testid="pricing-table">
        {plans.data.map((plan) => {
          const headline = headlinePrice(plan);
          const isCurrent = currentPlan === plan.code;
          // Only one card gets the loud button: the next step up, or Pro for a new workspace.
          // A downgrade stays available, just not encouraged.
          const isUpgrade = currentPlan
            ? LADDER.indexOf(plan.code) > LADDER.indexOf(currentPlan)
            : plan.code === "pro";

          return (
            <section
              key={plan.code}
              className={`panel plan ${isCurrent ? "plan-current" : ""}`.trim()}
            >
              <div>
                <div className="row">
                  <h2 className="plan-name">{plan.name}</h2>
                  {isCurrent && <span className="chip chip-plan">current</span>}
                </div>
                {plan.description && <p className="panel-note">{plan.description}</p>}
              </div>

              <div className="plan-price">
                <span className="plan-amount">
                  {plan.is_free || !headline?.amount
                    ? "Free"
                    : formatPrice(headline.amount, plan.currency)}
                </span>
                {!plan.is_free && headline?.cadence && (
                  <span className="mute">{CADENCE[headline.cadence]}</span>
                )}
              </div>

              <ul className="plan-features">
                {plan.features.length === 0 ? (
                  <li className="mute">No entitlements on this plan version.</li>
                ) : (
                  plan.features.map((feature) => <li key={feature.feature_code}>{feature.label}</li>)
                )}
              </ul>

              {plan.prices.length > 0 && (
                <div className="plan-lines">
                  {plan.prices.map((price) => (
                    <div key={price.component_id} className="plan-line">
                      <span>{price.name}</span>
                      <span>{priceLine(price, plan)}</span>
                    </div>
                  ))}
                </div>
              )}

              <button
                type="button"
                data-testid={`checkout-${plan.code}`}
                className={`btn ${isUpgrade ? "btn-primary" : ""}`.trim()}
                disabled={isCurrent || pending !== null}
                onClick={() => void start(plan.code)}
              >
                {pending === plan.code && <span className="spin" />}
                {isCurrent
                  ? "Current plan"
                  : !currentPlan
                    ? `Choose ${plan.name}`
                    : isUpgrade
                      ? `Upgrade to ${plan.name}`
                      : `Switch to ${plan.name}`}
              </button>

              <div className="label">
                version {plan.version}
                {plan.trial_days ? ` · ${plan.trial_days}-day trial` : ""}
                {" · "}
                {plan.currency}
              </div>
            </section>
          );
        })}
      </div>

      {!plans.loading && plans.data.length === 0 && !plans.error && (
        <p className="empty">
          No Scribe plans resolved. Seed them in the Meteroid dashboard — examples/CATALOG.md has the
          exact names.
        </p>
      )}
    </>
  );
}
