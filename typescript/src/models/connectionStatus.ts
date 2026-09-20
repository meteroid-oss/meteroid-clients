// this file is @generated
/** Status of a connected account */
export enum ConnectionStatus {
  Pending = "pending",
  Active = "active",
  Revoked = "revoked",
  Suspended = "suspended",
}

export const ConnectionStatusSerializer = {
  _fromJsonObject(object: any): ConnectionStatus {
    return object;
  },

  _toJsonObject(self: ConnectionStatus): any {
    return self;
  },
};
