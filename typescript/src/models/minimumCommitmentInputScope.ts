// this file is @generated
import {
  type AllComponentsScope,
  AllComponentsScopeSerializer,
} from "./allComponentsScope";
import { type ComponentsScope, ComponentsScopeSerializer } from "./componentsScope";

export interface MinimumCommitmentInputScopeAllComponents extends AllComponentsScope {
  type: "all_components";
}
export interface MinimumCommitmentInputScopeComponents extends ComponentsScope {
  type: "components";
}

export type MinimumCommitmentInputScope =
  | MinimumCommitmentInputScopeAllComponents
  | MinimumCommitmentInputScopeComponents;

export const MinimumCommitmentInputScopeSerializer = {
  _fromJsonObject(object: any): MinimumCommitmentInputScope {
    const type = object["type"];

    switch (type) {
      case "all_components":
        return {
          ...AllComponentsScopeSerializer._fromJsonObject(object),
          type: "all_components",
        };
      case "components":
        return {
          ...ComponentsScopeSerializer._fromJsonObject(object),
          type: "components",
        };
      default:
        throw new Error(`Unexpected type for MinimumCommitmentInputScope: ${type}`);
    }
  },

  _toJsonObject(self: MinimumCommitmentInputScope): any {
    switch (self.type) {
      case "all_components":
        return {
          ...AllComponentsScopeSerializer._toJsonObject(self),
          type: "all_components",
        };
      case "components":
        return {
          ...ComponentsScopeSerializer._toJsonObject(self),
          type: "components",
        };
      default:
        throw new Error(`Unexpected type for MinimumCommitmentInputScope`);
    }
  },
};
