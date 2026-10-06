// this file is @generated
import { extraProperties } from "../json.js";
import { type MetricSummary, MetricSummarySerializer } from "./metricSummary.js";
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse.js";

export interface MetricListResponse {
  data: MetricSummary[];
  paginationMeta: PaginationResponse;
}

/** Converts `MetricListResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const MetricListResponseSerializer = {
  parse(json: any): MetricListResponse {
    return {
      ...extraProperties(json, ["data", "pagination_meta"]),
      data: json["data"].map((item: any) => MetricSummarySerializer.parse(item)),
      paginationMeta: PaginationResponseSerializer.parse(json["pagination_meta"]),
    };
  },

  serialize(value: MetricListResponse): any {
    return {
      ...extraProperties(value, ["data", "paginationMeta"]),
      data: value.data.map((item: any) => MetricSummarySerializer.serialize(item)),
      pagination_meta: PaginationResponseSerializer.serialize(value.paginationMeta),
    };
  },
};
