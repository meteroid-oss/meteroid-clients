// Compiled by `npm run typecheck` (tsc -p test/types), never run.
import { Gate, UsageMeter, useEntitlement } from "@meteroid/react";

declare module "@meteroid/react" {
  interface Register {
    featureCode: "sso" | "api_calls";
  }
}

export function TypedFeatureCodes() {
  useEntitlement("sso");
  // @ts-expect-error: not a declared feature code
  useEntitlement("unknown");
  return (
    <>
      <Gate feature="api_calls">ok</Gate>
      {/* @ts-expect-error: not a declared feature code */}
      <UsageMeter feature="nope" />
    </>
  );
}
