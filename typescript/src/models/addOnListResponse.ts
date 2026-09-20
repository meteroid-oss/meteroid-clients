// this file is @generated
import { type AddOn, AddOnSerializer } from "./addOn";
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse";

export interface AddOnListResponse {
  data: AddOn[];

  paginationMeta: PaginationResponse;
}

export const AddOnListResponseSerializer = {
  _fromJsonObject(object: any): AddOnListResponse {
    return {
      data: object["data"].map((item: any) => AddOnSerializer._fromJsonObject(item)),
      paginationMeta: PaginationResponseSerializer._fromJsonObject(
        object["pagination_meta"]
      ),
    };
  },

  _toJsonObject(self: AddOnListResponse): any {
    return {
      data: self.data.map((item: any) => AddOnSerializer._toJsonObject(item)),
      pagination_meta: PaginationResponseSerializer._toJsonObject(self.paginationMeta),
    };
  },
};
