// this file is @generated
import { extraProperties } from "../json.js";
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
import { type PlanId, PlanIdSerializer } from "./planId.js";
import {
  type SubscriptionActivationConditionEnum,
  SubscriptionActivationConditionEnumSerializer,
} from "./subscriptionActivationConditionEnum.js";

export interface SubscriptionCreateRequest {
  activationCondition: SubscriptionActivationConditionEnum;
  addOns?: CreateSubscriptionAddOn[] | undefined;
  autoAdvanceInvoices?: boolean | undefined;
  /**
   * Historical import mode: when true, invoices finalized for this subscription keep their
   * billing-period date as the invoice date instead of being stamped with the emission date.
   */
  backdateInvoices?: boolean | undefined;
  billingDayAnchor?: number | null | undefined;
  chargeAutomatically?: boolean | undefined;
  couponCodes?: string[] | undefined;
  /**
   * User-defined custom property values, keyed by definition `key`. Validated against the
   * tenant's subscription definitions.
   */
  customProperties?: unknown | undefined;
  customerIdOrAlias: string;
  endDate?: string | undefined;
  invoiceMemo?: string | undefined;
  netTerms?: number | undefined;
  /** Payment methods configuration. If not specified, inherits from the invoicing entity. */
  paymentMethodsConfig?: PaymentMethodsConfig | undefined;
  planId: PlanId;
  priceComponents?: CreateSubscriptionComponents | undefined;
  purchaseOrder?: string | null | undefined;
  /**
   * Migration mode: when true with a past start_date, skip creating invoices for past cycles.
   * The subscription will be set to the current billing period with correct cycle_index.
   */
  skipPastInvoices?: boolean | undefined;
  startDate: string;
  trialDays?: number | undefined;
  version?: number | undefined;
}

/** Converts `SubscriptionCreateRequest` values from (`parse`) and to (`serialize`) their JSON form. */
export const SubscriptionCreateRequestSerializer = {
  parse(json: any): SubscriptionCreateRequest {
    return {
      ...extraProperties(json, [
        "activation_condition",
        "add_ons",
        "auto_advance_invoices",
        "backdate_invoices",
        "billing_day_anchor",
        "charge_automatically",
        "coupon_codes",
        "custom_properties",
        "customer_id_or_alias",
        "end_date",
        "invoice_memo",
        "net_terms",
        "payment_methods_config",
        "plan_id",
        "price_components",
        "purchase_order",
        "skip_past_invoices",
        "start_date",
        "trial_days",
        "version",
      ]),
      activationCondition: SubscriptionActivationConditionEnumSerializer.parse(
        json["activation_condition"]
      ),
      addOns:
        json["add_ons"] != null
          ? json["add_ons"].map((item: any) =>
              CreateSubscriptionAddOnSerializer.parse(item)
            )
          : undefined,
      autoAdvanceInvoices: json["auto_advance_invoices"],
      backdateInvoices: json["backdate_invoices"],
      billingDayAnchor: json["billing_day_anchor"],
      chargeAutomatically: json["charge_automatically"],
      couponCodes: json["coupon_codes"],
      customProperties: json["custom_properties"],
      customerIdOrAlias: json["customer_id_or_alias"],
      endDate: json["end_date"],
      invoiceMemo: json["invoice_memo"],
      netTerms: json["net_terms"],
      paymentMethodsConfig:
        json["payment_methods_config"] != null
          ? PaymentMethodsConfigSerializer.parse(json["payment_methods_config"])
          : undefined,
      planId: PlanIdSerializer.parse(json["plan_id"]),
      priceComponents:
        json["price_components"] != null
          ? CreateSubscriptionComponentsSerializer.parse(json["price_components"])
          : undefined,
      purchaseOrder: json["purchase_order"],
      skipPastInvoices: json["skip_past_invoices"],
      startDate: json["start_date"],
      trialDays: json["trial_days"],
      version: json["version"],
    };
  },

  serialize(value: SubscriptionCreateRequest): any {
    return {
      ...extraProperties(value, [
        "activationCondition",
        "addOns",
        "autoAdvanceInvoices",
        "backdateInvoices",
        "billingDayAnchor",
        "chargeAutomatically",
        "couponCodes",
        "customProperties",
        "customerIdOrAlias",
        "endDate",
        "invoiceMemo",
        "netTerms",
        "paymentMethodsConfig",
        "planId",
        "priceComponents",
        "purchaseOrder",
        "skipPastInvoices",
        "startDate",
        "trialDays",
        "version",
      ]),
      activation_condition: SubscriptionActivationConditionEnumSerializer.serialize(
        value.activationCondition
      ),
      add_ons:
        value.addOns != null
          ? value.addOns.map((item: any) =>
              CreateSubscriptionAddOnSerializer.serialize(item)
            )
          : undefined,
      auto_advance_invoices: value.autoAdvanceInvoices,
      backdate_invoices: value.backdateInvoices,
      billing_day_anchor: value.billingDayAnchor,
      charge_automatically: value.chargeAutomatically,
      coupon_codes: value.couponCodes,
      custom_properties: value.customProperties,
      customer_id_or_alias: value.customerIdOrAlias,
      end_date: value.endDate,
      invoice_memo: value.invoiceMemo,
      net_terms: value.netTerms,
      payment_methods_config:
        value.paymentMethodsConfig != null
          ? PaymentMethodsConfigSerializer.serialize(value.paymentMethodsConfig)
          : undefined,
      plan_id: PlanIdSerializer.serialize(value.planId),
      price_components:
        value.priceComponents != null
          ? CreateSubscriptionComponentsSerializer.serialize(value.priceComponents)
          : undefined,
      purchase_order: value.purchaseOrder,
      skip_past_invoices: value.skipPastInvoices,
      start_date: value.startDate,
      trial_days: value.trialDays,
      version: value.version,
    };
  },
};
