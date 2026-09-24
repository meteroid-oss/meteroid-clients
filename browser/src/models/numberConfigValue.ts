// this file is @generated
/** A number config value (decimal, encoded as a string). */
export interface NumberConfigValue {
  value: string;
}

export const NumberConfigValueSerializer = {
  _fromJsonObject(object: any): NumberConfigValue {
    return {
      value: object["value"],
    };
  },

  _toJsonObject(self: NumberConfigValue): any {
    return {
      value: self.value,
    };
  },
};
