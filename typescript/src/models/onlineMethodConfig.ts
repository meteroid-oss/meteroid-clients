// this file is @generated
import { extraProperties } from "../json.js";

export interface OnlineMethodConfig {
  enabled: boolean;
}

/** Converts `OnlineMethodConfig` values from (`parse`) and to (`serialize`) their JSON form. */
export const OnlineMethodConfigSerializer = {
  parse(json: any): OnlineMethodConfig {
    return {
      ...extraProperties(json, ["enabled"]),
      enabled: json["enabled"],
    };
  },

  serialize(value: OnlineMethodConfig): any {
    return {
      ...extraProperties(value, ["enabled"]),
      enabled: value.enabled,
    };
  },
};
