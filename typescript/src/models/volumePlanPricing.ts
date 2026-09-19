// this file is @generated
import { type TierRow, TierRowSerializer } from "./tierRow";

export interface VolumePlanPricing {
  blockSize?: number | null;

  tiers: TierRow[];
}

export const VolumePlanPricingSerializer = {
  _fromJsonObject(object: any): VolumePlanPricing {
    return {
      blockSize: object["block_size"],
      tiers: object["tiers"].map((item: any) => TierRowSerializer._fromJsonObject(item)),
    };
  },

  _toJsonObject(self: VolumePlanPricing): any {
    return {
      block_size: self.blockSize,
      tiers: self.tiers.map((item: any) => TierRowSerializer._toJsonObject(item)),
    };
  },
};
