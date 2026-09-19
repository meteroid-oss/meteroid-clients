// this file is @generated

export interface CapacityPricing {
  included: number;

  overageRate: string;

  rate: string;
}

export const CapacityPricingSerializer = {
  _fromJsonObject(object: any): CapacityPricing {
    return {
      included: object["included"],
      overageRate: object["overage_rate"],
      rate: object["rate"],
    };
  },

  _toJsonObject(self: CapacityPricing): any {
    return {
      included: self.included,
      overage_rate: self.overageRate,
      rate: self.rate,
    };
  },
};
