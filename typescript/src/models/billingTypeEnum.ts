// this file is @generated

export enum BillingTypeEnum {
  Advance = "ADVANCE",
  Arrears = "ARREARS",
}

export const BillingTypeEnumSerializer = {
  _fromJsonObject(object: any): BillingTypeEnum {
    return object;
  },

  _toJsonObject(self: BillingTypeEnum): any {
    return self;
  },
};
