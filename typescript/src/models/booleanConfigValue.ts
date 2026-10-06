// this file is @generated
import { extraProperties } from "../json.js";
/** A boolean config value. */
export interface BooleanConfigValue {
  value: boolean;
}

/** Converts `BooleanConfigValue` values from (`parse`) and to (`serialize`) their JSON form. */
export const BooleanConfigValueSerializer = {
  parse(json: any): BooleanConfigValue {
    return {
      ...extraProperties(json, ["value"]),
      value: json["value"],
    };
  },

  serialize(value: BooleanConfigValue): any {
    return {
      ...extraProperties(value, ["value"]),
      value: value.value,
    };
  },
};
