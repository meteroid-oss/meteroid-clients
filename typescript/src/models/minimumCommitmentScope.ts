// this file is @generated
import {
  type AllComponentsScope,
  AllComponentsScopeSerializer,
} from "./allComponentsScope";
import { type ProductsScope, ProductsScopeSerializer } from "./productsScope";

export interface MinimumCommitmentScopeAllComponents extends AllComponentsScope {
  type: "all_components";
}
export interface MinimumCommitmentScopeProducts extends ProductsScope {
  type: "products";
}

export type MinimumCommitmentScope =
  | MinimumCommitmentScopeAllComponents
  | MinimumCommitmentScopeProducts;

export const MinimumCommitmentScopeSerializer = {
  _fromJsonObject(object: any): MinimumCommitmentScope {
    const type = object["type"];

    switch (type) {
      case "all_components":
        return {
          ...AllComponentsScopeSerializer._fromJsonObject(object),
          type: "all_components",
        };
      case "products":
        return {
          ...ProductsScopeSerializer._fromJsonObject(object),
          type: "products",
        };
      default:
        throw new Error(`Unexpected type for MinimumCommitmentScope: ${type}`);
    }
  },

  _toJsonObject(self: MinimumCommitmentScope): any {
    switch (self.type) {
      case "all_components":
        return {
          ...AllComponentsScopeSerializer._toJsonObject(self),
          type: "all_components",
        };
      case "products":
        return {
          ...ProductsScopeSerializer._toJsonObject(self),
          type: "products",
        };
      default:
        throw new Error(`Unexpected type for MinimumCommitmentScope`);
    }
  },
};
