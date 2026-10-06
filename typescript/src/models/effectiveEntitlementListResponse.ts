// this file is @generated
import { extraProperties } from "../json.js";
import {
  type EffectiveEntitlement,
  EffectiveEntitlementSerializer,
} from "./effectiveEntitlement.js";

export interface EffectiveEntitlementListResponse {
  data: EffectiveEntitlement[];
}

/** Converts `EffectiveEntitlementListResponse` values from (`parse`) and to (`serialize`) their JSON form. */
export const EffectiveEntitlementListResponseSerializer = {
  parse(json: any): EffectiveEntitlementListResponse {
    return {
      ...extraProperties(json, ["data"]),
      data: json["data"].map((item: any) => EffectiveEntitlementSerializer.parse(item)),
    };
  },

  serialize(value: EffectiveEntitlementListResponse): any {
    return {
      ...extraProperties(value, ["data"]),
      data: value.data.map((item: any) => EffectiveEntitlementSerializer.serialize(item)),
    };
  },
};
