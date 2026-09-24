import {
  type BillingCycleResetPeriod,
  BillingCycleResetPeriodSerializer,
} from "./billingCycleResetPeriod";
import {
  type CalendarResetPeriod,
  CalendarResetPeriodSerializer,
} from "./calendarResetPeriod";
import {
  type FixedWindowResetPeriod,
  FixedWindowResetPeriodSerializer,
} from "./fixedWindowResetPeriod";
import { type NeverResetPeriod, NeverResetPeriodSerializer } from "./neverResetPeriod";
import {
  type SlidingWindowResetPeriod,
  SlidingWindowResetPeriodSerializer,
} from "./slidingWindowResetPeriod";

export interface ResetPeriodBillingCycle extends BillingCycleResetPeriod {
  type: "BILLING_CYCLE";
}
export interface ResetPeriodCalendar extends CalendarResetPeriod {
  type: "CALENDAR";
}
export interface ResetPeriodFixedWindow extends FixedWindowResetPeriod {
  type: "FIXED_WINDOW";
}
export interface ResetPeriodSlidingWindow extends SlidingWindowResetPeriod {
  type: "SLIDING_WINDOW";
}
export interface ResetPeriodNever extends NeverResetPeriod {
  type: "NEVER";
}

export type ResetPeriod =
  | ResetPeriodBillingCycle
  | ResetPeriodCalendar
  | ResetPeriodFixedWindow
  | ResetPeriodSlidingWindow
  | ResetPeriodNever;

export const ResetPeriodSerializer = {
  _fromJsonObject(object: any): ResetPeriod {
    const type = object["type"];

    switch (type) {
      case "BILLING_CYCLE":
        return {
          ...BillingCycleResetPeriodSerializer._fromJsonObject(object),
          type: "BILLING_CYCLE",
        };
      case "CALENDAR":
        return {
          ...CalendarResetPeriodSerializer._fromJsonObject(object),
          type: "CALENDAR",
        };
      case "FIXED_WINDOW":
        return {
          ...FixedWindowResetPeriodSerializer._fromJsonObject(object),
          type: "FIXED_WINDOW",
        };
      case "SLIDING_WINDOW":
        return {
          ...SlidingWindowResetPeriodSerializer._fromJsonObject(object),
          type: "SLIDING_WINDOW",
        };
      case "NEVER":
        return {
          ...NeverResetPeriodSerializer._fromJsonObject(object),
          type: "NEVER",
        };
      default:
        throw new Error(`Unexpected type for ResetPeriod: ${type}`);
    }
  },

  _toJsonObject(self: ResetPeriod): any {
    switch (self.type) {
      case "BILLING_CYCLE":
        return {
          ...BillingCycleResetPeriodSerializer._toJsonObject(self),
          type: "BILLING_CYCLE",
        };
      case "CALENDAR":
        return {
          ...CalendarResetPeriodSerializer._toJsonObject(self),
          type: "CALENDAR",
        };
      case "FIXED_WINDOW":
        return {
          ...FixedWindowResetPeriodSerializer._toJsonObject(self),
          type: "FIXED_WINDOW",
        };
      case "SLIDING_WINDOW":
        return {
          ...SlidingWindowResetPeriodSerializer._toJsonObject(self),
          type: "SLIDING_WINDOW",
        };
      case "NEVER":
        return {
          ...NeverResetPeriodSerializer._toJsonObject(self),
          type: "NEVER",
        };
      default:
        throw new Error(`Unexpected type for ResetPeriod`);
    }
  },
};
