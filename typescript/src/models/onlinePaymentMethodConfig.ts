// this file is @generated
import {
  type OnlineMethodsConfig,
  OnlineMethodsConfigSerializer,
} from "./onlineMethodsConfig";

export interface OnlinePaymentMethodConfig {
  config?: OnlineMethodsConfig | null;
}

export const OnlinePaymentMethodConfigSerializer = {
  _fromJsonObject(object: any): OnlinePaymentMethodConfig {
    return {
      config:
        object["config"] != null
          ? OnlineMethodsConfigSerializer._fromJsonObject(object["config"])
          : undefined,
    };
  },

  _toJsonObject(self: OnlinePaymentMethodConfig): any {
    return {
      config:
        self.config != null
          ? OnlineMethodsConfigSerializer._toJsonObject(self.config)
          : undefined,
    };
  },
};
