// this file is @generated
import { extraProperties } from "../json.js";

export interface CustomerPortalTokenResponse {
  /** Base URL of the customer portal */
  portalUrl: string;
  /** JWT token for portal access */
  token: string;
}

/** Converts `CustomerPortalTokenResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const CustomerPortalTokenResponseSerializer = {
  parse(json: any): CustomerPortalTokenResponse {
    return {
      ...extraProperties(json, ["portal_url", "token"]),
      portalUrl: json["portal_url"],
      token: json["token"],
    };
  },

  serialize(value: CustomerPortalTokenResponse): any {
    return {
      ...extraProperties(value, ["portalUrl", "token"]),
      portal_url: value.portalUrl,
      token: value.token,
    };
  },
};
