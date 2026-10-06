// this file is @generated
import {
  type AllComponentsScope,
  AllComponentsScopeSerializer,
} from "./allComponentsScope.js";
import { type ComponentsScope, ComponentsScopeSerializer } from "./componentsScope.js";

export interface MinimumCommitmentInputScopeAllComponents extends AllComponentsScope {
  type: "all_components";
}
export interface MinimumCommitmentInputScopeComponents extends ComponentsScope {
  type: "components";
}

export type MinimumCommitmentInputScope =
  | MinimumCommitmentInputScopeAllComponents
  | MinimumCommitmentInputScopeComponents;

/** Converts `MinimumCommitmentInputScope` values from (`parse`) and to (`serialize`) their JSON form. */
export const MinimumCommitmentInputScopeSerializer = {
  parse(json: any): MinimumCommitmentInputScope {
    switch (json["type"]) {
      case "all_components":
        return {
          ...AllComponentsScopeSerializer.parse(json),
          type: "all_components",
        };
      case "components":
        return {
          ...ComponentsScopeSerializer.parse(json),
          type: "components",
        };
      default:
        // A variant added to the API after this SDK was generated, kept as received.
        return json;
    }
  },

  serialize(value: MinimumCommitmentInputScope): any {
    switch (value.type) {
      case "all_components":
        return {
          ...AllComponentsScopeSerializer.serialize(value),
          type: "all_components",
        };
      case "components":
        return {
          ...ComponentsScopeSerializer.serialize(value),
          type: "components",
        };
      default:
        return value;
    }
  },
};
