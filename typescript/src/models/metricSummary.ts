// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import { type BillableMetricId, BillableMetricIdSerializer } from "./billableMetricId.js";
import {
  type BillingMetricAggregateEnum,
  BillingMetricAggregateEnumSerializer,
} from "./billingMetricAggregateEnum.js";

export interface MetricSummary {
  aggregationKey?: string | null | undefined;
  aggregationType: BillingMetricAggregateEnum;
  archivedAt?: Date | null | undefined;
  code: string;
  createdAt: Date;
  description?: string | null | undefined;
  id: BillableMetricId;
  name: string;
}

/** Converts `MetricSummary` values from (`parse`) and to (`serialize`) their JSON form. */
export const MetricSummarySerializer = {
  parse(json: any): MetricSummary {
    return {
      ...extraProperties(json, [
        "aggregation_key",
        "aggregation_type",
        "archived_at",
        "code",
        "created_at",
        "description",
        "id",
        "name",
      ]),
      aggregationKey: json["aggregation_key"],
      aggregationType: BillingMetricAggregateEnumSerializer.parse(
        json["aggregation_type"]
      ),
      archivedAt:
        json["archived_at"] != null
          ? parseDateTime(json["archived_at"])
          : json["archived_at"],
      code: json["code"],
      createdAt: parseDateTime(json["created_at"]),
      description: json["description"],
      id: BillableMetricIdSerializer.parse(json["id"]),
      name: json["name"],
    };
  },

  serialize(value: MetricSummary): any {
    return {
      ...extraProperties(value, [
        "aggregationKey",
        "aggregationType",
        "archivedAt",
        "code",
        "createdAt",
        "description",
        "id",
        "name",
      ]),
      aggregation_key: value.aggregationKey,
      aggregation_type: BillingMetricAggregateEnumSerializer.serialize(
        value.aggregationType
      ),
      archived_at: value.archivedAt,
      code: value.code,
      created_at: value.createdAt,
      description: value.description,
      id: BillableMetricIdSerializer.serialize(value.id),
      name: value.name,
    };
  },
};
