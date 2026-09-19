// this file is @generated
import { parseDateTime } from "../datetime";
import {
  type AppliedCouponDetailed,
  AppliedCouponDetailedSerializer,
} from "./appliedCouponDetailed";
import { type BillingPeriodEnum, BillingPeriodEnumSerializer } from "./billingPeriodEnum";
import { type Currency, CurrencySerializer } from "./currency";
import { type CustomerId, CustomerIdSerializer } from "./customerId";
import { type Entitlement, EntitlementSerializer } from "./entitlement";
import { type MinimumCommitment, MinimumCommitmentSerializer } from "./minimumCommitment";
import {
  type PaymentMethodsConfig,
  PaymentMethodsConfigSerializer,
} from "./paymentMethodsConfig";
import { type PlanId, PlanIdSerializer } from "./planId";
import { type PlanVersionId, PlanVersionIdSerializer } from "./planVersionId";
import { type SubscriptionAddOn, SubscriptionAddOnSerializer } from "./subscriptionAddOn";
import {
  type SubscriptionComponent,
  SubscriptionComponentSerializer,
} from "./subscriptionComponent";
import { type SubscriptionId, SubscriptionIdSerializer } from "./subscriptionId";
import {
  type SubscriptionStatusEnum,
  SubscriptionStatusEnumSerializer,
} from "./subscriptionStatusEnum";

export interface SubscriptionDetails {
  /** When the subscription was activated (first payment or activation condition met) */
  activatedAt?: Date | null;

  addOns: SubscriptionAddOn[];

  appliedCoupons: AppliedCouponDetailed[];

  autoAdvanceInvoices: boolean;

  billingDayAnchor: number;

  /** When billing started (after any trial period) */
  billingStartDate?: string | null;

  chargeAutomatically: boolean;

  checkoutUrl?: string | null;

  components: SubscriptionComponent[];

  /** When the subscription was created */
  createdAt: Date;

  currency: Currency;

  /** Current billing period end date */
  currentPeriodEnd?: string | null;

  /** Current billing period start date */
  currentPeriodStart: string;

  /** User-defined custom property values, keyed by definition `key`. */
  customProperties: any;

  customerAlias?: string | null;

  customerId: CustomerId;

  customerName: string;

  /** When the subscription ends (if set) */
  endDate?: string | null;

  entitlements?: Entitlement[];

  id: SubscriptionId;

  /** Default memo for invoices */
  invoiceMemo?: string | null;

  minimumCommitment?: MinimumCommitment | null;

  /** Monthly recurring revenue in cents */
  mrrCents: number;

  /** Payment terms in days (0 = due on issue) */
  netTerms: number;

  paymentMethodsConfig?: PaymentMethodsConfig | null;

  /** Billing period (monthly, annual, etc.) */
  period: BillingPeriodEnum;

  planId: PlanId;

  planName: string;

  planVersion: number;

  planVersionId: PlanVersionId;

  purchaseOrder?: string | null;

  /** When the subscription contract starts (benefits apply from this date) */
  startDate: string;

  status: SubscriptionStatusEnum;

  /** Trial duration in days */
  trialDuration?: number | null;
}

export const SubscriptionDetailsSerializer = {
  _fromJsonObject(object: any): SubscriptionDetails {
    return {
      activatedAt:
        object["activated_at"] != null
          ? parseDateTime(object["activated_at"])
          : undefined,
      addOns: object["add_ons"].map((item: any) =>
        SubscriptionAddOnSerializer._fromJsonObject(item)
      ),
      appliedCoupons: object["applied_coupons"].map((item: any) =>
        AppliedCouponDetailedSerializer._fromJsonObject(item)
      ),
      autoAdvanceInvoices: object["auto_advance_invoices"],
      billingDayAnchor: object["billing_day_anchor"],
      billingStartDate: object["billing_start_date"],
      chargeAutomatically: object["charge_automatically"],
      checkoutUrl: object["checkout_url"],
      components: object["components"].map((item: any) =>
        SubscriptionComponentSerializer._fromJsonObject(item)
      ),
      createdAt: parseDateTime(object["created_at"]),
      currency: CurrencySerializer._fromJsonObject(object["currency"]),
      currentPeriodEnd: object["current_period_end"],
      currentPeriodStart: object["current_period_start"],
      customProperties: object["custom_properties"],
      customerAlias: object["customer_alias"],
      customerId: CustomerIdSerializer._fromJsonObject(object["customer_id"]),
      customerName: object["customer_name"],
      endDate: object["end_date"],
      entitlements:
        object["entitlements"] != null
          ? object["entitlements"].map((item: any) =>
              EntitlementSerializer._fromJsonObject(item)
            )
          : undefined,
      id: SubscriptionIdSerializer._fromJsonObject(object["id"]),
      invoiceMemo: object["invoice_memo"],
      minimumCommitment:
        object["minimum_commitment"] != null
          ? MinimumCommitmentSerializer._fromJsonObject(object["minimum_commitment"])
          : undefined,
      mrrCents: object["mrr_cents"],
      netTerms: object["net_terms"],
      paymentMethodsConfig:
        object["payment_methods_config"] != null
          ? PaymentMethodsConfigSerializer._fromJsonObject(
              object["payment_methods_config"]
            )
          : undefined,
      period: BillingPeriodEnumSerializer._fromJsonObject(object["period"]),
      planId: PlanIdSerializer._fromJsonObject(object["plan_id"]),
      planName: object["plan_name"],
      planVersion: object["plan_version"],
      planVersionId: PlanVersionIdSerializer._fromJsonObject(object["plan_version_id"]),
      purchaseOrder: object["purchase_order"],
      startDate: object["start_date"],
      status: SubscriptionStatusEnumSerializer._fromJsonObject(object["status"]),
      trialDuration: object["trial_duration"],
    };
  },

  _toJsonObject(self: SubscriptionDetails): any {
    return {
      activated_at: self.activatedAt,
      add_ons: self.addOns.map((item: any) =>
        SubscriptionAddOnSerializer._toJsonObject(item)
      ),
      applied_coupons: self.appliedCoupons.map((item: any) =>
        AppliedCouponDetailedSerializer._toJsonObject(item)
      ),
      auto_advance_invoices: self.autoAdvanceInvoices,
      billing_day_anchor: self.billingDayAnchor,
      billing_start_date: self.billingStartDate,
      charge_automatically: self.chargeAutomatically,
      checkout_url: self.checkoutUrl,
      components: self.components.map((item: any) =>
        SubscriptionComponentSerializer._toJsonObject(item)
      ),
      created_at: self.createdAt,
      currency: CurrencySerializer._toJsonObject(self.currency),
      current_period_end: self.currentPeriodEnd,
      current_period_start: self.currentPeriodStart,
      custom_properties: self.customProperties,
      customer_alias: self.customerAlias,
      customer_id: CustomerIdSerializer._toJsonObject(self.customerId),
      customer_name: self.customerName,
      end_date: self.endDate,
      entitlements:
        self.entitlements != null
          ? self.entitlements.map((item: any) =>
              EntitlementSerializer._toJsonObject(item)
            )
          : undefined,
      id: SubscriptionIdSerializer._toJsonObject(self.id),
      invoice_memo: self.invoiceMemo,
      minimum_commitment:
        self.minimumCommitment != null
          ? MinimumCommitmentSerializer._toJsonObject(self.minimumCommitment)
          : undefined,
      mrr_cents: self.mrrCents,
      net_terms: self.netTerms,
      payment_methods_config:
        self.paymentMethodsConfig != null
          ? PaymentMethodsConfigSerializer._toJsonObject(self.paymentMethodsConfig)
          : undefined,
      period: BillingPeriodEnumSerializer._toJsonObject(self.period),
      plan_id: PlanIdSerializer._toJsonObject(self.planId),
      plan_name: self.planName,
      plan_version: self.planVersion,
      plan_version_id: PlanVersionIdSerializer._toJsonObject(self.planVersionId),
      purchase_order: self.purchaseOrder,
      start_date: self.startDate,
      status: SubscriptionStatusEnumSerializer._toJsonObject(self.status),
      trial_duration: self.trialDuration,
    };
  },
};
