// this file is @generated
import { extraProperties } from "../json.js";

export interface CreateOnboardingLinkRequest {
  redirectUrl: string;
}

/** Converts `CreateOnboardingLinkRequest` values from (`parse`) and to (`serialize`) their JSON form. */
export const CreateOnboardingLinkRequestSerializer = {
  parse(json: any): CreateOnboardingLinkRequest {
    return {
      ...extraProperties(json, ["redirect_url"]),
      redirectUrl: json["redirect_url"],
    };
  },

  serialize(value: CreateOnboardingLinkRequest): any {
    return {
      ...extraProperties(value, ["redirectUrl"]),
      redirect_url: value.redirectUrl,
    };
  },
};
