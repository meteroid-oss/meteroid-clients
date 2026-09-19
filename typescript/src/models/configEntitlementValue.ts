// this file is @generated
import { type ConfigValue, ConfigValueSerializer } from "./configValue";

export interface ConfigEntitlementValue {
  value: ConfigValue;
}

export const ConfigEntitlementValueSerializer = {
  _fromJsonObject(object: any): ConfigEntitlementValue {
    return {
      value: ConfigValueSerializer._fromJsonObject(object["value"]),
    };
  },

  _toJsonObject(self: ConfigEntitlementValue): any {
    return {
      value: ConfigValueSerializer._toJsonObject(self.value),
    };
  },
};
