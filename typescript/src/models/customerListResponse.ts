// this file is @generated
import { extraProperties } from "../json.js";
import { type Customer, CustomerSerializer } from "./customer.js";
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse.js";

export interface CustomerListResponse {
  data: Customer[];
  paginationMeta: PaginationResponse;
}

/** Converts `CustomerListResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const CustomerListResponseSerializer = {
  parse(json: any): CustomerListResponse {
    return {
      ...extraProperties(json, ["data", "pagination_meta"]),
      data: json["data"].map((item: any) => CustomerSerializer.parse(item)),
      paginationMeta: PaginationResponseSerializer.parse(json["pagination_meta"]),
    };
  },

  serialize(value: CustomerListResponse): any {
    return {
      ...extraProperties(value, ["data", "paginationMeta"]),
      data: value.data.map((item: any) => CustomerSerializer.serialize(item)),
      pagination_meta: PaginationResponseSerializer.serialize(value.paginationMeta),
    };
  },
};
