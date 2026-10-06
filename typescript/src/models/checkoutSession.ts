// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import {
  type CheckoutSessionId,
  CheckoutSessionIdSerializer,
} from "./checkoutSessionId.js";
import {
  type CheckoutSessionStatus,
  CheckoutSessionStatusSerializer,
} from "./checkoutSessionStatus.js";
import { type CheckoutType, CheckoutTypeSerializer } from "./checkoutType.js";
import { type CustomerId, CustomerIdSerializer } from "./customerId.js";
import {
  type PaymentMethodsConfig,
  PaymentMethodsConfigSerializer,
} from "./paymentMethodsConfig.js";
import { type PlanVersionId, PlanVersionIdSerializer } from "./planVersionId.js";
import { type SubscriptionId, SubscriptionIdSerializer } from "./subscriptionId.js";

export interface CheckoutSession {
  billingDayAnchor?: number | null | undefined;
  billingStartDate?: string | null | undefined;
  cancelUrl?: string | null | undefined;
  checkoutType: CheckoutType;
  checkoutUrl?: string | null | undefined;
  completedAt?: Date | null | undefined;
  couponCode?: string | null | undefined;
  createdAt: Date;
  customerId: CustomerId;
  /** When the session expires. None means the session never expires. */
  expiresAt?: Date | null | undefined;
  id: CheckoutSessionId;
  netTerms?: number | null | undefined;
  paymentMethodsConfig?: PaymentMethodsConfig | null | undefined;
  planVersionId: PlanVersionId;
  status: CheckoutSessionStatus;
  subscriptionId?: SubscriptionId | null | undefined;
  successUrl?: string | null | undefined;
  trialDurationDays?: number | null | undefined;
}

/** Converts `CheckoutSession` values from (`parse`) and to (`serialize`) their JSON form. */
export const CheckoutSessionSerializer = {
  parse(json: any): CheckoutSession {
    return {
      ...extraProperties(json, [
        "billing_day_anchor",
        "billing_start_date",
        "cancel_url",
        "checkout_type",
        "checkout_url",
        "completed_at",
        "coupon_code",
        "created_at",
        "customer_id",
        "expires_at",
        "id",
        "net_terms",
        "payment_methods_config",
        "plan_version_id",
        "status",
        "subscription_id",
        "success_url",
        "trial_duration_days",
      ]),
      billingDayAnchor: json["billing_day_anchor"],
      billingStartDate: json["billing_start_date"],
      cancelUrl: json["cancel_url"],
      checkoutType: CheckoutTypeSerializer.parse(json["checkout_type"]),
      checkoutUrl: json["checkout_url"],
      completedAt:
        json["completed_at"] != null
          ? parseDateTime(json["completed_at"])
          : json["completed_at"],
      couponCode: json["coupon_code"],
      createdAt: parseDateTime(json["created_at"]),
      customerId: CustomerIdSerializer.parse(json["customer_id"]),
      expiresAt:
        json["expires_at"] != null
          ? parseDateTime(json["expires_at"])
          : json["expires_at"],
      id: CheckoutSessionIdSerializer.parse(json["id"]),
      netTerms: json["net_terms"],
      paymentMethodsConfig:
        json["payment_methods_config"] != null
          ? PaymentMethodsConfigSerializer.parse(json["payment_methods_config"])
          : json["payment_methods_config"],
      planVersionId: PlanVersionIdSerializer.parse(json["plan_version_id"]),
      status: CheckoutSessionStatusSerializer.parse(json["status"]),
      subscriptionId:
        json["subscription_id"] != null
          ? SubscriptionIdSerializer.parse(json["subscription_id"])
          : json["subscription_id"],
      successUrl: json["success_url"],
      trialDurationDays: json["trial_duration_days"],
    };
  },

  serialize(value: CheckoutSession): any {
    return {
      ...extraProperties(value, [
        "billingDayAnchor",
        "billingStartDate",
        "cancelUrl",
        "checkoutType",
        "checkoutUrl",
        "completedAt",
        "couponCode",
        "createdAt",
        "customerId",
        "expiresAt",
        "id",
        "netTerms",
        "paymentMethodsConfig",
        "planVersionId",
        "status",
        "subscriptionId",
        "successUrl",
        "trialDurationDays",
      ]),
      billing_day_anchor: value.billingDayAnchor,
      billing_start_date: value.billingStartDate,
      cancel_url: value.cancelUrl,
      checkout_type: CheckoutTypeSerializer.serialize(value.checkoutType),
      checkout_url: value.checkoutUrl,
      completed_at: value.completedAt,
      coupon_code: value.couponCode,
      created_at: value.createdAt,
      customer_id: CustomerIdSerializer.serialize(value.customerId),
      expires_at: value.expiresAt,
      id: CheckoutSessionIdSerializer.serialize(value.id),
      net_terms: value.netTerms,
      payment_methods_config:
        value.paymentMethodsConfig != null
          ? PaymentMethodsConfigSerializer.serialize(value.paymentMethodsConfig)
          : value.paymentMethodsConfig,
      plan_version_id: PlanVersionIdSerializer.serialize(value.planVersionId),
      status: CheckoutSessionStatusSerializer.serialize(value.status),
      subscription_id:
        value.subscriptionId != null
          ? SubscriptionIdSerializer.serialize(value.subscriptionId)
          : value.subscriptionId,
      success_url: value.successUrl,
      trial_duration_days: value.trialDurationDays,
    };
  },
};
