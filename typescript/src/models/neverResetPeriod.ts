// this file is @generated
import { extraProperties } from "../json.js";
/** Never resets — counts all usage since the subscription was activated. */
export interface NeverResetPeriod {}

/** Converts `NeverResetPeriod` values from (`parse`) and to (`serialize`) their JSON form. */
export const NeverResetPeriodSerializer = {
  parse(json: any): NeverResetPeriod {
    return {
      ...extraProperties(json, []),
    };
  },

  serialize(value: NeverResetPeriod): any {
    return {
      ...extraProperties(value, []),
    };
  },
};
