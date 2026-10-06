// this file is @generated
import { extraProperties } from "../json.js";

export interface CustomerPortalTokenRequest {
  /**
   * Token lifetime in seconds. Defaults to 86400 (24 hours).
   * Must be between 60 and 2592000 (30 days).
   */
  expiresInSeconds?: number | null | undefined;
}

/** Converts `CustomerPortalTokenRequest` values from (`parse`) and to (`serialize`) their JSON form. */
export const CustomerPortalTokenRequestSerializer = {
  parse(json: any): CustomerPortalTokenRequest {
    return {
      ...extraProperties(json, ["expires_in_seconds"]),
      expiresInSeconds: json["expires_in_seconds"],
    };
  },

  serialize(value: CustomerPortalTokenRequest): any {
    return {
      ...extraProperties(value, ["expiresInSeconds"]),
      expires_in_seconds: value.expiresInSeconds,
    };
  },
};
