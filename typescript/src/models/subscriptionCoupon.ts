// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import { type CouponDiscount, CouponDiscountSerializer } from "./couponDiscount.js";
import { type CouponId, CouponIdSerializer } from "./couponId.js";
/**
 * Coupon as embedded in subscription details — a subset of the `Coupon` resource
 * returned by the coupons API.
 */
export interface SubscriptionCoupon {
  code: string;
  description: string;
  disabled: boolean;
  discount: CouponDiscount;
  expiresAt?: Date | null | undefined;
  id: CouponId;
  recurringValue?: number | null | undefined;
  redemptionLimit?: number | null | undefined;
  reusable: boolean;
}

/** Converts `SubscriptionCoupon` values from (`parse`) and to (`serialize`) their JSON form. */
export const SubscriptionCouponSerializer = {
  parse(json: any): SubscriptionCoupon {
    return {
      ...extraProperties(json, [
        "code",
        "description",
        "disabled",
        "discount",
        "expires_at",
        "id",
        "recurring_value",
        "redemption_limit",
        "reusable",
      ]),
      code: json["code"],
      description: json["description"],
      disabled: json["disabled"],
      discount: CouponDiscountSerializer.parse(json["discount"]),
      expiresAt:
        json["expires_at"] != null
          ? parseDateTime(json["expires_at"])
          : json["expires_at"],
      id: CouponIdSerializer.parse(json["id"]),
      recurringValue: json["recurring_value"],
      redemptionLimit: json["redemption_limit"],
      reusable: json["reusable"],
    };
  },

  serialize(value: SubscriptionCoupon): any {
    return {
      ...extraProperties(value, [
        "code",
        "description",
        "disabled",
        "discount",
        "expiresAt",
        "id",
        "recurringValue",
        "redemptionLimit",
        "reusable",
      ]),
      code: value.code,
      description: value.description,
      disabled: value.disabled,
      discount: CouponDiscountSerializer.serialize(value.discount),
      expires_at: value.expiresAt,
      id: CouponIdSerializer.serialize(value.id),
      recurring_value: value.recurringValue,
      redemption_limit: value.redemptionLimit,
      reusable: value.reusable,
    };
  },
};
