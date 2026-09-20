// this file is @generated

export interface ExtraRecurringPricing {
  quantity: number;

  unitPrice: string;
}

export const ExtraRecurringPricingSerializer = {
  _fromJsonObject(object: any): ExtraRecurringPricing {
    return {
      quantity: object["quantity"],
      unitPrice: object["unit_price"],
    };
  },

  _toJsonObject(self: ExtraRecurringPricing): any {
    return {
      quantity: self.quantity,
      unit_price: self.unitPrice,
    };
  },
};
