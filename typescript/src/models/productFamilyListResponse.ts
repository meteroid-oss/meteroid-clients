// this file is @generated
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse";
import { type ProductFamily, ProductFamilySerializer } from "./productFamily";

export interface ProductFamilyListResponse {
  data: ProductFamily[];

  paginationMeta: PaginationResponse;
}

export const ProductFamilyListResponseSerializer = {
  _fromJsonObject(object: any): ProductFamilyListResponse {
    return {
      data: object["data"].map((item: any) =>
        ProductFamilySerializer._fromJsonObject(item)
      ),
      paginationMeta: PaginationResponseSerializer._fromJsonObject(
        object["pagination_meta"]
      ),
    };
  },

  _toJsonObject(self: ProductFamilyListResponse): any {
    return {
      data: self.data.map((item: any) => ProductFamilySerializer._toJsonObject(item)),
      pagination_meta: PaginationResponseSerializer._toJsonObject(self.paginationMeta),
    };
  },
};
