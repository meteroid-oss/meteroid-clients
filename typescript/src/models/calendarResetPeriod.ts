// this file is @generated
import { extraProperties } from "../json.js";
import { type CalendarUnit, CalendarUnitSerializer } from "./calendarUnit.js";
/** Resets on calendar boundaries (e.g. the 1st of every month) — not tied to subscription start date. */
export interface CalendarResetPeriod {
  interval: number;
  unit: CalendarUnit;
}

/** Converts `CalendarResetPeriod` values from (`parse`) and to (`serialize`) their JSON form. */
export const CalendarResetPeriodSerializer = {
  parse(json: any): CalendarResetPeriod {
    return {
      ...extraProperties(json, ["interval", "unit"]),
      interval: json["interval"],
      unit: CalendarUnitSerializer.parse(json["unit"]),
    };
  },

  serialize(value: CalendarResetPeriod): any {
    return {
      ...extraProperties(value, ["interval", "unit"]),
      interval: value.interval,
      unit: CalendarUnitSerializer.serialize(value.unit),
    };
  },
};
