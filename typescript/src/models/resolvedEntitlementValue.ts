// this file is @generated
import {
  type BooleanResolvedEntitlementValue,
  BooleanResolvedEntitlementValueSerializer,
} from "./booleanResolvedEntitlementValue.js";
import {
  type ConfigResolvedEntitlementValue,
  ConfigResolvedEntitlementValueSerializer,
} from "./configResolvedEntitlementValue.js";
import {
  type MeteredResolvedEntitlementValue,
  MeteredResolvedEntitlementValueSerializer,
} from "./meteredResolvedEntitlementValue.js";

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

/** Converts `ResolvedEntitlementValue` values from (`parse`) and to (`serialize`) their JSON form. */
export const ResolvedEntitlementValueSerializer = {
  parse(json: any): ResolvedEntitlementValue {
    switch (json["type"]) {
      case "BOOLEAN":
        return {
          ...BooleanResolvedEntitlementValueSerializer.parse(json),
          type: "BOOLEAN",
        };
      case "METERED":
        return {
          ...MeteredResolvedEntitlementValueSerializer.parse(json),
          type: "METERED",
        };
      case "CONFIG":
        return {
          ...ConfigResolvedEntitlementValueSerializer.parse(json),
          type: "CONFIG",
        };
      default:
        // A variant added to the API after this SDK was generated, kept as received.
        return json;
    }
  },

  serialize(value: ResolvedEntitlementValue): any {
    switch (value.type) {
      case "BOOLEAN":
        return {
          ...BooleanResolvedEntitlementValueSerializer.serialize(value),
          type: "BOOLEAN",
        };
      case "METERED":
        return {
          ...MeteredResolvedEntitlementValueSerializer.serialize(value),
          type: "METERED",
        };
      case "CONFIG":
        return {
          ...ConfigResolvedEntitlementValueSerializer.serialize(value),
          type: "CONFIG",
        };
      default:
        return value;
    }
  },
};
