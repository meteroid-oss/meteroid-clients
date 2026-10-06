// this file is @generated
import {
  type AllComponentsScope,
  AllComponentsScopeSerializer,
} from "./allComponentsScope.js";
import { type ProductsScope, ProductsScopeSerializer } from "./productsScope.js";

export interface MinimumCommitmentScopeAllComponents extends AllComponentsScope {
  type: "all_components";
}
export interface MinimumCommitmentScopeProducts extends ProductsScope {
  type: "products";
}

export type MinimumCommitmentScope =
  | MinimumCommitmentScopeAllComponents
  | MinimumCommitmentScopeProducts;

/** Converts `MinimumCommitmentScope` values from (`parse`) and to (`serialize`) their JSON form. */
export const MinimumCommitmentScopeSerializer = {
  parse(json: any): MinimumCommitmentScope {
    switch (json["type"]) {
      case "all_components":
        return {
          ...AllComponentsScopeSerializer.parse(json),
          type: "all_components",
        };
      case "products":
        return {
          ...ProductsScopeSerializer.parse(json),
          type: "products",
        };
      default:
        // A variant added to the API after this SDK was generated, kept as received.
        return json;
    }
  },

  serialize(value: MinimumCommitmentScope): any {
    switch (value.type) {
      case "all_components":
        return {
          ...AllComponentsScopeSerializer.serialize(value),
          type: "all_components",
        };
      case "products":
        return {
          ...ProductsScopeSerializer.serialize(value),
          type: "products",
        };
      default:
        return value;
    }
  },
};
