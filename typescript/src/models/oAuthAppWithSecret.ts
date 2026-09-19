// this file is @generated
import { type OAuthApp, OAuthAppSerializer } from "./oAuthApp";
/** Result of creating an OAuth app (includes the plain-text secret) */
export interface OAuthAppWithSecret {
  app: OAuthApp;

  clientSecret: string;
}

export const OAuthAppWithSecretSerializer = {
  _fromJsonObject(object: any): OAuthAppWithSecret {
    return {
      app: OAuthAppSerializer._fromJsonObject(object["app"]),
      clientSecret: object["client_secret"],
    };
  },

  _toJsonObject(self: OAuthAppWithSecret): any {
    return {
      app: OAuthAppSerializer._toJsonObject(self.app),
      client_secret: self.clientSecret,
    };
  },
};
