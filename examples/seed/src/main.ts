/**
 * Apply scribe.catalog.yaml to a Meteroid tenant, idempotently, then verify it.
 *
 *     npm --prefix seed start        # or: make seed
 *
 * Reads METEROID_BASE_URL and METEROID_API_KEY from the environment; `make seed` exports
 * examples/.env into it. Re-running is expected to converge: every object is resolved by
 * its natural key before it is created, so a second run creates nothing.
 *
 * The run ends with CATALOG.md section 7's checklist, executed against the tenant the
 * seed just wrote to, printed as a PASS/FAIL table. Any FAIL exits non-zero.
 */

import { writeFileSync } from 'node:fs';
import { dirname, resolve } from 'node:path';
import { fileURLToPath } from 'node:url';

import { Meteroid, MeteroidError } from './meteroid.js';
import type { EntitlementSpec, Manifest, PlanManifest } from './manifest.js';
import { readManifest } from './manifest.js';
import { Checklist } from './verify.js';

const seedDir = resolve(dirname(fileURLToPath(import.meta.url)), '..');
const examplesDir = resolve(seedDir, '..');

interface Named { id: string; name: string }
interface Metric { id: string; code: string; name: string }
interface Feature { id: string; code: string }
interface Plan { id: string; name: string; version_id: string; status: string; currency: string }
interface Customer { id: string; alias: string | null }
interface Subscription { id: string; plan_id?: string; charge_automatically?: boolean }

function required(name: string): string {
  const value = (process.env[name] ?? '').trim();
  if (value === '') {
    console.error(`${name} is not set. Copy examples/.env.example to examples/.env first.`);
    process.exit(2);
  }
  return value;
}

function log(action: 'created' | 'exists' | 'published' | 'attached', what: string): void {
  const mark = action === 'exists' ? '·' : '+';
  console.log(`  ${mark} ${action.padEnd(9)} ${what}`);
}

// --------------------------------------------------------------------------- apply

async function seedProductFamily(api: Meteroid, m: Manifest): Promise<string> {
  const families = await api.list<Named>('/api/v1/product_families');
  const existing = families.find((f) => f.name === m.product_family.name);
  if (existing) {
    log('exists', `product family ${existing.name}`);
    return existing.id;
  }
  // ProductFamilyCreateRequest takes a name only — the alias is derived server-side, so
  // there is nothing to assert about it afterwards.
  const created = await api.post<Named>('/api/v1/product_families', { name: m.product_family.name });
  log('created', `product family ${created.name}`);
  return created.id;
}

async function seedMetrics(api: Meteroid, m: Manifest, familyId: string): Promise<Map<string, string>> {
  // `search` is a fuzzy match, so the list is narrowed on `code` here rather than trusted.
  const existing = await api.list<Metric>('/api/v1/metrics');
  const byCode = new Map(existing.map((metric) => [metric.code, metric.id]));

  for (const metric of m.metrics) {
    if (byCode.has(metric.code)) {
      log('exists', `metric ${metric.code}`);
      continue;
    }
    const created = await api.post<Metric>('/api/v1/metrics', {
      name: metric.name,
      code: metric.code,
      aggregation_type: metric.aggregation_type,
      aggregation_key: metric.aggregation_key ?? null,
      product_family_id: familyId,
    });
    byCode.set(created.code, created.id);
    log('created', `metric ${created.code}`);
  }
  return byCode;
}

async function seedFeatures(api: Meteroid, m: Manifest, metrics: Map<string, string>): Promise<Map<string, string>> {
  const byCode = new Map<string, string>();

  for (const feature of m.features) {
    // The exact lookup, and the same call every backend makes at startup.
    const found = await api.find<Feature>(`/api/v1/features/${feature.code}`);
    if (found) {
      byCode.set(feature.code, found.id);
      log('exists', `feature ${feature.code}`);
      continue;
    }

    const spec = feature.type;
    const feature_type =
      spec.type === 'METERED'
        ? { type: 'METERED', metric_id: metricId(metrics, spec.metric) }
        : spec.type === 'CONFIG'
          ? { type: 'CONFIG', value_type: spec.value_type, ...(spec.options ? { options: spec.options } : {}) }
          : { type: 'BOOLEAN' };

    const created = await api.post<Feature>('/api/v1/features', {
      code: feature.code,
      name: feature.name,
      description: feature.description ?? null,
      feature_type,
    });
    byCode.set(created.code, created.id);
    log('created', `feature ${created.code}`);
  }
  return byCode;
}

function metricId(metrics: Map<string, string>, code: string): string {
  const id = metrics.get(code);
  if (id === undefined) throw new Error(`manifest references metric \`${code}\`, which it does not define`);
  return id;
}

function featureId(features: Map<string, string>, code: string): string {
  const id = features.get(code);
  if (id === undefined) throw new Error(`manifest references feature \`${code}\`, which it does not define`);
  return id;
}

/** Manifest entitlements, with feature codes resolved to the ids the API wants. */
function entitlementBody(
  entitlements: Record<string, EntitlementSpec>,
  features: Map<string, string>,
): { feature_id: string; value: EntitlementSpec }[] {
  return Object.entries(entitlements).map(([code, value]) => ({ feature_id: featureId(features, code), value }));
}

/** Price components, with metric codes resolved to ids in the fees that carry one. */
function componentBody(plan: PlanManifest, metrics: Map<string, string>): unknown[] {
  return plan.components.map((component) => {
    const { metric, ...fee } = component.fee;
    return {
      name: component.name,
      fee: metric === undefined ? fee : { ...fee, metric_id: metricId(metrics, metric) },
    };
  });
}

async function seedPlans(
  api: Meteroid,
  m: Manifest,
  familyId: string,
  metrics: Map<string, string>,
  features: Map<string, string>,
): Promise<Map<string, Plan>> {
  const byName = new Map<string, Plan>();

  for (const plan of m.plans) {
    // Plans have no code, and `search` is fuzzy — "Scribe" alone returns all three — so
    // the result is narrowed on an exact name match. CATALOG.md section 5.
    const candidates = await api.list<Plan>(`/api/v1/plans?search=${encodeURIComponent(plan.name)}`);
    let current = candidates.find((p) => p.name === plan.name);

    if (current) {
      log('exists', `plan ${plan.name}`);
    } else {
      current = await api.post<Plan>('/api/v1/plans', {
        name: plan.name,
        description: plan.description ?? null,
        product_family_id: familyId,
        plan_type: plan.plan_type,
        status: 'DRAFT',
        currency: m.currency,
        components: componentBody(plan, metrics),
        entitlements: entitlementBody(plan.entitlements, features),
      });
      log('created', `plan ${plan.name}`);
    }

    // Attached unconditionally, not only on create: the endpoint skips entitlements the
    // version already carries, so this is what makes a manifest edit converge onto a plan
    // that already exists.
    await api.post(`/api/v1/plan-versions/${current.version_id}/entitlements`, {
      entitlements: entitlementBody(plan.entitlements, features),
    });
    log('attached', `${Object.keys(plan.entitlements).length} entitlements to ${plan.name}`);

    if (current.status === 'DRAFT') {
      current = await api.post<Plan>(`/api/v1/plans/${current.id}/publish`, {});
      log('published', `plan ${plan.name}`);
    }
    byName.set(plan.name, current);
  }
  return byName;
}

async function seedSubscribedWorkspace(api: Meteroid, m: Manifest, plans: Map<string, Plan>): Promise<string> {
  const { customer, subscription } = m.fixtures.subscribed_workspace;

  let workspace = await api.find<Customer>(`/api/v1/customers/${customer.alias}`);
  if (workspace) {
    log('exists', `customer ${customer.alias}`);
  } else {
    workspace = await api.post<Customer>('/api/v1/customers', {
      name: customer.name,
      alias: customer.alias,
      currency: m.currency,
      invoicing_emails: customer.invoicing_emails,
      custom_taxes: [],
    });
    log('created', `customer ${customer.alias}`);
  }

  const plan = plans.get(subscription.plan);
  if (plan === undefined) throw new Error(`fixture subscribes to \`${subscription.plan}\`, which the manifest does not define`);

  const existing = await api.list<Subscription>(`/api/v1/subscriptions?customer_id=${workspace.id}&plan_id=${plan.id}`);
  if (existing.length > 0) {
    log('exists', `subscription to ${plan.name}`);
    return customer.alias;
  }

  // ON_START activates without a hosted checkout, which is the whole point of the fixture.
  // `charge_automatically` is left to the server: with INSTANCE_BOOTSTRAP_TEST_GATEWAY the
  // tenant has a payment provider, so forcing it off here would misrepresent the demo.
  const created = await api.post<Subscription>('/api/v1/subscriptions', {
    customer_id_or_alias: customer.alias,
    plan_id: plan.id,
    start_date: new Date().toISOString().slice(0, 10),
    activation_condition: subscription.activation_condition,
  });
  log('created', `subscription to ${plan.name} (charge_automatically=${created.charge_automatically})`);
  return customer.alias;
}

// --------------------------------------------------------------------------- verify

async function verify(api: Meteroid, m: Manifest, alias: string): Promise<Checklist> {
  const checklist = new Checklist();

  await checklist.check(`metric \`${m.metrics[0]?.code}\` exists with aggregation ${m.metrics[0]?.aggregation_type}`, async () => {
    for (const metric of m.metrics) {
      const found = (await api.list<Metric & { aggregation_type: string }>('/api/v1/metrics')).find((x) => x.code === metric.code);
      if (!found) throw new Error(`no metric with code \`${metric.code}\``);
      if (found.aggregation_type !== metric.aggregation_type) {
        throw new Error(`metric \`${metric.code}\` aggregates ${found.aggregation_type}, manifest says ${metric.aggregation_type}`);
      }
    }
  });

  for (const feature of m.features) {
    await checklist.check(`feature \`${feature.code}\` is ${feature.type.type}`, async () => {
      const found = await api.find<Feature & { feature_type: { type: string } }>(`/api/v1/features/${feature.code}`);
      if (!found) throw new Error(`GET /api/v1/features/${feature.code} → 404`);
      if (found.feature_type.type !== feature.type.type) {
        throw new Error(`feature \`${feature.code}\` is ${found.feature_type.type}, manifest says ${feature.type.type}`);
      }
    });
  }

  for (const plan of m.plans) {
    await checklist.check(`plan \`${plan.name}\` is ACTIVE in ${m.currency}`, async () => {
      const found = (await api.list<Plan>(`/api/v1/plans?search=${encodeURIComponent(plan.name)}&status=ACTIVE`)).find(
        (p) => p.name === plan.name,
      );
      if (!found) throw new Error(`no ACTIVE plan named exactly \`${plan.name}\``);
      if (found.currency !== m.currency) throw new Error(`plan \`${plan.name}\` is in ${found.currency}, manifest says ${m.currency}`);
    });

    await checklist.check(`plan \`${plan.name}\` carries its ${Object.keys(plan.entitlements).length} entitlements`, async () => {
      const found = (await api.list<Plan>(`/api/v1/plans?search=${encodeURIComponent(plan.name)}&status=ACTIVE`)).find(
        (p) => p.name === plan.name,
      );
      if (!found) throw new Error(`no ACTIVE plan named exactly \`${plan.name}\``);
      const attached = await api.get<{ data: { feature_id: string }[] }>(`/api/v1/plan-versions/${found.version_id}/entitlements`);
      const missing = Object.keys(plan.entitlements).length - attached.data.length;
      if (missing > 0) throw new Error(`${attached.data.length} of ${Object.keys(plan.entitlements).length} entitlements attached`);
    });
  }

  await checklist.check(`workspace \`${alias}\` is subscribed`, async () => {
    const customer = await api.find<Customer>(`/api/v1/customers/${alias}`);
    if (!customer) throw new Error(`GET /api/v1/customers/${alias} → 404`);
    const subs = await api.list<Subscription>(`/api/v1/subscriptions?customer_id=${customer.id}`);
    if (subs.length === 0) throw new Error('customer has no subscription');
  });

  await checklist.check(`workspace \`${alias}\` resolves ${m.features.length} effective entitlements`, async () => {
    const res = await api.get<{ data: unknown[] }>(`/api/v1/customers/${alias}/entitlements`);
    if (res.data.length < m.features.length) {
      throw new Error(`${res.data.length} of ${m.features.length} features resolved`);
    }
  });

  return checklist;
}

// --------------------------------------------------------------------------- main

async function main(): Promise<void> {
  const baseUrl = (process.env['METEROID_BASE_URL'] ?? 'http://localhost:8084').replace(/\/+$/, '');
  const api = new Meteroid(baseUrl, required('METEROID_API_KEY'));
  const manifest = readManifest(resolve(seedDir, 'scribe.catalog.yaml'));

  console.log(`Seeding ${baseUrl} from seed/scribe.catalog.yaml\n`);

  const familyId = await seedProductFamily(api, manifest);
  const metrics = await seedMetrics(api, manifest, familyId);
  const features = await seedFeatures(api, manifest, metrics);
  const plans = await seedPlans(api, manifest, familyId, metrics, features);
  const alias = await seedSubscribedWorkspace(api, manifest, plans);

  console.log('\nVerifying (CATALOG.md section 7)\n');
  const checklist = await verify(api, manifest, alias);
  checklist.print();

  const envSeed = resolve(examplesDir, '.env.seed');
  writeFileSync(
    envSeed,
    [
      '# Written by `make seed`. Gitignored, and safe to delete — re-running the seed',
      '# recreates it. The contract suite mints a session token from this alias using',
      '# SCRIBE_SESSION_SECRET, which is how the metered, usage, invoice and quota tests',
      '# get a handle on a workspace that already has a subscription.',
      '#',
      '#     set -a; . ./.env.seed; set +a; make test-contract',
      '',
      `SCRIBE_SUBSCRIBED_CUSTOMER_ALIAS=${alias}`,
      '',
    ].join('\n'),
  );
  console.log(`\nWrote ${envSeed}`);
  console.log('Use it with:  set -a; . ./.env.seed; set +a; make test-contract');

  if (checklist.failed > 0) process.exit(1);
}

main().catch((err: unknown) => {
  if (err instanceof MeteroidError) {
    console.error(`\n${err.message}`);
    if (err.status === 404 || err.status === 405) {
      console.error(
        '\nThat endpoint does not exist on this Meteroid. The catalog writes the seed needs\n' +
          '(POST /api/v1/features, POST /api/v1/plan-versions/{id}/entitlements) are newer than\n' +
          'some published images — check GET /api-docs/openapi.json on the instance.',
      );
    }
  } else {
    console.error(`\n${err instanceof Error ? err.stack : String(err)}`);
  }
  process.exit(1);
});
