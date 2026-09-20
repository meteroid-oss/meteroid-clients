// this file is @generated

export interface CreateOnboardingLinkRequest {
  redirectUrl: string;
}

export const CreateOnboardingLinkRequestSerializer = {
  _fromJsonObject(object: any): CreateOnboardingLinkRequest {
    return {
      redirectUrl: object["redirect_url"],
    };
  },

  _toJsonObject(self: CreateOnboardingLinkRequest): any {
    return {
      redirect_url: self.redirectUrl,
    };
  },
};
