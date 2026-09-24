// this file is @generated
import { type BillingPeriodEnum, BillingPeriodEnumSerializer } from "./billingPeriodEnum";
import { type PlanId, PlanIdSerializer } from "./planId";
import { type SubscriptionId, SubscriptionIdSerializer } from "./subscriptionId";
import {
  type SubscriptionStatusEnum,
  SubscriptionStatusEnumSerializer,
} from "./subscriptionStatusEnum";

export interface ClientSubscription {
  billingPeriod?: BillingPeriodEnum | null;

  currency: string;

  /** Current billing period end date */
  currentPeriodEnd?: string | null;

  /** Current billing period start date */
  currentPeriodStart: string;

  /** When the subscription ends (if set) */
  endDate?: string | null;

  id: SubscriptionId;

  planId: PlanId;

  planName: string;

  planVersion: number;

  /** When the subscription contract starts (benefits apply from this date) */
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
      currency: object["currency"],
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
      currency: self.currency,
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
