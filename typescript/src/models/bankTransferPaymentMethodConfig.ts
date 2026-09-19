// this file is @generated
import { type BankAccountId, BankAccountIdSerializer } from "./bankAccountId";

export interface BankTransferPaymentMethodConfig {
  accountId?: BankAccountId | null;
}

export const BankTransferPaymentMethodConfigSerializer = {
  _fromJsonObject(object: any): BankTransferPaymentMethodConfig {
    return {
      accountId:
        object["account_id"] != null
          ? BankAccountIdSerializer._fromJsonObject(object["account_id"])
          : undefined,
    };
  },

  _toJsonObject(self: BankTransferPaymentMethodConfig): any {
    return {
      account_id:
        self.accountId != null
          ? BankAccountIdSerializer._toJsonObject(self.accountId)
          : undefined,
    };
  },
};
