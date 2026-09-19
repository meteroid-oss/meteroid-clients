// this file is @generated
import { type CouponDiscount, CouponDiscountSerializer } from "./couponDiscount";
import { type PlanId, PlanIdSerializer } from "./planId";

export interface CreateCouponRequest {
  code: string;

  description?: string | null;

  discount: CouponDiscount;

  expiresAt?: Date | null;

  planIds?: PlanId[];

  recurringValue?: number | null;

  redemptionLimit?: number | null;

  reusable?: boolean;
}

export const CreateCouponRequestSerializer = {
  _fromJsonObject(object: any): CreateCouponRequest {
    return {
      code: object["code"],
      description: object["description"],
      discount: CouponDiscountSerializer._fromJsonObject(object["discount"]),
      expiresAt:
        object["expires_at"] != null ? new Date(object["expires_at"]) : undefined,
      planIds:
        object["plan_ids"] != null
          ? object["plan_ids"].map((item: any) => PlanIdSerializer._fromJsonObject(item))
          : undefined,
      recurringValue: object["recurring_value"],
      redemptionLimit: object["redemption_limit"],
      reusable: object["reusable"],
    };
  },

  _toJsonObject(self: CreateCouponRequest): any {
    return {
      code: self.code,
      description: self.description,
      discount: CouponDiscountSerializer._toJsonObject(self.discount),
      expires_at: self.expiresAt,
      plan_ids:
        self.planIds != null
          ? self.planIds.map((item: any) => PlanIdSerializer._toJsonObject(item))
          : undefined,
      recurring_value: self.recurringValue,
      redemption_limit: self.redemptionLimit,
      reusable: self.reusable,
    };
  },
};
