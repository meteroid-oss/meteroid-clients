// Compiled by `npm run typecheck` (tsc -p test/types), never run: what
// `@meteroid/sdk` returns on the server must be accepted as `initialEntitlements`.
import type { MeteroidProviderProps } from "@meteroid/react";
import type { EffectiveEntitlementListResponse } from "../../../typescript/src/models/effectiveEntitlementListResponse";

export const fromServer = (
  entitlements: EffectiveEntitlementListResponse
): MeteroidProviderProps["initialEntitlements"] => entitlements;
