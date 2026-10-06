// this file is @generated
import { extraProperties } from "../json.js";
/** Token request (from POST body, application/x-www-form-urlencoded) */
export interface TokenRequest {
  /** Client ID (if not using HTTP Basic auth) */
  clientId?: string | null | undefined;
  /** Client secret (if not using HTTP Basic auth) */
  clientSecret?: string | null | undefined;
  /** Authorization code (for authorization_code grant) */
  code?: string | null | undefined;
  /** PKCE code verifier (for authorization_code grant with PKCE) */
  codeVerifier?: string | null | undefined;
  /** Grant type: "authorization_code" or "refresh_token" */
  grantType: string;
  /** Redirect URI (for authorization_code grant, must match the one used in /authorize) */
  redirectUri?: string | null | undefined;
  /** Refresh token (for refresh_token grant) */
  refreshToken?: string | null | undefined;
}

/** Converts `TokenRequest` values from (`parse`) and to (`serialize`) their JSON form. */
export const TokenRequestSerializer = {
  parse(json: any): TokenRequest {
    return {
      ...extraProperties(json, [
        "client_id",
        "client_secret",
        "code",
        "code_verifier",
        "grant_type",
        "redirect_uri",
        "refresh_token",
      ]),
      clientId: json["client_id"],
      clientSecret: json["client_secret"],
      code: json["code"],
      codeVerifier: json["code_verifier"],
      grantType: json["grant_type"],
      redirectUri: json["redirect_uri"],
      refreshToken: json["refresh_token"],
    };
  },

  serialize(value: TokenRequest): any {
    return {
      ...extraProperties(value, [
        "clientId",
        "clientSecret",
        "code",
        "codeVerifier",
        "grantType",
        "redirectUri",
        "refreshToken",
      ]),
      client_id: value.clientId,
      client_secret: value.clientSecret,
      code: value.code,
      code_verifier: value.codeVerifier,
      grant_type: value.grantType,
      redirect_uri: value.redirectUri,
      refresh_token: value.refreshToken,
    };
  },
};
