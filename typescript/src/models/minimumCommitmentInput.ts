// this file is @generated
import { extraProperties } from "../json.js";
import {
  type MinimumCommitmentInputScope,
  MinimumCommitmentInputScopeSerializer,
} from "./minimumCommitmentInputScope.js";

export interface MinimumCommitmentInput {
  /** Decimal string in the plan currency. */
  amount: string;
  scope: MinimumCommitmentInputScope;
}

/** Converts `MinimumCommitmentInput` values from (`parse`) and to (`serialize`) their JSON form. */
export const MinimumCommitmentInputSerializer = {
  parse(json: any): MinimumCommitmentInput {
    return {
      ...extraProperties(json, ["amount", "scope"]),
      amount: json["amount"],
      scope: MinimumCommitmentInputScopeSerializer.parse(json["scope"]),
    };
  },

  serialize(value: MinimumCommitmentInput): any {
    return {
      ...extraProperties(value, ["amount", "scope"]),
      amount: value.amount,
      scope: MinimumCommitmentInputScopeSerializer.serialize(value.scope),
    };
  },
};
