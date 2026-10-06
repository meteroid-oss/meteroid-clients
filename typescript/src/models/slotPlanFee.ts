// this file is @generated
import { extraProperties } from "../json.js";
import { type TermRate, TermRateSerializer } from "./termRate.js";
/** Slot-based fee (e.g., per-seat pricing) */
export interface SlotPlanFee {
  minimumCount?: number | null | undefined;
  quota?: number | null | undefined;
  rates: TermRate[];
  slotUnitName: string;
}

/** Converts `SlotPlanFee` values from (`parse`) and to (`serialize`) their JSON form. */
export const SlotPlanFeeSerializer = {
  parse(json: any): SlotPlanFee {
    return {
      ...extraProperties(json, ["minimum_count", "quota", "rates", "slot_unit_name"]),
      minimumCount: json["minimum_count"],
      quota: json["quota"],
      rates: json["rates"].map((item: any) => TermRateSerializer.parse(item)),
      slotUnitName: json["slot_unit_name"],
    };
  },

  serialize(value: SlotPlanFee): any {
    return {
      ...extraProperties(value, ["minimumCount", "quota", "rates", "slotUnitName"]),
      minimum_count: value.minimumCount,
      quota: value.quota,
      rates: value.rates.map((item: any) => TermRateSerializer.serialize(item)),
      slot_unit_name: value.slotUnitName,
    };
  },
};
