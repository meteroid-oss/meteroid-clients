// this file is @generated
/** OAuth 2.0 error codes as per RFC 6749 */
export const OAuthErrorCode = {
  InvalidRequest: "invalid_request",
  UnauthorizedClient: "unauthorized_client",
  AccessDenied: "access_denied",
  UnsupportedResponseType: "unsupported_response_type",
  InvalidScope: "invalid_scope",
  ServerError: "server_error",
  TemporarilyUnavailable: "temporarily_unavailable",
  InvalidGrant: "invalid_grant",
  InvalidClient: "invalid_client",
  UnsupportedGrantType: "unsupported_grant_type",
} as const;
export type OAuthErrorCode =
  | (typeof OAuthErrorCode)[keyof typeof OAuthErrorCode]
  | (string & {});

/** Converts `OAuthErrorCode` values from (`parse`) and to (`serialize`) their JSON form. */
export const OAuthErrorCodeSerializer = {
  parse(json: any): OAuthErrorCode {
    return json;
  },

  serialize(value: OAuthErrorCode): any {
    return value;
  },
};
