// this file is @generated
/** A structured (JSON) config value — the "metadata" case, several fields in one entitlement. */
export interface JsonConfigValue {
  value: unknown;
}

export const JsonConfigValueSerializer = {
  _fromJsonObject(object: any): JsonConfigValue {
    return {
      value: object["value"],
    };
  },

  _toJsonObject(self: JsonConfigValue): any {
    return {
      value: self.value,
    };
  },
};
