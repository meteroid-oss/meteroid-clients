// this file is @generated

export const CalendarUnit = {
  Hour: "HOUR",
  Day: "DAY",
  Week: "WEEK",
  Month: "MONTH",
  Year: "YEAR",
} as const;
export type CalendarUnit =
  | (typeof CalendarUnit)[keyof typeof CalendarUnit]
  | (string & {});

/** Converts `CalendarUnit` values from (`parse`) and to (`serialize`) their JSON form. */
export const CalendarUnitSerializer = {
  parse(json: any): CalendarUnit {
    return json;
  },

  serialize(value: CalendarUnit): any {
    return value;
  },
};
