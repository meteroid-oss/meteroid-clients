// this file is @generated
import { extraProperties } from "../json.js";
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse.js";
import {
  type PlanVersionSummary,
  PlanVersionSummarySerializer,
} from "./planVersionSummary.js";

export interface PlanVersionListResponse {
  data: PlanVersionSummary[];
  paginationMeta: PaginationResponse;
}

/** Converts `PlanVersionListResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const PlanVersionListResponseSerializer = {
  parse(json: any): PlanVersionListResponse {
    return {
      ...extraProperties(json, ["data", "pagination_meta"]),
      data: json["data"].map((item: any) => PlanVersionSummarySerializer.parse(item)),
      paginationMeta: PaginationResponseSerializer.parse(json["pagination_meta"]),
    };
  },

  serialize(value: PlanVersionListResponse): any {
    return {
      ...extraProperties(value, ["data", "paginationMeta"]),
      data: value.data.map((item: any) => PlanVersionSummarySerializer.serialize(item)),
      pagination_meta: PaginationResponseSerializer.serialize(value.paginationMeta),
    };
  },
};
