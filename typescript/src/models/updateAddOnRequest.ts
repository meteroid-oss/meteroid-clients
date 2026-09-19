// this file is @generated
import { type PriceId, PriceIdSerializer } from "./priceId";

export interface UpdateAddOnRequest {
  description?: string | null;

  maxInstancesPerSubscription?: number | null;

  name?: string | null;

  priceId?: PriceId | null;

  selfServiceable?: boolean | null;
}

export const UpdateAddOnRequestSerializer = {
  _fromJsonObject(object: any): UpdateAddOnRequest {
    return {
      description: object["description"],
      maxInstancesPerSubscription: object["max_instances_per_subscription"],
      name: object["name"],
      priceId:
        object["price_id"] != null
          ? PriceIdSerializer._fromJsonObject(object["price_id"])
          : undefined,
      selfServiceable: object["self_serviceable"],
    };
  },

  _toJsonObject(self: UpdateAddOnRequest): any {
    return {
      description: self.description,
      max_instances_per_subscription: self.maxInstancesPerSubscription,
      name: self.name,
      price_id:
        self.priceId != null ? PriceIdSerializer._toJsonObject(self.priceId) : undefined,
      self_serviceable: self.selfServiceable,
    };
  },
};
