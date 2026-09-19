// this file is @generated

export interface RateFee {
  rate: string;
}

export const RateFeeSerializer = {
  _fromJsonObject(object: any): RateFee {
    return {
      rate: object["rate"],
    };
  },

  _toJsonObject(self: RateFee): any {
    return {
      rate: self.rate,
    };
  },
};
