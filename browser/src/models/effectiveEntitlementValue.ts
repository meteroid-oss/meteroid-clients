// this file is @generated
import {
  type BooleanEffectiveEntitlementValue,
  BooleanEffectiveEntitlementValueSerializer,
} from "./booleanEffectiveEntitlementValue";
import {
  type ConfigEffectiveEntitlementValue,
  ConfigEffectiveEntitlementValueSerializer,
} from "./configEffectiveEntitlementValue";
import {
  type MeteredEffectiveEntitlementValue,
  MeteredEffectiveEntitlementValueSerializer,
} from "./meteredEffectiveEntitlementValue";

export interface EffectiveEntitlementValueBoolean
  extends BooleanEffectiveEntitlementValue {
  type: "BOOLEAN";
}
export interface EffectiveEntitlementValueMetered
  extends MeteredEffectiveEntitlementValue {
  type: "METERED";
}
export interface EffectiveEntitlementValueConfig extends ConfigEffectiveEntitlementValue {
  type: "CONFIG";
}

export type EffectiveEntitlementValue =
  | EffectiveEntitlementValueBoolean
  | EffectiveEntitlementValueMetered
  | EffectiveEntitlementValueConfig;

export const EffectiveEntitlementValueSerializer = {
  _fromJsonObject(object: any): EffectiveEntitlementValue {
    const type = object["type"];

    switch (type) {
      case "BOOLEAN":
        return {
          ...BooleanEffectiveEntitlementValueSerializer._fromJsonObject(object),
          type: "BOOLEAN",
        };
      case "METERED":
        return {
          ...MeteredEffectiveEntitlementValueSerializer._fromJsonObject(object),
          type: "METERED",
        };
      case "CONFIG":
        return {
          ...ConfigEffectiveEntitlementValueSerializer._fromJsonObject(object),
          type: "CONFIG",
        };
      default:
        throw new Error(`Unexpected type for EffectiveEntitlementValue: ${type}`);
    }
  },

  _toJsonObject(self: EffectiveEntitlementValue): any {
    switch (self.type) {
      case "BOOLEAN":
        return {
          ...BooleanEffectiveEntitlementValueSerializer._toJsonObject(self),
          type: "BOOLEAN",
        };
      case "METERED":
        return {
          ...MeteredEffectiveEntitlementValueSerializer._toJsonObject(self),
          type: "METERED",
        };
      case "CONFIG":
        return {
          ...ConfigEffectiveEntitlementValueSerializer._toJsonObject(self),
          type: "CONFIG",
        };
      default:
        throw new Error(`Unexpected type for EffectiveEntitlementValue`);
    }
  },
};
