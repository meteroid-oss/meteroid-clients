// this file is @generated
/** Onboarding mode for connected accounts */
export enum OnboardingMode {
  Express = "express",
  Full = "full",
}

export const OnboardingModeSerializer = {
  _fromJsonObject(object: any): OnboardingMode {
    return object;
  },

  _toJsonObject(self: OnboardingMode): any {
    return self;
  },
};
