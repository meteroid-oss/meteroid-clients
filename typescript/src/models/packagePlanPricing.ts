// this file is @generated
import { extraProperties } from "../json.js";

export interface PackagePlanPricing {
  blockSize: number;
  rate: string;
}

/** Converts `PackagePlanPricing` values from (`parse`) and to (`serialize`) their JSON form. */
export const PackagePlanPricingSerializer = {
  parse(json: any): PackagePlanPricing {
    return {
      ...extraProperties(json, ["block_size", "rate"]),
      blockSize: json["block_size"],
      rate: json["rate"],
    };
  },

  serialize(value: PackagePlanPricing): any {
    return {
      ...extraProperties(value, ["blockSize", "rate"]),
      block_size: value.blockSize,
      rate: value.rate,
    };
  },
};
