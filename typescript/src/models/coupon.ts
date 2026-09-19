// this file is @generated
import { type CouponDiscount, CouponDiscountSerializer } from "./couponDiscount";
import { type CouponId, CouponIdSerializer } from "./couponId";
import { type PlanId, PlanIdSerializer } from "./planId";

export interface Coupon {
  archivedAt?: Date | null;

  code: string;

  createdAt: Date;

  description?: string | null;

  disabled: boolean;

  discount: CouponDiscount;

  expiresAt?: Date | null;

  id: CouponId;

  planIds: PlanId[];

  recurringValue?: number | null;

  redemptionCount: number;

  redemptionLimit?: number | null;

  reusable: boolean;
}

export const CouponSerializer = {
  _fromJsonObject(object: any): Coupon {
    return {
      archivedAt:
        object["archived_at"] != null ? new Date(object["archived_at"]) : undefined,
      code: object["code"],
      createdAt: new Date(object["created_at"]),
      description: object["description"],
      disabled: object["disabled"],
      discount: CouponDiscountSerializer._fromJsonObject(object["discount"]),
      expiresAt:
        object["expires_at"] != null ? new Date(object["expires_at"]) : undefined,
      id: CouponIdSerializer._fromJsonObject(object["id"]),
      planIds: object["plan_ids"].map((item: any) =>
        PlanIdSerializer._fromJsonObject(item)
      ),
      recurringValue: object["recurring_value"],
      redemptionCount: object["redemption_count"],
      redemptionLimit: object["redemption_limit"],
      reusable: object["reusable"],
    };
  },

  _toJsonObject(self: Coupon): any {
    return {
      archived_at: self.archivedAt,
      code: self.code,
      created_at: self.createdAt,
      description: self.description,
      disabled: self.disabled,
      discount: CouponDiscountSerializer._toJsonObject(self.discount),
      expires_at: self.expiresAt,
      id: CouponIdSerializer._toJsonObject(self.id),
      plan_ids: self.planIds.map((item: any) => PlanIdSerializer._toJsonObject(item)),
      recurring_value: self.recurringValue,
      redemption_count: self.redemptionCount,
      redemption_limit: self.redemptionLimit,
      reusable: self.reusable,
    };
  },
};
