// this file is @generated
import { parseDateTime } from "../datetime";
import { type CustomerId, CustomerIdSerializer } from "./customerId";
import { type InvoiceId, InvoiceIdSerializer } from "./invoiceId";
import { type InvoiceStatus, InvoiceStatusSerializer } from "./invoiceStatus";

export interface InvoiceEventData {
  consolidatedIntoInvoiceId?: InvoiceId | null;

  createdAt: Date;

  currency: string;

  /** User-defined custom property values, keyed by definition key. */
  customProperties: any;

  customerId: CustomerId;

  invoiceId: InvoiceId;

  /** Absent while the invoice is a draft — the number is assigned at finalization. */
  invoiceNumber?: string | null;

  parentInvoiceId?: InvoiceId | null;

  status: InvoiceStatus;

  taxAmount: number;

  total: number;
}

export const InvoiceEventDataSerializer = {
  _fromJsonObject(object: any): InvoiceEventData {
    return {
      consolidatedIntoInvoiceId:
        object["consolidated_into_invoice_id"] != null
          ? InvoiceIdSerializer._fromJsonObject(object["consolidated_into_invoice_id"])
          : undefined,
      createdAt: parseDateTime(object["created_at"]),
      currency: object["currency"],
      customProperties: object["custom_properties"],
      customerId: CustomerIdSerializer._fromJsonObject(object["customer_id"]),
      invoiceId: InvoiceIdSerializer._fromJsonObject(object["invoice_id"]),
      invoiceNumber: object["invoice_number"],
      parentInvoiceId:
        object["parent_invoice_id"] != null
          ? InvoiceIdSerializer._fromJsonObject(object["parent_invoice_id"])
          : undefined,
      status: InvoiceStatusSerializer._fromJsonObject(object["status"]),
      taxAmount: object["tax_amount"],
      total: object["total"],
    };
  },

  _toJsonObject(self: InvoiceEventData): any {
    return {
      consolidated_into_invoice_id:
        self.consolidatedIntoInvoiceId != null
          ? InvoiceIdSerializer._toJsonObject(self.consolidatedIntoInvoiceId)
          : undefined,
      created_at: self.createdAt,
      currency: self.currency,
      custom_properties: self.customProperties,
      customer_id: CustomerIdSerializer._toJsonObject(self.customerId),
      invoice_id: InvoiceIdSerializer._toJsonObject(self.invoiceId),
      invoice_number: self.invoiceNumber,
      parent_invoice_id:
        self.parentInvoiceId != null
          ? InvoiceIdSerializer._toJsonObject(self.parentInvoiceId)
          : undefined,
      status: InvoiceStatusSerializer._toJsonObject(self.status),
      tax_amount: self.taxAmount,
      total: self.total,
    };
  },
};
