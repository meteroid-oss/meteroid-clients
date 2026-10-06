// this file is @generated
import { extraProperties } from "../json.js";

export interface BooleanResolvedEntitlementValue {
  enabled: boolean;
}

/** Converts `BooleanResolvedEntitlementValue` values from (`parse`) and to (`serialize`) their JSON form. */
export const BooleanResolvedEntitlementValueSerializer = {
  parse(json: any): BooleanResolvedEntitlementValue {
    return {
      ...extraProperties(json, ["enabled"]),
      enabled: json["enabled"],
    };
  },

  serialize(value: BooleanResolvedEntitlementValue): any {
    return {
      ...extraProperties(value, ["enabled"]),
      enabled: value.enabled,
    };
  },
};
