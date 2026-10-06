// this file is @generated
import { extraProperties } from "../json.js";
import { type BatchJobResponse, BatchJobResponseSerializer } from "./batchJobResponse.js";
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse.js";

export interface BatchJobListResponse {
  data: BatchJobResponse[];
  paginationMeta: PaginationResponse;
}

/** Converts `BatchJobListResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const BatchJobListResponseSerializer = {
  parse(json: any): BatchJobListResponse {
    return {
      ...extraProperties(json, ["data", "pagination_meta"]),
      data: json["data"].map((item: any) => BatchJobResponseSerializer.parse(item)),
      paginationMeta: PaginationResponseSerializer.parse(json["pagination_meta"]),
    };
  },

  serialize(value: BatchJobListResponse): any {
    return {
      ...extraProperties(value, ["data", "paginationMeta"]),
      data: value.data.map((item: any) => BatchJobResponseSerializer.serialize(item)),
      pagination_meta: PaginationResponseSerializer.serialize(value.paginationMeta),
    };
  },
};
