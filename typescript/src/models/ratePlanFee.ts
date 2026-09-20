// this file is @generated
import { type TermRate, TermRateSerializer } from "./termRate";
/** Recurring rate fee (e.g., monthly subscription) */
export interface RatePlanFee {
  rates: TermRate[];
}

export const RatePlanFeeSerializer = {
  _fromJsonObject(object: any): RatePlanFee {
    return {
      rates: object["rates"].map((item: any) => TermRateSerializer._fromJsonObject(item)),
    };
  },

  _toJsonObject(self: RatePlanFee): any {
    return {
      rates: self.rates.map((item: any) => TermRateSerializer._toJsonObject(item)),
    };
  },
};
