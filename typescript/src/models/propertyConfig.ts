// this file is @generated
import { extraProperties } from "../json.js";
import { type SelectOption, SelectOptionSerializer } from "./selectOption.js";
/** Type-specific configuration. Only the fields relevant to `property_type` are interpreted. */
export interface PropertyConfig {
  max?: number | null | undefined;
  /** Maximum length for `TEXT`. */
  maxLength?: number | null | undefined;
  /** Inclusive numeric bounds for `NUMBER`. */
  min?: number | null | undefined;
  /** Allowed choices for `SINGLE_SELECT` / `MULTI_SELECT`. */
  options?: SelectOption[] | null | undefined;
}

/** Converts `PropertyConfig` values from (`parse`) and to (`serialize`) their JSON form. */
export const PropertyConfigSerializer = {
  parse(json: any): PropertyConfig {
    return {
      ...extraProperties(json, ["max", "max_length", "min", "options"]),
      max: json["max"],
      maxLength: json["max_length"],
      min: json["min"],
      options:
        json["options"] != null
          ? json["options"].map((item: any) => SelectOptionSerializer.parse(item))
          : json["options"],
    };
  },

  serialize(value: PropertyConfig): any {
    return {
      ...extraProperties(value, ["max", "maxLength", "min", "options"]),
      max: value.max,
      max_length: value.maxLength,
      min: value.min,
      options:
        value.options != null
          ? value.options.map((item: any) => SelectOptionSerializer.serialize(item))
          : value.options,
    };
  },
};
