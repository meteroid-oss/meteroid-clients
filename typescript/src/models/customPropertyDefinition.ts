// this file is @generated
import {
  type CustomPropertyDefinitionId,
  CustomPropertyDefinitionIdSerializer,
} from "./customPropertyDefinitionId";
import {
  type CustomPropertyEntityType,
  CustomPropertyEntityTypeSerializer,
} from "./customPropertyEntityType";
import {
  type CustomPropertyType,
  CustomPropertyTypeSerializer,
} from "./customPropertyType";
import { type PropertyConfig, PropertyConfigSerializer } from "./propertyConfig";

export interface CustomPropertyDefinition {
  archived: boolean;

  config: PropertyConfig;

  defaultValue?: any;

  description?: string | null;

  displayOrder: number;

  entityType: CustomPropertyEntityType;

  id: CustomPropertyDefinitionId;

  key: string;

  name: string;

  propertyType: CustomPropertyType;

  required: boolean;
}

export const CustomPropertyDefinitionSerializer = {
  _fromJsonObject(object: any): CustomPropertyDefinition {
    return {
      archived: object["archived"],
      config: PropertyConfigSerializer._fromJsonObject(object["config"]),
      defaultValue: object["default_value"],
      description: object["description"],
      displayOrder: object["display_order"],
      entityType: CustomPropertyEntityTypeSerializer._fromJsonObject(
        object["entity_type"]
      ),
      id: CustomPropertyDefinitionIdSerializer._fromJsonObject(object["id"]),
      key: object["key"],
      name: object["name"],
      propertyType: CustomPropertyTypeSerializer._fromJsonObject(object["property_type"]),
      required: object["required"],
    };
  },

  _toJsonObject(self: CustomPropertyDefinition): any {
    return {
      archived: self.archived,
      config: PropertyConfigSerializer._toJsonObject(self.config),
      default_value: self.defaultValue,
      description: self.description,
      display_order: self.displayOrder,
      entity_type: CustomPropertyEntityTypeSerializer._toJsonObject(self.entityType),
      id: CustomPropertyDefinitionIdSerializer._toJsonObject(self.id),
      key: self.key,
      name: self.name,
      property_type: CustomPropertyTypeSerializer._toJsonObject(self.propertyType),
      required: self.required,
    };
  },
};
