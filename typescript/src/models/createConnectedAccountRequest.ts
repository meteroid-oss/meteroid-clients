// this file is @generated
import { type ConnectionType, ConnectionTypeSerializer } from "./connectionType";
import { type CustomerId, CustomerIdSerializer } from "./customerId";

export interface CreateConnectedAccountRequest {
  connectedOrganizationId: string;

  connectionType?: ConnectionType | null;

  metadata?: unknown;

  platformCustomerId?: CustomerId | null;
}

export const CreateConnectedAccountRequestSerializer = {
  _fromJsonObject(object: any): CreateConnectedAccountRequest {
    return {
      connectedOrganizationId: object["connected_organization_id"],
      connectionType:
        object["connection_type"] != null
          ? ConnectionTypeSerializer._fromJsonObject(object["connection_type"])
          : undefined,
      metadata: object["metadata"],
      platformCustomerId:
        object["platform_customer_id"] != null
          ? CustomerIdSerializer._fromJsonObject(object["platform_customer_id"])
          : undefined,
    };
  },

  _toJsonObject(self: CreateConnectedAccountRequest): any {
    return {
      connected_organization_id: self.connectedOrganizationId,
      connection_type:
        self.connectionType != null
          ? ConnectionTypeSerializer._toJsonObject(self.connectionType)
          : undefined,
      metadata: self.metadata,
      platform_customer_id:
        self.platformCustomerId != null
          ? CustomerIdSerializer._toJsonObject(self.platformCustomerId)
          : undefined,
    };
  },
};
