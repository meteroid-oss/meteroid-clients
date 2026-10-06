// this file is @generated
import { extraProperties } from "../json.js";
import { type MetricUsage, MetricUsageSerializer } from "./metricUsage.js";

export interface UsageResponse {
  periodEnd: string;
  periodStart: string;
  usage: MetricUsage[];
}

/** Converts `UsageResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const UsageResponseSerializer = {
  parse(json: any): UsageResponse {
    return {
      ...extraProperties(json, ["period_end", "period_start", "usage"]),
      periodEnd: json["period_end"],
      periodStart: json["period_start"],
      usage: json["usage"].map((item: any) => MetricUsageSerializer.parse(item)),
    };
  },

  serialize(value: UsageResponse): any {
    return {
      ...extraProperties(value, ["periodEnd", "periodStart", "usage"]),
      period_end: value.periodEnd,
      period_start: value.periodStart,
      usage: value.usage.map((item: any) => MetricUsageSerializer.serialize(item)),
    };
  },
};
