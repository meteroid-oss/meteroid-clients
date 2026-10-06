// this file is @generated
import { extraProperties } from "../json.js";
import {
  type CustomPropertyDefinition,
  CustomPropertyDefinitionSerializer,
} from "./customPropertyDefinition.js";
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse.js";

export interface CustomPropertyDefinitionListResponse {
  data: CustomPropertyDefinition[];
  paginationMeta: PaginationResponse;
}

/** Converts `CustomPropertyDefinitionListResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const CustomPropertyDefinitionListResponseSerializer = {
  parse(json: any): CustomPropertyDefinitionListResponse {
    return {
      ...extraProperties(json, ["data", "pagination_meta"]),
      data: json["data"].map((item: any) =>
        CustomPropertyDefinitionSerializer.parse(item)
      ),
      paginationMeta: PaginationResponseSerializer.parse(json["pagination_meta"]),
    };
  },

  serialize(value: CustomPropertyDefinitionListResponse): any {
    return {
      ...extraProperties(value, ["data", "paginationMeta"]),
      data: value.data.map((item: any) =>
        CustomPropertyDefinitionSerializer.serialize(item)
      ),
      pagination_meta: PaginationResponseSerializer.serialize(value.paginationMeta),
    };
  },
};
