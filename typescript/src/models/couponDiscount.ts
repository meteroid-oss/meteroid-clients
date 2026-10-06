// this file is @generated
import { type FixedDiscount, FixedDiscountSerializer } from "./fixedDiscount.js";
import {
  type PercentageDiscount,
  PercentageDiscountSerializer,
} from "./percentageDiscount.js";

export interface CouponDiscountPercentage extends PercentageDiscount {
  type: "PERCENTAGE";
}
export interface CouponDiscountFixed extends FixedDiscount {
  type: "FIXED";
}

export type CouponDiscount = CouponDiscountPercentage | CouponDiscountFixed;

/** Converts `CouponDiscount` values from (`parse`) and to (`serialize`) their JSON form. */
export const CouponDiscountSerializer = {
  parse(json: any): CouponDiscount {
    switch (json["type"]) {
      case "PERCENTAGE":
        return {
          ...PercentageDiscountSerializer.parse(json),
          type: "PERCENTAGE",
        };
      case "FIXED":
        return {
          ...FixedDiscountSerializer.parse(json),
          type: "FIXED",
        };
      default:
        // A variant added to the API after this SDK was generated, kept as received.
        return json;
    }
  },

  serialize(value: CouponDiscount): any {
    switch (value.type) {
      case "PERCENTAGE":
        return {
          ...PercentageDiscountSerializer.serialize(value),
          type: "PERCENTAGE",
        };
      case "FIXED":
        return {
          ...FixedDiscountSerializer.serialize(value),
          type: "FIXED",
        };
      default:
        return value;
    }
  },
};
