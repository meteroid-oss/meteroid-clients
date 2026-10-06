// this file is @generated
import { extraProperties } from "../json.js";

export interface ExternalPaymentMethodConfig {}

/** Converts `ExternalPaymentMethodConfig` values from (`parse`) and to (`serialize`) their JSON form. */
export const ExternalPaymentMethodConfigSerializer = {
  parse(json: any): ExternalPaymentMethodConfig {
    return {
      ...extraProperties(json, []),
    };
  },

  serialize(value: ExternalPaymentMethodConfig): any {
    return {
      ...extraProperties(value, []),
    };
  },
};
