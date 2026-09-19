// this file is @generated
import { parseDateTime } from "../datetime";
import { type OAuthAppId, OAuthAppIdSerializer } from "./oAuthAppId";
import { type OrganizationId, OrganizationIdSerializer } from "./organizationId";
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

  updatedAt?: Date | null;
}

export const OAuthAppSerializer = {
  _fromJsonObject(object: any): OAuthApp {
    return {
      clientId: object["client_id"],
      clientSecretHint: object["client_secret_hint"],
      createdAt: parseDateTime(object["created_at"]),
      id: OAuthAppIdSerializer._fromJsonObject(object["id"]),
      isActive: object["is_active"],
      name: object["name"],
      organizationId: OrganizationIdSerializer._fromJsonObject(object["organization_id"]),
      redirectUris: object["redirect_uris"],
      scopes: object["scopes"],
      updatedAt:
        object["updated_at"] != null ? parseDateTime(object["updated_at"]) : undefined,
    };
  },

  _toJsonObject(self: OAuthApp): any {
    return {
      client_id: self.clientId,
      client_secret_hint: self.clientSecretHint,
      created_at: self.createdAt,
      id: OAuthAppIdSerializer._toJsonObject(self.id),
      is_active: self.isActive,
      name: self.name,
      organization_id: OrganizationIdSerializer._toJsonObject(self.organizationId),
      redirect_uris: self.redirectUris,
      scopes: self.scopes,
      updated_at: self.updatedAt,
    };
  },
};
