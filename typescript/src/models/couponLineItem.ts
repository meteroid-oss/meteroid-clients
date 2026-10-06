// this file is @generated
import { extraProperties } from "../json.js";

export interface CouponLineItem {
  couponId: string;
  name: string;
  total: number;
}

/** Converts `CouponLineItem` values from (`parse`) and to (`serialize`) their JSON form. */
export const CouponLineItemSerializer = {
  parse(json: any): CouponLineItem {
    return {
      ...extraProperties(json, ["coupon_id", "name", "total"]),
      couponId: json["coupon_id"],
      name: json["name"],
      total: json["total"],
    };
  },

  serialize(value: CouponLineItem): any {
    return {
      ...extraProperties(value, ["couponId", "name", "total"]),
      coupon_id: value.couponId,
      name: value.name,
      total: value.total,
    };
  },
};
