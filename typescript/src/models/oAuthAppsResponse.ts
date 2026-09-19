// this file is @generated
import { type OAuthApp, OAuthAppSerializer } from "./oAuthApp";

export interface OAuthAppsResponse {
  data: OAuthApp[];
}

export const OAuthAppsResponseSerializer = {
  _fromJsonObject(object: any): OAuthAppsResponse {
    return {
      data: object["data"].map((item: any) => OAuthAppSerializer._fromJsonObject(item)),
    };
  },

  _toJsonObject(self: OAuthAppsResponse): any {
    return {
      data: self.data.map((item: any) => OAuthAppSerializer._toJsonObject(item)),
    };
  },
};
