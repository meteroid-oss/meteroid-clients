// this file is @generated
import { extraProperties } from "../json.js";
import { type ConfigValueType, ConfigValueTypeSerializer } from "./configValueType.js";
/** A static, typed configuration value. No metric — resolved synchronously. */
export interface ConfigFeatureType {
  /** Allowed values when `value_type = SELECT`. Empty otherwise. */
  options?: string[] | undefined;
  /** The feature's value type, fixed at creation. */
  valueType: ConfigValueType;
}

/** Converts `ConfigFeatureType` values from (`parse`) and to (`serialize`) their JSON form. */
export const ConfigFeatureTypeSerializer = {
  parse(json: any): ConfigFeatureType {
    return {
      ...extraProperties(json, ["options", "value_type"]),
      options: json["options"],
      valueType: ConfigValueTypeSerializer.parse(json["value_type"]),
    };
  },

  serialize(value: ConfigFeatureType): any {
    return {
      ...extraProperties(value, ["options", "valueType"]),
      options: value.options,
      value_type: ConfigValueTypeSerializer.serialize(value.valueType),
    };
  },
};
