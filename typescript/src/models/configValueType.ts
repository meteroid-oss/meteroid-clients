// this file is @generated
/** Authoritative value type of a Config feature. `MAP`/`JSON` both carry a JSON value. */
export const ConfigValueType = {
  Number: "NUMBER",
  Boolean: "BOOLEAN",
  Text: "TEXT",
  Map: "MAP",
  Json: "JSON",
  Select: "SELECT",
} as const;
export type ConfigValueType =
  | (typeof ConfigValueType)[keyof typeof ConfigValueType]
  | (string & {});

/** Converts `ConfigValueType` values from (`parse`) and to (`serialize`) their JSON form. */
export const ConfigValueTypeSerializer = {
  parse(json: any): ConfigValueType {
    return json;
  },

  serialize(value: ConfigValueType): any {
    return value;
  },
};
