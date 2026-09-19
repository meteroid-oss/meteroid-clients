// this file is @generated
import { parseDateTime } from "../datetime";
import { type BillingPeriodEnum, BillingPeriodEnumSerializer } from "./billingPeriodEnum";
import { type CustomerId, CustomerIdSerializer } from "./customerId";
import { type SubscriptionId, SubscriptionIdSerializer } from "./subscriptionId";
import {
  type SubscriptionStatusEnum,
  SubscriptionStatusEnumSerializer,
} from "./subscriptionStatusEnum";
import {
  type SubscriptionUpdateType,
  SubscriptionUpdateTypeSerializer,
} from "./subscriptionUpdateType";

export interface SubscriptionEventData {
  activatedAt?: Date | null;

  autoAdvanceInvoices: boolean;

  billingDayAnchor: number;

  billingStartDate?: string | null;

  /** Present on `subscription.cancelled` when a reason was supplied. */
  cancellationReason?: string | null;

  changeType?: SubscriptionUpdateType | null;

  chargeAutomatically: boolean;

  createdAt: Date;

  currency: string;

  /** User-defined custom property values, keyed by definition key. */
  customProperties: unknown;

  customerAlias?: string | null;

  customerId: CustomerId;

  customerName: string;

  endDate?: string | null;

  invoiceMemo?: string | null;

  invoiceThreshold?: string | null;

  mrrCents: number;

  netTerms: number;

  period: BillingPeriodEnum;

  planName: string;

  purchaseOrder?: string | null;

  startDate: string;

  status: SubscriptionStatusEnum;

  subscriptionId: SubscriptionId;

  trialDuration?: number | null;

  version: number;
}

export const SubscriptionEventDataSerializer = {
  _fromJsonObject(object: any): SubscriptionEventData {
    return {
      activatedAt:
        object["activated_at"] != null
          ? parseDateTime(object["activated_at"])
          : undefined,
      autoAdvanceInvoices: object["auto_advance_invoices"],
      billingDayAnchor: object["billing_day_anchor"],
      billingStartDate: object["billing_start_date"],
      cancellationReason: object["cancellation_reason"],
      changeType:
        object["change_type"] != null
          ? SubscriptionUpdateTypeSerializer._fromJsonObject(object["change_type"])
          : undefined,
      chargeAutomatically: object["charge_automatically"],
      createdAt: parseDateTime(object["created_at"]),
      currency: object["currency"],
      customProperties: object["custom_properties"],
      customerAlias: object["customer_alias"],
      customerId: CustomerIdSerializer._fromJsonObject(object["customer_id"]),
      customerName: object["customer_name"],
      endDate: object["end_date"],
      invoiceMemo: object["invoice_memo"],
      invoiceThreshold: object["invoice_threshold"],
      mrrCents: object["mrr_cents"],
      netTerms: object["net_terms"],
      period: BillingPeriodEnumSerializer._fromJsonObject(object["period"]),
      planName: object["plan_name"],
      purchaseOrder: object["purchase_order"],
      startDate: object["start_date"],
      status: SubscriptionStatusEnumSerializer._fromJsonObject(object["status"]),
      subscriptionId: SubscriptionIdSerializer._fromJsonObject(object["subscription_id"]),
      trialDuration: object["trial_duration"],
      version: object["version"],
    };
  },

  _toJsonObject(self: SubscriptionEventData): any {
    return {
      activated_at: self.activatedAt,
      auto_advance_invoices: self.autoAdvanceInvoices,
      billing_day_anchor: self.billingDayAnchor,
      billing_start_date: self.billingStartDate,
      cancellation_reason: self.cancellationReason,
      change_type:
        self.changeType != null
          ? SubscriptionUpdateTypeSerializer._toJsonObject(self.changeType)
          : undefined,
      charge_automatically: self.chargeAutomatically,
      created_at: self.createdAt,
      currency: self.currency,
      custom_properties: self.customProperties,
      customer_alias: self.customerAlias,
      customer_id: CustomerIdSerializer._toJsonObject(self.customerId),
      customer_name: self.customerName,
      end_date: self.endDate,
      invoice_memo: self.invoiceMemo,
      invoice_threshold: self.invoiceThreshold,
      mrr_cents: self.mrrCents,
      net_terms: self.netTerms,
      period: BillingPeriodEnumSerializer._toJsonObject(self.period),
      plan_name: self.planName,
      purchase_order: self.purchaseOrder,
      start_date: self.startDate,
      status: SubscriptionStatusEnumSerializer._toJsonObject(self.status),
      subscription_id: SubscriptionIdSerializer._toJsonObject(self.subscriptionId),
      trial_duration: self.trialDuration,
      version: self.version,
    };
  },
};
