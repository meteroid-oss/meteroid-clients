// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import {
  type CustomerPaymentMethodId,
  CustomerPaymentMethodIdSerializer,
} from "./customerPaymentMethodId.js";
import {
  type PaymentMethodInfo,
  PaymentMethodInfoSerializer,
} from "./paymentMethodInfo.js";
import {
  type PaymentStatusEnum,
  PaymentStatusEnumSerializer,
} from "./paymentStatusEnum.js";
import {
  type PaymentTransactionId,
  PaymentTransactionIdSerializer,
} from "./paymentTransactionId.js";
import { type PaymentTypeEnum, PaymentTypeEnumSerializer } from "./paymentTypeEnum.js";

export interface Transaction {
  amount: number;
  currency: string;
  error?: string | null | undefined;
  id: PaymentTransactionId;
  paymentMethodId?: CustomerPaymentMethodId | null | undefined;
  paymentMethodInfo?: PaymentMethodInfo | null | undefined;
  paymentType: PaymentTypeEnum;
  processedAt?: Date | null | undefined;
  providerTransactionId?: string | null | undefined;
  status: PaymentStatusEnum;
}

/** Converts `Transaction` values from (`parse`) and to (`serialize`) their JSON form. */
export const TransactionSerializer = {
  parse(json: any): Transaction {
    return {
      ...extraProperties(json, [
        "amount",
        "currency",
        "error",
        "id",
        "payment_method_id",
        "payment_method_info",
        "payment_type",
        "processed_at",
        "provider_transaction_id",
        "status",
      ]),
      amount: json["amount"],
      currency: json["currency"],
      error: json["error"],
      id: PaymentTransactionIdSerializer.parse(json["id"]),
      paymentMethodId:
        json["payment_method_id"] != null
          ? CustomerPaymentMethodIdSerializer.parse(json["payment_method_id"])
          : json["payment_method_id"],
      paymentMethodInfo:
        json["payment_method_info"] != null
          ? PaymentMethodInfoSerializer.parse(json["payment_method_info"])
          : json["payment_method_info"],
      paymentType: PaymentTypeEnumSerializer.parse(json["payment_type"]),
      processedAt:
        json["processed_at"] != null
          ? parseDateTime(json["processed_at"])
          : json["processed_at"],
      providerTransactionId: json["provider_transaction_id"],
      status: PaymentStatusEnumSerializer.parse(json["status"]),
    };
  },

  serialize(value: Transaction): any {
    return {
      ...extraProperties(value, [
        "amount",
        "currency",
        "error",
        "id",
        "paymentMethodId",
        "paymentMethodInfo",
        "paymentType",
        "processedAt",
        "providerTransactionId",
        "status",
      ]),
      amount: value.amount,
      currency: value.currency,
      error: value.error,
      id: PaymentTransactionIdSerializer.serialize(value.id),
      payment_method_id:
        value.paymentMethodId != null
          ? CustomerPaymentMethodIdSerializer.serialize(value.paymentMethodId)
          : value.paymentMethodId,
      payment_method_info:
        value.paymentMethodInfo != null
          ? PaymentMethodInfoSerializer.serialize(value.paymentMethodInfo)
          : value.paymentMethodInfo,
      payment_type: PaymentTypeEnumSerializer.serialize(value.paymentType),
      processed_at: value.processedAt,
      provider_transaction_id: value.providerTransactionId,
      status: PaymentStatusEnumSerializer.serialize(value.status),
    };
  },
};
