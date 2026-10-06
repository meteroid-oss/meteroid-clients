// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import { type CouponDiscount, CouponDiscountSerializer } from "./couponDiscount.js";
import { type CouponId, CouponIdSerializer } from "./couponId.js";

export interface CouponEventData {
  code: string;
  couponId: CouponId;
  createdAt: Date;
  description: string;
  disabled: boolean;
  discount: CouponDiscount;
  expiresAt?: Date | null | undefined;
  recurringValue?: number | null | undefined;
  redemptionLimit?: number | null | undefined;
  reusable: boolean;
}

/** Converts `CouponEventData` values from (`parse`) and to (`serialize`) their JSON form. */
export const CouponEventDataSerializer = {
  parse(json: any): CouponEventData {
    return {
      ...extraProperties(json, [
        "code",
        "coupon_id",
        "created_at",
        "description",
        "disabled",
        "discount",
        "expires_at",
        "recurring_value",
        "redemption_limit",
        "reusable",
      ]),
      code: json["code"],
      couponId: CouponIdSerializer.parse(json["coupon_id"]),
      createdAt: parseDateTime(json["created_at"]),
      description: json["description"],
      disabled: json["disabled"],
      discount: CouponDiscountSerializer.parse(json["discount"]),
      expiresAt:
        json["expires_at"] != null
          ? parseDateTime(json["expires_at"])
          : json["expires_at"],
      recurringValue: json["recurring_value"],
      redemptionLimit: json["redemption_limit"],
      reusable: json["reusable"],
    };
  },

  serialize(value: CouponEventData): any {
    return {
      ...extraProperties(value, [
        "code",
        "couponId",
        "createdAt",
        "description",
        "disabled",
        "discount",
        "expiresAt",
        "recurringValue",
        "redemptionLimit",
        "reusable",
      ]),
      code: value.code,
      coupon_id: CouponIdSerializer.serialize(value.couponId),
      created_at: value.createdAt,
      description: value.description,
      disabled: value.disabled,
      discount: CouponDiscountSerializer.serialize(value.discount),
      expires_at: value.expiresAt,
      recurring_value: value.recurringValue,
      redemption_limit: value.redemptionLimit,
      reusable: value.reusable,
    };
  },
};
