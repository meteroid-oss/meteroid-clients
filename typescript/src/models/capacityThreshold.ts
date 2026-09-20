// this file is @generated

export interface CapacityThreshold {
  includedAmount: number;

  perUnitOverage: string;

  price: string;
}

export const CapacityThresholdSerializer = {
  _fromJsonObject(object: any): CapacityThreshold {
    return {
      includedAmount: object["included_amount"],
      perUnitOverage: object["per_unit_overage"],
      price: object["price"],
    };
  },

  _toJsonObject(self: CapacityThreshold): any {
    return {
      included_amount: self.includedAmount,
      per_unit_overage: self.perUnitOverage,
      price: self.price,
    };
  },
};
