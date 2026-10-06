// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import {
  type BillingPeriodEnum,
  BillingPeriodEnumSerializer,
} from "./billingPeriodEnum.js";
import { type CustomerId, CustomerIdSerializer } from "./customerId.js";
import { type SubscriptionId, SubscriptionIdSerializer } from "./subscriptionId.js";
import {
  type SubscriptionStatusEnum,
  SubscriptionStatusEnumSerializer,
} from "./subscriptionStatusEnum.js";
import {
  type SubscriptionUpdateType,
  SubscriptionUpdateTypeSerializer,
} from "./subscriptionUpdateType.js";

export interface SubscriptionEventData {
  activatedAt?: Date | null | undefined;
  autoAdvanceInvoices: boolean;
  billingDayAnchor: number;
  billingStartDate?: string | null | undefined;
  /** Present on `subscription.cancelled` when a reason was supplied. */
  cancellationReason?: string | null | undefined;
  changeType?: SubscriptionUpdateType | null | undefined;
  chargeAutomatically: boolean;
  createdAt: Date;
  currency: string;
  /** User-defined custom property values, keyed by definition key. */
  customProperties: unknown;
  customerAlias?: string | null | undefined;
  customerId: CustomerId;
  customerName: string;
  endDate?: string | null | undefined;
  invoiceMemo?: string | null | undefined;
  invoiceThreshold?: string | null | undefined;
  mrrCents: number;
  netTerms: number;
  period: BillingPeriodEnum;
  planName: string;
  purchaseOrder?: string | null | undefined;
  startDate: string;
  status: SubscriptionStatusEnum;
  subscriptionId: SubscriptionId;
  trialDuration?: number | null | undefined;
  version: number;
}

/** Converts `SubscriptionEventData` values from (`parse`) and to (`serialize`) their JSON form. */
export const SubscriptionEventDataSerializer = {
  parse(json: any): SubscriptionEventData {
    return {
      ...extraProperties(json, [
        "activated_at",
        "auto_advance_invoices",
        "billing_day_anchor",
        "billing_start_date",
        "cancellation_reason",
        "change_type",
        "charge_automatically",
        "created_at",
        "currency",
        "custom_properties",
        "customer_alias",
        "customer_id",
        "customer_name",
        "end_date",
        "invoice_memo",
        "invoice_threshold",
        "mrr_cents",
        "net_terms",
        "period",
        "plan_name",
        "purchase_order",
        "start_date",
        "status",
        "subscription_id",
        "trial_duration",
        "version",
      ]),
      activatedAt:
        json["activated_at"] != null
          ? parseDateTime(json["activated_at"])
          : json["activated_at"],
      autoAdvanceInvoices: json["auto_advance_invoices"],
      billingDayAnchor: json["billing_day_anchor"],
      billingStartDate: json["billing_start_date"],
      cancellationReason: json["cancellation_reason"],
      changeType:
        json["change_type"] != null
          ? SubscriptionUpdateTypeSerializer.parse(json["change_type"])
          : json["change_type"],
      chargeAutomatically: json["charge_automatically"],
      createdAt: parseDateTime(json["created_at"]),
      currency: json["currency"],
      customProperties: json["custom_properties"],
      customerAlias: json["customer_alias"],
      customerId: CustomerIdSerializer.parse(json["customer_id"]),
      customerName: json["customer_name"],
      endDate: json["end_date"],
      invoiceMemo: json["invoice_memo"],
      invoiceThreshold: json["invoice_threshold"],
      mrrCents: json["mrr_cents"],
      netTerms: json["net_terms"],
      period: BillingPeriodEnumSerializer.parse(json["period"]),
      planName: json["plan_name"],
      purchaseOrder: json["purchase_order"],
      startDate: json["start_date"],
      status: SubscriptionStatusEnumSerializer.parse(json["status"]),
      subscriptionId: SubscriptionIdSerializer.parse(json["subscription_id"]),
      trialDuration: json["trial_duration"],
      version: json["version"],
    };
  },

  serialize(value: SubscriptionEventData): any {
    return {
      ...extraProperties(value, [
        "activatedAt",
        "autoAdvanceInvoices",
        "billingDayAnchor",
        "billingStartDate",
        "cancellationReason",
        "changeType",
        "chargeAutomatically",
        "createdAt",
        "currency",
        "customProperties",
        "customerAlias",
        "customerId",
        "customerName",
        "endDate",
        "invoiceMemo",
        "invoiceThreshold",
        "mrrCents",
        "netTerms",
        "period",
        "planName",
        "purchaseOrder",
        "startDate",
        "status",
        "subscriptionId",
        "trialDuration",
        "version",
      ]),
      activated_at: value.activatedAt,
      auto_advance_invoices: value.autoAdvanceInvoices,
      billing_day_anchor: value.billingDayAnchor,
      billing_start_date: value.billingStartDate,
      cancellation_reason: value.cancellationReason,
      change_type:
        value.changeType != null
          ? SubscriptionUpdateTypeSerializer.serialize(value.changeType)
          : value.changeType,
      charge_automatically: value.chargeAutomatically,
      created_at: value.createdAt,
      currency: value.currency,
      custom_properties: value.customProperties,
      customer_alias: value.customerAlias,
      customer_id: CustomerIdSerializer.serialize(value.customerId),
      customer_name: value.customerName,
      end_date: value.endDate,
      invoice_memo: value.invoiceMemo,
      invoice_threshold: value.invoiceThreshold,
      mrr_cents: value.mrrCents,
      net_terms: value.netTerms,
      period: BillingPeriodEnumSerializer.serialize(value.period),
      plan_name: value.planName,
      purchase_order: value.purchaseOrder,
      start_date: value.startDate,
      status: SubscriptionStatusEnumSerializer.serialize(value.status),
      subscription_id: SubscriptionIdSerializer.serialize(value.subscriptionId),
      trial_duration: value.trialDuration,
      version: value.version,
    };
  },
};
