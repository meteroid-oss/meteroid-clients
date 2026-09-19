// this file is @generated
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse";
import { type Product, ProductSerializer } from "./product";

export interface ProductListResponse {
  data: Product[];

  paginationMeta: PaginationResponse;
}

export const ProductListResponseSerializer = {
  _fromJsonObject(object: any): ProductListResponse {
    return {
      data: object["data"].map((item: any) => ProductSerializer._fromJsonObject(item)),
      paginationMeta: PaginationResponseSerializer._fromJsonObject(
        object["pagination_meta"]
      ),
    };
  },

  _toJsonObject(self: ProductListResponse): any {
    return {
      data: self.data.map((item: any) => ProductSerializer._toJsonObject(item)),
      pagination_meta: PaginationResponseSerializer._toJsonObject(self.paginationMeta),
    };
  },
};
