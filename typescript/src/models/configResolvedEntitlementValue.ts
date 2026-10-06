// this file is @generated
import { extraProperties } from "../json.js";
import { type ConfigValue, ConfigValueSerializer } from "./configValue.js";

export interface ConfigResolvedEntitlementValue {
  value: ConfigValue;
}

/** Converts `ConfigResolvedEntitlementValue` values from (`parse`) and to (`serialize`) their JSON form. */
export const ConfigResolvedEntitlementValueSerializer = {
  parse(json: any): ConfigResolvedEntitlementValue {
    return {
      ...extraProperties(json, ["value"]),
      value: ConfigValueSerializer.parse(json["value"]),
    };
  },

  serialize(value: ConfigResolvedEntitlementValue): any {
    return {
      ...extraProperties(value, ["value"]),
      value: ConfigValueSerializer.serialize(value.value),
    };
  },
};
