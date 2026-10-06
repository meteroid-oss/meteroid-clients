// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import { type Entitlement, EntitlementSerializer } from "./entitlement.js";
import {
  type EntitlementProductRef,
  EntitlementProductRefSerializer,
} from "./entitlementProductRef.js";
import { type FeatureId, FeatureIdSerializer } from "./featureId.js";
import { type FeatureStatus, FeatureStatusSerializer } from "./featureStatus.js";
import { type FeatureType, FeatureTypeSerializer } from "./featureType.js";

export interface Feature {
  /** Unique key used to reference this feature in your code. Cannot be changed after creation. */
  code: string;
  createdAt: Date;
  description?: string | null | undefined;
  entitlement?: Entitlement | null | undefined;
  featureType: FeatureType;
  id: FeatureId;
  name: string;
  product?: EntitlementProductRef | null | undefined;
  status: FeatureStatus;
}

/** Converts `Feature` values from (`parse`) and to (`serialize`) their JSON form. */
export const FeatureSerializer = {
  parse(json: any): Feature {
    return {
      ...extraProperties(json, [
        "code",
        "created_at",
        "description",
        "entitlement",
        "feature_type",
        "id",
        "name",
        "product",
        "status",
      ]),
      code: json["code"],
      createdAt: parseDateTime(json["created_at"]),
      description: json["description"],
      entitlement:
        json["entitlement"] != null
          ? EntitlementSerializer.parse(json["entitlement"])
          : json["entitlement"],
      featureType: FeatureTypeSerializer.parse(json["feature_type"]),
      id: FeatureIdSerializer.parse(json["id"]),
      name: json["name"],
      product:
        json["product"] != null
          ? EntitlementProductRefSerializer.parse(json["product"])
          : json["product"],
      status: FeatureStatusSerializer.parse(json["status"]),
    };
  },

  serialize(value: Feature): any {
    return {
      ...extraProperties(value, [
        "code",
        "createdAt",
        "description",
        "entitlement",
        "featureType",
        "id",
        "name",
        "product",
        "status",
      ]),
      code: value.code,
      created_at: value.createdAt,
      description: value.description,
      entitlement:
        value.entitlement != null
          ? EntitlementSerializer.serialize(value.entitlement)
          : value.entitlement,
      feature_type: FeatureTypeSerializer.serialize(value.featureType),
      id: FeatureIdSerializer.serialize(value.id),
      name: value.name,
      product:
        value.product != null
          ? EntitlementProductRefSerializer.serialize(value.product)
          : value.product,
      status: FeatureStatusSerializer.serialize(value.status),
    };
  },
};
