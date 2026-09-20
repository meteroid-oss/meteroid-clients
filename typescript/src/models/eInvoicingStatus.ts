// this file is @generated
/**
 * Whether the structured e-invoice was produced with the accounting PDF. Absent when the
 * invoicing entity had not opted in at the time the invoice was issued.
 */
export enum EInvoicingStatus {
  Generated = "GENERATED",
  Failed = "FAILED",
}

export const EInvoicingStatusSerializer = {
  _fromJsonObject(object: any): EInvoicingStatus {
    return object;
  },

  _toJsonObject(self: EInvoicingStatus): any {
    return self;
  },
};
