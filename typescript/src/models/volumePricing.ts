// this file is @generated
import { type TierRow, TierRowSerializer } from "./tierRow";

export interface VolumePricing {
  blockSize?: number | null;

  tiers: TierRow[];
}

export const VolumePricingSerializer = {
  _fromJsonObject(object: any): VolumePricing {
    return {
      blockSize: object["block_size"],
      tiers: object["tiers"].map((item: any) => TierRowSerializer._fromJsonObject(item)),
    };
  },

  _toJsonObject(self: VolumePricing): any {
    return {
      block_size: self.blockSize,
      tiers: self.tiers.map((item: any) => TierRowSerializer._toJsonObject(item)),
    };
  },
};
