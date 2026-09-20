// this file is @generated
import { type Feature, FeatureSerializer } from "./feature";
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse";

export interface FeatureListResponse {
  data: Feature[];

  paginationMeta: PaginationResponse;
}

export const FeatureListResponseSerializer = {
  _fromJsonObject(object: any): FeatureListResponse {
    return {
      data: object["data"].map((item: any) => FeatureSerializer._fromJsonObject(item)),
      paginationMeta: PaginationResponseSerializer._fromJsonObject(
        object["pagination_meta"]
      ),
    };
  },

  _toJsonObject(self: FeatureListResponse): any {
    return {
      data: self.data.map((item: any) => FeatureSerializer._toJsonObject(item)),
      pagination_meta: PaginationResponseSerializer._toJsonObject(self.paginationMeta),
    };
  },
};
