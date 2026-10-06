// this file is @generated
import { extraProperties } from "../json.js";

export interface SlotFee {
  initialSlots: number;
  maxSlots?: number | null | undefined;
  minSlots?: number | null | undefined;
  unit: string;
  unitRate: string;
}

/** Converts `SlotFee` values from (`parse`) and to (`serialize`) their JSON form. */
export const SlotFeeSerializer = {
  parse(json: any): SlotFee {
    return {
      ...extraProperties(json, [
        "initial_slots",
        "max_slots",
        "min_slots",
        "unit",
        "unit_rate",
      ]),
      initialSlots: json["initial_slots"],
      maxSlots: json["max_slots"],
      minSlots: json["min_slots"],
      unit: json["unit"],
      unitRate: json["unit_rate"],
    };
  },

  serialize(value: SlotFee): any {
    return {
      ...extraProperties(value, [
        "initialSlots",
        "maxSlots",
        "minSlots",
        "unit",
        "unitRate",
      ]),
      initial_slots: value.initialSlots,
      max_slots: value.maxSlots,
      min_slots: value.minSlots,
      unit: value.unit,
      unit_rate: value.unitRate,
    };
  },
};
