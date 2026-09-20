// this file is @generated
import { type PriceEntry, PriceEntrySerializer } from "./priceEntry";
import { type ProductRef, ProductRefSerializer } from "./productRef";

export interface ExtraComponent {
  name: string;

  priceEntry: PriceEntry;

  productRef: ProductRef;
}

export const ExtraComponentSerializer = {
  _fromJsonObject(object: any): ExtraComponent {
    return {
      name: object["name"],
      priceEntry: PriceEntrySerializer._fromJsonObject(object["price_entry"]),
      productRef: ProductRefSerializer._fromJsonObject(object["product_ref"]),
    };
  },

  _toJsonObject(self: ExtraComponent): any {
    return {
      name: self.name,
      price_entry: PriceEntrySerializer._toJsonObject(self.priceEntry),
      product_ref: ProductRefSerializer._toJsonObject(self.productRef),
    };
  },
};
