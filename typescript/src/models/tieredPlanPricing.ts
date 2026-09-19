// this file is @generated
import { type TierRow, TierRowSerializer } from "./tierRow";

export interface TieredPlanPricing {
  blockSize?: number | null;

  tiers: TierRow[];
}

export const TieredPlanPricingSerializer = {
  _fromJsonObject(object: any): TieredPlanPricing {
    return {
      blockSize: object["block_size"],
      tiers: object["tiers"].map((item: any) => TierRowSerializer._fromJsonObject(item)),
    };
  },

  _toJsonObject(self: TieredPlanPricing): any {
    return {
      block_size: self.blockSize,
      tiers: self.tiers.map((item: any) => TierRowSerializer._toJsonObject(item)),
    };
  },
};
