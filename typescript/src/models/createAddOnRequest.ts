// this file is @generated
import { type PriceId, PriceIdSerializer } from "./priceId";
import { type ProductId, ProductIdSerializer } from "./productId";

export interface CreateAddOnRequest {
  description?: string | null;

  maxInstancesPerSubscription?: number | null;

  name: string;

  priceId: PriceId;

  productId: ProductId;

  selfServiceable?: boolean;
}

export const CreateAddOnRequestSerializer = {
  _fromJsonObject(object: any): CreateAddOnRequest {
    return {
      description: object["description"],
      maxInstancesPerSubscription: object["max_instances_per_subscription"],
      name: object["name"],
      priceId: PriceIdSerializer._fromJsonObject(object["price_id"]),
      productId: ProductIdSerializer._fromJsonObject(object["product_id"]),
      selfServiceable: object["self_serviceable"],
    };
  },

  _toJsonObject(self: CreateAddOnRequest): any {
    return {
      description: self.description,
      max_instances_per_subscription: self.maxInstancesPerSubscription,
      name: self.name,
      price_id: PriceIdSerializer._toJsonObject(self.priceId),
      product_id: ProductIdSerializer._toJsonObject(self.productId),
      self_serviceable: self.selfServiceable,
    };
  },
};
