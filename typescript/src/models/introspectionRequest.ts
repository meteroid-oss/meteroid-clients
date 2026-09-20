// this file is @generated
/** Token introspection request */
export interface IntrospectionRequest {
  /** The token to introspect */
  token: string;
}

export const IntrospectionRequestSerializer = {
  _fromJsonObject(object: any): IntrospectionRequest {
    return {
      token: object["token"],
    };
  },

  _toJsonObject(self: IntrospectionRequest): any {
    return {
      token: self.token,
    };
  },
};
