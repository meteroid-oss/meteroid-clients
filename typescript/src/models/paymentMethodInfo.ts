// this file is @generated
import {
  type PaymentMethodTypeEnum,
  PaymentMethodTypeEnumSerializer,
} from "./paymentMethodTypeEnum";

export interface PaymentMethodInfo {
  accountNumberHint?: string | null;

  cardBrand?: string | null;

  cardLast4?: string | null;

  paymentMethodType: PaymentMethodTypeEnum;
}

export const PaymentMethodInfoSerializer = {
  _fromJsonObject(object: any): PaymentMethodInfo {
    return {
      accountNumberHint: object["account_number_hint"],
      cardBrand: object["card_brand"],
      cardLast4: object["card_last4"],
      paymentMethodType: PaymentMethodTypeEnumSerializer._fromJsonObject(
        object["payment_method_type"]
      ),
    };
  },

  _toJsonObject(self: PaymentMethodInfo): any {
    return {
      account_number_hint: self.accountNumberHint,
      card_brand: self.cardBrand,
      card_last4: self.cardLast4,
      payment_method_type: PaymentMethodTypeEnumSerializer._toJsonObject(
        self.paymentMethodType
      ),
    };
  },
};
