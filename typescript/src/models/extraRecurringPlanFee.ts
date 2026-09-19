// this file is @generated
import { type BillingPeriodEnum, BillingPeriodEnumSerializer } from "./billingPeriodEnum";
import { type BillingType, BillingTypeSerializer } from "./billingType";
/** Extra recurring fee */
export interface ExtraRecurringPlanFee {
  billingType: BillingType;

  cadence: BillingPeriodEnum;

  quantity: number;

  unitPrice: string;
}

export const ExtraRecurringPlanFeeSerializer = {
  _fromJsonObject(object: any): ExtraRecurringPlanFee {
    return {
      billingType: BillingTypeSerializer._fromJsonObject(object["billing_type"]),
      cadence: BillingPeriodEnumSerializer._fromJsonObject(object["cadence"]),
      quantity: object["quantity"],
      unitPrice: object["unit_price"],
    };
  },

  _toJsonObject(self: ExtraRecurringPlanFee): any {
    return {
      billing_type: BillingTypeSerializer._toJsonObject(self.billingType),
      cadence: BillingPeriodEnumSerializer._toJsonObject(self.cadence),
      quantity: self.quantity,
      unit_price: self.unitPrice,
    };
  },
};
