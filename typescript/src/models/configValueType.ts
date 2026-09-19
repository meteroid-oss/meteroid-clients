// this file is @generated
/** Authoritative value type of a Config feature. `MAP`/`JSON` both carry a JSON value. */
export enum ConfigValueType {
  Number = "NUMBER",
  Boolean = "BOOLEAN",
  Text = "TEXT",
  Map = "MAP",
  Json = "JSON",
  Select = "SELECT",
}

export const ConfigValueTypeSerializer = {
  _fromJsonObject(object: any): ConfigValueType {
    return object;
  },

  _toJsonObject(self: ConfigValueType): any {
    return self;
  },
};
