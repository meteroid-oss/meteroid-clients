// this file is @generated

export interface CouponLineItem {
  couponId: string;

  name: string;

  total: number;
}

export const CouponLineItemSerializer = {
  _fromJsonObject(object: any): CouponLineItem {
    return {
      couponId: object["coupon_id"],
      name: object["name"],
      total: object["total"],
    };
  },

  _toJsonObject(self: CouponLineItem): any {
    return {
      coupon_id: self.couponId,
      name: self.name,
      total: self.total,
    };
  },
};
