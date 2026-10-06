// this file is @generated
/**
 * Whether the structured e-invoice was produced with the accounting PDF. Absent when the
 * invoicing entity had not opted in at the time the invoice was issued.
 */
export const EInvoicingStatus = {
  Generated: "GENERATED",
  Failed: "FAILED",
} as const;
export type EInvoicingStatus =
  | (typeof EInvoicingStatus)[keyof typeof EInvoicingStatus]
  | (string & {});

/** Converts `EInvoicingStatus` values from (`parse`) and to (`serialize`) their JSON form. */
export const EInvoicingStatusSerializer = {
  parse(json: any): EInvoicingStatus {
    return json;
  },

  serialize(value: EInvoicingStatus): any {
    return value;
  },
};
