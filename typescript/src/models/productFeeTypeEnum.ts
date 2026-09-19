// this file is @generated

export enum ProductFeeTypeEnum {
  Rate = "RATE",
  Slot = "SLOT",
  Capacity = "CAPACITY",
  Usage = "USAGE",
  ExtraRecurring = "EXTRA_RECURRING",
  OneTime = "ONE_TIME",
}

export const ProductFeeTypeEnumSerializer = {
  _fromJsonObject(object: any): ProductFeeTypeEnum {
    return object;
  },

  _toJsonObject(self: ProductFeeTypeEnum): any {
    return self;
  },
};
