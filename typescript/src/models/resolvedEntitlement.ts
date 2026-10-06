// this file is @generated
import { extraProperties } from "../json.js";
import { type FeatureRef, FeatureRefSerializer } from "./featureRef.js";
import {
  type ResolvedEntitlementValue,
  ResolvedEntitlementValueSerializer,
} from "./resolvedEntitlementValue.js";
/** Merged entitlement value for a feature across the priority hierarchy, without usage data. */
export interface ResolvedEntitlement {
  feature: FeatureRef;
  value: ResolvedEntitlementValue;
}

/** Converts `ResolvedEntitlement` values from (`parse`) and to (`serialize`) their JSON form. */
export const ResolvedEntitlementSerializer = {
  parse(json: any): ResolvedEntitlement {
    return {
      ...extraProperties(json, ["feature", "value"]),
      feature: FeatureRefSerializer.parse(json["feature"]),
      value: ResolvedEntitlementValueSerializer.parse(json["value"]),
    };
  },

  serialize(value: ResolvedEntitlement): any {
    return {
      ...extraProperties(value, ["feature", "value"]),
      feature: FeatureRefSerializer.serialize(value.feature),
      value: ResolvedEntitlementValueSerializer.serialize(value.value),
    };
  },
};
