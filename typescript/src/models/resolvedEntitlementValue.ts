// this file is @generated
import {
  type BooleanResolvedEntitlementValue,
  BooleanResolvedEntitlementValueSerializer,
} from "./booleanResolvedEntitlementValue";
import {
  type ConfigResolvedEntitlementValue,
  ConfigResolvedEntitlementValueSerializer,
} from "./configResolvedEntitlementValue";
import {
  type MeteredResolvedEntitlementValue,
  MeteredResolvedEntitlementValueSerializer,
} from "./meteredResolvedEntitlementValue";

export interface ResolvedEntitlementValueBoolean extends BooleanResolvedEntitlementValue {
  type: "BOOLEAN";
}
export interface ResolvedEntitlementValueMetered extends MeteredResolvedEntitlementValue {
  type: "METERED";
}
export interface ResolvedEntitlementValueConfig extends ConfigResolvedEntitlementValue {
  type: "CONFIG";
}

export type ResolvedEntitlementValue =
  | ResolvedEntitlementValueBoolean
  | ResolvedEntitlementValueMetered
  | ResolvedEntitlementValueConfig;

export const ResolvedEntitlementValueSerializer = {
  _fromJsonObject(object: any): ResolvedEntitlementValue {
    const type = object["type"];

    switch (type) {
      case "BOOLEAN":
        return {
          ...BooleanResolvedEntitlementValueSerializer._fromJsonObject(object),
          type: "BOOLEAN",
        };
      case "METERED":
        return {
          ...MeteredResolvedEntitlementValueSerializer._fromJsonObject(object),
          type: "METERED",
        };
      case "CONFIG":
        return {
          ...ConfigResolvedEntitlementValueSerializer._fromJsonObject(object),
          type: "CONFIG",
        };
      default:
        throw new Error(`Unexpected type for ResolvedEntitlementValue: ${type}`);
    }
  },

  _toJsonObject(self: ResolvedEntitlementValue): any {
    switch (self.type) {
      case "BOOLEAN":
        return {
          ...BooleanResolvedEntitlementValueSerializer._toJsonObject(self),
          type: "BOOLEAN",
        };
      case "METERED":
        return {
          ...MeteredResolvedEntitlementValueSerializer._toJsonObject(self),
          type: "METERED",
        };
      case "CONFIG":
        return {
          ...ConfigResolvedEntitlementValueSerializer._toJsonObject(self),
          type: "CONFIG",
        };
      default:
        throw new Error(`Unexpected type for ResolvedEntitlementValue`);
    }
  },
};
