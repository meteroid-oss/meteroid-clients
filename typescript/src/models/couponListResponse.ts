// this file is @generated
import { extraProperties } from "../json.js";
import { type Coupon, CouponSerializer } from "./coupon.js";
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse.js";

export interface CouponListResponse {
  data: Coupon[];
  paginationMeta: PaginationResponse;
}

/** Converts `CouponListResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const CouponListResponseSerializer = {
  parse(json: any): CouponListResponse {
    return {
      ...extraProperties(json, ["data", "pagination_meta"]),
      data: json["data"].map((item: any) => CouponSerializer.parse(item)),
      paginationMeta: PaginationResponseSerializer.parse(json["pagination_meta"]),
    };
  },

  serialize(value: CouponListResponse): any {
    return {
      ...extraProperties(value, ["data", "paginationMeta"]),
      data: value.data.map((item: any) => CouponSerializer.serialize(item)),
      pagination_meta: PaginationResponseSerializer.serialize(value.paginationMeta),
    };
  },
};
