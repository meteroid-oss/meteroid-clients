// this file is @generated

export interface PackagePlanPricing {
  blockSize: number;

  rate: string;
}

export const PackagePlanPricingSerializer = {
  _fromJsonObject(object: any): PackagePlanPricing {
    return {
      blockSize: object["block_size"],
      rate: object["rate"],
    };
  },

  _toJsonObject(self: PackagePlanPricing): any {
    return {
      block_size: self.blockSize,
      rate: self.rate,
    };
  },
};
