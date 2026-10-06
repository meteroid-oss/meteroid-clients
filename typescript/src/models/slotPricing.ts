// this file is @generated
import { extraProperties } from "../json.js";

export interface SlotPricing {
  maxSlots?: number | null | undefined;
  minSlots?: number | null | undefined;
  unitRate: string;
}

/** Converts `SlotPricing` values from (`parse`) and to (`serialize`) their JSON form. */
export const SlotPricingSerializer = {
  parse(json: any): SlotPricing {
    return {
      ...extraProperties(json, ["max_slots", "min_slots", "unit_rate"]),
      maxSlots: json["max_slots"],
      minSlots: json["min_slots"],
      unitRate: json["unit_rate"],
    };
  },

  serialize(value: SlotPricing): any {
    return {
      ...extraProperties(value, ["maxSlots", "minSlots", "unitRate"]),
      max_slots: value.maxSlots,
      min_slots: value.minSlots,
      unit_rate: value.unitRate,
    };
  },
};
