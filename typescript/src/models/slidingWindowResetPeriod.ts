// this file is @generated
import { extraProperties } from "../json.js";
import { type CalendarUnit, CalendarUnitSerializer } from "./calendarUnit.js";
/** Always ends at now — e.g. 30 days means the last 30 days, old usage drops off automatically. */
export interface SlidingWindowResetPeriod {
  interval: number;
  unit: CalendarUnit;
}

/** Converts `SlidingWindowResetPeriod` values from (`parse`) and to (`serialize`) their JSON form. */
export const SlidingWindowResetPeriodSerializer = {
  parse(json: any): SlidingWindowResetPeriod {
    return {
      ...extraProperties(json, ["interval", "unit"]),
      interval: json["interval"],
      unit: CalendarUnitSerializer.parse(json["unit"]),
    };
  },

  serialize(value: SlidingWindowResetPeriod): any {
    return {
      ...extraProperties(value, ["interval", "unit"]),
      interval: value.interval,
      unit: CalendarUnitSerializer.serialize(value.unit),
    };
  },
};
