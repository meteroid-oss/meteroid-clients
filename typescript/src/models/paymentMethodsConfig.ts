// this file is @generated
import {
  type BankTransferPaymentMethodConfig,
  BankTransferPaymentMethodConfigSerializer,
} from "./bankTransferPaymentMethodConfig.js";
import {
  type ExternalPaymentMethodConfig,
  ExternalPaymentMethodConfigSerializer,
} from "./externalPaymentMethodConfig.js";
import {
  type OnlinePaymentMethodConfig,
  OnlinePaymentMethodConfigSerializer,
} from "./onlinePaymentMethodConfig.js";

export interface PaymentMethodsConfigOnline extends OnlinePaymentMethodConfig {
  type: "online";
}
export interface PaymentMethodsConfigBankTransfer
  extends BankTransferPaymentMethodConfig {
  type: "bank_transfer";
}
export interface PaymentMethodsConfigExternal extends ExternalPaymentMethodConfig {
  type: "external";
}

/** Online (card/direct debit), BankTransfer, or External. */
export type PaymentMethodsConfig =
  | PaymentMethodsConfigOnline
  | PaymentMethodsConfigBankTransfer
  | PaymentMethodsConfigExternal;

/** Converts `PaymentMethodsConfig` values from (`parse`) and to (`serialize`) their JSON form. */
export const PaymentMethodsConfigSerializer = {
  parse(json: any): PaymentMethodsConfig {
    switch (json["type"]) {
      case "online":
        return {
          ...OnlinePaymentMethodConfigSerializer.parse(json),
          type: "online",
        };
      case "bank_transfer":
        return {
          ...BankTransferPaymentMethodConfigSerializer.parse(json),
          type: "bank_transfer",
        };
      case "external":
        return {
          ...ExternalPaymentMethodConfigSerializer.parse(json),
          type: "external",
        };
      default:
        // A variant added to the API after this SDK was generated, kept as received.
        return json;
    }
  },

  serialize(value: PaymentMethodsConfig): any {
    switch (value.type) {
      case "online":
        return {
          ...OnlinePaymentMethodConfigSerializer.serialize(value),
          type: "online",
        };
      case "bank_transfer":
        return {
          ...BankTransferPaymentMethodConfigSerializer.serialize(value),
          type: "bank_transfer",
        };
      case "external":
        return {
          ...ExternalPaymentMethodConfigSerializer.serialize(value),
          type: "external",
        };
      default:
        return value;
    }
  },
};
