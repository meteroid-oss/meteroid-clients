// this file is @generated
import { extraProperties } from "../json.js";
import {
  type MinimumCommitmentScope,
  MinimumCommitmentScopeSerializer,
} from "./minimumCommitmentScope.js";

export interface MinimumCommitment {
  /** Decimal string in the plan currency, e.g. "100.00". */
  amount: string;
  scope: MinimumCommitmentScope;
}

/** Converts `MinimumCommitment` values from (`parse`) and to (`serialize`) their JSON form. */
export const MinimumCommitmentSerializer = {
  parse(json: any): MinimumCommitment {
    return {
      ...extraProperties(json, ["amount", "scope"]),
      amount: json["amount"],
      scope: MinimumCommitmentScopeSerializer.parse(json["scope"]),
    };
  },

  serialize(value: MinimumCommitment): any {
    return {
      ...extraProperties(value, ["amount", "scope"]),
      amount: value.amount,
      scope: MinimumCommitmentScopeSerializer.serialize(value.scope),
    };
  },
};
