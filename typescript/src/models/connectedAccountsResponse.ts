// this file is @generated
import { extraProperties } from "../json.js";
import { type ConnectedAccount, ConnectedAccountSerializer } from "./connectedAccount.js";

export interface ConnectedAccountsResponse {
  data: ConnectedAccount[];
}

/** Converts `ConnectedAccountsResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const ConnectedAccountsResponseSerializer = {
  parse(json: any): ConnectedAccountsResponse {
    return {
      ...extraProperties(json, ["data"]),
      data: json["data"].map((item: any) => ConnectedAccountSerializer.parse(item)),
    };
  },

  serialize(value: ConnectedAccountsResponse): any {
    return {
      ...extraProperties(value, ["data"]),
      data: value.data.map((item: any) => ConnectedAccountSerializer.serialize(item)),
    };
  },
};
