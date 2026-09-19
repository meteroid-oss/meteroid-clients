// this file is @generated
import { type ConfigValue, ConfigValueSerializer } from "./configValue";

export interface ConfigResolvedEntitlementValue {
  value: ConfigValue;
}

export const ConfigResolvedEntitlementValueSerializer = {
  _fromJsonObject(object: any): ConfigResolvedEntitlementValue {
    return {
      value: ConfigValueSerializer._fromJsonObject(object["value"]),
    };
  },

  _toJsonObject(self: ConfigResolvedEntitlementValue): any {
    return {
      value: ConfigValueSerializer._toJsonObject(self.value),
    };
  },
};
