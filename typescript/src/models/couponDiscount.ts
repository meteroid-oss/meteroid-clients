// this file is @generated
import { type FixedDiscount, FixedDiscountSerializer } from "./fixedDiscount";
import {
  type PercentageDiscount,
  PercentageDiscountSerializer,
} from "./percentageDiscount";

export interface CouponDiscountPercentage extends PercentageDiscount {
  type: "PERCENTAGE";
}
export interface CouponDiscountFixed extends FixedDiscount {
  type: "FIXED";
}

export type CouponDiscount = CouponDiscountPercentage | CouponDiscountFixed;

export const CouponDiscountSerializer = {
  _fromJsonObject(object: any): CouponDiscount {
    const type = object["type"];

    switch (type) {
      case "PERCENTAGE":
        return {
          ...PercentageDiscountSerializer._fromJsonObject(object),
          type: "PERCENTAGE",
        };
      case "FIXED":
        return {
          ...FixedDiscountSerializer._fromJsonObject(object),
          type: "FIXED",
        };
      default:
        throw new Error(`Unexpected type for CouponDiscount: ${type}`);
    }
  },

  _toJsonObject(self: CouponDiscount): any {
    switch (self.type) {
      case "PERCENTAGE":
        return {
          ...PercentageDiscountSerializer._toJsonObject(self),
          type: "PERCENTAGE",
        };
      case "FIXED":
        return {
          ...FixedDiscountSerializer._toJsonObject(self),
          type: "FIXED",
        };
      default:
        throw new Error(`Unexpected type for CouponDiscount`);
    }
  },
};
