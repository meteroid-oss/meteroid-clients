// this file is @generated

export interface SlotFee {
  initialSlots: number;

  maxSlots?: number | null;

  minSlots?: number | null;

  unit: string;

  unitRate: string;
}

export const SlotFeeSerializer = {
  _fromJsonObject(object: any): SlotFee {
    return {
      initialSlots: object["initial_slots"],
      maxSlots: object["max_slots"],
      minSlots: object["min_slots"],
      unit: object["unit"],
      unitRate: object["unit_rate"],
    };
  },

  _toJsonObject(self: SlotFee): any {
    return {
      initial_slots: self.initialSlots,
      max_slots: self.maxSlots,
      min_slots: self.minSlots,
      unit: self.unit,
      unit_rate: self.unitRate,
    };
  },
};
