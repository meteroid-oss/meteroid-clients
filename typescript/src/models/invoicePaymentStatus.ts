// this file is @generated

export enum InvoicePaymentStatus {
  Unpaid = "UNPAID",
  PartiallyPaid = "PARTIALLY_PAID",
  Paid = "PAID",
  Errored = "ERRORED",
  Processing = "PROCESSING",
}

export const InvoicePaymentStatusSerializer = {
  _fromJsonObject(object: any): InvoicePaymentStatus {
    return object;
  },

  _toJsonObject(self: InvoicePaymentStatus): any {
    return self;
  },
};
