// this file is @generated

export interface OneTimePricing {
  quantity: number;

  unitPrice: string;
}

export const OneTimePricingSerializer = {
  _fromJsonObject(object: any): OneTimePricing {
    return {
      quantity: object["quantity"],
      unitPrice: object["unit_price"],
    };
  },

  _toJsonObject(self: OneTimePricing): any {
    return {
      quantity: self.quantity,
      unit_price: self.unitPrice,
    };
  },
};
