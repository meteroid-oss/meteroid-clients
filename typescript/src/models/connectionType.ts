// this file is @generated
/** Type of connection between platform and connected account */
export enum ConnectionType {
  Standard = "standard",
  Express = "express",
}

export const ConnectionTypeSerializer = {
  _fromJsonObject(object: any): ConnectionType {
    return object;
  },

  _toJsonObject(self: ConnectionType): any {
    return self;
  },
};
