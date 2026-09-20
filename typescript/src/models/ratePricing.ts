// this file is @generated

export interface RatePricing {
  rate: string;
}

export const RatePricingSerializer = {
  _fromJsonObject(object: any): RatePricing {
    return {
      rate: object["rate"],
    };
  },

  _toJsonObject(self: RatePricing): any {
    return {
      rate: self.rate,
    };
  },
};
