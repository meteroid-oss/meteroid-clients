// this file is @generated
import { extraProperties } from "../json.js";
/** Token introspection request */
export interface IntrospectionRequest {
  /** The token to introspect */
  token: string;
}

/** Converts `IntrospectionRequest` values from (`parse`) and to (`serialize`) their JSON form. */
export const IntrospectionRequestSerializer = {
  parse(json: any): IntrospectionRequest {
    return {
      ...extraProperties(json, ["token"]),
      token: json["token"],
    };
  },

  serialize(value: IntrospectionRequest): any {
    return {
      ...extraProperties(value, ["token"]),
      token: value.token,
    };
  },
};
