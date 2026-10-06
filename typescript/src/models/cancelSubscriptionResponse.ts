// this file is @generated
import { extraProperties } from "../json.js";
import { type Subscription, SubscriptionSerializer } from "./subscription.js";

export interface CancelSubscriptionResponse {
  subscription: Subscription;
}

/** Converts `CancelSubscriptionResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const CancelSubscriptionResponseSerializer = {
  parse(json: any): CancelSubscriptionResponse {
    return {
      ...extraProperties(json, ["subscription"]),
      subscription: SubscriptionSerializer.parse(json["subscription"]),
    };
  },

  serialize(value: CancelSubscriptionResponse): any {
    return {
      ...extraProperties(value, ["subscription"]),
      subscription: SubscriptionSerializer.serialize(value.subscription),
    };
  },
};
