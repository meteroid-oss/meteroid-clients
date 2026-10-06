// this file is @generated
import { extraProperties } from "../json.js";
import { type PriceEntry, PriceEntrySerializer } from "./priceEntry.js";

export interface SubscriptionAddOnPriceOverride {
  name?: string | null | undefined;
  priceEntry: PriceEntry;
}

/** Converts `SubscriptionAddOnPriceOverride` values from (`parse`) and to (`serialize`) their JSON form. */
export const SubscriptionAddOnPriceOverrideSerializer = {
  parse(json: any): SubscriptionAddOnPriceOverride {
    return {
      ...extraProperties(json, ["name", "price_entry"]),
      name: json["name"],
      priceEntry: PriceEntrySerializer.parse(json["price_entry"]),
    };
  },

  serialize(value: SubscriptionAddOnPriceOverride): any {
    return {
      ...extraProperties(value, ["name", "priceEntry"]),
      name: value.name,
      price_entry: PriceEntrySerializer.serialize(value.priceEntry),
    };
  },
};
