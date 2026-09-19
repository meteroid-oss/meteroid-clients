// this file is @generated
import { type AddOnId, AddOnIdSerializer } from "./addOnId";
import {
  type SubscriptionAddOnId,
  SubscriptionAddOnIdSerializer,
} from "./subscriptionAddOnId";
import { type SubscriptionFee, SubscriptionFeeSerializer } from "./subscriptionFee";
import {
  type SubscriptionFeeBillingPeriodEnum,
  SubscriptionFeeBillingPeriodEnumSerializer,
} from "./subscriptionFeeBillingPeriodEnum";

export interface SubscriptionAddOn {
  addOnId?: AddOnId;

  fee: SubscriptionFee;

  id?: SubscriptionAddOnId;

  name: string;

  period: SubscriptionFeeBillingPeriodEnum;

  quantity: number;
}

export const SubscriptionAddOnSerializer = {
  _fromJsonObject(object: any): SubscriptionAddOn {
    return {
      addOnId:
        object["add_on_id"] != null
          ? AddOnIdSerializer._fromJsonObject(object["add_on_id"])
          : undefined,
      fee: SubscriptionFeeSerializer._fromJsonObject(object["fee"]),
      id:
        object["id"] != null
          ? SubscriptionAddOnIdSerializer._fromJsonObject(object["id"])
          : undefined,
      name: object["name"],
      period: SubscriptionFeeBillingPeriodEnumSerializer._fromJsonObject(
        object["period"]
      ),
      quantity: object["quantity"],
    };
  },

  _toJsonObject(self: SubscriptionAddOn): any {
    return {
      add_on_id:
        self.addOnId != null ? AddOnIdSerializer._toJsonObject(self.addOnId) : undefined,
      fee: SubscriptionFeeSerializer._toJsonObject(self.fee),
      id:
        self.id != null
          ? SubscriptionAddOnIdSerializer._toJsonObject(self.id)
          : undefined,
      name: self.name,
      period: SubscriptionFeeBillingPeriodEnumSerializer._toJsonObject(self.period),
      quantity: self.quantity,
    };
  },
};
