// this file is @generated
import { extraProperties } from "../json.js";
import {
  type OnlineMethodConfig,
  OnlineMethodConfigSerializer,
} from "./onlineMethodConfig.js";

export interface OnlineMethodsConfig {
  card?: OnlineMethodConfig | null | undefined;
  directDebit?: OnlineMethodConfig | null | undefined;
}

/** Converts `OnlineMethodsConfig` values from (`parse`) and to (`serialize`) their JSON form. */
export const OnlineMethodsConfigSerializer = {
  parse(json: any): OnlineMethodsConfig {
    return {
      ...extraProperties(json, ["card", "direct_debit"]),
      card:
        json["card"] != null
          ? OnlineMethodConfigSerializer.parse(json["card"])
          : json["card"],
      directDebit:
        json["direct_debit"] != null
          ? OnlineMethodConfigSerializer.parse(json["direct_debit"])
          : json["direct_debit"],
    };
  },

  serialize(value: OnlineMethodsConfig): any {
    return {
      ...extraProperties(value, ["card", "directDebit"]),
      card:
        value.card != null
          ? OnlineMethodConfigSerializer.serialize(value.card)
          : value.card,
      direct_debit:
        value.directDebit != null
          ? OnlineMethodConfigSerializer.serialize(value.directDebit)
          : value.directDebit,
    };
  },
};
