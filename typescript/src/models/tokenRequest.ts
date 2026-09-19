// this file is @generated
/** Token request (from POST body, application/x-www-form-urlencoded) */
export interface TokenRequest {
  /** Client ID (if not using HTTP Basic auth) */
  clientId?: string | null;

  /** Client secret (if not using HTTP Basic auth) */
  clientSecret?: string | null;

  /** Authorization code (for authorization_code grant) */
  code?: string | null;

  /** PKCE code verifier (for authorization_code grant with PKCE) */
  codeVerifier?: string | null;

  /** Grant type: "authorization_code" or "refresh_token" */
  grantType: string;

  /** Redirect URI (for authorization_code grant, must match the one used in /authorize) */
  redirectUri?: string | null;

  /** Refresh token (for refresh_token grant) */
  refreshToken?: string | null;
}

export const TokenRequestSerializer = {
  _fromJsonObject(object: any): TokenRequest {
    return {
      clientId: object["client_id"],
      clientSecret: object["client_secret"],
      code: object["code"],
      codeVerifier: object["code_verifier"],
      grantType: object["grant_type"],
      redirectUri: object["redirect_uri"],
      refreshToken: object["refresh_token"],
    };
  },

  _toJsonObject(self: TokenRequest): any {
    return {
      client_id: self.clientId,
      client_secret: self.clientSecret,
      code: self.code,
      code_verifier: self.codeVerifier,
      grant_type: self.grantType,
      redirect_uri: self.redirectUri,
      refresh_token: self.refreshToken,
    };
  },
};
