// this file is @generated
import { extraProperties } from "../json.js";

export interface PaginationResponse {
  page: number;
  perPage: number;
  totalItems: number;
  totalPages: number;
}

/** Converts `PaginationResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const PaginationResponseSerializer = {
  parse(json: any): PaginationResponse {
    return {
      ...extraProperties(json, ["page", "per_page", "total_items", "total_pages"]),
      page: json["page"],
      perPage: json["per_page"],
      totalItems: json["total_items"],
      totalPages: json["total_pages"],
    };
  },

  serialize(value: PaginationResponse): any {
    return {
      ...extraProperties(value, ["page", "perPage", "totalItems", "totalPages"]),
      page: value.page,
      per_page: value.perPage,
      total_items: value.totalItems,
      total_pages: value.totalPages,
    };
  },
};
