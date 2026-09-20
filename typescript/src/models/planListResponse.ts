// this file is @generated
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse";
import { type Plan, PlanSerializer } from "./plan";

export interface PlanListResponse {
  data: Plan[];

  paginationMeta: PaginationResponse;
}

export const PlanListResponseSerializer = {
  _fromJsonObject(object: any): PlanListResponse {
    return {
      data: object["data"].map((item: any) => PlanSerializer._fromJsonObject(item)),
      paginationMeta: PaginationResponseSerializer._fromJsonObject(
        object["pagination_meta"]
      ),
    };
  },

  _toJsonObject(self: PlanListResponse): any {
    return {
      data: self.data.map((item: any) => PlanSerializer._toJsonObject(item)),
      pagination_meta: PaginationResponseSerializer._toJsonObject(self.paginationMeta),
    };
  },
};
