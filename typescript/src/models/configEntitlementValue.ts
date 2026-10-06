// this file is @generated
import { extraProperties } from "../json.js";
import { type ConfigValue, ConfigValueSerializer } from "./configValue.js";

export interface ConfigEntitlementValue {
  value: ConfigValue;
}

/** Converts `ConfigEntitlementValue` values from (`parse`) and to (`serialize`) their JSON form. */
export const ConfigEntitlementValueSerializer = {
  parse(json: any): ConfigEntitlementValue {
    return {
      ...extraProperties(json, ["value"]),
      value: ConfigValueSerializer.parse(json["value"]),
    };
  },

  serialize(value: ConfigEntitlementValue): any {
    return {
      ...extraProperties(value, ["value"]),
      value: ConfigValueSerializer.serialize(value.value),
    };
  },
};
