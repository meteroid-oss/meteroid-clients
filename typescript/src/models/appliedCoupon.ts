// this file is @generated
import { parseDateTime } from "../datetime";
import { type AppliedCouponId, AppliedCouponIdSerializer } from "./appliedCouponId";
import { type CouponId, CouponIdSerializer } from "./couponId";

export interface AppliedCoupon {
  appliedAmount?: string | null;

  appliedCount?: number | null;

  couponId: CouponId;

  createdAt: Date;

  id: AppliedCouponId;

  isActive: boolean;

  lastAppliedAt?: Date | null;
}

export const AppliedCouponSerializer = {
  _fromJsonObject(object: any): AppliedCoupon {
    return {
      appliedAmount: object["applied_amount"],
      appliedCount: object["applied_count"],
      couponId: CouponIdSerializer._fromJsonObject(object["coupon_id"]),
      createdAt: parseDateTime(object["created_at"]),
      id: AppliedCouponIdSerializer._fromJsonObject(object["id"]),
      isActive: object["is_active"],
      lastAppliedAt:
        object["last_applied_at"] != null
          ? parseDateTime(object["last_applied_at"])
          : undefined,
    };
  },

  _toJsonObject(self: AppliedCoupon): any {
    return {
      applied_amount: self.appliedAmount,
      applied_count: self.appliedCount,
      coupon_id: CouponIdSerializer._toJsonObject(self.couponId),
      created_at: self.createdAt,
      id: AppliedCouponIdSerializer._toJsonObject(self.id),
      is_active: self.isActive,
      last_applied_at: self.lastAppliedAt,
    };
  },
};
