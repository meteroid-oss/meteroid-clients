// this file is @generated
import { extraProperties } from "../json.js";
import { type CustomerId, CustomerIdSerializer } from "./customerId.js";
import { type QuoteId, QuoteIdSerializer } from "./quoteId.js";
import { type SubscriptionId, SubscriptionIdSerializer } from "./subscriptionId.js";

export interface QuoteEventData {
  customerId: CustomerId;
  quoteId: QuoteId;
  subscriptionId?: SubscriptionId | null | undefined;
}

/** Converts `QuoteEventData` values from (`parse`) and to (`serialize`) their JSON form. */
export const QuoteEventDataSerializer = {
  parse(json: any): QuoteEventData {
    return {
      ...extraProperties(json, ["customer_id", "quote_id", "subscription_id"]),
      customerId: CustomerIdSerializer.parse(json["customer_id"]),
      quoteId: QuoteIdSerializer.parse(json["quote_id"]),
      subscriptionId:
        json["subscription_id"] != null
          ? SubscriptionIdSerializer.parse(json["subscription_id"])
          : json["subscription_id"],
    };
  },

  serialize(value: QuoteEventData): any {
    return {
      ...extraProperties(value, ["customerId", "quoteId", "subscriptionId"]),
      customer_id: CustomerIdSerializer.serialize(value.customerId),
      quote_id: QuoteIdSerializer.serialize(value.quoteId),
      subscription_id:
        value.subscriptionId != null
          ? SubscriptionIdSerializer.serialize(value.subscriptionId)
          : value.subscriptionId,
    };
  },
};
