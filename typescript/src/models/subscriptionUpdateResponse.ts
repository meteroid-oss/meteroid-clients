// this file is @generated
import {
  type SubscriptionDetails,
  SubscriptionDetailsSerializer,
} from "./subscriptionDetails";

export interface SubscriptionUpdateResponse {
  subscription: SubscriptionDetails;
}

export const SubscriptionUpdateResponseSerializer = {
  _fromJsonObject(object: any): SubscriptionUpdateResponse {
    return {
      subscription: SubscriptionDetailsSerializer._fromJsonObject(object["subscription"]),
    };
  },

  _toJsonObject(self: SubscriptionUpdateResponse): any {
    return {
      subscription: SubscriptionDetailsSerializer._toJsonObject(self.subscription),
    };
  },
};
