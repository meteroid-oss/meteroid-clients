// this file is @generated
import {
  type BooleanEntitlementValue,
  BooleanEntitlementValueSerializer,
} from "./booleanEntitlementValue";
import {
  type ConfigEntitlementValue,
  ConfigEntitlementValueSerializer,
} from "./configEntitlementValue";
import {
  type MeteredEntitlementValue,
  MeteredEntitlementValueSerializer,
} from "./meteredEntitlementValue";

export interface EntitlementValueBoolean extends BooleanEntitlementValue {
  type: "BOOLEAN";
}
export interface EntitlementValueMetered extends MeteredEntitlementValue {
  type: "METERED";
}
export interface EntitlementValueConfig extends ConfigEntitlementValue {
  type: "CONFIG";
}

export type EntitlementValue =
  | EntitlementValueBoolean
  | EntitlementValueMetered
  | EntitlementValueConfig;

export const EntitlementValueSerializer = {
  _fromJsonObject(object: any): EntitlementValue {
    const type = object["type"];

    switch (type) {
      case "BOOLEAN":
        return {
          ...BooleanEntitlementValueSerializer._fromJsonObject(object),
          type: "BOOLEAN",
        };
      case "METERED":
        return {
          ...MeteredEntitlementValueSerializer._fromJsonObject(object),
          type: "METERED",
        };
      case "CONFIG":
        return {
          ...ConfigEntitlementValueSerializer._fromJsonObject(object),
          type: "CONFIG",
        };
      default:
        throw new Error(`Unexpected type for EntitlementValue: ${type}`);
    }
  },

  _toJsonObject(self: EntitlementValue): any {
    switch (self.type) {
      case "BOOLEAN":
        return {
          ...BooleanEntitlementValueSerializer._toJsonObject(self),
          type: "BOOLEAN",
        };
      case "METERED":
        return {
          ...MeteredEntitlementValueSerializer._toJsonObject(self),
          type: "METERED",
        };
      case "CONFIG":
        return {
          ...ConfigEntitlementValueSerializer._toJsonObject(self),
          type: "CONFIG",
        };
      default:
        throw new Error(`Unexpected type for EntitlementValue`);
    }
  },
};
