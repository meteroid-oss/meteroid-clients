// this file is @generated
/** Type of connection between platform and connected account */
export const ConnectionType = {
  Standard: "standard",
  Express: "express",
} as const;
export type ConnectionType =
  | (typeof ConnectionType)[keyof typeof ConnectionType]
  | (string & {});

/** Converts `ConnectionType` values from (`parse`) and to (`serialize`) their JSON form. */
export const ConnectionTypeSerializer = {
  parse(json: any): ConnectionType {
    return json;
  },

  serialize(value: ConnectionType): any {
    return value;
  },
};
