// this file is @generated
import { type TermRate, TermRateSerializer } from "./termRate";
/** Slot-based fee (e.g., per-seat pricing) */
export interface SlotPlanFee {
  minimumCount?: number | null;

  quota?: number | null;

  rates: TermRate[];

  slotUnitName: string;
}

export const SlotPlanFeeSerializer = {
  _fromJsonObject(object: any): SlotPlanFee {
    return {
      minimumCount: object["minimum_count"],
      quota: object["quota"],
      rates: object["rates"].map((item: any) => TermRateSerializer._fromJsonObject(item)),
      slotUnitName: object["slot_unit_name"],
    };
  },

  _toJsonObject(self: SlotPlanFee): any {
    return {
      minimum_count: self.minimumCount,
      quota: self.quota,
      rates: self.rates.map((item: any) => TermRateSerializer._toJsonObject(item)),
      slot_unit_name: self.slotUnitName,
    };
  },
};
