// this file is @generated
/** A boolean config value. */
export interface BooleanConfigValue {
  value: boolean;
}

export const BooleanConfigValueSerializer = {
  _fromJsonObject(object: any): BooleanConfigValue {
    return {
      value: object["value"],
    };
  },

  _toJsonObject(self: BooleanConfigValue): any {
    return {
      value: self.value,
    };
  },
};
