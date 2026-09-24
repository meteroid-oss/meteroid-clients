import {
  type EffectiveEntitlement,
  EffectiveEntitlementSerializer,
} from "./effectiveEntitlement";

export interface EffectiveEntitlementListResponse {
  data: EffectiveEntitlement[];
}

export const EffectiveEntitlementListResponseSerializer = {
  _fromJsonObject(object: any): EffectiveEntitlementListResponse {
    return {
      data: object["data"].map((item: any) =>
        EffectiveEntitlementSerializer._fromJsonObject(item)
      ),
    };
  },

  _toJsonObject(self: EffectiveEntitlementListResponse): any {
    return {
      data: self.data.map((item: any) =>
        EffectiveEntitlementSerializer._toJsonObject(item)
      ),
    };
  },
};
