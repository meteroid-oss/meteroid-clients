// this file is @generated
import { type ExistingPriceRef, ExistingPriceRefSerializer } from "./existingPriceRef.js";
import { type PriceInput, PriceInputSerializer } from "./priceInput.js";

export interface PriceEntryExisting extends ExistingPriceRef {
  type: "EXISTING";
}
export interface PriceEntryNew extends PriceInput {
  type: "NEW";
}

export type PriceEntry = PriceEntryExisting | PriceEntryNew;

/** Converts `PriceEntry` values from (`parse`) and to (`serialize`) their JSON form. */
export const PriceEntrySerializer = {
  parse(json: any): PriceEntry {
    switch (json["type"]) {
      case "EXISTING":
        return {
          ...ExistingPriceRefSerializer.parse(json),
          type: "EXISTING",
        };
      case "NEW":
        return {
          ...PriceInputSerializer.parse(json),
          type: "NEW",
        };
      default:
        // A variant added to the API after this SDK was generated, kept as received.
        return json;
    }
  },

  serialize(value: PriceEntry): any {
    switch (value.type) {
      case "EXISTING":
        return {
          ...ExistingPriceRefSerializer.serialize(value),
          type: "EXISTING",
        };
      case "NEW":
        return {
          ...PriceInputSerializer.serialize(value),
          type: "NEW",
        };
      default:
        return value;
    }
  },
};
