// this file is @generated
import { extraProperties } from "../json.js";
import { type AddOn, AddOnSerializer } from "./addOn.js";
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse.js";

export interface AddOnListResponse {
  data: AddOn[];
  paginationMeta: PaginationResponse;
}

/** Converts `AddOnListResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const AddOnListResponseSerializer = {
  parse(json: any): AddOnListResponse {
    return {
      ...extraProperties(json, ["data", "pagination_meta"]),
      data: json["data"].map((item: any) => AddOnSerializer.parse(item)),
      paginationMeta: PaginationResponseSerializer.parse(json["pagination_meta"]),
    };
  },

  serialize(value: AddOnListResponse): any {
    return {
      ...extraProperties(value, ["data", "paginationMeta"]),
      data: value.data.map((item: any) => AddOnSerializer.serialize(item)),
      pagination_meta: PaginationResponseSerializer.serialize(value.paginationMeta),
    };
  },
};
