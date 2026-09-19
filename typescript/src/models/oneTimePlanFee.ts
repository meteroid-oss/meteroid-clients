// this file is @generated
/** One-time fee */
export interface OneTimePlanFee {
  quantity: number;

  unitPrice: string;
}

export const OneTimePlanFeeSerializer = {
  _fromJsonObject(object: any): OneTimePlanFee {
    return {
      quantity: object["quantity"],
      unitPrice: object["unit_price"],
    };
  },

  _toJsonObject(self: OneTimePlanFee): any {
    return {
      quantity: self.quantity,
      unit_price: self.unitPrice,
    };
  },
};
