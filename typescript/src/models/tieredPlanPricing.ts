// this file is @generated
import { extraProperties } from "../json.js";
import { type TierRow, TierRowSerializer } from "./tierRow.js";

export interface TieredPlanPricing {
  blockSize?: number | null | undefined;
  tiers: TierRow[];
}

/** Converts `TieredPlanPricing` values from (`parse`) and to (`serialize`) their JSON form. */
export const TieredPlanPricingSerializer = {
  parse(json: any): TieredPlanPricing {
    return {
      ...extraProperties(json, ["block_size", "tiers"]),
      blockSize: json["block_size"],
      tiers: json["tiers"].map((item: any) => TierRowSerializer.parse(item)),
    };
  },

  serialize(value: TieredPlanPricing): any {
    return {
      ...extraProperties(value, ["blockSize", "tiers"]),
      block_size: value.blockSize,
      tiers: value.tiers.map((item: any) => TierRowSerializer.serialize(item)),
    };
  },
};
