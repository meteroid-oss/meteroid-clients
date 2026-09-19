// this file is @generated
import {
  type ExistingProductRef,
  ExistingProductRefSerializer,
} from "./existingProductRef";
import { type NewProductRef, NewProductRefSerializer } from "./newProductRef";

export interface ProductRefExisting extends ExistingProductRef {
  type: "EXISTING";
}
export interface ProductRefNew extends NewProductRef {
  type: "NEW";
}

export type ProductRef = ProductRefExisting | ProductRefNew;

export const ProductRefSerializer = {
  _fromJsonObject(object: any): ProductRef {
    const type = object["type"];

    switch (type) {
      case "EXISTING":
        return {
          ...ExistingProductRefSerializer._fromJsonObject(object),
          type: "EXISTING",
        };
      case "NEW":
        return {
          ...NewProductRefSerializer._fromJsonObject(object),
          type: "NEW",
        };
      default:
        throw new Error(`Unexpected type for ProductRef: ${type}`);
    }
  },

  _toJsonObject(self: ProductRef): any {
    switch (self.type) {
      case "EXISTING":
        return {
          ...ExistingProductRefSerializer._toJsonObject(self),
          type: "EXISTING",
        };
      case "NEW":
        return {
          ...NewProductRefSerializer._toJsonObject(self),
          type: "NEW",
        };
      default:
        throw new Error(`Unexpected type for ProductRef`);
    }
  },
};
