// this file is @generated
import { extraProperties } from "../json.js";
import { type AddOnId, AddOnIdSerializer } from "./addOnId.js";
import {
  type SubscriptionAddOnId,
  SubscriptionAddOnIdSerializer,
} from "./subscriptionAddOnId.js";
import { type SubscriptionFee, SubscriptionFeeSerializer } from "./subscriptionFee.js";
import {
  type SubscriptionFeeBillingPeriodEnum,
  SubscriptionFeeBillingPeriodEnumSerializer,
} from "./subscriptionFeeBillingPeriodEnum.js";

export interface SubscriptionAddOn {
  addOnId?: AddOnId | undefined;
  fee: SubscriptionFee;
  id?: SubscriptionAddOnId | undefined;
  name: string;
  period: SubscriptionFeeBillingPeriodEnum;
  quantity: number;
}

/** Converts `SubscriptionAddOn` values from (`parse`) and to (`serialize`) their JSON form. */
export const SubscriptionAddOnSerializer = {
  parse(json: any): SubscriptionAddOn {
    return {
      ...extraProperties(json, ["add_on_id", "fee", "id", "name", "period", "quantity"]),
      addOnId:
        json["add_on_id"] != null
          ? AddOnIdSerializer.parse(json["add_on_id"])
          : undefined,
      fee: SubscriptionFeeSerializer.parse(json["fee"]),
      id:
        json["id"] != null ? SubscriptionAddOnIdSerializer.parse(json["id"]) : undefined,
      name: json["name"],
      period: SubscriptionFeeBillingPeriodEnumSerializer.parse(json["period"]),
      quantity: json["quantity"],
    };
  },

  serialize(value: SubscriptionAddOn): any {
    return {
      ...extraProperties(value, ["addOnId", "fee", "id", "name", "period", "quantity"]),
      add_on_id:
        value.addOnId != null ? AddOnIdSerializer.serialize(value.addOnId) : undefined,
      fee: SubscriptionFeeSerializer.serialize(value.fee),
      id:
        value.id != null ? SubscriptionAddOnIdSerializer.serialize(value.id) : undefined,
      name: value.name,
      period: SubscriptionFeeBillingPeriodEnumSerializer.serialize(value.period),
      quantity: value.quantity,
    };
  },
};
