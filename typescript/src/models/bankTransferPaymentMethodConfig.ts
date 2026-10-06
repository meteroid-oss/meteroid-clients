// this file is @generated
import { extraProperties } from "../json.js";
import { type BankAccountId, BankAccountIdSerializer } from "./bankAccountId.js";

export interface BankTransferPaymentMethodConfig {
  accountId?: BankAccountId | null | undefined;
}

/** Converts `BankTransferPaymentMethodConfig` values from (`parse`) and to (`serialize`) their JSON form. */
export const BankTransferPaymentMethodConfigSerializer = {
  parse(json: any): BankTransferPaymentMethodConfig {
    return {
      ...extraProperties(json, ["account_id"]),
      accountId:
        json["account_id"] != null
          ? BankAccountIdSerializer.parse(json["account_id"])
          : json["account_id"],
    };
  },

  serialize(value: BankTransferPaymentMethodConfig): any {
    return {
      ...extraProperties(value, ["accountId"]),
      account_id:
        value.accountId != null
          ? BankAccountIdSerializer.serialize(value.accountId)
          : value.accountId,
    };
  },
};
