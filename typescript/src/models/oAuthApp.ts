// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import { type OAuthAppId, OAuthAppIdSerializer } from "./oAuthAppId.js";
import { type OrganizationId, OrganizationIdSerializer } from "./organizationId.js";
/** An OAuth application registered by a platform */
export interface OAuthApp {
  clientId: string;
  clientSecretHint: string;
  createdAt: Date;
  id: OAuthAppId;
  isActive: boolean;
  name: string;
  organizationId: OrganizationId;
  redirectUris: string[];
  scopes: string[];
  updatedAt?: Date | null | undefined;
}

/** Converts `OAuthApp` values from (`parse`) and to (`serialize`) their JSON form. */
export const OAuthAppSerializer = {
  parse(json: any): OAuthApp {
    return {
      ...extraProperties(json, [
        "client_id",
        "client_secret_hint",
        "created_at",
        "id",
        "is_active",
        "name",
        "organization_id",
        "redirect_uris",
        "scopes",
        "updated_at",
      ]),
      clientId: json["client_id"],
      clientSecretHint: json["client_secret_hint"],
      createdAt: parseDateTime(json["created_at"]),
      id: OAuthAppIdSerializer.parse(json["id"]),
      isActive: json["is_active"],
      name: json["name"],
      organizationId: OrganizationIdSerializer.parse(json["organization_id"]),
      redirectUris: json["redirect_uris"],
      scopes: json["scopes"],
      updatedAt:
        json["updated_at"] != null
          ? parseDateTime(json["updated_at"])
          : json["updated_at"],
    };
  },

  serialize(value: OAuthApp): any {
    return {
      ...extraProperties(value, [
        "clientId",
        "clientSecretHint",
        "createdAt",
        "id",
        "isActive",
        "name",
        "organizationId",
        "redirectUris",
        "scopes",
        "updatedAt",
      ]),
      client_id: value.clientId,
      client_secret_hint: value.clientSecretHint,
      created_at: value.createdAt,
      id: OAuthAppIdSerializer.serialize(value.id),
      is_active: value.isActive,
      name: value.name,
      organization_id: OrganizationIdSerializer.serialize(value.organizationId),
      redirect_uris: value.redirectUris,
      scopes: value.scopes,
      updated_at: value.updatedAt,
    };
  },
};
