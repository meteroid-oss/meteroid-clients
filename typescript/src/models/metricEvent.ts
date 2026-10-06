// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties, pickProperties } from "../json.js";
import { type EventId, EventIdSerializer } from "./eventId.js";
import { type EventType, EventTypeSerializer } from "./eventType.js";
import { type MetricEventData, MetricEventDataSerializer } from "./metricEventData.js";

export interface MetricEvent extends MetricEventData {
  id: EventId;
  timestamp: Date;
  type: EventType;
}

/** Converts `MetricEvent` values from (`parse`) and to (`serialize`) their JSON form. */
export const MetricEventSerializer = {
  parse(json: any): MetricEvent {
    return {
      ...extraProperties(json, [
        "id",
        "timestamp",
        "type",
        "aggregation_key",
        "aggregation_type",
        "code",
        "created_at",
        "description",
        "metric_id",
        "name",
        "product_family_id",
        "product_id",
        "segmentation_matrix",
        "unit_conversion_factor",
        "unit_conversion_rounding",
        "usage_group_key",
      ]),
      ...pickProperties(MetricEventDataSerializer.parse(json), [
        "aggregationKey",
        "aggregationType",
        "code",
        "createdAt",
        "description",
        "metricId",
        "name",
        "productFamilyId",
        "productId",
        "segmentationMatrix",
        "unitConversionFactor",
        "unitConversionRounding",
        "usageGroupKey",
      ]),
      id: EventIdSerializer.parse(json["id"]),
      timestamp: parseDateTime(json["timestamp"]),
      type: EventTypeSerializer.parse(json["type"]),
    };
  },

  serialize(value: MetricEvent): any {
    return {
      ...extraProperties(value, [
        "id",
        "timestamp",
        "type",
        "aggregationKey",
        "aggregationType",
        "code",
        "createdAt",
        "description",
        "metricId",
        "name",
        "productFamilyId",
        "productId",
        "segmentationMatrix",
        "unitConversionFactor",
        "unitConversionRounding",
        "usageGroupKey",
      ]),
      ...pickProperties(MetricEventDataSerializer.serialize(value), [
        "aggregation_key",
        "aggregation_type",
        "code",
        "created_at",
        "description",
        "metric_id",
        "name",
        "product_family_id",
        "product_id",
        "segmentation_matrix",
        "unit_conversion_factor",
        "unit_conversion_rounding",
        "usage_group_key",
      ]),
      id: EventIdSerializer.serialize(value.id),
      timestamp: value.timestamp,
      type: EventTypeSerializer.serialize(value.type),
    };
  },
};
