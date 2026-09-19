// this file is @generated
/** Token revocation request */
export interface RevocationRequest {
  /** The token to revoke */
  token: string;

  /** Optional hint about the token type (access_token or refresh_token) */
  tokenTypeHint?: string | null;
}

export const RevocationRequestSerializer = {
  _fromJsonObject(object: any): RevocationRequest {
    return {
      token: object["token"],
      tokenTypeHint: object["token_type_hint"],
    };
  },

  _toJsonObject(self: RevocationRequest): any {
    return {
      token: self.token,
      token_type_hint: self.tokenTypeHint,
    };
  },
};
