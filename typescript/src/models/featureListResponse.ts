// this file is @generated
import { extraProperties } from "../json.js";
import { type Feature, FeatureSerializer } from "./feature.js";
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse.js";

export interface FeatureListResponse {
  data: Feature[];
  paginationMeta: PaginationResponse;
}

/** Converts `FeatureListResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const FeatureListResponseSerializer = {
  parse(json: any): FeatureListResponse {
    return {
      ...extraProperties(json, ["data", "pagination_meta"]),
      data: json["data"].map((item: any) => FeatureSerializer.parse(item)),
      paginationMeta: PaginationResponseSerializer.parse(json["pagination_meta"]),
    };
  },

  serialize(value: FeatureListResponse): any {
    return {
      ...extraProperties(value, ["data", "paginationMeta"]),
      data: value.data.map((item: any) => FeatureSerializer.serialize(item)),
      pagination_meta: PaginationResponseSerializer.serialize(value.paginationMeta),
    };
  },
};
