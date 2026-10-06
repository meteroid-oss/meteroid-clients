// this file is @generated
import { extraProperties } from "../json.js";
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse.js";
import { type Product, ProductSerializer } from "./product.js";

export interface ProductListResponse {
  data: Product[];
  paginationMeta: PaginationResponse;
}

/** Converts `ProductListResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const ProductListResponseSerializer = {
  parse(json: any): ProductListResponse {
    return {
      ...extraProperties(json, ["data", "pagination_meta"]),
      data: json["data"].map((item: any) => ProductSerializer.parse(item)),
      paginationMeta: PaginationResponseSerializer.parse(json["pagination_meta"]),
    };
  },

  serialize(value: ProductListResponse): any {
    return {
      ...extraProperties(value, ["data", "paginationMeta"]),
      data: value.data.map((item: any) => ProductSerializer.serialize(item)),
      pagination_meta: PaginationResponseSerializer.serialize(value.paginationMeta),
    };
  },
};
