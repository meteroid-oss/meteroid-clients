// this file is @generated
import { extraProperties } from "../json.js";
import {
  type ResolvedEntitlement,
  ResolvedEntitlementSerializer,
} from "./resolvedEntitlement.js";

export interface ResolvedEntitlementListResponse {
  data: ResolvedEntitlement[];
}

/** Converts `ResolvedEntitlementListResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const ResolvedEntitlementListResponseSerializer = {
  parse(json: any): ResolvedEntitlementListResponse {
    return {
      ...extraProperties(json, ["data"]),
      data: json["data"].map((item: any) => ResolvedEntitlementSerializer.parse(item)),
    };
  },

  serialize(value: ResolvedEntitlementListResponse): any {
    return {
      ...extraProperties(value, ["data"]),
      data: value.data.map((item: any) => ResolvedEntitlementSerializer.serialize(item)),
    };
  },
};
