// this file is @generated
import { extraProperties } from "../json.js";
import {
  type BatchJobItemFailureResponse,
  BatchJobItemFailureResponseSerializer,
} from "./batchJobItemFailureResponse.js";

export interface BatchJobFailuresResponse {
  data: BatchJobItemFailureResponse[];
  totalCount: number;
}

/** Converts `BatchJobFailuresResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const BatchJobFailuresResponseSerializer = {
  parse(json: any): BatchJobFailuresResponse {
    return {
      ...extraProperties(json, ["data", "total_count"]),
      data: json["data"].map((item: any) =>
        BatchJobItemFailureResponseSerializer.parse(item)
      ),
      totalCount: json["total_count"],
    };
  },

  serialize(value: BatchJobFailuresResponse): any {
    return {
      ...extraProperties(value, ["data", "totalCount"]),
      data: value.data.map((item: any) =>
        BatchJobItemFailureResponseSerializer.serialize(item)
      ),
      total_count: value.totalCount,
    };
  },
};
