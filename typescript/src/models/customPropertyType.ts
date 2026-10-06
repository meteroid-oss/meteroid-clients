// this file is @generated

export const CustomPropertyType = {
  Text: "TEXT",
  Number: "NUMBER",
  Boolean: "BOOLEAN",
  Date: "DATE",
  Datetime: "DATETIME",
  SingleSelect: "SINGLE_SELECT",
  MultiSelect: "MULTI_SELECT",
  Json: "JSON",
  Url: "URL",
  Email: "EMAIL",
} as const;
export type CustomPropertyType =
  | (typeof CustomPropertyType)[keyof typeof CustomPropertyType]
  | (string & {});

/** Converts `CustomPropertyType` values from (`parse`) and to (`serialize`) their JSON form. */
export const CustomPropertyTypeSerializer = {
  parse(json: any): CustomPropertyType {
    return json;
  },

  serialize(value: CustomPropertyType): any {
    return value;
  },
};
