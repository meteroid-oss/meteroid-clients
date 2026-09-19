// this file is @generated
import { type CouponLineItem, CouponLineItemSerializer } from "./couponLineItem";
import { type Currency, CurrencySerializer } from "./currency";
import { type CustomerDetails, CustomerDetailsSerializer } from "./customerDetails";
import { type CustomerId, CustomerIdSerializer } from "./customerId";
import { type InvoiceId, InvoiceIdSerializer } from "./invoiceId";
import { type InvoiceLineItem, InvoiceLineItemSerializer } from "./invoiceLineItem";
import {
  type InvoicePaymentStatus,
  InvoicePaymentStatusSerializer,
} from "./invoicePaymentStatus";
import { type InvoiceStatus, InvoiceStatusSerializer } from "./invoiceStatus";
import { type InvoiceType, InvoiceTypeSerializer } from "./invoiceType";
import { type SubscriptionId, SubscriptionIdSerializer } from "./subscriptionId";
import { type TaxBreakdownItem, TaxBreakdownItemSerializer } from "./taxBreakdownItem";
import { type Transaction, TransactionSerializer } from "./transaction";

export interface Invoice {
  amountDue: number;

  appliedCredits: number;

  /**
   * The period/moment this invoice is about — the subscription period start, or the invoice's
   * own date for manual/one-off. Stable and always present, distinct from `invoice_date` (the
   * emission date). Shown as "Invoice date".
   */
  billingPeriodStart?: string | null;

  childInvoiceId?: InvoiceId | null;

  coupons: CouponLineItem[];

  createdAt: Date;

  currency: Currency;

  /** User-defined custom property values, keyed by definition `key`. */
  customProperties: any;

  customerDetails: CustomerDetails;

  customerId: CustomerId;

  dueDate?: string | null;

  finalizedAt?: Date | null;

  id: InvoiceId;

  invoiceDate: string;

  invoiceNumber: string;

  invoiceType: InvoiceType;

  lineItems: InvoiceLineItem[];

  markedAsUncollectibleAt?: Date | null;

  memo?: string | null;

  netTerms: number;

  paidAt?: Date | null;

  parentInvoiceId?: InvoiceId | null;

  paymentStatus: InvoicePaymentStatus;

  purchaseOrder?: string | null;

  reference?: string | null;

  status: InvoiceStatus;

  subscriptionId?: SubscriptionId | null;

  subtotal: number;

  subtotalRecurring: number;

  taxAmount: number;

  taxBreakdown: TaxBreakdownItem[];

  total: number;

  transactions: Transaction[];

  updatedAt?: Date | null;

  voidedAt?: Date | null;
}

export const InvoiceSerializer = {
  _fromJsonObject(object: any): Invoice {
    return {
      amountDue: object["amount_due"],
      appliedCredits: object["applied_credits"],
      billingPeriodStart: object["billing_period_start"],
      childInvoiceId:
        object["child_invoice_id"] != null
          ? InvoiceIdSerializer._fromJsonObject(object["child_invoice_id"])
          : undefined,
      coupons: object["coupons"].map((item: any) =>
        CouponLineItemSerializer._fromJsonObject(item)
      ),
      createdAt: new Date(object["created_at"]),
      currency: CurrencySerializer._fromJsonObject(object["currency"]),
      customProperties: object["custom_properties"],
      customerDetails: CustomerDetailsSerializer._fromJsonObject(
        object["customer_details"]
      ),
      customerId: CustomerIdSerializer._fromJsonObject(object["customer_id"]),
      dueDate: object["due_date"],
      finalizedAt:
        object["finalized_at"] != null ? new Date(object["finalized_at"]) : undefined,
      id: InvoiceIdSerializer._fromJsonObject(object["id"]),
      invoiceDate: object["invoice_date"],
      invoiceNumber: object["invoice_number"],
      invoiceType: InvoiceTypeSerializer._fromJsonObject(object["invoice_type"]),
      lineItems: object["line_items"].map((item: any) =>
        InvoiceLineItemSerializer._fromJsonObject(item)
      ),
      markedAsUncollectibleAt:
        object["marked_as_uncollectible_at"] != null
          ? new Date(object["marked_as_uncollectible_at"])
          : undefined,
      memo: object["memo"],
      netTerms: object["net_terms"],
      paidAt: object["paid_at"] != null ? new Date(object["paid_at"]) : undefined,
      parentInvoiceId:
        object["parent_invoice_id"] != null
          ? InvoiceIdSerializer._fromJsonObject(object["parent_invoice_id"])
          : undefined,
      paymentStatus: InvoicePaymentStatusSerializer._fromJsonObject(
        object["payment_status"]
      ),
      purchaseOrder: object["purchase_order"],
      reference: object["reference"],
      status: InvoiceStatusSerializer._fromJsonObject(object["status"]),
      subscriptionId:
        object["subscription_id"] != null
          ? SubscriptionIdSerializer._fromJsonObject(object["subscription_id"])
          : undefined,
      subtotal: object["subtotal"],
      subtotalRecurring: object["subtotal_recurring"],
      taxAmount: object["tax_amount"],
      taxBreakdown: object["tax_breakdown"].map((item: any) =>
        TaxBreakdownItemSerializer._fromJsonObject(item)
      ),
      total: object["total"],
      transactions: object["transactions"].map((item: any) =>
        TransactionSerializer._fromJsonObject(item)
      ),
      updatedAt:
        object["updated_at"] != null ? new Date(object["updated_at"]) : undefined,
      voidedAt: object["voided_at"] != null ? new Date(object["voided_at"]) : undefined,
    };
  },

  _toJsonObject(self: Invoice): any {
    return {
      amount_due: self.amountDue,
      applied_credits: self.appliedCredits,
      billing_period_start: self.billingPeriodStart,
      child_invoice_id:
        self.childInvoiceId != null
          ? InvoiceIdSerializer._toJsonObject(self.childInvoiceId)
          : undefined,
      coupons: self.coupons.map((item: any) =>
        CouponLineItemSerializer._toJsonObject(item)
      ),
      created_at: self.createdAt,
      currency: CurrencySerializer._toJsonObject(self.currency),
      custom_properties: self.customProperties,
      customer_details: CustomerDetailsSerializer._toJsonObject(self.customerDetails),
      customer_id: CustomerIdSerializer._toJsonObject(self.customerId),
      due_date: self.dueDate,
      finalized_at: self.finalizedAt,
      id: InvoiceIdSerializer._toJsonObject(self.id),
      invoice_date: self.invoiceDate,
      invoice_number: self.invoiceNumber,
      invoice_type: InvoiceTypeSerializer._toJsonObject(self.invoiceType),
      line_items: self.lineItems.map((item: any) =>
        InvoiceLineItemSerializer._toJsonObject(item)
      ),
      marked_as_uncollectible_at: self.markedAsUncollectibleAt,
      memo: self.memo,
      net_terms: self.netTerms,
      paid_at: self.paidAt,
      parent_invoice_id:
        self.parentInvoiceId != null
          ? InvoiceIdSerializer._toJsonObject(self.parentInvoiceId)
          : undefined,
      payment_status: InvoicePaymentStatusSerializer._toJsonObject(self.paymentStatus),
      purchase_order: self.purchaseOrder,
      reference: self.reference,
      status: InvoiceStatusSerializer._toJsonObject(self.status),
      subscription_id:
        self.subscriptionId != null
          ? SubscriptionIdSerializer._toJsonObject(self.subscriptionId)
          : undefined,
      subtotal: self.subtotal,
      subtotal_recurring: self.subtotalRecurring,
      tax_amount: self.taxAmount,
      tax_breakdown: self.taxBreakdown.map((item: any) =>
        TaxBreakdownItemSerializer._toJsonObject(item)
      ),
      total: self.total,
      transactions: self.transactions.map((item: any) =>
        TransactionSerializer._toJsonObject(item)
      ),
      updated_at: self.updatedAt,
      voided_at: self.voidedAt,
    };
  },
};
