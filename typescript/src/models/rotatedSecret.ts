// this file is @generated
/** Result of rotating a client secret */
export interface RotatedSecret {
  clientSecret: string;

  clientSecretHint: string;
}

export const RotatedSecretSerializer = {
  _fromJsonObject(object: any): RotatedSecret {
    return {
      clientSecret: object["client_secret"],
      clientSecretHint: object["client_secret_hint"],
    };
  },

  _toJsonObject(self: RotatedSecret): any {
    return {
      client_secret: self.clientSecret,
      client_secret_hint: self.clientSecretHint,
    };
  },
};
