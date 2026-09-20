// this file is @generated
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse";
import {
  type PlanVersionSummary,
  PlanVersionSummarySerializer,
} from "./planVersionSummary";

export interface PlanVersionListResponse {
  data: PlanVersionSummary[];

  paginationMeta: PaginationResponse;
}

export const PlanVersionListResponseSerializer = {
  _fromJsonObject(object: any): PlanVersionListResponse {
    return {
      data: object["data"].map((item: any) =>
        PlanVersionSummarySerializer._fromJsonObject(item)
      ),
      paginationMeta: PaginationResponseSerializer._fromJsonObject(
        object["pagination_meta"]
      ),
    };
  },

  _toJsonObject(self: PlanVersionListResponse): any {
    return {
      data: self.data.map((item: any) =>
        PlanVersionSummarySerializer._toJsonObject(item)
      ),
      pagination_meta: PaginationResponseSerializer._toJsonObject(self.paginationMeta),
    };
  },
};
