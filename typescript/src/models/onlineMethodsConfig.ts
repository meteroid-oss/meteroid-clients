// this file is @generated
import {
  type OnlineMethodConfig,
  OnlineMethodConfigSerializer,
} from "./onlineMethodConfig";

export interface OnlineMethodsConfig {
  card?: OnlineMethodConfig | null;

  directDebit?: OnlineMethodConfig | null;
}

export const OnlineMethodsConfigSerializer = {
  _fromJsonObject(object: any): OnlineMethodsConfig {
    return {
      card:
        object["card"] != null
          ? OnlineMethodConfigSerializer._fromJsonObject(object["card"])
          : undefined,
      directDebit:
        object["direct_debit"] != null
          ? OnlineMethodConfigSerializer._fromJsonObject(object["direct_debit"])
          : undefined,
    };
  },

  _toJsonObject(self: OnlineMethodsConfig): any {
    return {
      card:
        self.card != null
          ? OnlineMethodConfigSerializer._toJsonObject(self.card)
          : undefined,
      direct_debit:
        self.directDebit != null
          ? OnlineMethodConfigSerializer._toJsonObject(self.directDebit)
          : undefined,
    };
  },
};
