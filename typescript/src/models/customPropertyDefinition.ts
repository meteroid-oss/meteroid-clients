// this file is @generated
import { extraProperties } from "../json.js";
import {
  type CustomPropertyDefinitionId,
  CustomPropertyDefinitionIdSerializer,
} from "./customPropertyDefinitionId.js";
import {
  type CustomPropertyEntityType,
  CustomPropertyEntityTypeSerializer,
} from "./customPropertyEntityType.js";
import {
  type CustomPropertyType,
  CustomPropertyTypeSerializer,
} from "./customPropertyType.js";
import { type PropertyConfig, PropertyConfigSerializer } from "./propertyConfig.js";

export interface CustomPropertyDefinition {
  archived: boolean;
  config: PropertyConfig;
  defaultValue?: unknown | undefined;
  description?: string | null | undefined;
  displayOrder: number;
  entityType: CustomPropertyEntityType;
  id: CustomPropertyDefinitionId;
  key: string;
  name: string;
  propertyType: CustomPropertyType;
  required: boolean;
}

/** Converts `CustomPropertyDefinition` values from (`parse`) and to (`serialize`) their JSON form. */
export const CustomPropertyDefinitionSerializer = {
  parse(json: any): CustomPropertyDefinition {
    return {
      ...extraProperties(json, [
        "archived",
        "config",
        "default_value",
        "description",
        "display_order",
        "entity_type",
        "id",
        "key",
        "name",
        "property_type",
        "required",
      ]),
      archived: json["archived"],
      config: PropertyConfigSerializer.parse(json["config"]),
      defaultValue: json["default_value"],
      description: json["description"],
      displayOrder: json["display_order"],
      entityType: CustomPropertyEntityTypeSerializer.parse(json["entity_type"]),
      id: CustomPropertyDefinitionIdSerializer.parse(json["id"]),
      key: json["key"],
      name: json["name"],
      propertyType: CustomPropertyTypeSerializer.parse(json["property_type"]),
      required: json["required"],
    };
  },

  serialize(value: CustomPropertyDefinition): any {
    return {
      ...extraProperties(value, [
        "archived",
        "config",
        "defaultValue",
        "description",
        "displayOrder",
        "entityType",
        "id",
        "key",
        "name",
        "propertyType",
        "required",
      ]),
      archived: value.archived,
      config: PropertyConfigSerializer.serialize(value.config),
      default_value: value.defaultValue,
      description: value.description,
      display_order: value.displayOrder,
      entity_type: CustomPropertyEntityTypeSerializer.serialize(value.entityType),
      id: CustomPropertyDefinitionIdSerializer.serialize(value.id),
      key: value.key,
      name: value.name,
      property_type: CustomPropertyTypeSerializer.serialize(value.propertyType),
      required: value.required,
    };
  },
};
