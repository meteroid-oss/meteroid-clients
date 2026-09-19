// this file is @generated
import {
  type EffectiveEntitlementValue,
  EffectiveEntitlementValueSerializer,
} from "./effectiveEntitlementValue";
import { type FeatureRef, FeatureRefSerializer } from "./featureRef";
/** Merged entitlement value for a feature for a specific customer, enriched with live usage data. */
export interface EffectiveEntitlement {
  feature: FeatureRef;

  value: EffectiveEntitlementValue;
}

export const EffectiveEntitlementSerializer = {
  _fromJsonObject(object: any): EffectiveEntitlement {
    return {
      feature: FeatureRefSerializer._fromJsonObject(object["feature"]),
      value: EffectiveEntitlementValueSerializer._fromJsonObject(object["value"]),
    };
  },

  _toJsonObject(self: EffectiveEntitlement): any {
    return {
      feature: FeatureRefSerializer._toJsonObject(self.feature),
      value: EffectiveEntitlementValueSerializer._toJsonObject(self.value),
    };
  },
};
