// this file is @generated
import { extraProperties } from "../json.js";

export interface SelectOption {
  label?: string | null | undefined;
  value: string;
}

/** Converts `SelectOption` values from (`parse`) and to (`serialize`) their JSON form. */
export const SelectOptionSerializer = {
  parse(json: any): SelectOption {
    return {
      ...extraProperties(json, ["label", "value"]),
      label: json["label"],
      value: json["value"],
    };
  },

  serialize(value: SelectOption): any {
    return {
      ...extraProperties(value, ["label", "value"]),
      label: value.label,
      value: value.value,
    };
  },
};
