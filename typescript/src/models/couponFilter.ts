// this file is @generated

export enum CouponFilter {
  All = "ALL",
  Active = "ACTIVE",
  Inactive = "INACTIVE",
  Archived = "ARCHIVED",
}

export const CouponFilterSerializer = {
  _fromJsonObject(object: any): CouponFilter {
    return object;
  },

  _toJsonObject(self: CouponFilter): any {
    return self;
  },
};
