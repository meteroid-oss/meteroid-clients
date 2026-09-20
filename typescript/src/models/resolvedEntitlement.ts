// this file is @generated
import { type FeatureRef, FeatureRefSerializer } from "./featureRef";
import {
  type ResolvedEntitlementValue,
  ResolvedEntitlementValueSerializer,
} from "./resolvedEntitlementValue";
/** Merged entitlement value for a feature across the priority hierarchy, without usage data. */
export interface ResolvedEntitlement {
  feature: FeatureRef;

  value: ResolvedEntitlementValue;
}

export const ResolvedEntitlementSerializer = {
  _fromJsonObject(object: any): ResolvedEntitlement {
    return {
      feature: FeatureRefSerializer._fromJsonObject(object["feature"]),
      value: ResolvedEntitlementValueSerializer._fromJsonObject(object["value"]),
    };
  },

  _toJsonObject(self: ResolvedEntitlement): any {
    return {
      feature: FeatureRefSerializer._toJsonObject(self.feature),
      value: ResolvedEntitlementValueSerializer._toJsonObject(self.value),
    };
  },
};
