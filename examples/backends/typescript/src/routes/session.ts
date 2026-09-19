/** `POST /api/session` and `GET /api/me` — the demo workspace and what it is subscribed to. */

import { randomUUID } from "node:crypto";

import type { Subscription as SdkSubscription } from "@meteroid/sdk";

import {
  type CreateSessionResponse,
  decodeCreateSessionRequest,
  type MeResponse,
  type Plan,
  type PlanCode,
  type Subscription,
  timestamp,
} from "../dto.js";
import { upstream } from "../error.js";
import { created, ok, type Reply, type ScribeRequest } from "../http.js";
import { mint, requireSession } from "../session.js";
import type { AppState } from "../state.js";
import { currentSubscription, loadCustomer, toWorkspace } from "../workspace.js";
import { bounded, optionalJsonBody } from "./index.js";

/**
 * Create a brand-new Meteroid customer and hand back a session token bound to it.
 *
 * This is the only object the demo ever creates in Meteroid. The catalog is seeded
 * once, by hand (`examples/CATALOG.md`); customers are per demo run and disposable.
 */
export async function createSession(
  state: AppState,
  request: ScribeRequest,
): Promise<Reply<CreateSessionResponse>> {
  const body = optionalJsonBody(request, decodeCreateSessionRequest);

  // A short random alias is the workspace's identity everywhere: it is what the
  // session token carries, what ingested events reference, and what every `idOrAlias`
  // parameter below receives.
  const alias = `scribe-demo-${randomUUID().replaceAll("-", "")}`;
  const name =
    body.workspace_name === null
      ? "Scribe demo workspace"
      : bounded("workspace_name", body.workspace_name, 120);
  const email =
    body.email === null ? `${alias}@example.invalid` : bounded("email", body.email, 254);

  const customer = await state.meteroid.customers
    .createCustomer({
      alias,
      // Meteroid requires all four of these. The currency must match the seeded plans'
      // currency or checkout will refuse the plan version later on.
      currency: state.config.defaultCurrency,
      customTaxes: [],
      invoicingEmails: [email],
      name,
    })
    .catch(upstream("POST /api/v1/customers"));

  return created({
    session_token: mint(state.config.sessionSecret, alias),
    workspace: toWorkspace(customer, alias),
  });
}

/** The current workspace, its subscription, and the plan that subscription is on. */
export async function getMe(state: AppState, request: ScribeRequest): Promise<Reply<MeResponse>> {
  const { customerAlias: alias } = requireSession(state, request);

  const customer = await loadCustomer(state, alias);
  const subscription = await currentSubscription(state, alias);

  // The plan is only looked up when there is a subscription to look it up for, so a
  // never-subscribed workspace works even before the catalog is reachable.
  let projected: Subscription | null = null;
  let plan: Plan | null = null;
  if (subscription !== null) {
    const catalog = await state.catalog();
    const planCode = catalog.planCodeFor(subscription.planId, subscription.planName);
    projected = projectSubscription(subscription, planCode);
    plan = planCode === null ? null : catalog.plan(planCode);
  }

  return ok({ workspace: toWorkspace(customer, alias), subscription: projected, plan });
}

/**
 * Every field is a 1:1 projection of a Meteroid field — nothing is derived, so the
 * demo's view and Meteroid's can never drift. In particular `trial_duration_days` is
 * Meteroid's `trialDuration`, not a computed trial end date.
 *
 * The `?? null`s are the contract's nullability rule at work: the SDK leaves an absent
 * optional field `undefined`, and `JSON.stringify` would drop the key.
 */
export function projectSubscription(
  subscription: SdkSubscription,
  planCode: PlanCode | null,
): Subscription {
  return {
    id: subscription.id,
    status: subscription.status,
    plan_code: planCode,
    plan_name: subscription.planName,
    plan_version_id: subscription.planVersionId,
    currency: subscription.currency,
    current_period_start: subscription.currentPeriodStart,
    current_period_end: subscription.currentPeriodEnd ?? null,
    trial_duration_days: subscription.trialDuration ?? null,
    created_at: timestamp(subscription.createdAt),
  };
}
