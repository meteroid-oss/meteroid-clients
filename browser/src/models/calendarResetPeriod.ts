// this file is @generated
import { type CalendarUnit, CalendarUnitSerializer } from "./calendarUnit";
/** Resets on calendar boundaries (e.g. the 1st of every month) — not tied to subscription start date. */
export interface CalendarResetPeriod {
  interval: number;

  unit: CalendarUnit;
}

export const CalendarResetPeriodSerializer = {
  _fromJsonObject(object: any): CalendarResetPeriod {
    return {
      interval: object["interval"],
      unit: CalendarUnitSerializer._fromJsonObject(object["unit"]),
    };
  },

  _toJsonObject(self: CalendarResetPeriod): any {
    return {
      interval: self.interval,
      unit: CalendarUnitSerializer._toJsonObject(self.unit),
    };
  },
};
