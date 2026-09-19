// this file is @generated
import { type MetricSummary, MetricSummarySerializer } from "./metricSummary";
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse";

export interface MetricListResponse {
  data: MetricSummary[];

  paginationMeta: PaginationResponse;
}

export const MetricListResponseSerializer = {
  _fromJsonObject(object: any): MetricListResponse {
    return {
      data: object["data"].map((item: any) =>
        MetricSummarySerializer._fromJsonObject(item)
      ),
      paginationMeta: PaginationResponseSerializer._fromJsonObject(
        object["pagination_meta"]
      ),
    };
  },

  _toJsonObject(self: MetricListResponse): any {
    return {
      data: self.data.map((item: any) => MetricSummarySerializer._toJsonObject(item)),
      pagination_meta: PaginationResponseSerializer._toJsonObject(self.paginationMeta),
    };
  },
};
