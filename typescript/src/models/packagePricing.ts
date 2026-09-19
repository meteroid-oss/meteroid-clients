// this file is @generated

export interface PackagePricing {
  blockSize: number;

  rate: string;
}

export const PackagePricingSerializer = {
  _fromJsonObject(object: any): PackagePricing {
    return {
      blockSize: object["block_size"],
      rate: object["rate"],
    };
  },

  _toJsonObject(self: PackagePricing): any {
    return {
      block_size: self.blockSize,
      rate: self.rate,
    };
  },
};
