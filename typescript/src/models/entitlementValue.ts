// this file is @generated
import {
  type BooleanEntitlementValue,
  BooleanEntitlementValueSerializer,
} from "./booleanEntitlementValue.js";
import {
  type ConfigEntitlementValue,
  ConfigEntitlementValueSerializer,
} from "./configEntitlementValue.js";
import {
  type MeteredEntitlementValue,
  MeteredEntitlementValueSerializer,
} from "./meteredEntitlementValue.js";

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

/** Converts `EntitlementValue` values from (`parse`) and to (`serialize`) their JSON form. */
export const EntitlementValueSerializer = {
  parse(json: any): EntitlementValue {
    switch (json["type"]) {
      case "BOOLEAN":
        return {
          ...BooleanEntitlementValueSerializer.parse(json),
          type: "BOOLEAN",
        };
      case "METERED":
        return {
          ...MeteredEntitlementValueSerializer.parse(json),
          type: "METERED",
        };
      case "CONFIG":
        return {
          ...ConfigEntitlementValueSerializer.parse(json),
          type: "CONFIG",
        };
      default:
        // A variant added to the API after this SDK was generated, kept as received.
        return json;
    }
  },

  serialize(value: EntitlementValue): any {
    switch (value.type) {
      case "BOOLEAN":
        return {
          ...BooleanEntitlementValueSerializer.serialize(value),
          type: "BOOLEAN",
        };
      case "METERED":
        return {
          ...MeteredEntitlementValueSerializer.serialize(value),
          type: "METERED",
        };
      case "CONFIG":
        return {
          ...ConfigEntitlementValueSerializer.serialize(value),
          type: "CONFIG",
        };
      default:
        return value;
    }
  },
};
