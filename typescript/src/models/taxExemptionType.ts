// this file is @generated

export enum TaxExemptionType {
  ReverseCharge = "REVERSE_CHARGE",
  TaxExempt = "TAX_EXEMPT",
  NotRegistered = "NOT_REGISTERED",
  Export = "EXPORT",
}

export const TaxExemptionTypeSerializer = {
  _fromJsonObject(object: any): TaxExemptionType {
    return object;
  },

  _toJsonObject(self: TaxExemptionType): any {
    return self;
  },
};
