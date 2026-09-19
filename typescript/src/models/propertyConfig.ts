// this file is @generated
import { type SelectOption, SelectOptionSerializer } from "./selectOption";
/** Type-specific configuration. Only the fields relevant to `property_type` are interpreted. */
export interface PropertyConfig {
  max?: number | null;

  /** Maximum length for `TEXT`. */
  maxLength?: number | null;

  /** Inclusive numeric bounds for `NUMBER`. */
  min?: number | null;

  /** Allowed choices for `SINGLE_SELECT` / `MULTI_SELECT`. */
  options?: SelectOption[] | null;
}

export const PropertyConfigSerializer = {
  _fromJsonObject(object: any): PropertyConfig {
    return {
      max: object["max"],
      maxLength: object["max_length"],
      min: object["min"],
      options:
        object["options"] != null
          ? object["options"].map((item: any) =>
              SelectOptionSerializer._fromJsonObject(item)
            )
          : undefined,
    };
  },

  _toJsonObject(self: PropertyConfig): any {
    return {
      max: self.max,
      max_length: self.maxLength,
      min: self.min,
      options:
        self.options != null
          ? self.options.map((item: any) => SelectOptionSerializer._toJsonObject(item))
          : undefined,
    };
  },
};
