// this file is @generated

export interface SlotPricing {
  maxSlots?: number | null;

  minSlots?: number | null;

  unitRate: string;
}

export const SlotPricingSerializer = {
  _fromJsonObject(object: any): SlotPricing {
    return {
      maxSlots: object["max_slots"],
      minSlots: object["min_slots"],
      unitRate: object["unit_rate"],
    };
  },

  _toJsonObject(self: SlotPricing): any {
    return {
      max_slots: self.maxSlots,
      min_slots: self.minSlots,
      unit_rate: self.unitRate,
    };
  },
};
