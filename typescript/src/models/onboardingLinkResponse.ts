// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
/** Result of creating an onboarding link */
export interface OnboardingLinkResponse {
  expiresAt: Date;
  url: string;
}

/** Converts `OnboardingLinkResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const OnboardingLinkResponseSerializer = {
  parse(json: any): OnboardingLinkResponse {
    return {
      ...extraProperties(json, ["expires_at", "url"]),
      expiresAt: parseDateTime(json["expires_at"]),
      url: json["url"],
    };
  },

  serialize(value: OnboardingLinkResponse): any {
    return {
      ...extraProperties(value, ["expiresAt", "url"]),
      expires_at: value.expiresAt,
      url: value.url,
    };
  },
};
