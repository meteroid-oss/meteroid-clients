// this file is @generated
import { type Customer, CustomerSerializer } from "./customer";
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse";

export interface CustomerListResponse {
  data: Customer[];

  paginationMeta: PaginationResponse;
}

export const CustomerListResponseSerializer = {
  _fromJsonObject(object: any): CustomerListResponse {
    return {
      data: object["data"].map((item: any) => CustomerSerializer._fromJsonObject(item)),
      paginationMeta: PaginationResponseSerializer._fromJsonObject(
        object["pagination_meta"]
      ),
    };
  },

  _toJsonObject(self: CustomerListResponse): any {
    return {
      data: self.data.map((item: any) => CustomerSerializer._toJsonObject(item)),
      pagination_meta: PaginationResponseSerializer._toJsonObject(self.paginationMeta),
    };
  },
};
