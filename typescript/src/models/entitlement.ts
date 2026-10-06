// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import { type EntitlementId, EntitlementIdSerializer } from "./entitlementId.js";
import { type EntitlementValue, EntitlementValueSerializer } from "./entitlementValue.js";
import { type FeatureId, FeatureIdSerializer } from "./featureId.js";
/** A raw entitlement row attached to one entity (feature, plan version, add-on, or subscription). */
export interface Entitlement {
  createdAt: Date;
  featureId: FeatureId;
  id: EntitlementId;
  updatedAt: Date;
  value: EntitlementValue;
}

/** Converts `Entitlement` values from (`parse`) and to (`serialize`) their JSON form. */
export const EntitlementSerializer = {
  parse(json: any): Entitlement {
    return {
      ...extraProperties(json, ["created_at", "feature_id", "id", "updated_at", "value"]),
      createdAt: parseDateTime(json["created_at"]),
      featureId: FeatureIdSerializer.parse(json["feature_id"]),
      id: EntitlementIdSerializer.parse(json["id"]),
      updatedAt: parseDateTime(json["updated_at"]),
      value: EntitlementValueSerializer.parse(json["value"]),
    };
  },

  serialize(value: Entitlement): any {
    return {
      ...extraProperties(value, ["createdAt", "featureId", "id", "updatedAt", "value"]),
      created_at: value.createdAt,
      feature_id: FeatureIdSerializer.serialize(value.featureId),
      id: EntitlementIdSerializer.serialize(value.id),
      updated_at: value.updatedAt,
      value: EntitlementValueSerializer.serialize(value.value),
    };
  },
};
