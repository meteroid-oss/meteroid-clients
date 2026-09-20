// this file is @generated

export interface SelectOption {
  label?: string | null;

  value: string;
}

export const SelectOptionSerializer = {
  _fromJsonObject(object: any): SelectOption {
    return {
      label: object["label"],
      value: object["value"],
    };
  },

  _toJsonObject(self: SelectOption): any {
    return {
      label: self.label,
      value: self.value,
    };
  },
};
