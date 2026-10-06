// this file is @generated
import { extraProperties } from "../json.js";
import {
  type SubscriptionDetails,
  SubscriptionDetailsSerializer,
} from "./subscriptionDetails.js";

export interface SubscriptionUpdateResponse {
  subscription: SubscriptionDetails;
}

/** Converts `SubscriptionUpdateResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const SubscriptionUpdateResponseSerializer = {
  parse(json: any): SubscriptionUpdateResponse {
    return {
      ...extraProperties(json, ["subscription"]),
      subscription: SubscriptionDetailsSerializer.parse(json["subscription"]),
    };
  },

  serialize(value: SubscriptionUpdateResponse): any {
    return {
      ...extraProperties(value, ["subscription"]),
      subscription: SubscriptionDetailsSerializer.serialize(value.subscription),
    };
  },
};
