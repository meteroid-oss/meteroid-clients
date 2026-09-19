// this file is @generated

export interface TierRow {
  firstUnit: number;

  flatCap?: string | null;

  flatFee?: string | null;

  rate: string;
}

export const TierRowSerializer = {
  _fromJsonObject(object: any): TierRow {
    return {
      firstUnit: object["first_unit"],
      flatCap: object["flat_cap"],
      flatFee: object["flat_fee"],
      rate: object["rate"],
    };
  },

  _toJsonObject(self: TierRow): any {
    return {
      first_unit: self.firstUnit,
      flat_cap: self.flatCap,
      flat_fee: self.flatFee,
      rate: self.rate,
    };
  },
};
