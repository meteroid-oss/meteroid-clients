// this file is @generated

export interface PerUnitPricing {
  rate: string;
}

export const PerUnitPricingSerializer = {
  _fromJsonObject(object: any): PerUnitPricing {
    return {
      rate: object["rate"],
    };
  },

  _toJsonObject(self: PerUnitPricing): any {
    return {
      rate: self.rate,
    };
  },
};
