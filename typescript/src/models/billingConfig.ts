// this file is @generated

export interface BillingConfig {
  billingCycles?: number | null;

  netTerms?: number;

  periodStartDay?: number | null;
}

export const BillingConfigSerializer = {
  _fromJsonObject(object: any): BillingConfig {
    return {
      billingCycles: object["billing_cycles"],
      netTerms: object["net_terms"],
      periodStartDay: object["period_start_day"],
    };
  },

  _toJsonObject(self: BillingConfig): any {
    return {
      billing_cycles: self.billingCycles,
      net_terms: self.netTerms,
      period_start_day: self.periodStartDay,
    };
  },
};
