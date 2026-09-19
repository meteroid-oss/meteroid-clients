// this file is @generated
import { type BillingTypeEnum, BillingTypeEnumSerializer } from "./billingTypeEnum";

export interface RecurringFee {
  billingType: BillingTypeEnum;

  quantity: number;

  rate: string;
}

export const RecurringFeeSerializer = {
  _fromJsonObject(object: any): RecurringFee {
    return {
      billingType: BillingTypeEnumSerializer._fromJsonObject(object["billing_type"]),
      quantity: object["quantity"],
      rate: object["rate"],
    };
  },

  _toJsonObject(self: RecurringFee): any {
    return {
      billing_type: BillingTypeEnumSerializer._toJsonObject(self.billingType),
      quantity: self.quantity,
      rate: self.rate,
    };
  },
};
