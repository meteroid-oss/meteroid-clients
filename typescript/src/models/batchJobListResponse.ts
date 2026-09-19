// this file is @generated
import { type BatchJobResponse, BatchJobResponseSerializer } from "./batchJobResponse";
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse";

export interface BatchJobListResponse {
  data: BatchJobResponse[];

  paginationMeta: PaginationResponse;
}

export const BatchJobListResponseSerializer = {
  _fromJsonObject(object: any): BatchJobListResponse {
    return {
      data: object["data"].map((item: any) =>
        BatchJobResponseSerializer._fromJsonObject(item)
      ),
      paginationMeta: PaginationResponseSerializer._fromJsonObject(
        object["pagination_meta"]
      ),
    };
  },

  _toJsonObject(self: BatchJobListResponse): any {
    return {
      data: self.data.map((item: any) => BatchJobResponseSerializer._toJsonObject(item)),
      pagination_meta: PaginationResponseSerializer._toJsonObject(self.paginationMeta),
    };
  },
};
