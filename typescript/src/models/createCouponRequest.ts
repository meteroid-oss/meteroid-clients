// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import { type CouponDiscount, CouponDiscountSerializer } from "./couponDiscount.js";
import { type PlanId, PlanIdSerializer } from "./planId.js";

export interface CreateCouponRequest {
  code: string;
  description?: string | null | undefined;
  discount: CouponDiscount;
  expiresAt?: Date | null | undefined;
  planIds?: PlanId[] | undefined;
  recurringValue?: number | null | undefined;
  redemptionLimit?: number | null | undefined;
  reusable?: boolean | undefined;
}

/** Converts `CreateCouponRequest` values from (`parse`) and to (`serialize`) their JSON form. */
export const CreateCouponRequestSerializer = {
  parse(json: any): CreateCouponRequest {
    return {
      ...extraProperties(json, [
        "code",
        "description",
        "discount",
        "expires_at",
        "plan_ids",
        "recurring_value",
        "redemption_limit",
        "reusable",
      ]),
      code: json["code"],
      description: json["description"],
      discount: CouponDiscountSerializer.parse(json["discount"]),
      expiresAt:
        json["expires_at"] != null
          ? parseDateTime(json["expires_at"])
          : json["expires_at"],
      planIds:
        json["plan_ids"] != null
          ? json["plan_ids"].map((item: any) => PlanIdSerializer.parse(item))
          : undefined,
      recurringValue: json["recurring_value"],
      redemptionLimit: json["redemption_limit"],
      reusable: json["reusable"],
    };
  },

  serialize(value: CreateCouponRequest): any {
    return {
      ...extraProperties(value, [
        "code",
        "description",
        "discount",
        "expiresAt",
        "planIds",
        "recurringValue",
        "redemptionLimit",
        "reusable",
      ]),
      code: value.code,
      description: value.description,
      discount: CouponDiscountSerializer.serialize(value.discount),
      expires_at: value.expiresAt,
      plan_ids:
        value.planIds != null
          ? value.planIds.map((item: any) => PlanIdSerializer.serialize(item))
          : undefined,
      recurring_value: value.recurringValue,
      redemption_limit: value.redemptionLimit,
      reusable: value.reusable,
    };
  },
};
