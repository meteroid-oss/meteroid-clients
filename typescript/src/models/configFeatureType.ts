// this file is @generated
import { type ConfigValueType, ConfigValueTypeSerializer } from "./configValueType";
/** A static, typed configuration value. No metric — resolved synchronously. */
export interface ConfigFeatureType {
  /** Allowed values when `value_type = SELECT`. Empty otherwise. */
  options?: string[];

  /** The feature's value type, fixed at creation. */
  valueType: ConfigValueType;
}

export const ConfigFeatureTypeSerializer = {
  _fromJsonObject(object: any): ConfigFeatureType {
    return {
      options: object["options"],
      valueType: ConfigValueTypeSerializer._fromJsonObject(object["value_type"]),
    };
  },

  _toJsonObject(self: ConfigFeatureType): any {
    return {
      options: self.options,
      value_type: ConfigValueTypeSerializer._toJsonObject(self.valueType),
    };
  },
};
