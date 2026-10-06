// this file is @generated
import { extraProperties } from "../json.js";
/** A number config value (decimal, encoded as a string). */
export interface NumberConfigValue {
  value: string;
}

/** Converts `NumberConfigValue` values from (`parse`) and to (`serialize`) their JSON form. */
export const NumberConfigValueSerializer = {
  parse(json: any): NumberConfigValue {
    return {
      ...extraProperties(json, ["value"]),
      value: json["value"],
    };
  },

  serialize(value: NumberConfigValue): any {
    return {
      ...extraProperties(value, ["value"]),
      value: value.value,
    };
  },
};
