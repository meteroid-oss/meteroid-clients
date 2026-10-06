// this file is @generated
import { extraProperties } from "../json.js";

export interface BooleanEntitlementValue {
  enabled: boolean;
}

/** Converts `BooleanEntitlementValue` values from (`parse`) and to (`serialize`) their JSON form. */
export const BooleanEntitlementValueSerializer = {
  parse(json: any): BooleanEntitlementValue {
    return {
      ...extraProperties(json, ["enabled"]),
      enabled: json["enabled"],
    };
  },

  serialize(value: BooleanEntitlementValue): any {
    return {
      ...extraProperties(value, ["enabled"]),
      enabled: value.enabled,
    };
  },
};
