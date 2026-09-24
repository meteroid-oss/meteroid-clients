import { type BillingPeriodEnum, BillingPeriodEnumSerializer } from "./billingPeriodEnum";
import { type Currency, CurrencySerializer } from "./currency";
import { type PlanId, PlanIdSerializer } from "./planId";
import { type SubscriptionId, SubscriptionIdSerializer } from "./subscriptionId";
import {
  type SubscriptionStatusEnum,
  SubscriptionStatusEnumSerializer,
} from "./subscriptionStatusEnum";
/** A subscription of the signed-in customer, without pricing internals. */
export interface ClientSubscription {
  billingPeriod?: BillingPeriodEnum | null;

  currency: Currency;

  currentPeriodEnd?: string | null;

  currentPeriodStart: string;

  endDate?: string | null;

  id: SubscriptionId;

  planId: PlanId;

  planName: string;

  planVersion: number;

  startDate: string;

  status: SubscriptionStatusEnum;
}

export const ClientSubscriptionSerializer = {
  _fromJsonObject(object: any): ClientSubscription {
    return {
      billingPeriod:
        object["billing_period"] != null
          ? BillingPeriodEnumSerializer._fromJsonObject(object["billing_period"])
          : undefined,
      currency: CurrencySerializer._fromJsonObject(object["currency"]),
      currentPeriodEnd: object["current_period_end"],
      currentPeriodStart: object["current_period_start"],
      endDate: object["end_date"],
      id: SubscriptionIdSerializer._fromJsonObject(object["id"]),
      planId: PlanIdSerializer._fromJsonObject(object["plan_id"]),
      planName: object["plan_name"],
      planVersion: object["plan_version"],
      startDate: object["start_date"],
      status: SubscriptionStatusEnumSerializer._fromJsonObject(object["status"]),
    };
  },

  _toJsonObject(self: ClientSubscription): any {
    return {
      billing_period:
        self.billingPeriod != null
          ? BillingPeriodEnumSerializer._toJsonObject(self.billingPeriod)
          : undefined,
      currency: CurrencySerializer._toJsonObject(self.currency),
      current_period_end: self.currentPeriodEnd,
      current_period_start: self.currentPeriodStart,
      end_date: self.endDate,
      id: SubscriptionIdSerializer._toJsonObject(self.id),
      plan_id: PlanIdSerializer._toJsonObject(self.planId),
      plan_name: self.planName,
      plan_version: self.planVersion,
      start_date: self.startDate,
      status: SubscriptionStatusEnumSerializer._toJsonObject(self.status),
    };
  },
};
