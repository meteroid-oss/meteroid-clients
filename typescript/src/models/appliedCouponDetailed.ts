// this file is @generated
import { type AppliedCoupon, AppliedCouponSerializer } from "./appliedCoupon";
import {
  type SubscriptionCoupon,
  SubscriptionCouponSerializer,
} from "./subscriptionCoupon";

export interface AppliedCouponDetailed {
  appliedCoupon: AppliedCoupon;

  coupon: SubscriptionCoupon;
}

export const AppliedCouponDetailedSerializer = {
  _fromJsonObject(object: any): AppliedCouponDetailed {
    return {
      appliedCoupon: AppliedCouponSerializer._fromJsonObject(object["applied_coupon"]),
      coupon: SubscriptionCouponSerializer._fromJsonObject(object["coupon"]),
    };
  },

  _toJsonObject(self: AppliedCouponDetailed): any {
    return {
      applied_coupon: AppliedCouponSerializer._toJsonObject(self.appliedCoupon),
      coupon: SubscriptionCouponSerializer._toJsonObject(self.coupon),
    };
  },
};
