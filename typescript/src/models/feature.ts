// this file is @generated
import { type Entitlement, EntitlementSerializer } from "./entitlement";
import {
  type EntitlementProductRef,
  EntitlementProductRefSerializer,
} from "./entitlementProductRef";
import { type FeatureId, FeatureIdSerializer } from "./featureId";
import { type FeatureStatus, FeatureStatusSerializer } from "./featureStatus";
import { type FeatureType, FeatureTypeSerializer } from "./featureType";

export interface Feature {
  /** Unique key used to reference this feature in your code. Cannot be changed after creation. */
  code: string;

  createdAt: Date;

  description?: string | null;

  entitlement?: Entitlement | null;

  featureType: FeatureType;

  id: FeatureId;

  name: string;

  product?: EntitlementProductRef | null;

  status: FeatureStatus;
}

export const FeatureSerializer = {
  _fromJsonObject(object: any): Feature {
    return {
      code: object["code"],
      createdAt: new Date(object["created_at"]),
      description: object["description"],
      entitlement:
        object["entitlement"] != null
          ? EntitlementSerializer._fromJsonObject(object["entitlement"])
          : undefined,
      featureType: FeatureTypeSerializer._fromJsonObject(object["feature_type"]),
      id: FeatureIdSerializer._fromJsonObject(object["id"]),
      name: object["name"],
      product:
        object["product"] != null
          ? EntitlementProductRefSerializer._fromJsonObject(object["product"])
          : undefined,
      status: FeatureStatusSerializer._fromJsonObject(object["status"]),
    };
  },

  _toJsonObject(self: Feature): any {
    return {
      code: self.code,
      created_at: self.createdAt,
      description: self.description,
      entitlement:
        self.entitlement != null
          ? EntitlementSerializer._toJsonObject(self.entitlement)
          : undefined,
      feature_type: FeatureTypeSerializer._toJsonObject(self.featureType),
      id: FeatureIdSerializer._toJsonObject(self.id),
      name: self.name,
      product:
        self.product != null
          ? EntitlementProductRefSerializer._toJsonObject(self.product)
          : undefined,
      status: FeatureStatusSerializer._toJsonObject(self.status),
    };
  },
};
