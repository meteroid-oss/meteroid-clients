// this file is @generated
import { extraProperties } from "../json.js";
import {
  type PaymentMethodTypeEnum,
  PaymentMethodTypeEnumSerializer,
} from "./paymentMethodTypeEnum.js";

export interface PaymentMethodInfo {
  accountNumberHint?: string | null | undefined;
  cardBrand?: string | null | undefined;
  cardLast4?: string | null | undefined;
  paymentMethodType: PaymentMethodTypeEnum;
}

/** Converts `PaymentMethodInfo` values from (`parse`) and to (`serialize`) their JSON form. */
export const PaymentMethodInfoSerializer = {
  parse(json: any): PaymentMethodInfo {
    return {
      ...extraProperties(json, [
        "account_number_hint",
        "card_brand",
        "card_last4",
        "payment_method_type",
      ]),
      accountNumberHint: json["account_number_hint"],
      cardBrand: json["card_brand"],
      cardLast4: json["card_last4"],
      paymentMethodType: PaymentMethodTypeEnumSerializer.parse(
        json["payment_method_type"]
      ),
    };
  },

  serialize(value: PaymentMethodInfo): any {
    return {
      ...extraProperties(value, [
        "accountNumberHint",
        "cardBrand",
        "cardLast4",
        "paymentMethodType",
      ]),
      account_number_hint: value.accountNumberHint,
      card_brand: value.cardBrand,
      card_last4: value.cardLast4,
      payment_method_type: PaymentMethodTypeEnumSerializer.serialize(
        value.paymentMethodType
      ),
    };
  },
};
