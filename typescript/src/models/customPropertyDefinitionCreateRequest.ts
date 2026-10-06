// this file is @generated
import { extraProperties } from "../json.js";
import {
  type CustomPropertyEntityType,
  CustomPropertyEntityTypeSerializer,
} from "./customPropertyEntityType.js";
import {
  type CustomPropertyType,
  CustomPropertyTypeSerializer,
} from "./customPropertyType.js";
import { type PropertyConfig, PropertyConfigSerializer } from "./propertyConfig.js";

export interface CustomPropertyDefinitionCreateRequest {
  config?: PropertyConfig | undefined;
  defaultValue?: unknown | undefined;
  description?: string | null | undefined;
  displayOrder?: number | undefined;
  entityType: CustomPropertyEntityType;
  /** Immutable machine name; letters, digits and underscores only. Unique per entity type. */
  key: string;
  name: string;
  propertyType: CustomPropertyType;
  required?: boolean | undefined;
}

/** Converts `CustomPropertyDefinitionCreateRequest` values from (`parse`) and to (`serialize`) their JSON form. */
export const CustomPropertyDefinitionCreateRequestSerializer = {
  parse(json: any): CustomPropertyDefinitionCreateRequest {
    return {
      ...extraProperties(json, [
        "config",
        "default_value",
        "description",
        "display_order",
        "entity_type",
        "key",
        "name",
        "property_type",
        "required",
      ]),
      config:
        json["config"] != null
          ? PropertyConfigSerializer.parse(json["config"])
          : undefined,
      defaultValue: json["default_value"],
      description: json["description"],
      displayOrder: json["display_order"],
      entityType: CustomPropertyEntityTypeSerializer.parse(json["entity_type"]),
      key: json["key"],
      name: json["name"],
      propertyType: CustomPropertyTypeSerializer.parse(json["property_type"]),
      required: json["required"],
    };
  },

  serialize(value: CustomPropertyDefinitionCreateRequest): any {
    return {
      ...extraProperties(value, [
        "config",
        "defaultValue",
        "description",
        "displayOrder",
        "entityType",
        "key",
        "name",
        "propertyType",
        "required",
      ]),
      config:
        value.config != null
          ? PropertyConfigSerializer.serialize(value.config)
          : undefined,
      default_value: value.defaultValue,
      description: value.description,
      display_order: value.displayOrder,
      entity_type: CustomPropertyEntityTypeSerializer.serialize(value.entityType),
      key: value.key,
      name: value.name,
      property_type: CustomPropertyTypeSerializer.serialize(value.propertyType),
      required: value.required,
    };
  },
};
