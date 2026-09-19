// this file is @generated
import {
  type BatchJobItemFailureResponse,
  BatchJobItemFailureResponseSerializer,
} from "./batchJobItemFailureResponse";

export interface BatchJobFailuresResponse {
  data: BatchJobItemFailureResponse[];

  totalCount: number;
}

export const BatchJobFailuresResponseSerializer = {
  _fromJsonObject(object: any): BatchJobFailuresResponse {
    return {
      data: object["data"].map((item: any) =>
        BatchJobItemFailureResponseSerializer._fromJsonObject(item)
      ),
      totalCount: object["total_count"],
    };
  },

  _toJsonObject(self: BatchJobFailuresResponse): any {
    return {
      data: self.data.map((item: any) =>
        BatchJobItemFailureResponseSerializer._toJsonObject(item)
      ),
      total_count: self.totalCount,
    };
  },
};
