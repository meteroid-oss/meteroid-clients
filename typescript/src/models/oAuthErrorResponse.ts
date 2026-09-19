// this file is @generated
import { type OAuthErrorCode, OAuthErrorCodeSerializer } from "./oAuthErrorCode";
/** OAuth 2.0 error response as per RFC 6749 Section 5.2 */
export interface OAuthErrorResponse {
  error: OAuthErrorCode;

  errorDescription?: string | null;

  errorUri?: string | null;
}

export const OAuthErrorResponseSerializer = {
  _fromJsonObject(object: any): OAuthErrorResponse {
    return {
      error: OAuthErrorCodeSerializer._fromJsonObject(object["error"]),
      errorDescription: object["error_description"],
      errorUri: object["error_uri"],
    };
  },

  _toJsonObject(self: OAuthErrorResponse): any {
    return {
      error: OAuthErrorCodeSerializer._toJsonObject(self.error),
      error_description: self.errorDescription,
      error_uri: self.errorUri,
    };
  },
};
