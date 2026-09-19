// this file is @generated
import { type TierRow, TierRowSerializer } from "./tierRow";

export interface TieredPricing {
  blockSize?: number | null;

  tiers: TierRow[];
}

export const TieredPricingSerializer = {
  _fromJsonObject(object: any): TieredPricing {
    return {
      blockSize: object["block_size"],
      tiers: object["tiers"].map((item: any) => TierRowSerializer._fromJsonObject(item)),
    };
  },

  _toJsonObject(self: TieredPricing): any {
    return {
      block_size: self.blockSize,
      tiers: self.tiers.map((item: any) => TierRowSerializer._toJsonObject(item)),
    };
  },
};
