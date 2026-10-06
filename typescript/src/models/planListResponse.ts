// this file is @generated
import { extraProperties } from "../json.js";
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse.js";
import { type Plan, PlanSerializer } from "./plan.js";

export interface PlanListResponse {
  data: Plan[];
  paginationMeta: PaginationResponse;
}

/** Converts `PlanListResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const PlanListResponseSerializer = {
  parse(json: any): PlanListResponse {
    return {
      ...extraProperties(json, ["data", "pagination_meta"]),
      data: json["data"].map((item: any) => PlanSerializer.parse(item)),
      paginationMeta: PaginationResponseSerializer.parse(json["pagination_meta"]),
    };
  },

  serialize(value: PlanListResponse): any {
    return {
      ...extraProperties(value, ["data", "paginationMeta"]),
      data: value.data.map((item: any) => PlanSerializer.serialize(item)),
      pagination_meta: PaginationResponseSerializer.serialize(value.paginationMeta),
    };
  },
};
