// this file is @generated

export enum InvoiceType {
  Recurring = "RECURRING",
  OneOff = "ONE_OFF",
  Adjustment = "ADJUSTMENT",
  UsageThreshold = "USAGE_THRESHOLD",
}

export const InvoiceTypeSerializer = {
  _fromJsonObject(object: any): InvoiceType {
    return object;
  },

  _toJsonObject(self: InvoiceType): any {
    return self;
  },
};
