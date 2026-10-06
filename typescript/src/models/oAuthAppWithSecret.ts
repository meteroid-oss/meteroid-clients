// this file is @generated
import { extraProperties } from "../json.js";
import { type OAuthApp, OAuthAppSerializer } from "./oAuthApp.js";
/** Result of creating an OAuth app (includes the plain-text secret) */
export interface OAuthAppWithSecret {
  app: OAuthApp;
  clientSecret: string;
}

/** Converts `OAuthAppWithSecret` values from (`parse`) and to (`serialize`) their JSON form. */
export const OAuthAppWithSecretSerializer = {
  parse(json: any): OAuthAppWithSecret {
    return {
      ...extraProperties(json, ["app", "client_secret"]),
      app: OAuthAppSerializer.parse(json["app"]),
      clientSecret: json["client_secret"],
    };
  },

  serialize(value: OAuthAppWithSecret): any {
    return {
      ...extraProperties(value, ["app", "clientSecret"]),
      app: OAuthAppSerializer.serialize(value.app),
      client_secret: value.clientSecret,
    };
  },
};
