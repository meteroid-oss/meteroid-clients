// this file is @generated
import {
  type ClientSubscription,
  ClientSubscriptionSerializer,
} from "./clientSubscription";

export interface ClientSubscriptionListResponse {
  data: ClientSubscription[];
}

export const ClientSubscriptionListResponseSerializer = {
  _fromJsonObject(object: any): ClientSubscriptionListResponse {
    return {
      data: object["data"].map((item: any) =>
        ClientSubscriptionSerializer._fromJsonObject(item)
      ),
    };
  },

  _toJsonObject(self: ClientSubscriptionListResponse): any {
    return {
      data: self.data.map((item: any) =>
        ClientSubscriptionSerializer._toJsonObject(item)
      ),
    };
  },
};
