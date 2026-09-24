import {
  type EntitlementProductRef,
  EntitlementProductRefSerializer,
} from "./entitlementProductRef";
import { type FeatureId, FeatureIdSerializer } from "./featureId";

export interface FeatureRef {
  /** Unique key used to reference this feature in your code. Cannot be changed after creation. */
  code: string;

  id: FeatureId;

  name: string;

  product?: EntitlementProductRef | null;
}

export const FeatureRefSerializer = {
  _fromJsonObject(object: any): FeatureRef {
    return {
      code: object["code"],
      id: FeatureIdSerializer._fromJsonObject(object["id"]),
      name: object["name"],
      product:
        object["product"] != null
          ? EntitlementProductRefSerializer._fromJsonObject(object["product"])
          : undefined,
    };
  },

  _toJsonObject(self: FeatureRef): any {
    return {
      code: self.code,
      id: FeatureIdSerializer._toJsonObject(self.id),
      name: self.name,
      product:
        self.product != null
          ? EntitlementProductRefSerializer._toJsonObject(self.product)
          : undefined,
    };
  },
};
