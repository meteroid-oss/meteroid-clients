// this file is @generated
import { extraProperties } from "../json.js";
import { type BillingTypeEnum, BillingTypeEnumSerializer } from "./billingTypeEnum.js";

export interface RecurringFee {
  billingType: BillingTypeEnum;
  quantity: number;
  rate: string;
}

/** Converts `RecurringFee` values from (`parse`) and to (`serialize`) their JSON form. */
export const RecurringFeeSerializer = {
  parse(json: any): RecurringFee {
    return {
      ...extraProperties(json, ["billing_type", "quantity", "rate"]),
      billingType: BillingTypeEnumSerializer.parse(json["billing_type"]),
      quantity: json["quantity"],
      rate: json["rate"],
    };
  },

  serialize(value: RecurringFee): any {
    return {
      ...extraProperties(value, ["billingType", "quantity", "rate"]),
      billing_type: BillingTypeEnumSerializer.serialize(value.billingType),
      quantity: value.quantity,
      rate: value.rate,
    };
  },
};
