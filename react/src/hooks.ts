import {
  type CheckOptions,
  checkEntitlement,
  type EntitlementCheck,
  type Meteroid,
  type MeteroidSnapshot,
} from "@meteroid/browser";
import { useContext, useMemo, useSyncExternalStore } from "react";
import { MeteroidContext } from "./provider";
import type { FeatureCode } from "./register";

/** The client of the nearest `<MeteroidProvider>`, e.g. to call `refresh()`. */
export function useMeteroid(): Meteroid {
  const client = useContext(MeteroidContext);
  if (client === null) {
    throw new Error(
      "Meteroid: hooks and components must be used inside <MeteroidProvider>"
    );
  }
  return client;
}

function useResource<K extends keyof MeteroidSnapshot>(key: K): MeteroidSnapshot[K] {
  const client = useMeteroid();
  return useSyncExternalStore(
    client.subscribe,
    () => client.getSnapshot()[key],
    () => client.getServerSnapshot()[key]
  );
}

/** All the entitlements of the customer. */
export const useEntitlements = () => useResource("entitlements");

/** The signed-in customer. */
export const useCustomer = () => useResource("customer");

/** The customer's subscriptions. */
export const useSubscriptions = () => useResource("subscriptions");

export type UseEntitlementOptions = CheckOptions;

/**
 * Whether the customer can use a feature, from the loaded entitlements. Until they
 * are loaded (or when loading failed), `hasAccess` is `fallback` (default `false`)
 * and `isFallback` is `true`.
 */
export function useEntitlement(
  featureCode: FeatureCode,
  options?: UseEntitlementOptions
): EntitlementCheck {
  const entitlements = useResource("entitlements");
  const fallback = options?.fallback ?? false;
  return useMemo(
    () => checkEntitlement(entitlements, featureCode, { fallback }),
    [entitlements, featureCode, fallback]
  );
}
