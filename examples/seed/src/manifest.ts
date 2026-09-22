/**
 * The shape of `scribe.catalog.yaml`, and the one place it is read.
 *
 * The manifest is the source of truth: nothing under `src/` names a plan, a feature code,
 * a price or a limit. Adding a feature to the catalog is a manifest edit.
 */

import { readFileSync } from 'node:fs';
import { parse } from 'yaml';

export type FeatureSpec =
  | { type: 'BOOLEAN' }
  | { type: 'METERED'; metric: string }
  | { type: 'CONFIG'; value_type: 'NUMBER' | 'TEXT' | 'JSON' | 'SELECT'; options?: string[] };

export type EntitlementSpec =
  | { type: 'BOOLEAN'; enabled: boolean }
  | { type: 'METERED'; enabled: boolean; limit?: string; reset_period: ResetPeriod }
  | { type: 'CONFIG'; value: { kind: 'NUMBER' | 'TEXT' | 'JSON' | 'SELECT'; value: string } };

export interface ResetPeriod {
  type: 'BILLING_CYCLE' | 'CALENDAR' | 'FIXED_WINDOW' | 'SLIDING_WINDOW' | 'NEVER';
  interval?: number;
  unit?: 'HOUR' | 'DAY' | 'WEEK' | 'MONTH' | 'YEAR';
}

export interface MetricManifest {
  code: string;
  name: string;
  aggregation_type: string;
  aggregation_key?: string;
}

export interface FeatureManifest {
  code: string;
  name: string;
  description?: string;
  type: FeatureSpec;
}

/** A price component, with the metric named by code where Meteroid wants an id. */
export interface ComponentManifest {
  name: string;
  fee: Record<string, unknown> & { type: string; metric?: string };
}

export interface PlanManifest {
  plan_code: string;
  name: string;
  plan_type: 'FREE' | 'STANDARD' | 'CUSTOM';
  description?: string;
  components: ComponentManifest[];
  entitlements: Record<string, EntitlementSpec>;
}

export interface Manifest {
  currency: string;
  product_family: { name: string };
  metrics: MetricManifest[];
  features: FeatureManifest[];
  plans: PlanManifest[];
  fixtures: {
    subscribed_workspace: {
      customer: { name: string; alias: string; invoicing_emails: string[] };
      subscription: { plan: string; activation_condition: string };
    };
  };
}

export function readManifest(path: string): Manifest {
  return parse(readFileSync(path, 'utf8')) as Manifest;
}
