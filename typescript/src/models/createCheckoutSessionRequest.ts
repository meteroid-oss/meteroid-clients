// this file is @generated
import { extraProperties } from "../json.js";
import { type CouponId, CouponIdSerializer } from "./couponId.js";
import {
  type CreateSubscriptionAddOn,
  CreateSubscriptionAddOnSerializer,
} from "./createSubscriptionAddOn.js";
import {
  type CreateSubscriptionComponents,
  CreateSubscriptionComponentsSerializer,
} from "./createSubscriptionComponents.js";
import {
  type PaymentMethodsConfig,
  PaymentMethodsConfigSerializer,
} from "./paymentMethodsConfig.js";
import { type PlanVersionId, PlanVersionIdSerializer } from "./planVersionId.js";

export interface CreateCheckoutSessionRequest {
  addOns?: CreateSubscriptionAddOn[] | null | undefined;
  /** If false, invoices will stay in Draft until manually reviewed and finalized. Default is true. */
  autoAdvanceInvoices?: boolean | null | undefined;
  billingDayAnchor?: number | null | undefined;
  billingStartDate?: string | null | undefined;
  /** Absolute http(s) URL offered to the customer to leave the checkout without paying. */
  cancelUrl?: string | null | undefined;
  /** Automatically try to charge the customer's configured payment method on finalize. Default is true. */
  chargeAutomatically?: boolean | null | undefined;
  components?: CreateSubscriptionComponents | null | undefined;
  couponCode?: string | null | undefined;
  couponIds?: CouponId[] | undefined;
  /** Customer ID or alias */
  customerId: string;
  endDate?: string | null | undefined;
  /** Session expiry time in hours. Default is 1 hour for self-serve checkout. */
  expiresInHours?: number | null | undefined;
  invoiceMemo?: string | null | undefined;
  invoiceThreshold?: string | null | undefined;
  metadata?: unknown | undefined;
  netTerms?: number | null | undefined;
  paymentMethodsConfig?: PaymentMethodsConfig | null | undefined;
  planVersionId: PlanVersionId;
  purchaseOrder?: string | null | undefined;
  /**
   * Absolute http(s) URL the customer is sent to after a successful checkout.
   * `checkout_session_id` is appended as a query parameter. Without it the customer stays on
   * the hosted confirmation page.
   */
  successUrl?: string | null | undefined;
  trialDurationDays?: number | null | undefined;
}

/** Converts `CreateCheckoutSessionRequest` values from (`parse`) and to (`serialize`) their JSON form. */
export const CreateCheckoutSessionRequestSerializer = {
  parse(json: any): CreateCheckoutSessionRequest {
    return {
      ...extraProperties(json, [
        "add_ons",
        "auto_advance_invoices",
        "billing_day_anchor",
        "billing_start_date",
        "cancel_url",
        "charge_automatically",
        "components",
        "coupon_code",
        "coupon_ids",
        "customer_id",
        "end_date",
        "expires_in_hours",
        "invoice_memo",
        "invoice_threshold",
        "metadata",
        "net_terms",
        "payment_methods_config",
        "plan_version_id",
        "purchase_order",
        "success_url",
        "trial_duration_days",
      ]),
      addOns:
        json["add_ons"] != null
          ? json["add_ons"].map((item: any) =>
              CreateSubscriptionAddOnSerializer.parse(item)
            )
          : json["add_ons"],
      autoAdvanceInvoices: json["auto_advance_invoices"],
      billingDayAnchor: json["billing_day_anchor"],
      billingStartDate: json["billing_start_date"],
      cancelUrl: json["cancel_url"],
      chargeAutomatically: json["charge_automatically"],
      components:
        json["components"] != null
          ? CreateSubscriptionComponentsSerializer.parse(json["components"])
          : json["components"],
      couponCode: json["coupon_code"],
      couponIds:
        json["coupon_ids"] != null
          ? json["coupon_ids"].map((item: any) => CouponIdSerializer.parse(item))
          : undefined,
      customerId: json["customer_id"],
      endDate: json["end_date"],
      expiresInHours: json["expires_in_hours"],
      invoiceMemo: json["invoice_memo"],
      invoiceThreshold: json["invoice_threshold"],
      metadata: json["metadata"],
      netTerms: json["net_terms"],
      paymentMethodsConfig:
        json["payment_methods_config"] != null
          ? PaymentMethodsConfigSerializer.parse(json["payment_methods_config"])
          : json["payment_methods_config"],
      planVersionId: PlanVersionIdSerializer.parse(json["plan_version_id"]),
      purchaseOrder: json["purchase_order"],
      successUrl: json["success_url"],
      trialDurationDays: json["trial_duration_days"],
    };
  },

  serialize(value: CreateCheckoutSessionRequest): any {
    return {
      ...extraProperties(value, [
        "addOns",
        "autoAdvanceInvoices",
        "billingDayAnchor",
        "billingStartDate",
        "cancelUrl",
        "chargeAutomatically",
        "components",
        "couponCode",
        "couponIds",
        "customerId",
        "endDate",
        "expiresInHours",
        "invoiceMemo",
        "invoiceThreshold",
        "metadata",
        "netTerms",
        "paymentMethodsConfig",
        "planVersionId",
        "purchaseOrder",
        "successUrl",
        "trialDurationDays",
      ]),
      add_ons:
        value.addOns != null
          ? value.addOns.map((item: any) =>
              CreateSubscriptionAddOnSerializer.serialize(item)
            )
          : value.addOns,
      auto_advance_invoices: value.autoAdvanceInvoices,
      billing_day_anchor: value.billingDayAnchor,
      billing_start_date: value.billingStartDate,
      cancel_url: value.cancelUrl,
      charge_automatically: value.chargeAutomatically,
      components:
        value.components != null
          ? CreateSubscriptionComponentsSerializer.serialize(value.components)
          : value.components,
      coupon_code: value.couponCode,
      coupon_ids:
        value.couponIds != null
          ? value.couponIds.map((item: any) => CouponIdSerializer.serialize(item))
          : undefined,
      customer_id: value.customerId,
      end_date: value.endDate,
      expires_in_hours: value.expiresInHours,
      invoice_memo: value.invoiceMemo,
      invoice_threshold: value.invoiceThreshold,
      metadata: value.metadata,
      net_terms: value.netTerms,
      payment_methods_config:
        value.paymentMethodsConfig != null
          ? PaymentMethodsConfigSerializer.serialize(value.paymentMethodsConfig)
          : value.paymentMethodsConfig,
      plan_version_id: PlanVersionIdSerializer.serialize(value.planVersionId),
      purchase_order: value.purchaseOrder,
      success_url: value.successUrl,
      trial_duration_days: value.trialDurationDays,
    };
  },
};
