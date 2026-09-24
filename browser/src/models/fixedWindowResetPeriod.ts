import { type CalendarUnit, CalendarUnitSerializer } from "./calendarUnit";
/** Resets at regular intervals — anchored to your subscription's exact activation time. */
export interface FixedWindowResetPeriod {
  interval: number;

  unit: CalendarUnit;
}

export const FixedWindowResetPeriodSerializer = {
  _fromJsonObject(object: any): FixedWindowResetPeriod {
    return {
      interval: object["interval"],
      unit: CalendarUnitSerializer._fromJsonObject(object["unit"]),
    };
  },

  _toJsonObject(self: FixedWindowResetPeriod): any {
    return {
      interval: self.interval,
      unit: CalendarUnitSerializer._toJsonObject(self.unit),
    };
  },
};
