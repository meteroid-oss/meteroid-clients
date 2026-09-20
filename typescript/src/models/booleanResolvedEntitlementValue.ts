// this file is @generated

export interface BooleanResolvedEntitlementValue {
  enabled: boolean;
}

export const BooleanResolvedEntitlementValueSerializer = {
  _fromJsonObject(object: any): BooleanResolvedEntitlementValue {
    return {
      enabled: object["enabled"],
    };
  },

  _toJsonObject(self: BooleanResolvedEntitlementValue): any {
    return {
      enabled: self.enabled,
    };
  },
};
