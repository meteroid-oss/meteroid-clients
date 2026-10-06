// this file is @generated

export const InvoicePaymentStatus = {
  Unpaid: "UNPAID",
  PartiallyPaid: "PARTIALLY_PAID",
  Paid: "PAID",
  Errored: "ERRORED",
  Processing: "PROCESSING",
} as const;
export type InvoicePaymentStatus =
  | (typeof InvoicePaymentStatus)[keyof typeof InvoicePaymentStatus]
  | (string & {});

/** Converts `InvoicePaymentStatus` values from (`parse`) and to (`serialize`) their JSON form. */
export const InvoicePaymentStatusSerializer = {
  parse(json: any): InvoicePaymentStatus {
    return json;
  },

  serialize(value: InvoicePaymentStatus): any {
    return value;
  },
};
