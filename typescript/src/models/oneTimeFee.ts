// this file is @generated

export interface OneTimeFee {
  quantity: number;

  rate: string;
}

export const OneTimeFeeSerializer = {
  _fromJsonObject(object: any): OneTimeFee {
    return {
      quantity: object["quantity"],
      rate: object["rate"],
    };
  },

  _toJsonObject(self: OneTimeFee): any {
    return {
      quantity: self.quantity,
      rate: self.rate,
    };
  },
};
