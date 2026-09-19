// this file is @generated
import { type BillingPeriodEnum, BillingPeriodEnumSerializer } from "./billingPeriodEnum";
import { type Currency, CurrencySerializer } from "./currency";
import { type CustomerId, CustomerIdSerializer } from "./customerId";
import {
  type PaymentMethodsConfig,
  PaymentMethodsConfigSerializer,
} from "./paymentMethodsConfig";
import { type PlanId, PlanIdSerializer } from "./planId";
import { type PlanVersionId, PlanVersionIdSerializer } from "./planVersionId";
import { type SubscriptionId, SubscriptionIdSerializer } from "./subscriptionId";
import {
  type SubscriptionStatusEnum,
  SubscriptionStatusEnumSerializer,
} from "./subscriptionStatusEnum";

export interface Subscription {
  /** When the subscription was activated (first payment or activation condition met) */
  activatedAt?: Date | null;

  /** If false, invoices will stay in Draft until manually reviewed and finalized. Default to true. */
  autoAdvanceInvoices: boolean;

  billingDayAnchor: number;

  /** When billing started (after any trial period) */
  billingStartDate?: string | null;

  /** Automatically try to charge the customer's configured payment method on finalize. */
  chargeAutomatically: boolean;

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

  id: SubscriptionId;

  /** Default memo for invoices */
  invoiceMemo?: string | null;

  /** Monthly recurring revenue in cents */
  mrrCents: number;

  /** Payment terms in days (0 = due on issue) */
  netTerms: number;

  paymentMethodsConfig?: PaymentMethodsConfig | null;

  /** Billing period (monthly, annual, etc.) */
  period: BillingPeriodEnum;

  planDescription?: string | null;

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

export const SubscriptionSerializer = {
  _fromJsonObject(object: any): Subscription {
    return {
      activatedAt:
        object["activated_at"] != null ? new Date(object["activated_at"]) : undefined,
      autoAdvanceInvoices: object["auto_advance_invoices"],
      billingDayAnchor: object["billing_day_anchor"],
      billingStartDate: object["billing_start_date"],
      chargeAutomatically: object["charge_automatically"],
      createdAt: new Date(object["created_at"]),
      currency: CurrencySerializer._fromJsonObject(object["currency"]),
      currentPeriodEnd: object["current_period_end"],
      currentPeriodStart: object["current_period_start"],
      customProperties: object["custom_properties"],
      customerAlias: object["customer_alias"],
      customerId: CustomerIdSerializer._fromJsonObject(object["customer_id"]),
      customerName: object["customer_name"],
      endDate: object["end_date"],
      id: SubscriptionIdSerializer._fromJsonObject(object["id"]),
      invoiceMemo: object["invoice_memo"],
      mrrCents: object["mrr_cents"],
      netTerms: object["net_terms"],
      paymentMethodsConfig:
        object["payment_methods_config"] != null
          ? PaymentMethodsConfigSerializer._fromJsonObject(
              object["payment_methods_config"]
            )
          : undefined,
      period: BillingPeriodEnumSerializer._fromJsonObject(object["period"]),
      planDescription: object["plan_description"],
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

  _toJsonObject(self: Subscription): any {
    return {
      activated_at: self.activatedAt,
      auto_advance_invoices: self.autoAdvanceInvoices,
      billing_day_anchor: self.billingDayAnchor,
      billing_start_date: self.billingStartDate,
      charge_automatically: self.chargeAutomatically,
      created_at: self.createdAt,
      currency: CurrencySerializer._toJsonObject(self.currency),
      current_period_end: self.currentPeriodEnd,
      current_period_start: self.currentPeriodStart,
      custom_properties: self.customProperties,
      customer_alias: self.customerAlias,
      customer_id: CustomerIdSerializer._toJsonObject(self.customerId),
      customer_name: self.customerName,
      end_date: self.endDate,
      id: SubscriptionIdSerializer._toJsonObject(self.id),
      invoice_memo: self.invoiceMemo,
      mrr_cents: self.mrrCents,
      net_terms: self.netTerms,
      payment_methods_config:
        self.paymentMethodsConfig != null
          ? PaymentMethodsConfigSerializer._toJsonObject(self.paymentMethodsConfig)
          : undefined,
      period: BillingPeriodEnumSerializer._toJsonObject(self.period),
      plan_description: self.planDescription,
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
