// this file is @generated
import { parseDateTime } from "../datetime";
import {
  type CustomerPaymentMethodId,
  CustomerPaymentMethodIdSerializer,
} from "./customerPaymentMethodId";
import { type PaymentMethodInfo, PaymentMethodInfoSerializer } from "./paymentMethodInfo";
import { type PaymentStatusEnum, PaymentStatusEnumSerializer } from "./paymentStatusEnum";
import {
  type PaymentTransactionId,
  PaymentTransactionIdSerializer,
} from "./paymentTransactionId";
import { type PaymentTypeEnum, PaymentTypeEnumSerializer } from "./paymentTypeEnum";

export interface Transaction {
  amount: number;

  currency: string;

  error?: string | null;

  id: PaymentTransactionId;

  paymentMethodId?: CustomerPaymentMethodId | null;

  paymentMethodInfo?: PaymentMethodInfo | null;

  paymentType: PaymentTypeEnum;

  processedAt?: Date | null;

  providerTransactionId?: string | null;

  status: PaymentStatusEnum;
}

export const TransactionSerializer = {
  _fromJsonObject(object: any): Transaction {
    return {
      amount: object["amount"],
      currency: object["currency"],
      error: object["error"],
      id: PaymentTransactionIdSerializer._fromJsonObject(object["id"]),
      paymentMethodId:
        object["payment_method_id"] != null
          ? CustomerPaymentMethodIdSerializer._fromJsonObject(object["payment_method_id"])
          : undefined,
      paymentMethodInfo:
        object["payment_method_info"] != null
          ? PaymentMethodInfoSerializer._fromJsonObject(object["payment_method_info"])
          : undefined,
      paymentType: PaymentTypeEnumSerializer._fromJsonObject(object["payment_type"]),
      processedAt:
        object["processed_at"] != null
          ? parseDateTime(object["processed_at"])
          : undefined,
      providerTransactionId: object["provider_transaction_id"],
      status: PaymentStatusEnumSerializer._fromJsonObject(object["status"]),
    };
  },

  _toJsonObject(self: Transaction): any {
    return {
      amount: self.amount,
      currency: self.currency,
      error: self.error,
      id: PaymentTransactionIdSerializer._toJsonObject(self.id),
      payment_method_id:
        self.paymentMethodId != null
          ? CustomerPaymentMethodIdSerializer._toJsonObject(self.paymentMethodId)
          : undefined,
      payment_method_info:
        self.paymentMethodInfo != null
          ? PaymentMethodInfoSerializer._toJsonObject(self.paymentMethodInfo)
          : undefined,
      payment_type: PaymentTypeEnumSerializer._toJsonObject(self.paymentType),
      processed_at: self.processedAt,
      provider_transaction_id: self.providerTransactionId,
      status: PaymentStatusEnumSerializer._toJsonObject(self.status),
    };
  },
};
