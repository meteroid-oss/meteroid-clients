// this file is @generated
import {
  type BankTransferPaymentMethodConfig,
  BankTransferPaymentMethodConfigSerializer,
} from "./bankTransferPaymentMethodConfig";
import {
  type ExternalPaymentMethodConfig,
  ExternalPaymentMethodConfigSerializer,
} from "./externalPaymentMethodConfig";
import {
  type OnlinePaymentMethodConfig,
  OnlinePaymentMethodConfigSerializer,
} from "./onlinePaymentMethodConfig";

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

export const PaymentMethodsConfigSerializer = {
  _fromJsonObject(object: any): PaymentMethodsConfig {
    const type = object["type"];

    switch (type) {
      case "online":
        return {
          ...OnlinePaymentMethodConfigSerializer._fromJsonObject(object),
          type: "online",
        };
      case "bank_transfer":
        return {
          ...BankTransferPaymentMethodConfigSerializer._fromJsonObject(object),
          type: "bank_transfer",
        };
      case "external":
        return {
          ...ExternalPaymentMethodConfigSerializer._fromJsonObject(object),
          type: "external",
        };
      default:
        throw new Error(`Unexpected type for PaymentMethodsConfig: ${type}`);
    }
  },

  _toJsonObject(self: PaymentMethodsConfig): any {
    switch (self.type) {
      case "online":
        return {
          ...OnlinePaymentMethodConfigSerializer._toJsonObject(self),
          type: "online",
        };
      case "bank_transfer":
        return {
          ...BankTransferPaymentMethodConfigSerializer._toJsonObject(self),
          type: "bank_transfer",
        };
      case "external":
        return {
          ...ExternalPaymentMethodConfigSerializer._toJsonObject(self),
          type: "external",
        };
      default:
        throw new Error(`Unexpected type for PaymentMethodsConfig`);
    }
  },
};
