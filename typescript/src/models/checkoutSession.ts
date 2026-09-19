// this file is @generated
import { parseDateTime } from "../datetime";
import { type CheckoutSessionId, CheckoutSessionIdSerializer } from "./checkoutSessionId";
import {
  type CheckoutSessionStatus,
  CheckoutSessionStatusSerializer,
} from "./checkoutSessionStatus";
import { type CheckoutType, CheckoutTypeSerializer } from "./checkoutType";
import { type CustomerId, CustomerIdSerializer } from "./customerId";
import {
  type PaymentMethodsConfig,
  PaymentMethodsConfigSerializer,
} from "./paymentMethodsConfig";
import { type PlanVersionId, PlanVersionIdSerializer } from "./planVersionId";
import { type SubscriptionId, SubscriptionIdSerializer } from "./subscriptionId";

export interface CheckoutSession {
  billingDayAnchor?: number | null;

  billingStartDate?: string | null;

  checkoutType: CheckoutType;

  checkoutUrl?: string | null;

  completedAt?: Date | null;

  couponCode?: string | null;

  createdAt: Date;

  customerId: CustomerId;

  /** When the session expires. None means the session never expires. */
  expiresAt?: Date | null;

  id: CheckoutSessionId;

  netTerms?: number | null;

  paymentMethodsConfig?: PaymentMethodsConfig | null;

  planVersionId: PlanVersionId;

  status: CheckoutSessionStatus;

  subscriptionId?: SubscriptionId | null;

  trialDurationDays?: number | null;
}

export const CheckoutSessionSerializer = {
  _fromJsonObject(object: any): CheckoutSession {
    return {
      billingDayAnchor: object["billing_day_anchor"],
      billingStartDate: object["billing_start_date"],
      checkoutType: CheckoutTypeSerializer._fromJsonObject(object["checkout_type"]),
      checkoutUrl: object["checkout_url"],
      completedAt:
        object["completed_at"] != null
          ? parseDateTime(object["completed_at"])
          : undefined,
      couponCode: object["coupon_code"],
      createdAt: parseDateTime(object["created_at"]),
      customerId: CustomerIdSerializer._fromJsonObject(object["customer_id"]),
      expiresAt:
        object["expires_at"] != null ? parseDateTime(object["expires_at"]) : undefined,
      id: CheckoutSessionIdSerializer._fromJsonObject(object["id"]),
      netTerms: object["net_terms"],
      paymentMethodsConfig:
        object["payment_methods_config"] != null
          ? PaymentMethodsConfigSerializer._fromJsonObject(
              object["payment_methods_config"]
            )
          : undefined,
      planVersionId: PlanVersionIdSerializer._fromJsonObject(object["plan_version_id"]),
      status: CheckoutSessionStatusSerializer._fromJsonObject(object["status"]),
      subscriptionId:
        object["subscription_id"] != null
          ? SubscriptionIdSerializer._fromJsonObject(object["subscription_id"])
          : undefined,
      trialDurationDays: object["trial_duration_days"],
    };
  },

  _toJsonObject(self: CheckoutSession): any {
    return {
      billing_day_anchor: self.billingDayAnchor,
      billing_start_date: self.billingStartDate,
      checkout_type: CheckoutTypeSerializer._toJsonObject(self.checkoutType),
      checkout_url: self.checkoutUrl,
      completed_at: self.completedAt,
      coupon_code: self.couponCode,
      created_at: self.createdAt,
      customer_id: CustomerIdSerializer._toJsonObject(self.customerId),
      expires_at: self.expiresAt,
      id: CheckoutSessionIdSerializer._toJsonObject(self.id),
      net_terms: self.netTerms,
      payment_methods_config:
        self.paymentMethodsConfig != null
          ? PaymentMethodsConfigSerializer._toJsonObject(self.paymentMethodsConfig)
          : undefined,
      plan_version_id: PlanVersionIdSerializer._toJsonObject(self.planVersionId),
      status: CheckoutSessionStatusSerializer._toJsonObject(self.status),
      subscription_id:
        self.subscriptionId != null
          ? SubscriptionIdSerializer._toJsonObject(self.subscriptionId)
          : undefined,
      trial_duration_days: self.trialDurationDays,
    };
  },
};
