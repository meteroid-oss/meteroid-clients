// this file is @generated
import { parseDateTime } from "../datetime";
import { type CouponDiscount, CouponDiscountSerializer } from "./couponDiscount";
import { type CouponId, CouponIdSerializer } from "./couponId";

export interface CouponEventData {
  code: string;

  couponId: CouponId;

  createdAt: Date;

  description: string;

  disabled: boolean;

  discount: CouponDiscount;

  expiresAt?: Date | null;

  recurringValue?: number | null;

  redemptionLimit?: number | null;

  reusable: boolean;
}

export const CouponEventDataSerializer = {
  _fromJsonObject(object: any): CouponEventData {
    return {
      code: object["code"],
      couponId: CouponIdSerializer._fromJsonObject(object["coupon_id"]),
      createdAt: parseDateTime(object["created_at"]),
      description: object["description"],
      disabled: object["disabled"],
      discount: CouponDiscountSerializer._fromJsonObject(object["discount"]),
      expiresAt:
        object["expires_at"] != null ? parseDateTime(object["expires_at"]) : undefined,
      recurringValue: object["recurring_value"],
      redemptionLimit: object["redemption_limit"],
      reusable: object["reusable"],
    };
  },

  _toJsonObject(self: CouponEventData): any {
    return {
      code: self.code,
      coupon_id: CouponIdSerializer._toJsonObject(self.couponId),
      created_at: self.createdAt,
      description: self.description,
      disabled: self.disabled,
      discount: CouponDiscountSerializer._toJsonObject(self.discount),
      expires_at: self.expiresAt,
      recurring_value: self.recurringValue,
      redemption_limit: self.redemptionLimit,
      reusable: self.reusable,
    };
  },
};
