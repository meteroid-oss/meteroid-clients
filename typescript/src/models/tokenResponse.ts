// this file is @generated
import { extraProperties } from "../json.js";
/** Token response as per OAuth 2.0 spec */
export interface TokenResponse {
  accessToken: string;
  expiresIn: number;
  refreshToken?: string | null | undefined;
  scope?: string | null | undefined;
  tokenType: string;
}

/** Converts `TokenResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const TokenResponseSerializer = {
  parse(json: any): TokenResponse {
    return {
      ...extraProperties(json, [
        "access_token",
        "expires_in",
        "refresh_token",
        "scope",
        "token_type",
      ]),
      accessToken: json["access_token"],
      expiresIn: json["expires_in"],
      refreshToken: json["refresh_token"],
      scope: json["scope"],
      tokenType: json["token_type"],
    };
  },

  serialize(value: TokenResponse): any {
    return {
      ...extraProperties(value, [
        "accessToken",
        "expiresIn",
        "refreshToken",
        "scope",
        "tokenType",
      ]),
      access_token: value.accessToken,
      expires_in: value.expiresIn,
      refresh_token: value.refreshToken,
      scope: value.scope,
      token_type: value.tokenType,
    };
  },
};
