import type { ReactNode } from "react";
import { useEntitlement } from "./hooks";
import type { FeatureCode } from "./register";

export interface GateProps {
  feature: FeatureCode;
  /** Rendered when the customer has no access, e.g. an upgrade prompt. */
  fallback?: ReactNode;
  /** Rendered until the entitlements are known. */
  loading?: ReactNode;
  children?: ReactNode;
}

/** Renders its children only when the customer has access to `feature`. */
export function Gate({ feature, fallback = null, loading = null, children }: GateProps) {
  const { status, hasAccess } = useEntitlement(feature);
  if (status === "loading") {
    return <>{loading}</>;
  }
  return <>{hasAccess ? children : fallback}</>;
}
