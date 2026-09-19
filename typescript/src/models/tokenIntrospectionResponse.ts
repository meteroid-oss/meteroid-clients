// this file is @generated
/** Token introspection response as per RFC 7662 */
export interface TokenIntrospectionResponse {
  active: boolean;

  clientId?: string | null;

  exp?: number | null;

  iat?: number | null;

  scope?: string | null;

  sub?: string | null;

  tokenType?: string | null;
}

export const TokenIntrospectionResponseSerializer = {
  _fromJsonObject(object: any): TokenIntrospectionResponse {
    return {
      active: object["active"],
      clientId: object["client_id"],
      exp: object["exp"],
      iat: object["iat"],
      scope: object["scope"],
      sub: object["sub"],
      tokenType: object["token_type"],
    };
  },

  _toJsonObject(self: TokenIntrospectionResponse): any {
    return {
      active: self.active,
      client_id: self.clientId,
      exp: self.exp,
      iat: self.iat,
      scope: self.scope,
      sub: self.sub,
      token_type: self.tokenType,
    };
  },
};
