// this file is @generated

export interface PercentageDiscount {
  percentage: string;
}

export const PercentageDiscountSerializer = {
  _fromJsonObject(object: any): PercentageDiscount {
    return {
      percentage: object["percentage"],
    };
  },

  _toJsonObject(self: PercentageDiscount): any {
    return {
      percentage: self.percentage,
    };
  },
};
