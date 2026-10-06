// this file is @generated
import { extraProperties } from "../json.js";

export interface CreateOAuthAppRequest {
  name: string;
  redirectUris: string[];
  scopes?: string[] | null | undefined;
}

/** Converts `CreateOAuthAppRequest` values from (`parse`) and to (`serialize`) their JSON form. */
export const CreateOAuthAppRequestSerializer = {
  parse(json: any): CreateOAuthAppRequest {
    return {
      ...extraProperties(json, ["name", "redirect_uris", "scopes"]),
      name: json["name"],
      redirectUris: json["redirect_uris"],
      scopes: json["scopes"],
    };
  },

  serialize(value: CreateOAuthAppRequest): any {
    return {
      ...extraProperties(value, ["name", "redirectUris", "scopes"]),
      name: value.name,
      redirect_uris: value.redirectUris,
      scopes: value.scopes,
    };
  },
};
