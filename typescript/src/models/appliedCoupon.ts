// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import { type AppliedCouponId, AppliedCouponIdSerializer } from "./appliedCouponId.js";
import { type CouponId, CouponIdSerializer } from "./couponId.js";

export interface AppliedCoupon {
  appliedAmount?: string | null | undefined;
  appliedCount?: number | null | undefined;
  couponId: CouponId;
  createdAt: Date;
  id: AppliedCouponId;
  isActive: boolean;
  lastAppliedAt?: Date | null | undefined;
}

/** Converts `AppliedCoupon` values from (`parse`) and to (`serialize`) their JSON form. */
export const AppliedCouponSerializer = {
  parse(json: any): AppliedCoupon {
    return {
      ...extraProperties(json, [
        "applied_amount",
        "applied_count",
        "coupon_id",
        "created_at",
        "id",
        "is_active",
        "last_applied_at",
      ]),
      appliedAmount: json["applied_amount"],
      appliedCount: json["applied_count"],
      couponId: CouponIdSerializer.parse(json["coupon_id"]),
      createdAt: parseDateTime(json["created_at"]),
      id: AppliedCouponIdSerializer.parse(json["id"]),
      isActive: json["is_active"],
      lastAppliedAt:
        json["last_applied_at"] != null
          ? parseDateTime(json["last_applied_at"])
          : json["last_applied_at"],
    };
  },

  serialize(value: AppliedCoupon): any {
    return {
      ...extraProperties(value, [
        "appliedAmount",
        "appliedCount",
        "couponId",
        "createdAt",
        "id",
        "isActive",
        "lastAppliedAt",
      ]),
      applied_amount: value.appliedAmount,
      applied_count: value.appliedCount,
      coupon_id: CouponIdSerializer.serialize(value.couponId),
      created_at: value.createdAt,
      id: AppliedCouponIdSerializer.serialize(value.id),
      is_active: value.isActive,
      last_applied_at: value.lastAppliedAt,
    };
  },
};
