// this file is @generated
import { type Invoice, InvoiceSerializer } from "./invoice";
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse";

export interface InvoiceListResponse {
  data: Invoice[];

  paginationMeta: PaginationResponse;
}

export const InvoiceListResponseSerializer = {
  _fromJsonObject(object: any): InvoiceListResponse {
    return {
      data: object["data"].map((item: any) => InvoiceSerializer._fromJsonObject(item)),
      paginationMeta: PaginationResponseSerializer._fromJsonObject(
        object["pagination_meta"]
      ),
    };
  },

  _toJsonObject(self: InvoiceListResponse): any {
    return {
      data: self.data.map((item: any) => InvoiceSerializer._toJsonObject(item)),
      pagination_meta: PaginationResponseSerializer._toJsonObject(self.paginationMeta),
    };
  },
};
