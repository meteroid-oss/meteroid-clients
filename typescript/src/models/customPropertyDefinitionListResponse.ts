// this file is @generated
import {
  type CustomPropertyDefinition,
  CustomPropertyDefinitionSerializer,
} from "./customPropertyDefinition";
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse";

export interface CustomPropertyDefinitionListResponse {
  data: CustomPropertyDefinition[];

  paginationMeta: PaginationResponse;
}

export const CustomPropertyDefinitionListResponseSerializer = {
  _fromJsonObject(object: any): CustomPropertyDefinitionListResponse {
    return {
      data: object["data"].map((item: any) =>
        CustomPropertyDefinitionSerializer._fromJsonObject(item)
      ),
      paginationMeta: PaginationResponseSerializer._fromJsonObject(
        object["pagination_meta"]
      ),
    };
  },

  _toJsonObject(self: CustomPropertyDefinitionListResponse): any {
    return {
      data: self.data.map((item: any) =>
        CustomPropertyDefinitionSerializer._toJsonObject(item)
      ),
      pagination_meta: PaginationResponseSerializer._toJsonObject(self.paginationMeta),
    };
  },
};
