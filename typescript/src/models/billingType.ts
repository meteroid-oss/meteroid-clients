// this file is @generated

export enum BillingType {
  Advance = "ADVANCE",
  Arrears = "ARREARS",
}

export const BillingTypeSerializer = {
  _fromJsonObject(object: any): BillingType {
    return object;
  },

  _toJsonObject(self: BillingType): any {
    return self;
  },
};
