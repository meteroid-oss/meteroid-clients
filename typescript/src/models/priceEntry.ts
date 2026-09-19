// this file is @generated
import { type ExistingPriceRef, ExistingPriceRefSerializer } from "./existingPriceRef";
import { type PriceInput, PriceInputSerializer } from "./priceInput";

export interface PriceEntryExisting extends ExistingPriceRef {
  type: "EXISTING";
}
export interface PriceEntryNew extends PriceInput {
  type: "NEW";
}

export type PriceEntry = PriceEntryExisting | PriceEntryNew;

export const PriceEntrySerializer = {
  _fromJsonObject(object: any): PriceEntry {
    const type = object["type"];

    switch (type) {
      case "EXISTING":
        return {
          ...ExistingPriceRefSerializer._fromJsonObject(object),
          type: "EXISTING",
        };
      case "NEW":
        return {
          ...PriceInputSerializer._fromJsonObject(object),
          type: "NEW",
        };
      default:
        throw new Error(`Unexpected type for PriceEntry: ${type}`);
    }
  },

  _toJsonObject(self: PriceEntry): any {
    switch (self.type) {
      case "EXISTING":
        return {
          ...ExistingPriceRefSerializer._toJsonObject(self),
          type: "EXISTING",
        };
      case "NEW":
        return {
          ...PriceInputSerializer._toJsonObject(self),
          type: "NEW",
        };
      default:
        throw new Error(`Unexpected type for PriceEntry`);
    }
  },
};
