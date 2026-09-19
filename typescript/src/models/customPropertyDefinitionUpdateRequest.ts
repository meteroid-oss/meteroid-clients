// this file is @generated
import { type PropertyConfig, PropertyConfigSerializer } from "./propertyConfig";
/**
 * Update of a definition. `key`, `entity_type` and `property_type` are immutable and cannot be
 * changed here. Any field left absent is unchanged.
 */
export interface CustomPropertyDefinitionUpdateRequest {
  config?: PropertyConfig | null;

  defaultValue?: any;

  description?: string | null;

  displayOrder?: number | null;

  name?: string | null;

  required?: boolean | null;
}

export const CustomPropertyDefinitionUpdateRequestSerializer = {
  _fromJsonObject(object: any): CustomPropertyDefinitionUpdateRequest {
    return {
      config:
        object["config"] != null
          ? PropertyConfigSerializer._fromJsonObject(object["config"])
          : undefined,
      defaultValue: object["default_value"],
      description: object["description"],
      displayOrder: object["display_order"],
      name: object["name"],
      required: object["required"],
    };
  },

  _toJsonObject(self: CustomPropertyDefinitionUpdateRequest): any {
    return {
      config:
        self.config != null
          ? PropertyConfigSerializer._toJsonObject(self.config)
          : undefined,
      default_value: self.defaultValue,
      description: self.description,
      display_order: self.displayOrder,
      name: self.name,
      required: self.required,
    };
  },
};
