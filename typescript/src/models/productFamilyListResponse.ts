// this file is @generated
import { extraProperties } from "../json.js";
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse.js";
import { type ProductFamily, ProductFamilySerializer } from "./productFamily.js";

export interface ProductFamilyListResponse {
  data: ProductFamily[];
  paginationMeta: PaginationResponse;
}

/** Converts `ProductFamilyListResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const ProductFamilyListResponseSerializer = {
  parse(json: any): ProductFamilyListResponse {
    return {
      ...extraProperties(json, ["data", "pagination_meta"]),
      data: json["data"].map((item: any) => ProductFamilySerializer.parse(item)),
      paginationMeta: PaginationResponseSerializer.parse(json["pagination_meta"]),
    };
  },

  serialize(value: ProductFamilyListResponse): any {
    return {
      ...extraProperties(value, ["data", "paginationMeta"]),
      data: value.data.map((item: any) => ProductFamilySerializer.serialize(item)),
      pagination_meta: PaginationResponseSerializer.serialize(value.paginationMeta),
    };
  },
};
