// this file is @generated
import { extraProperties } from "../json.js";

export interface PackagePricing {
  blockSize: number;
  rate: string;
}

/** Converts `PackagePricing` values from (`parse`) and to (`serialize`) their JSON form. */
export const PackagePricingSerializer = {
  parse(json: any): PackagePricing {
    return {
      ...extraProperties(json, ["block_size", "rate"]),
      blockSize: json["block_size"],
      rate: json["rate"],
    };
  },

  serialize(value: PackagePricing): any {
    return {
      ...extraProperties(value, ["blockSize", "rate"]),
      block_size: value.blockSize,
      rate: value.rate,
    };
  },
};
