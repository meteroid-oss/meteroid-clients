// this file is @generated
import { extraProperties } from "../json.js";
import { type PriceId, PriceIdSerializer } from "./priceId.js";

export interface UpdateAddOnRequest {
  description?: string | null | undefined;
  maxInstancesPerSubscription?: number | null | undefined;
  name?: string | null | undefined;
  priceId?: PriceId | null | undefined;
  selfServiceable?: boolean | null | undefined;
}

/** Converts `UpdateAddOnRequest` values from (`parse`) and to (`serialize`) their JSON form. */
export const UpdateAddOnRequestSerializer = {
  parse(json: any): UpdateAddOnRequest {
    return {
      ...extraProperties(json, [
        "description",
        "max_instances_per_subscription",
        "name",
        "price_id",
        "self_serviceable",
      ]),
      description: json["description"],
      maxInstancesPerSubscription: json["max_instances_per_subscription"],
      name: json["name"],
      priceId:
        json["price_id"] != null
          ? PriceIdSerializer.parse(json["price_id"])
          : json["price_id"],
      selfServiceable: json["self_serviceable"],
    };
  },

  serialize(value: UpdateAddOnRequest): any {
    return {
      ...extraProperties(value, [
        "description",
        "maxInstancesPerSubscription",
        "name",
        "priceId",
        "selfServiceable",
      ]),
      description: value.description,
      max_instances_per_subscription: value.maxInstancesPerSubscription,
      name: value.name,
      price_id:
        value.priceId != null
          ? PriceIdSerializer.serialize(value.priceId)
          : value.priceId,
      self_serviceable: value.selfServiceable,
    };
  },
};
