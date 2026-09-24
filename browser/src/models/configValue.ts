// this file is @generated
import {
  type BooleanConfigValue,
  BooleanConfigValueSerializer,
} from "./booleanConfigValue";
import { type JsonConfigValue, JsonConfigValueSerializer } from "./jsonConfigValue";
import { type NumberConfigValue, NumberConfigValueSerializer } from "./numberConfigValue";
import { type TextConfigValue, TextConfigValueSerializer } from "./textConfigValue";

export interface ConfigValueNumber extends NumberConfigValue {
  kind: "NUMBER";
}
export interface ConfigValueBoolean extends BooleanConfigValue {
  kind: "BOOLEAN";
}
export interface ConfigValueText extends TextConfigValue {
  kind: "TEXT";
}
export interface ConfigValueJson extends JsonConfigValue {
  kind: "JSON";
}

/**
 * A static, typed configuration value carried by a Config entitlement. Resolved synchronously
 * through the entitlement hierarchy — no metric, no usage counter.
 */
export type ConfigValue =
  | ConfigValueNumber
  | ConfigValueBoolean
  | ConfigValueText
  | ConfigValueJson;

export const ConfigValueSerializer = {
  _fromJsonObject(object: any): ConfigValue {
    const kind = object["kind"];

    switch (kind) {
      case "NUMBER":
        return {
          ...NumberConfigValueSerializer._fromJsonObject(object),
          kind: "NUMBER",
        };
      case "BOOLEAN":
        return {
          ...BooleanConfigValueSerializer._fromJsonObject(object),
          kind: "BOOLEAN",
        };
      case "TEXT":
        return {
          ...TextConfigValueSerializer._fromJsonObject(object),
          kind: "TEXT",
        };
      case "JSON":
        return {
          ...JsonConfigValueSerializer._fromJsonObject(object),
          kind: "JSON",
        };
      default:
        throw new Error(`Unexpected kind for ConfigValue: ${kind}`);
    }
  },

  _toJsonObject(self: ConfigValue): any {
    switch (self.kind) {
      case "NUMBER":
        return {
          ...NumberConfigValueSerializer._toJsonObject(self),
          kind: "NUMBER",
        };
      case "BOOLEAN":
        return {
          ...BooleanConfigValueSerializer._toJsonObject(self),
          kind: "BOOLEAN",
        };
      case "TEXT":
        return {
          ...TextConfigValueSerializer._toJsonObject(self),
          kind: "TEXT",
        };
      case "JSON":
        return {
          ...JsonConfigValueSerializer._toJsonObject(self),
          kind: "JSON",
        };
      default:
        throw new Error(`Unexpected kind for ConfigValue`);
    }
  },
};
