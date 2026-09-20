// this file is @generated
import { type PriceComponentId, PriceComponentIdSerializer } from "./priceComponentId";
import { type PriceEntry, PriceEntrySerializer } from "./priceEntry";

export interface ComponentOverride {
  componentId: PriceComponentId;

  name: string;

  priceEntry: PriceEntry;
}

export const ComponentOverrideSerializer = {
  _fromJsonObject(object: any): ComponentOverride {
    return {
      componentId: PriceComponentIdSerializer._fromJsonObject(object["component_id"]),
      name: object["name"],
      priceEntry: PriceEntrySerializer._fromJsonObject(object["price_entry"]),
    };
  },

  _toJsonObject(self: ComponentOverride): any {
    return {
      component_id: PriceComponentIdSerializer._toJsonObject(self.componentId),
      name: self.name,
      price_entry: PriceEntrySerializer._toJsonObject(self.priceEntry),
    };
  },
};
