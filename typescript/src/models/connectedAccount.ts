// this file is @generated
import { parseDateTime } from "../datetime";
import {
  type ConnectedAccountId,
  ConnectedAccountIdSerializer,
} from "./connectedAccountId";
import { type ConnectionStatus, ConnectionStatusSerializer } from "./connectionStatus";
import { type ConnectionType, ConnectionTypeSerializer } from "./connectionType";
import { type CountryCode, CountryCodeSerializer } from "./countryCode";
import { type CustomerId, CustomerIdSerializer } from "./customerId";
import { type OnboardingMode, OnboardingModeSerializer } from "./onboardingMode";
import { type OrganizationId, OrganizationIdSerializer } from "./organizationId";
import { type TenantId, TenantIdSerializer } from "./tenantId";
/** A connected account (relationship between platform and connected org) */
export interface ConnectedAccount {
  connectedOrganizationId?: OrganizationId | null;

  connectedTenantId?: TenantId | null;

  connectionType: ConnectionType;

  createdAt: Date;

  id: ConnectedAccountId;

  metadata?: any;

  onboardingCompletedAt?: Date | null;

  onboardingMode: OnboardingMode;

  pendingCountry?: CountryCode | null;

  /** Email of the user being invited (express flow only) */
  pendingEmail?: string | null;

  /** Name of the organization to be created (express flow only) */
  pendingOrganizationName?: string | null;

  platformCustomerId?: CustomerId | null;

  platformOrganizationId: OrganizationId;

  revokedAt?: Date | null;

  status: ConnectionStatus;
}

export const ConnectedAccountSerializer = {
  _fromJsonObject(object: any): ConnectedAccount {
    return {
      connectedOrganizationId:
        object["connected_organization_id"] != null
          ? OrganizationIdSerializer._fromJsonObject(object["connected_organization_id"])
          : undefined,
      connectedTenantId:
        object["connected_tenant_id"] != null
          ? TenantIdSerializer._fromJsonObject(object["connected_tenant_id"])
          : undefined,
      connectionType: ConnectionTypeSerializer._fromJsonObject(object["connection_type"]),
      createdAt: parseDateTime(object["created_at"]),
      id: ConnectedAccountIdSerializer._fromJsonObject(object["id"]),
      metadata: object["metadata"],
      onboardingCompletedAt:
        object["onboarding_completed_at"] != null
          ? parseDateTime(object["onboarding_completed_at"])
          : undefined,
      onboardingMode: OnboardingModeSerializer._fromJsonObject(object["onboarding_mode"]),
      pendingCountry:
        object["pending_country"] != null
          ? CountryCodeSerializer._fromJsonObject(object["pending_country"])
          : undefined,
      pendingEmail: object["pending_email"],
      pendingOrganizationName: object["pending_organization_name"],
      platformCustomerId:
        object["platform_customer_id"] != null
          ? CustomerIdSerializer._fromJsonObject(object["platform_customer_id"])
          : undefined,
      platformOrganizationId: OrganizationIdSerializer._fromJsonObject(
        object["platform_organization_id"]
      ),
      revokedAt:
        object["revoked_at"] != null ? parseDateTime(object["revoked_at"]) : undefined,
      status: ConnectionStatusSerializer._fromJsonObject(object["status"]),
    };
  },

  _toJsonObject(self: ConnectedAccount): any {
    return {
      connected_organization_id:
        self.connectedOrganizationId != null
          ? OrganizationIdSerializer._toJsonObject(self.connectedOrganizationId)
          : undefined,
      connected_tenant_id:
        self.connectedTenantId != null
          ? TenantIdSerializer._toJsonObject(self.connectedTenantId)
          : undefined,
      connection_type: ConnectionTypeSerializer._toJsonObject(self.connectionType),
      created_at: self.createdAt,
      id: ConnectedAccountIdSerializer._toJsonObject(self.id),
      metadata: self.metadata,
      onboarding_completed_at: self.onboardingCompletedAt,
      onboarding_mode: OnboardingModeSerializer._toJsonObject(self.onboardingMode),
      pending_country:
        self.pendingCountry != null
          ? CountryCodeSerializer._toJsonObject(self.pendingCountry)
          : undefined,
      pending_email: self.pendingEmail,
      pending_organization_name: self.pendingOrganizationName,
      platform_customer_id:
        self.platformCustomerId != null
          ? CustomerIdSerializer._toJsonObject(self.platformCustomerId)
          : undefined,
      platform_organization_id: OrganizationIdSerializer._toJsonObject(
        self.platformOrganizationId
      ),
      revoked_at: self.revokedAt,
      status: ConnectionStatusSerializer._toJsonObject(self.status),
    };
  },
};
