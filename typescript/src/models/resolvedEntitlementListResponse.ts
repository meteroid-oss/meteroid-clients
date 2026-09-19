// this file is @generated
import {
  type ResolvedEntitlement,
  ResolvedEntitlementSerializer,
} from "./resolvedEntitlement";

export interface ResolvedEntitlementListResponse {
  data: ResolvedEntitlement[];
}

export const ResolvedEntitlementListResponseSerializer = {
  _fromJsonObject(object: any): ResolvedEntitlementListResponse {
    return {
      data: object["data"].map((item: any) =>
        ResolvedEntitlementSerializer._fromJsonObject(item)
      ),
    };
  },

  _toJsonObject(self: ResolvedEntitlementListResponse): any {
    return {
      data: self.data.map((item: any) =>
        ResolvedEntitlementSerializer._toJsonObject(item)
      ),
    };
  },
};
