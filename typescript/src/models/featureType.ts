// this file is @generated
import {
  type BooleanFeatureType,
  BooleanFeatureTypeSerializer,
} from "./booleanFeatureType";
import { type ConfigFeatureType, ConfigFeatureTypeSerializer } from "./configFeatureType";
import {
  type MeteredFeatureType,
  MeteredFeatureTypeSerializer,
} from "./meteredFeatureType";

export interface FeatureTypeBoolean extends BooleanFeatureType {
  type: "BOOLEAN";
}
export interface FeatureTypeMetered extends MeteredFeatureType {
  type: "METERED";
}
export interface FeatureTypeConfig extends ConfigFeatureType {
  type: "CONFIG";
}

export type FeatureType = FeatureTypeBoolean | FeatureTypeMetered | FeatureTypeConfig;

export const FeatureTypeSerializer = {
  _fromJsonObject(object: any): FeatureType {
    const type = object["type"];

    switch (type) {
      case "BOOLEAN":
        return {
          ...BooleanFeatureTypeSerializer._fromJsonObject(object),
          type: "BOOLEAN",
        };
      case "METERED":
        return {
          ...MeteredFeatureTypeSerializer._fromJsonObject(object),
          type: "METERED",
        };
      case "CONFIG":
        return {
          ...ConfigFeatureTypeSerializer._fromJsonObject(object),
          type: "CONFIG",
        };
      default:
        throw new Error(`Unexpected type for FeatureType: ${type}`);
    }
  },

  _toJsonObject(self: FeatureType): any {
    switch (self.type) {
      case "BOOLEAN":
        return {
          ...BooleanFeatureTypeSerializer._toJsonObject(self),
          type: "BOOLEAN",
        };
      case "METERED":
        return {
          ...MeteredFeatureTypeSerializer._toJsonObject(self),
          type: "METERED",
        };
      case "CONFIG":
        return {
          ...ConfigFeatureTypeSerializer._toJsonObject(self),
          type: "CONFIG",
        };
      default:
        throw new Error(`Unexpected type for FeatureType`);
    }
  },
};
