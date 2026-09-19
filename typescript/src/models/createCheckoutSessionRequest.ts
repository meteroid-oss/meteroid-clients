// this file is @generated
import { type CouponId, CouponIdSerializer } from "./couponId";
import {
  type CreateSubscriptionAddOn,
  CreateSubscriptionAddOnSerializer,
} from "./createSubscriptionAddOn";
import {
  type CreateSubscriptionComponents,
  CreateSubscriptionComponentsSerializer,
} from "./createSubscriptionComponents";
import {
  type PaymentMethodsConfig,
  PaymentMethodsConfigSerializer,
} from "./paymentMethodsConfig";
import { type PlanVersionId, PlanVersionIdSerializer } from "./planVersionId";

export interface CreateCheckoutSessionRequest {
  addOns?: CreateSubscriptionAddOn[] | null;

  /** If false, invoices will stay in Draft until manually reviewed and finalized. Default is true. */
  autoAdvanceInvoices?: boolean | null;

  billingDayAnchor?: number | null;

  billingStartDate?: string | null;

  /** Automatically try to charge the customer's configured payment method on finalize. Default is true. */
  chargeAutomatically?: boolean | null;

  components?: CreateSubscriptionComponents | null;

  couponCode?: string | null;

  couponIds?: CouponId[];

  /** Customer ID or alias */
  customerId: string;

  endDate?: string | null;

  /** Session expiry time in hours. Default is 1 hour for self-serve checkout. */
  expiresInHours?: number | null;

  invoiceMemo?: string | null;

  invoiceThreshold?: string | null;

  metadata?: any;

  netTerms?: number | null;

  paymentMethodsConfig?: PaymentMethodsConfig | null;

  planVersionId: PlanVersionId;

  purchaseOrder?: string | null;

  trialDurationDays?: number | null;
}

export const CreateCheckoutSessionRequestSerializer = {
  _fromJsonObject(object: any): CreateCheckoutSessionRequest {
    return {
      addOns:
        object["add_ons"] != null
          ? object["add_ons"].map((item: any) =>
              CreateSubscriptionAddOnSerializer._fromJsonObject(item)
            )
          : undefined,
      autoAdvanceInvoices: object["auto_advance_invoices"],
      billingDayAnchor: object["billing_day_anchor"],
      billingStartDate: object["billing_start_date"],
      chargeAutomatically: object["charge_automatically"],
      components:
        object["components"] != null
          ? CreateSubscriptionComponentsSerializer._fromJsonObject(object["components"])
          : undefined,
      couponCode: object["coupon_code"],
      couponIds:
        object["coupon_ids"] != null
          ? object["coupon_ids"].map((item: any) =>
              CouponIdSerializer._fromJsonObject(item)
            )
          : undefined,
      customerId: object["customer_id"],
      endDate: object["end_date"],
      expiresInHours: object["expires_in_hours"],
      invoiceMemo: object["invoice_memo"],
      invoiceThreshold: object["invoice_threshold"],
      metadata: object["metadata"],
      netTerms: object["net_terms"],
      paymentMethodsConfig:
        object["payment_methods_config"] != null
          ? PaymentMethodsConfigSerializer._fromJsonObject(
              object["payment_methods_config"]
            )
          : undefined,
      planVersionId: PlanVersionIdSerializer._fromJsonObject(object["plan_version_id"]),
      purchaseOrder: object["purchase_order"],
      trialDurationDays: object["trial_duration_days"],
    };
  },

  _toJsonObject(self: CreateCheckoutSessionRequest): any {
    return {
      add_ons:
        self.addOns != null
          ? self.addOns.map((item: any) =>
              CreateSubscriptionAddOnSerializer._toJsonObject(item)
            )
          : undefined,
      auto_advance_invoices: self.autoAdvanceInvoices,
      billing_day_anchor: self.billingDayAnchor,
      billing_start_date: self.billingStartDate,
      charge_automatically: self.chargeAutomatically,
      components:
        self.components != null
          ? CreateSubscriptionComponentsSerializer._toJsonObject(self.components)
          : undefined,
      coupon_code: self.couponCode,
      coupon_ids:
        self.couponIds != null
          ? self.couponIds.map((item: any) => CouponIdSerializer._toJsonObject(item))
          : undefined,
      customer_id: self.customerId,
      end_date: self.endDate,
      expires_in_hours: self.expiresInHours,
      invoice_memo: self.invoiceMemo,
      invoice_threshold: self.invoiceThreshold,
      metadata: self.metadata,
      net_terms: self.netTerms,
      payment_methods_config:
        self.paymentMethodsConfig != null
          ? PaymentMethodsConfigSerializer._toJsonObject(self.paymentMethodsConfig)
          : undefined,
      plan_version_id: PlanVersionIdSerializer._toJsonObject(self.planVersionId),
      purchase_order: self.purchaseOrder,
      trial_duration_days: self.trialDurationDays,
    };
  },
};
