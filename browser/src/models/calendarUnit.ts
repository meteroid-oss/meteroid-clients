export enum CalendarUnit {
  Hour = "HOUR",
  Day = "DAY",
  Week = "WEEK",
  Month = "MONTH",
  Year = "YEAR",
}

export const CalendarUnitSerializer = {
  _fromJsonObject(object: any): CalendarUnit {
    return object;
  },

  _toJsonObject(self: CalendarUnit): any {
    return self;
  },
};
