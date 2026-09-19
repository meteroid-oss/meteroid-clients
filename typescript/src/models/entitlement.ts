// this file is @generated
import { type EntitlementId, EntitlementIdSerializer } from "./entitlementId";
import { type EntitlementValue, EntitlementValueSerializer } from "./entitlementValue";
import { type FeatureId, FeatureIdSerializer } from "./featureId";
/** A raw entitlement row attached to one entity (feature, plan version, add-on, or subscription). */
export interface Entitlement {
  createdAt: Date;

  featureId: FeatureId;

  id: EntitlementId;

  updatedAt: Date;

  value: EntitlementValue;
}

export const EntitlementSerializer = {
  _fromJsonObject(object: any): Entitlement {
    return {
      createdAt: new Date(object["created_at"]),
      featureId: FeatureIdSerializer._fromJsonObject(object["feature_id"]),
      id: EntitlementIdSerializer._fromJsonObject(object["id"]),
      updatedAt: new Date(object["updated_at"]),
      value: EntitlementValueSerializer._fromJsonObject(object["value"]),
    };
  },

  _toJsonObject(self: Entitlement): any {
    return {
      created_at: self.createdAt,
      feature_id: FeatureIdSerializer._toJsonObject(self.featureId),
      id: EntitlementIdSerializer._toJsonObject(self.id),
      updated_at: self.updatedAt,
      value: EntitlementValueSerializer._toJsonObject(self.value),
    };
  },
};
