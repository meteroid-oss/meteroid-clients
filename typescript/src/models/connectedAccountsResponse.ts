// this file is @generated
import { type ConnectedAccount, ConnectedAccountSerializer } from "./connectedAccount";

export interface ConnectedAccountsResponse {
  data: ConnectedAccount[];
}

export const ConnectedAccountsResponseSerializer = {
  _fromJsonObject(object: any): ConnectedAccountsResponse {
    return {
      data: object["data"].map((item: any) =>
        ConnectedAccountSerializer._fromJsonObject(item)
      ),
    };
  },

  _toJsonObject(self: ConnectedAccountsResponse): any {
    return {
      data: self.data.map((item: any) => ConnectedAccountSerializer._toJsonObject(item)),
    };
  },
};
