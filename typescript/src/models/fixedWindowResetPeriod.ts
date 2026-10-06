// this file is @generated
import { extraProperties } from "../json.js";
import { type CalendarUnit, CalendarUnitSerializer } from "./calendarUnit.js";
/** Resets at regular intervals — anchored to your subscription's exact activation time. */
export interface FixedWindowResetPeriod {
  interval: number;
  unit: CalendarUnit;
}

/** Converts `FixedWindowResetPeriod` values from (`parse`) and to (`serialize`) their JSON form. */
export const FixedWindowResetPeriodSerializer = {
  parse(json: any): FixedWindowResetPeriod {
    return {
      ...extraProperties(json, ["interval", "unit"]),
      interval: json["interval"],
      unit: CalendarUnitSerializer.parse(json["unit"]),
    };
  },

  serialize(value: FixedWindowResetPeriod): any {
    return {
      ...extraProperties(value, ["interval", "unit"]),
      interval: value.interval,
      unit: CalendarUnitSerializer.serialize(value.unit),
    };
  },
};
