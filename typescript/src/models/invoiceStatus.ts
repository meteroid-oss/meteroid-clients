// this file is @generated

export enum InvoiceStatus {
  Draft = "DRAFT",
  Finalized = "FINALIZED",
  Uncollectible = "UNCOLLECTIBLE",
  Void = "VOID",
  Closed = "CLOSED",
}

export const InvoiceStatusSerializer = {
  _fromJsonObject(object: any): InvoiceStatus {
    return object;
  },

  _toJsonObject(self: InvoiceStatus): any {
    return self;
  },
};
