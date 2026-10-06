// this file is @generated
import { extraProperties } from "../json.js";
/** A structured (JSON) config value — the "metadata" case, several fields in one entitlement. */
export interface JsonConfigValue {
  value: unknown;
}

/** Converts `JsonConfigValue` values from (`parse`) and to (`serialize`) their JSON form. */
export const JsonConfigValueSerializer = {
  parse(json: any): JsonConfigValue {
    return {
      ...extraProperties(json, ["value"]),
      value: json["value"],
    };
  },

  serialize(value: JsonConfigValue): any {
    return {
      ...extraProperties(value, ["value"]),
      value: value.value,
    };
  },
};
