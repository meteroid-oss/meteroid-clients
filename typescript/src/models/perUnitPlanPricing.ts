// this file is @generated

export interface PerUnitPlanPricing {
  rate: string;
}

export const PerUnitPlanPricingSerializer = {
  _fromJsonObject(object: any): PerUnitPlanPricing {
    return {
      rate: object["rate"],
    };
  },

  _toJsonObject(self: PerUnitPlanPricing): any {
    return {
      rate: self.rate,
    };
  },
};
