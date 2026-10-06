// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import { type CouponLineItem, CouponLineItemSerializer } from "./couponLineItem.js";
import { type Currency, CurrencySerializer } from "./currency.js";
import { type CustomerDetails, CustomerDetailsSerializer } from "./customerDetails.js";
import { type CustomerId, CustomerIdSerializer } from "./customerId.js";
import { type EInvoicingStatus, EInvoicingStatusSerializer } from "./eInvoicingStatus.js";
import { type InvoiceId, InvoiceIdSerializer } from "./invoiceId.js";
import { type InvoiceLineItem, InvoiceLineItemSerializer } from "./invoiceLineItem.js";
import {
  type InvoicePaymentStatus,
  InvoicePaymentStatusSerializer,
} from "./invoicePaymentStatus.js";
import { type InvoiceStatus, InvoiceStatusSerializer } from "./invoiceStatus.js";
import { type InvoiceType, InvoiceTypeSerializer } from "./invoiceType.js";
import { type SubscriptionId, SubscriptionIdSerializer } from "./subscriptionId.js";
import { type TaxBreakdownItem, TaxBreakdownItemSerializer } from "./taxBreakdownItem.js";
import { type Transaction, TransactionSerializer } from "./transaction.js";

export interface Invoice {
  amountDue: number;
  appliedCredits: number;
  /**
   * The period/moment this invoice is about — the subscription period start, or the invoice's
   * own date for manual/one-off. Stable and always present, distinct from `invoice_date` (the
   * emission date). Shown as "Invoice date".
   */
  billingPeriodStart?: string | null | undefined;
  childInvoiceId?: InvoiceId | null | undefined;
  coupons: CouponLineItem[];
  createdAt: Date;
  currency: Currency;
  /** User-defined custom property values, keyed by definition `key`. */
  customProperties: unknown;
  customerDetails: CustomerDetails;
  customerId: CustomerId;
  dueDate?: string | null | undefined;
  einvoicingStatus?: EInvoicingStatus | null | undefined;
  finalizedAt?: Date | null | undefined;
  id: InvoiceId;
  invoiceDate: string;
  invoiceNumber: string;
  invoiceType: InvoiceType;
  lineItems: InvoiceLineItem[];
  markedAsUncollectibleAt?: Date | null | undefined;
  memo?: string | null | undefined;
  netTerms: number;
  paidAt?: Date | null | undefined;
  parentInvoiceId?: InvoiceId | null | undefined;
  paymentStatus: InvoicePaymentStatus;
  purchaseOrder?: string | null | undefined;
  reference?: string | null | undefined;
  status: InvoiceStatus;
  subscriptionId?: SubscriptionId | null | undefined;
  subtotal: number;
  subtotalRecurring: number;
  taxAmount: number;
  taxBreakdown: TaxBreakdownItem[];
  total: number;
  transactions: Transaction[];
  updatedAt?: Date | null | undefined;
  voidedAt?: Date | null | undefined;
}

/** Converts `Invoice` values from (`parse`) and to (`serialize`) their JSON form. */
export const InvoiceSerializer = {
  parse(json: any): Invoice {
    return {
      ...extraProperties(json, [
        "amount_due",
        "applied_credits",
        "billing_period_start",
        "child_invoice_id",
        "coupons",
        "created_at",
        "currency",
        "custom_properties",
        "customer_details",
        "customer_id",
        "due_date",
        "einvoicing_status",
        "finalized_at",
        "id",
        "invoice_date",
        "invoice_number",
        "invoice_type",
        "line_items",
        "marked_as_uncollectible_at",
        "memo",
        "net_terms",
        "paid_at",
        "parent_invoice_id",
        "payment_status",
        "purchase_order",
        "reference",
        "status",
        "subscription_id",
        "subtotal",
        "subtotal_recurring",
        "tax_amount",
        "tax_breakdown",
        "total",
        "transactions",
        "updated_at",
        "voided_at",
      ]),
      amountDue: json["amount_due"],
      appliedCredits: json["applied_credits"],
      billingPeriodStart: json["billing_period_start"],
      childInvoiceId:
        json["child_invoice_id"] != null
          ? InvoiceIdSerializer.parse(json["child_invoice_id"])
          : json["child_invoice_id"],
      coupons: json["coupons"].map((item: any) => CouponLineItemSerializer.parse(item)),
      createdAt: parseDateTime(json["created_at"]),
      currency: CurrencySerializer.parse(json["currency"]),
      customProperties: json["custom_properties"],
      customerDetails: CustomerDetailsSerializer.parse(json["customer_details"]),
      customerId: CustomerIdSerializer.parse(json["customer_id"]),
      dueDate: json["due_date"],
      einvoicingStatus:
        json["einvoicing_status"] != null
          ? EInvoicingStatusSerializer.parse(json["einvoicing_status"])
          : json["einvoicing_status"],
      finalizedAt:
        json["finalized_at"] != null
          ? parseDateTime(json["finalized_at"])
          : json["finalized_at"],
      id: InvoiceIdSerializer.parse(json["id"]),
      invoiceDate: json["invoice_date"],
      invoiceNumber: json["invoice_number"],
      invoiceType: InvoiceTypeSerializer.parse(json["invoice_type"]),
      lineItems: json["line_items"].map((item: any) =>
        InvoiceLineItemSerializer.parse(item)
      ),
      markedAsUncollectibleAt:
        json["marked_as_uncollectible_at"] != null
          ? parseDateTime(json["marked_as_uncollectible_at"])
          : json["marked_as_uncollectible_at"],
      memo: json["memo"],
      netTerms: json["net_terms"],
      paidAt: json["paid_at"] != null ? parseDateTime(json["paid_at"]) : json["paid_at"],
      parentInvoiceId:
        json["parent_invoice_id"] != null
          ? InvoiceIdSerializer.parse(json["parent_invoice_id"])
          : json["parent_invoice_id"],
      paymentStatus: InvoicePaymentStatusSerializer.parse(json["payment_status"]),
      purchaseOrder: json["purchase_order"],
      reference: json["reference"],
      status: InvoiceStatusSerializer.parse(json["status"]),
      subscriptionId:
        json["subscription_id"] != null
          ? SubscriptionIdSerializer.parse(json["subscription_id"])
          : json["subscription_id"],
      subtotal: json["subtotal"],
      subtotalRecurring: json["subtotal_recurring"],
      taxAmount: json["tax_amount"],
      taxBreakdown: json["tax_breakdown"].map((item: any) =>
        TaxBreakdownItemSerializer.parse(item)
      ),
      total: json["total"],
      transactions: json["transactions"].map((item: any) =>
        TransactionSerializer.parse(item)
      ),
      updatedAt:
        json["updated_at"] != null
          ? parseDateTime(json["updated_at"])
          : json["updated_at"],
      voidedAt:
        json["voided_at"] != null ? parseDateTime(json["voided_at"]) : json["voided_at"],
    };
  },

  serialize(value: Invoice): any {
    return {
      ...extraProperties(value, [
        "amountDue",
        "appliedCredits",
        "billingPeriodStart",
        "childInvoiceId",
        "coupons",
        "createdAt",
        "currency",
        "customProperties",
        "customerDetails",
        "customerId",
        "dueDate",
        "einvoicingStatus",
        "finalizedAt",
        "id",
        "invoiceDate",
        "invoiceNumber",
        "invoiceType",
        "lineItems",
        "markedAsUncollectibleAt",
        "memo",
        "netTerms",
        "paidAt",
        "parentInvoiceId",
        "paymentStatus",
        "purchaseOrder",
        "reference",
        "status",
        "subscriptionId",
        "subtotal",
        "subtotalRecurring",
        "taxAmount",
        "taxBreakdown",
        "total",
        "transactions",
        "updatedAt",
        "voidedAt",
      ]),
      amount_due: value.amountDue,
      applied_credits: value.appliedCredits,
      billing_period_start: value.billingPeriodStart,
      child_invoice_id:
        value.childInvoiceId != null
          ? InvoiceIdSerializer.serialize(value.childInvoiceId)
          : value.childInvoiceId,
      coupons: value.coupons.map((item: any) => CouponLineItemSerializer.serialize(item)),
      created_at: value.createdAt,
      currency: CurrencySerializer.serialize(value.currency),
      custom_properties: value.customProperties,
      customer_details: CustomerDetailsSerializer.serialize(value.customerDetails),
      customer_id: CustomerIdSerializer.serialize(value.customerId),
      due_date: value.dueDate,
      einvoicing_status:
        value.einvoicingStatus != null
          ? EInvoicingStatusSerializer.serialize(value.einvoicingStatus)
          : value.einvoicingStatus,
      finalized_at: value.finalizedAt,
      id: InvoiceIdSerializer.serialize(value.id),
      invoice_date: value.invoiceDate,
      invoice_number: value.invoiceNumber,
      invoice_type: InvoiceTypeSerializer.serialize(value.invoiceType),
      line_items: value.lineItems.map((item: any) =>
        InvoiceLineItemSerializer.serialize(item)
      ),
      marked_as_uncollectible_at: value.markedAsUncollectibleAt,
      memo: value.memo,
      net_terms: value.netTerms,
      paid_at: value.paidAt,
      parent_invoice_id:
        value.parentInvoiceId != null
          ? InvoiceIdSerializer.serialize(value.parentInvoiceId)
          : value.parentInvoiceId,
      payment_status: InvoicePaymentStatusSerializer.serialize(value.paymentStatus),
      purchase_order: value.purchaseOrder,
      reference: value.reference,
      status: InvoiceStatusSerializer.serialize(value.status),
      subscription_id:
        value.subscriptionId != null
          ? SubscriptionIdSerializer.serialize(value.subscriptionId)
          : value.subscriptionId,
      subtotal: value.subtotal,
      subtotal_recurring: value.subtotalRecurring,
      tax_amount: value.taxAmount,
      tax_breakdown: value.taxBreakdown.map((item: any) =>
        TaxBreakdownItemSerializer.serialize(item)
      ),
      total: value.total,
      transactions: value.transactions.map((item: any) =>
        TransactionSerializer.serialize(item)
      ),
      updated_at: value.updatedAt,
      voided_at: value.voidedAt,
    };
  },
};
