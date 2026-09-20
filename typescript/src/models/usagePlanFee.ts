// this file is @generated
import { type BillableMetricId, BillableMetricIdSerializer } from "./billableMetricId";
import { type BillingPeriodEnum, BillingPeriodEnumSerializer } from "./billingPeriodEnum";
import {
  type PlanUsagePricingModel,
  PlanUsagePricingModelSerializer,
} from "./planUsagePricingModel";
/** Usage-based fee */
export interface UsagePlanFee {
  cadence: BillingPeriodEnum;

  metricId: BillableMetricId;

  pricing: PlanUsagePricingModel;
}

export const UsagePlanFeeSerializer = {
  _fromJsonObject(object: any): UsagePlanFee {
    return {
      cadence: BillingPeriodEnumSerializer._fromJsonObject(object["cadence"]),
      metricId: BillableMetricIdSerializer._fromJsonObject(object["metric_id"]),
      pricing: PlanUsagePricingModelSerializer._fromJsonObject(object["pricing"]),
    };
  },

  _toJsonObject(self: UsagePlanFee): any {
    return {
      cadence: BillingPeriodEnumSerializer._toJsonObject(self.cadence),
      metric_id: BillableMetricIdSerializer._toJsonObject(self.metricId),
      pricing: PlanUsagePricingModelSerializer._toJsonObject(self.pricing),
    };
  },
};
