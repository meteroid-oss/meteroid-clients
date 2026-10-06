// this file is @generated
import { extraProperties } from "../json.js";
import { type ConnectionType, ConnectionTypeSerializer } from "./connectionType.js";
import { type CustomerId, CustomerIdSerializer } from "./customerId.js";

export interface CreateConnectedAccountRequest {
  connectedOrganizationId: string;
  connectionType?: ConnectionType | null | undefined;
  metadata?: unknown | undefined;
  platformCustomerId?: CustomerId | null | undefined;
}

/** Converts `CreateConnectedAccountRequest` values from (`parse`) and to (`serialize`) their JSON form. */
export const CreateConnectedAccountRequestSerializer = {
  parse(json: any): CreateConnectedAccountRequest {
    return {
      ...extraProperties(json, [
        "connected_organization_id",
        "connection_type",
        "metadata",
        "platform_customer_id",
      ]),
      connectedOrganizationId: json["connected_organization_id"],
      connectionType:
        json["connection_type"] != null
          ? ConnectionTypeSerializer.parse(json["connection_type"])
          : json["connection_type"],
      metadata: json["metadata"],
      platformCustomerId:
        json["platform_customer_id"] != null
          ? CustomerIdSerializer.parse(json["platform_customer_id"])
          : json["platform_customer_id"],
    };
  },

  serialize(value: CreateConnectedAccountRequest): any {
    return {
      ...extraProperties(value, [
        "connectedOrganizationId",
        "connectionType",
        "metadata",
        "platformCustomerId",
      ]),
      connected_organization_id: value.connectedOrganizationId,
      connection_type:
        value.connectionType != null
          ? ConnectionTypeSerializer.serialize(value.connectionType)
          : value.connectionType,
      metadata: value.metadata,
      platform_customer_id:
        value.platformCustomerId != null
          ? CustomerIdSerializer.serialize(value.platformCustomerId)
          : value.platformCustomerId,
    };
  },
};
