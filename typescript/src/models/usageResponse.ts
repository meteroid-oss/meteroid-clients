// this file is @generated
import { type MetricUsage, MetricUsageSerializer } from "./metricUsage";

export interface UsageResponse {
  periodEnd: string;

  periodStart: string;

  usage: MetricUsage[];
}

export const UsageResponseSerializer = {
  _fromJsonObject(object: any): UsageResponse {
    return {
      periodEnd: object["period_end"],
      periodStart: object["period_start"],
      usage: object["usage"].map((item: any) =>
        MetricUsageSerializer._fromJsonObject(item)
      ),
    };
  },

  _toJsonObject(self: UsageResponse): any {
    return {
      period_end: self.periodEnd,
      period_start: self.periodStart,
      usage: self.usage.map((item: any) => MetricUsageSerializer._toJsonObject(item)),
    };
  },
};
