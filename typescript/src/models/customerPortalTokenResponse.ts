// this file is @generated

export interface CustomerPortalTokenResponse {
  /** Base URL of the customer portal */
  portalUrl: string;

  /** JWT token for portal access */
  token: string;
}

export const CustomerPortalTokenResponseSerializer = {
  _fromJsonObject(object: any): CustomerPortalTokenResponse {
    return {
      portalUrl: object["portal_url"],
      token: object["token"],
    };
  },

  _toJsonObject(self: CustomerPortalTokenResponse): any {
    return {
      portal_url: self.portalUrl,
      token: self.token,
    };
  },
};
