// this file is @generated
/** OAuth 2.0 error codes as per RFC 6749 */
export enum OAuthErrorCode {
  InvalidRequest = "invalid_request",
  UnauthorizedClient = "unauthorized_client",
  AccessDenied = "access_denied",
  UnsupportedResponseType = "unsupported_response_type",
  InvalidScope = "invalid_scope",
  ServerError = "server_error",
  TemporarilyUnavailable = "temporarily_unavailable",
  InvalidGrant = "invalid_grant",
  InvalidClient = "invalid_client",
  UnsupportedGrantType = "unsupported_grant_type",
}

export const OAuthErrorCodeSerializer = {
  _fromJsonObject(object: any): OAuthErrorCode {
    return object;
  },

  _toJsonObject(self: OAuthErrorCode): any {
    return self;
  },
};
