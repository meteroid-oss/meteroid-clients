// this file is @generated
import { extraProperties } from "../json.js";
import {
  type EffectiveEntitlementValue,
  EffectiveEntitlementValueSerializer,
} from "./effectiveEntitlementValue.js";
import { type FeatureRef, FeatureRefSerializer } from "./featureRef.js";
/** Merged entitlement value for a feature for a specific customer, enriched with live usage data. */
export interface EffectiveEntitlement {
  feature: FeatureRef;
  value: EffectiveEntitlementValue;
}

/** Converts `EffectiveEntitlement` values from (`parse`) and to (`serialize`) their JSON form. */
export const EffectiveEntitlementSerializer = {
  parse(json: any): EffectiveEntitlement {
    return {
      ...extraProperties(json, ["feature", "value"]),
      feature: FeatureRefSerializer.parse(json["feature"]),
      value: EffectiveEntitlementValueSerializer.parse(json["value"]),
    };
  },

  serialize(value: EffectiveEntitlement): any {
    return {
      ...extraProperties(value, ["feature", "value"]),
      feature: FeatureRefSerializer.serialize(value.feature),
      value: EffectiveEntitlementValueSerializer.serialize(value.value),
    };
  },
};
