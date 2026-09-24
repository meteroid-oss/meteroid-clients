/** Never resets — counts all usage since the subscription was activated. */
export interface NeverResetPeriod {}

export const NeverResetPeriodSerializer = {
  _fromJsonObject(object: any): NeverResetPeriod {
    return {};
  },

  _toJsonObject(self: NeverResetPeriod): any {
    return {};
  },
};
