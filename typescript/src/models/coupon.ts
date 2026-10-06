// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import { type CouponDiscount, CouponDiscountSerializer } from "./couponDiscount.js";
import { type CouponId, CouponIdSerializer } from "./couponId.js";
import { type PlanId, PlanIdSerializer } from "./planId.js";

export interface Coupon {
  archivedAt?: Date | null | undefined;
  code: string;
  createdAt: Date;
  description?: string | null | undefined;
  disabled: boolean;
  discount: CouponDiscount;
  expiresAt?: Date | null | undefined;
  id: CouponId;
  planIds: PlanId[];
  recurringValue?: number | null | undefined;
  redemptionCount: number;
  redemptionLimit?: number | null | undefined;
  reusable: boolean;
}

/** Converts `Coupon` values from (`parse`) and to (`serialize`) their JSON form. */
export const CouponSerializer = {
  parse(json: any): Coupon {
    return {
      ...extraProperties(json, [
        "archived_at",
        "code",
        "created_at",
        "description",
        "disabled",
        "discount",
        "expires_at",
        "id",
        "plan_ids",
        "recurring_value",
        "redemption_count",
        "redemption_limit",
        "reusable",
      ]),
      archivedAt:
        json["archived_at"] != null
          ? parseDateTime(json["archived_at"])
          : json["archived_at"],
      code: json["code"],
      createdAt: parseDateTime(json["created_at"]),
      description: json["description"],
      disabled: json["disabled"],
      discount: CouponDiscountSerializer.parse(json["discount"]),
      expiresAt:
        json["expires_at"] != null
          ? parseDateTime(json["expires_at"])
          : json["expires_at"],
      id: CouponIdSerializer.parse(json["id"]),
      planIds: json["plan_ids"].map((item: any) => PlanIdSerializer.parse(item)),
      recurringValue: json["recurring_value"],
      redemptionCount: json["redemption_count"],
      redemptionLimit: json["redemption_limit"],
      reusable: json["reusable"],
    };
  },

  serialize(value: Coupon): any {
    return {
      ...extraProperties(value, [
        "archivedAt",
        "code",
        "createdAt",
        "description",
        "disabled",
        "discount",
        "expiresAt",
        "id",
        "planIds",
        "recurringValue",
        "redemptionCount",
        "redemptionLimit",
        "reusable",
      ]),
      archived_at: value.archivedAt,
      code: value.code,
      created_at: value.createdAt,
      description: value.description,
      disabled: value.disabled,
      discount: CouponDiscountSerializer.serialize(value.discount),
      expires_at: value.expiresAt,
      id: CouponIdSerializer.serialize(value.id),
      plan_ids: value.planIds.map((item: any) => PlanIdSerializer.serialize(item)),
      recurring_value: value.recurringValue,
      redemption_count: value.redemptionCount,
      redemption_limit: value.redemptionLimit,
      reusable: value.reusable,
    };
  },
};
