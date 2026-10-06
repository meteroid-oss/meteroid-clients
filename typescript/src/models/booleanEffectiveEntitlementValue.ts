// this file is @generated
import { extraProperties } from "../json.js";

export interface BooleanEffectiveEntitlementValue {
  enabled: boolean;
}

/** Converts `BooleanEffectiveEntitlementValue` values from (`parse`) and to (`serialize`) their JSON form. */
export const BooleanEffectiveEntitlementValueSerializer = {
  parse(json: any): BooleanEffectiveEntitlementValue {
    return {
      ...extraProperties(json, ["enabled"]),
      enabled: json["enabled"],
    };
  },

  serialize(value: BooleanEffectiveEntitlementValue): any {
    return {
      ...extraProperties(value, ["enabled"]),
      enabled: value.enabled,
    };
  },
};
