// this file is @generated
import {
  type MinimumCommitmentInputScope,
  MinimumCommitmentInputScopeSerializer,
} from "./minimumCommitmentInputScope";

export interface MinimumCommitmentInput {
  /** Decimal string in the plan currency. */
  amount: string;

  scope: MinimumCommitmentInputScope;
}

export const MinimumCommitmentInputSerializer = {
  _fromJsonObject(object: any): MinimumCommitmentInput {
    return {
      amount: object["amount"],
      scope: MinimumCommitmentInputScopeSerializer._fromJsonObject(object["scope"]),
    };
  },

  _toJsonObject(self: MinimumCommitmentInput): any {
    return {
      amount: self.amount,
      scope: MinimumCommitmentInputScopeSerializer._toJsonObject(self.scope),
    };
  },
};
