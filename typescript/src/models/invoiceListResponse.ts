// this file is @generated
import { extraProperties } from "../json.js";
import { type Invoice, InvoiceSerializer } from "./invoice.js";
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse.js";

export interface InvoiceListResponse {
  data: Invoice[];
  paginationMeta: PaginationResponse;
}

/** Converts `InvoiceListResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const InvoiceListResponseSerializer = {
  parse(json: any): InvoiceListResponse {
    return {
      ...extraProperties(json, ["data", "pagination_meta"]),
      data: json["data"].map((item: any) => InvoiceSerializer.parse(item)),
      paginationMeta: PaginationResponseSerializer.parse(json["pagination_meta"]),
    };
  },

  serialize(value: InvoiceListResponse): any {
    return {
      ...extraProperties(value, ["data", "paginationMeta"]),
      data: value.data.map((item: any) => InvoiceSerializer.serialize(item)),
      pagination_meta: PaginationResponseSerializer.serialize(value.paginationMeta),
    };
  },
};
