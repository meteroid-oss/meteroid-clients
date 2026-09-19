/**
 * Catalog resolution.
 *
 * The demo **never creates catalog objects** — the operator seeds them once, by hand
 * (`examples/CATALOG.md`). Everything here is a lookup by a stable identifier, and
 * every failure becomes `503 CATALOG_NOT_SEEDED` naming exactly what was missing.
 *
 * Two things are resolved:
 *
 * - the four **features**, by code, which is what tells an unseeded tenant apart from a
 *   workspace that simply has no subscription (both show zero entitlements); and
 * - the three **plans**, by their exact seeded name, because Meteroid plans carry no
 *   user-supplied code.
 *
 * The result is cached for the life of the process once it succeeds. Failures are not
 * cached, so seeding the tenant while the backend runs fixes it without a restart.
 */

import {
  BillingPeriodEnum,
  type CalendarUnit,
  type Fee,
  type Meteroid,
  PlanStatusEnum,
  PlanTypeEnum,
  type ResetPeriod,
  type ResolvedEntitlementValue,
  type TermRate,
} from "@meteroid/sdk";

import { normalize } from "./decimal.js";
import {
  METEROID_PLAN_NAME,
  PLAN_CODES,
  type Plan,
  type PlanCode,
  type PlanFeatureLine,
  type PlanPrice,
} from "./dto.js";
import { ApiError, isNotFound, upstream } from "./error.js";

/** The four feature codes this demo gates on. Seeded in the dashboard; GET-only over REST. */
export const FEATURE_CODES = ["transcription_minutes", "sso", "retention_days", "seats"] as const;

/**
 * The metered feature the transcription endpoint enforces, and the billable metric code
 * the ingested events carry.
 */
export const TRANSCRIPTION_MINUTES = "transcription_minutes";

const SEED_HINT = "Seed the catalog per examples/CATALOG.md.";

export class Catalog {
  public constructor(
    /** In `PLAN_CODES` order — cheapest first. */
    public readonly plans: readonly Plan[],
    /** Meteroid plan id → the demo's plan code, for labelling a subscription's plan. */
    private readonly planCodesById: ReadonlyMap<string, PlanCode>,
  ) {}

  public plan(code: PlanCode): Plan {
    const plan = this.plans.find((candidate) => candidate.code === code);
    if (plan === undefined) {
      throw ApiError.internal(`The resolved catalog holds no "${code}" plan.`);
    }
    return plan;
  }

  /**
   * Label a Meteroid subscription's plan. Matches on `planId` first — a dashboard
   * rename then still resolves — and falls back to the exact seeded name.
   */
  public planCodeFor(planId: string, planName: string): PlanCode | null {
    return (
      this.planCodesById.get(planId) ??
      PLAN_CODES.find((code) => METEROID_PLAN_NAME[code] === planName) ??
      null
    );
  }
}

/** Process-wide cache of the resolved catalog. Only successes are cached. */
export class CatalogCache {
  private resolved: Catalog | null = null;

  public async get(
    client: Meteroid,
    metrics: MetricCache,
    expectedCurrency: string,
  ): Promise<Catalog> {
    this.resolved ??= await resolve(client, metrics, expectedCurrency);
    return this.resolved;
  }
}

/**
 * Meteroid identifies the metric behind a metered entitlement, and behind a
 * `USAGE`/`CAPACITY` price component, by **id** only. This maps ids back onto the codes
 * application code actually knows.
 */
export class MetricCache {
  private codesById = new Map<string, string>();

  /** Load (or reload) the whole map. Cheap: one page covers any realistic demo tenant. */
  public async refresh(client: Meteroid): Promise<void> {
    const response = await client.metrics
      .listMetrics({ perPage: 100 })
      .catch(upstream("GET /api/v1/metrics"));

    this.codesById = new Map(response.data.map((metric) => [metric.id, metric.code]));
  }

  /**
   * Resolve one metric id, refreshing once on a miss so a metric seeded after startup
   * still shows up. `null` is not fatal anywhere — the code is presentational.
   */
  public async codeFor(client: Meteroid, metricId: string): Promise<string | null> {
    if (!this.codesById.has(metricId)) {
      try {
        await this.refresh(client);
      } catch {
        return null;
      }
    }
    return this.codeForCached(metricId);
  }

  public codeForCached(metricId: string): string | null {
    return this.codesById.get(metricId) ?? null;
  }
}

async function resolve(
  client: Meteroid,
  metrics: MetricCache,
  expectedCurrency: string,
): Promise<Catalog> {
  // 1. The four features must exist. This is the check that keeps an unseeded tenant
  //    from masquerading as "your plan doesn't include that" on the first transcription.
  for (const code of FEATURE_CODES) {
    await client.features.getFeature(code).catch((err: unknown) => {
      if (isNotFound(err)) {
        throw ApiError.catalogNotSeeded(
          `No feature with code "${code}". Features cannot be created over the REST API; ` +
            `create it in the Meteroid dashboard. ${SEED_HINT}`,
        );
      }
      return upstream(`GET /api/v1/features/${code}`)(err);
    });
  }

  // 2. metric id → code, used to name the unit of usage-priced components below.
  await metrics.refresh(client);

  // 3. The three plans, by exact seeded name.
  const plans: Plan[] = [];
  const planCodesById = new Map<string, PlanCode>();
  for (const code of PLAN_CODES) {
    const plan = await resolvePlan(client, metrics, code, expectedCurrency);
    planCodesById.set(plan.plan_id, code);
    plans.push(plan);
  }

  return new Catalog(plans, planCodesById);
}

async function resolvePlan(
  client: Meteroid,
  metrics: MetricCache,
  code: PlanCode,
  expectedCurrency: string,
): Promise<Plan> {
  const name = METEROID_PLAN_NAME[code];

  // `search` is a fuzzy name match — "Scribe" alone returns all three plans — so the
  // exact-name filter below is what actually pins the plan down.
  const found = await client.plans
    .listPlans({ search: name, status: [PlanStatusEnum.Active], perPage: 100 })
    .catch(upstream("GET /api/v1/plans"));

  const plan = found.data.find((candidate) => candidate.name === name);
  if (plan === undefined) {
    throw ApiError.catalogNotSeeded(
      `No published plan named "${name}" (plan_code=${code}). ${SEED_HINT}`,
    );
  }

  // Meteroid refuses to check a customer out against a plan version in another
  // currency, so catching the mismatch here beats a confusing failure at checkout.
  if (plan.currency.toUpperCase() !== expectedCurrency.toUpperCase()) {
    throw ApiError.catalogNotSeeded(
      `Plan "${name}" is priced in ${plan.currency} but SCRIBE_DEFAULT_CURRENCY is ` +
        `${expectedCurrency}; Meteroid will not check out a customer against a plan in ` +
        "another currency.",
    );
  }

  // The marketing bullets come from the plan version's entitlements, so the pricing
  // page and the enforcement path cannot drift apart.
  const entitlements = await client.plans
    .listPlanVersionEntitlements(plan.versionId)
    .catch(upstream(`GET /api/v1/plan-versions/${plan.versionId}/entitlements`));

  const features: PlanFeatureLine[] = entitlements.data.map((entitlement) => ({
    feature_code: entitlement.feature.code,
    label: featureLabel(entitlement.feature.name, entitlement.value),
  }));

  const prices: PlanPrice[] = [];
  for (const component of plan.priceComponents) {
    // A component with no fee has nothing to show, so it is dropped entirely.
    if (component.fee != null) {
      prices.push(flattenFee(metrics, component.id, component.name, component.fee));
    }
  }

  return {
    code,
    name: plan.name,
    description: plan.description ?? null,
    plan_id: plan.id,
    plan_version_id: plan.versionId,
    version: plan.version,
    currency: plan.currency,
    is_free: plan.planType === PlanTypeEnum.Free,
    trial_days: plan.trial?.durationDays ?? null,
    prices,
    features,
  };
}

/**
 * Flatten one Meteroid price component into the display-oriented `PlanPrice` of the
 * contract. Deliberately lossy: this renders a pricing table, it does not reprice.
 *
 * `Fee` is a discriminated union on `type`, so the `switch` narrows each arm to its own
 * variant and the compiler proves all six are handled.
 */
function flattenFee(
  metrics: MetricCache,
  componentId: string,
  componentName: string,
  fee: Fee,
): PlanPrice {
  const price: PlanPrice = {
    component_id: componentId,
    name: componentName,
    kind: fee.type,
    cadence: null,
    amount: null,
    unit_amount: null,
    included_amount: null,
    unit_name: null,
    pricing_model: null,
  };

  switch (fee.type) {
    case "RATE":
    case "SLOT": {
      const term = pickTerm(fee.rates);
      if (term !== undefined) {
        price.cadence = term.term;
        price.amount = normalize(term.price);
      }
      if (fee.type === "SLOT") {
        price.unit_name = fee.slotUnitName;
      }
      return price;
    }
    case "CAPACITY": {
      price.cadence = fee.cadence;
      price.unit_name = metrics.codeForCached(fee.metricId);
      const threshold = fee.thresholds[0];
      if (threshold !== undefined) {
        price.amount = normalize(threshold.price);
        price.unit_amount = normalize(threshold.perUnitOverage);
        // Meteroid types this one as an integer count; the contract carries every
        // quantity as a decimal string.
        price.included_amount = normalize(String(threshold.includedAmount));
      }
      return price;
    }
    case "USAGE":
      price.cadence = fee.cadence;
      price.unit_name = metrics.codeForCached(fee.metricId);
      price.pricing_model = fee.pricing.type;
      // Only PER_UNIT has a single displayable unit price.
      if (fee.pricing.type === "PER_UNIT") {
        price.unit_amount = normalize(fee.pricing.rate);
      }
      return price;
    case "EXTRA_RECURRING":
      price.cadence = fee.cadence;
      price.amount = normalize(fee.unitPrice);
      return price;
    case "ONE_TIME":
      price.amount = normalize(fee.unitPrice);
      return price;
  }
}

/**
 * A `RATE` or `SLOT` fee prices one billing term each. The table shows one of them: the
 * monthly term when it exists (that is what the seeded catalog uses), else the first.
 * Meteroid's `Plan` carries no cadence of its own to match against.
 */
function pickTerm(rates: readonly TermRate[]): TermRate | undefined {
  return rates.find((rate) => rate.term === BillingPeriodEnum.Monthly) ?? rates[0];
}

/** Render one plan-version entitlement as a marketing bullet. */
export function featureLabel(featureName: string, value: ResolvedEntitlementValue): string {
  const included = (on: boolean) => `${featureName} ${on ? "included" : "not included"}`;

  switch (value.type) {
    case "BOOLEAN":
      return included(value.enabled);
    case "METERED":
      if (!value.enabled) {
        return included(false);
      }
      return value.limit == null
        ? `Unlimited ${lowerFirst(featureName)}`
        : `${normalize(value.limit)} ${lowerFirst(featureName)}${resetSuffix(value.resetPeriod)}`;
    case "CONFIG":
      switch (value.value.kind) {
        case "NUMBER":
          return `${normalize(value.value.value)} ${lowerFirst(featureName)}`;
        case "BOOLEAN":
          return included(value.value.value);
        case "TEXT":
          return `${featureName}: ${value.value.value}`;
        case "JSON":
          return `${featureName} configured`;
      }
  }
}

function resetSuffix(resetPeriod: ResetPeriod): string {
  switch (resetPeriod.type) {
    case "BILLING_CYCLE":
      return " per billing cycle";
    case "NEVER":
      return "";
    case "CALENDAR":
    case "FIXED_WINDOW":
      return ` per ${interval(resetPeriod.interval, resetPeriod.unit)}`;
    case "SLIDING_WINDOW":
      return ` per rolling ${interval(resetPeriod.interval, resetPeriod.unit)}`;
  }
}

function interval(count: number, unit: CalendarUnit): string {
  const name = unit.toLowerCase();
  return count === 1 ? name : `${count} ${name}s`;
}

function lowerFirst(value: string): string {
  const [first = "", ...rest] = Array.from(value);
  return first.toLowerCase() + rest.join("");
}
