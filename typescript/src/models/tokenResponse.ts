// this file is @generated
/** Token response as per OAuth 2.0 spec */
export interface TokenResponse {
  accessToken: string;

  expiresIn: number;

  refreshToken?: string | null;

  scope?: string | null;

  tokenType: string;
}

export const TokenResponseSerializer = {
  _fromJsonObject(object: any): TokenResponse {
    return {
      accessToken: object["access_token"],
      expiresIn: object["expires_in"],
      refreshToken: object["refresh_token"],
      scope: object["scope"],
      tokenType: object["token_type"],
    };
  },

  _toJsonObject(self: TokenResponse): any {
    return {
      access_token: self.accessToken,
      expires_in: self.expiresIn,
      refresh_token: self.refreshToken,
      scope: self.scope,
      token_type: self.tokenType,
    };
  },
};
