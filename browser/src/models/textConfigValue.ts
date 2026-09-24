// this file is @generated
/** A text config value. */
export interface TextConfigValue {
  value: string;
}

export const TextConfigValueSerializer = {
  _fromJsonObject(object: any): TextConfigValue {
    return {
      value: object["value"],
    };
  },

  _toJsonObject(self: TextConfigValue): any {
    return {
      value: self.value,
    };
  },
};
