// this file is @generated
import { type CouponDiscount, CouponDiscountSerializer } from "./couponDiscount";
import { type PlanId, PlanIdSerializer } from "./planId";

export interface UpdateCouponRequest {
  description?: string | null;

  discount?: CouponDiscount | null;

  planIds?: PlanId[] | null;
}

export const UpdateCouponRequestSerializer = {
  _fromJsonObject(object: any): UpdateCouponRequest {
    return {
      description: object["description"],
      discount:
        object["discount"] != null
          ? CouponDiscountSerializer._fromJsonObject(object["discount"])
          : undefined,
      planIds:
        object["plan_ids"] != null
          ? object["plan_ids"].map((item: any) => PlanIdSerializer._fromJsonObject(item))
          : undefined,
    };
  },

  _toJsonObject(self: UpdateCouponRequest): any {
    return {
      description: self.description,
      discount:
        self.discount != null
          ? CouponDiscountSerializer._toJsonObject(self.discount)
          : undefined,
      plan_ids:
        self.planIds != null
          ? self.planIds.map((item: any) => PlanIdSerializer._toJsonObject(item))
          : undefined,
    };
  },
};
