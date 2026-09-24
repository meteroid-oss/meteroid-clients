import { type CalendarUnit, CalendarUnitSerializer } from "./calendarUnit";
/** Always ends at now — e.g. 30 days means the last 30 days, old usage drops off automatically. */
export interface SlidingWindowResetPeriod {
  interval: number;

  unit: CalendarUnit;
}

export const SlidingWindowResetPeriodSerializer = {
  _fromJsonObject(object: any): SlidingWindowResetPeriod {
    return {
      interval: object["interval"],
      unit: CalendarUnitSerializer._fromJsonObject(object["unit"]),
    };
  },

  _toJsonObject(self: SlidingWindowResetPeriod): any {
    return {
      interval: self.interval,
      unit: CalendarUnitSerializer._toJsonObject(self.unit),
    };
  },
};
