/**
 * Per-workspace Meteroid lookups shared by several handlers.
 *
 * A "workspace" is one Meteroid **customer**. The demo addresses it everywhere by its
 * *alias* (`scribe-demo-…`), never by the Meteroid id: every Meteroid endpoint the demo
 * touches accepts an id or an alias, which is the point being demonstrated — you can
 * drive Meteroid entirely from your own identifiers.
 */

import { type Customer, type Subscription, SubscriptionStatusEnum } from "@meteroid/sdk";

import { nextUp, type PlanCode, type Workspace } from "./dto.js";
import { upstream } from "./error.js";
import type { AppState } from "./state.js";

/** Statuses that count as "the subscription this workspace is living on right now". */
const LIVE_STATUSES: readonly SubscriptionStatusEnum[] = [
  SubscriptionStatusEnum.Active,
  SubscriptionStatusEnum.TrialActive,
];

export function loadCustomer(state: AppState, alias: string): Promise<Customer> {
  return state.meteroid.customers
    .getCustomer(alias)
    .catch(upstream(`GET /api/v1/customers/${alias}`));
}

/**
 * The workspace's most relevant subscription, or `null` if it has never checked out.
 *
 * The contract pins the rule down so every backend picks the same one: ask Meteroid for
 * the customer's subscriptions newest-first, take the first `ACTIVE` or `TRIAL_ACTIVE`
 * one, and otherwise the most recently created regardless of status.
 */
export async function currentSubscription(
  state: AppState,
  alias: string,
): Promise<Subscription | null> {
  // `customerId` accepts a Meteroid id *or* an external alias, so no id lookup first.
  const response = await state.meteroid.subscriptions
    .listSubscriptions({ customerId: alias, orderBy: "created_at.desc", perPage: 100 })
    .catch(upstream("GET /api/v1/subscriptions"));

  const subscriptions = response.data;
  return (
    subscriptions.find((subscription) => LIVE_STATUSES.includes(subscription.status)) ??
    subscriptions[0] ??
    null
  );
}

/**
 * Project a Meteroid customer onto the contract's `Workspace`.
 *
 * Note there is no `created_at`: Meteroid's `Customer` carries no creation timestamp,
 * so the contract does not pretend it does.
 */
export function toWorkspace(customer: Customer, fallbackAlias: string): Workspace {
  const alias = customer.alias ?? fallbackAlias;

  return {
    id: alias,
    name: customer.name,
    customer_id: customer.id,
    customer_alias: alias,
    currency: customer.currency,
  };
}

/**
 * The plan to offer when a workspace hits a wall (`402` / `403`).
 *
 * One plan up from where it is now: `pro` for an unsubscribed workspace or one on a
 * plan outside the Scribe catalog, `scale` for a `pro` workspace, and `null` on `scale`
 * — there is nothing left to sell. Never throws: this decorates an error response, and
 * a failed lookup here must not replace the error the caller actually hit.
 */
export async function upgradeTarget(state: AppState, alias: string): Promise<PlanCode | null> {
  const subscription = await currentSubscription(state, alias).catch(() => null);
  if (subscription === null) {
    return "pro";
  }

  try {
    const catalog = await state.catalog();
    const current = catalog.planCodeFor(subscription.planId, subscription.planName);
    return current === null ? "pro" : nextUp(current);
  } catch {
    return null;
  }
}
