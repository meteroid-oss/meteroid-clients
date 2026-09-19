// this file is @generated

export interface CustomerPortalTokenRequest {
  /**
   * Token lifetime in seconds. Defaults to 86400 (24 hours).
   * Must be between 60 and 2592000 (30 days).
   */
  expiresInSeconds?: number | null;
}

export const CustomerPortalTokenRequestSerializer = {
  _fromJsonObject(object: any): CustomerPortalTokenRequest {
    return {
      expiresInSeconds: object["expires_in_seconds"],
    };
  },

  _toJsonObject(self: CustomerPortalTokenRequest): any {
    return {
      expires_in_seconds: self.expiresInSeconds,
    };
  },
};
