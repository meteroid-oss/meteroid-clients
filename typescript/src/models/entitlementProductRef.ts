// this file is @generated
import { type ProductId, ProductIdSerializer } from "./productId";
/** Minimal reference to the product a feature belongs to. */
export interface EntitlementProductRef {
  id: ProductId;

  name: string;
}

export const EntitlementProductRefSerializer = {
  _fromJsonObject(object: any): EntitlementProductRef {
    return {
      id: ProductIdSerializer._fromJsonObject(object["id"]),
      name: object["name"],
    };
  },

  _toJsonObject(self: EntitlementProductRef): any {
    return {
      id: ProductIdSerializer._toJsonObject(self.id),
      name: self.name,
    };
  },
};
