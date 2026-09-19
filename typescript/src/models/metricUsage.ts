// this file is @generated
import { type BillableMetricId, BillableMetricIdSerializer } from "./billableMetricId";
import { type GroupedUsage, GroupedUsageSerializer } from "./groupedUsage";

export interface MetricUsage {
  groupedUsage: GroupedUsage[];

  metricCode: string;

  metricId: BillableMetricId;

  metricName: string;

  totalValue: string;
}

export const MetricUsageSerializer = {
  _fromJsonObject(object: any): MetricUsage {
    return {
      groupedUsage: object["grouped_usage"].map((item: any) =>
        GroupedUsageSerializer._fromJsonObject(item)
      ),
      metricCode: object["metric_code"],
      metricId: BillableMetricIdSerializer._fromJsonObject(object["metric_id"]),
      metricName: object["metric_name"],
      totalValue: object["total_value"],
    };
  },

  _toJsonObject(self: MetricUsage): any {
    return {
      grouped_usage: self.groupedUsage.map((item: any) =>
        GroupedUsageSerializer._toJsonObject(item)
      ),
      metric_code: self.metricCode,
      metric_id: BillableMetricIdSerializer._toJsonObject(self.metricId),
      metric_name: self.metricName,
      total_value: self.totalValue,
    };
  },
};
