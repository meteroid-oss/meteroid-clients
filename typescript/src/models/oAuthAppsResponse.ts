// this file is @generated
import { extraProperties } from "../json.js";
import { type OAuthApp, OAuthAppSerializer } from "./oAuthApp.js";

export interface OAuthAppsResponse {
  data: OAuthApp[];
}

/** Converts `OAuthAppsResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const OAuthAppsResponseSerializer = {
  parse(json: any): OAuthAppsResponse {
    return {
      ...extraProperties(json, ["data"]),
      data: json["data"].map((item: any) => OAuthAppSerializer.parse(item)),
    };
  },

  serialize(value: OAuthAppsResponse): any {
    return {
      ...extraProperties(value, ["data"]),
      data: value.data.map((item: any) => OAuthAppSerializer.serialize(item)),
    };
  },
};
