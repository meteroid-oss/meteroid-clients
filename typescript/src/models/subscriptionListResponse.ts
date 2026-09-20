// this file is @generated
import {
  type PaginationResponse,
  PaginationResponseSerializer,
} from "./paginationResponse";
import { type Subscription, SubscriptionSerializer } from "./subscription";

export interface SubscriptionListResponse {
  data: Subscription[];

  paginationMeta: PaginationResponse;
}

export const SubscriptionListResponseSerializer = {
  _fromJsonObject(object: any): SubscriptionListResponse {
    return {
      data: object["data"].map((item: any) =>
        SubscriptionSerializer._fromJsonObject(item)
      ),
      paginationMeta: PaginationResponseSerializer._fromJsonObject(
        object["pagination_meta"]
      ),
    };
  },

  _toJsonObject(self: SubscriptionListResponse): any {
    return {
      data: self.data.map((item: any) => SubscriptionSerializer._toJsonObject(item)),
      pagination_meta: PaginationResponseSerializer._toJsonObject(self.paginationMeta),
    };
  },
};
