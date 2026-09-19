// this file is @generated
import {
  type CustomPropertyEntityType,
  CustomPropertyEntityTypeSerializer,
} from "./customPropertyEntityType";
import {
  type CustomPropertyType,
  CustomPropertyTypeSerializer,
} from "./customPropertyType";
import { type PropertyConfig, PropertyConfigSerializer } from "./propertyConfig";

export interface CustomPropertyDefinitionCreateRequest {
  config?: PropertyConfig;

  defaultValue?: any;

  description?: string | null;

  displayOrder?: number;

  entityType: CustomPropertyEntityType;

  /** Immutable machine name; letters, digits and underscores only. Unique per entity type. */
  key: string;

  name: string;

  propertyType: CustomPropertyType;

  required?: boolean;
}

export const CustomPropertyDefinitionCreateRequestSerializer = {
  _fromJsonObject(object: any): CustomPropertyDefinitionCreateRequest {
    return {
      config:
        object["config"] != null
          ? PropertyConfigSerializer._fromJsonObject(object["config"])
          : undefined,
      defaultValue: object["default_value"],
      description: object["description"],
      displayOrder: object["display_order"],
      entityType: CustomPropertyEntityTypeSerializer._fromJsonObject(
        object["entity_type"]
      ),
      key: object["key"],
      name: object["name"],
      propertyType: CustomPropertyTypeSerializer._fromJsonObject(object["property_type"]),
      required: object["required"],
    };
  },

  _toJsonObject(self: CustomPropertyDefinitionCreateRequest): any {
    return {
      config:
        self.config != null
          ? PropertyConfigSerializer._toJsonObject(self.config)
          : undefined,
      default_value: self.defaultValue,
      description: self.description,
      display_order: self.displayOrder,
      entity_type: CustomPropertyEntityTypeSerializer._toJsonObject(self.entityType),
      key: self.key,
      name: self.name,
      property_type: CustomPropertyTypeSerializer._toJsonObject(self.propertyType),
      required: self.required,
    };
  },
};
