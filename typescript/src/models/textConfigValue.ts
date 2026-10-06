// this file is @generated
import { extraProperties } from "../json.js";
/** A text config value. */
export interface TextConfigValue {
  value: string;
}

/** Converts `TextConfigValue` values from (`parse`) and to (`serialize`) their JSON form. */
export const TextConfigValueSerializer = {
  parse(json: any): TextConfigValue {
    return {
      ...extraProperties(json, ["value"]),
      value: json["value"],
    };
  },

  serialize(value: TextConfigValue): any {
    return {
      ...extraProperties(value, ["value"]),
      value: value.value,
    };
  },
};
