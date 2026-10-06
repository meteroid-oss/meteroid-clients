// this file is @generated
import { extraProperties } from "../json.js";
import { type AppliedCoupon, AppliedCouponSerializer } from "./appliedCoupon.js";
import {
  type SubscriptionCoupon,
  SubscriptionCouponSerializer,
} from "./subscriptionCoupon.js";

export interface AppliedCouponDetailed {
  appliedCoupon: AppliedCoupon;
  coupon: SubscriptionCoupon;
}

/** Converts `AppliedCouponDetailed` values from (`parse`) and to (`serialize`) their JSON form. */
export const AppliedCouponDetailedSerializer = {
  parse(json: any): AppliedCouponDetailed {
    return {
      ...extraProperties(json, ["applied_coupon", "coupon"]),
      appliedCoupon: AppliedCouponSerializer.parse(json["applied_coupon"]),
      coupon: SubscriptionCouponSerializer.parse(json["coupon"]),
    };
  },

  serialize(value: AppliedCouponDetailed): any {
    return {
      ...extraProperties(value, ["appliedCoupon", "coupon"]),
      applied_coupon: AppliedCouponSerializer.serialize(value.appliedCoupon),
      coupon: SubscriptionCouponSerializer.serialize(value.coupon),
    };
  },
};
