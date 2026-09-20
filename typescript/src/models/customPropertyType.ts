// this file is @generated

export enum CustomPropertyType {
  Text = "TEXT",
  Number = "NUMBER",
  Boolean = "BOOLEAN",
  Date = "DATE",
  Datetime = "DATETIME",
  SingleSelect = "SINGLE_SELECT",
  MultiSelect = "MULTI_SELECT",
  Json = "JSON",
  Url = "URL",
  Email = "EMAIL",
}

export const CustomPropertyTypeSerializer = {
  _fromJsonObject(object: any): CustomPropertyType {
    return object;
  },

  _toJsonObject(self: CustomPropertyType): any {
    return self;
  },
};
