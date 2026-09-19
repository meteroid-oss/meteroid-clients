// this file is @generated
/** Result of creating an onboarding link */
export interface OnboardingLinkResponse {
  expiresAt: Date;

  url: string;
}

export const OnboardingLinkResponseSerializer = {
  _fromJsonObject(object: any): OnboardingLinkResponse {
    return {
      expiresAt: new Date(object["expires_at"]),
      url: object["url"],
    };
  },

  _toJsonObject(self: OnboardingLinkResponse): any {
    return {
      expires_at: self.expiresAt,
      url: self.url,
    };
  },
};
