// this file is @generated
import { parseDateTime } from "../datetime";
import { type AddOnId, AddOnIdSerializer } from "./addOnId";
import { type PriceId, PriceIdSerializer } from "./priceId";
import {
  type ProductFeeTypeEnum,
  ProductFeeTypeEnumSerializer,
} from "./productFeeTypeEnum";
import { type ProductId, ProductIdSerializer } from "./productId";

export interface AddOnEventData {
  addOnId: AddOnId;

  createdAt: Date;

  description?: string | null;

  feeType?: ProductFeeTypeEnum | null;

  maxInstancesPerSubscription?: number | null;

  name: string;

  priceId: PriceId;

  productId: ProductId;

  selfServiceable: boolean;
}

export const AddOnEventDataSerializer = {
  _fromJsonObject(object: any): AddOnEventData {
    return {
      addOnId: AddOnIdSerializer._fromJsonObject(object["add_on_id"]),
      createdAt: parseDateTime(object["created_at"]),
      description: object["description"],
      feeType:
        object["fee_type"] != null
          ? ProductFeeTypeEnumSerializer._fromJsonObject(object["fee_type"])
          : undefined,
      maxInstancesPerSubscription: object["max_instances_per_subscription"],
      name: object["name"],
      priceId: PriceIdSerializer._fromJsonObject(object["price_id"]),
      productId: ProductIdSerializer._fromJsonObject(object["product_id"]),
      selfServiceable: object["self_serviceable"],
    };
  },

  _toJsonObject(self: AddOnEventData): any {
    return {
      add_on_id: AddOnIdSerializer._toJsonObject(self.addOnId),
      created_at: self.createdAt,
      description: self.description,
      fee_type:
        self.feeType != null
          ? ProductFeeTypeEnumSerializer._toJsonObject(self.feeType)
          : undefined,
      max_instances_per_subscription: self.maxInstancesPerSubscription,
      name: self.name,
      price_id: PriceIdSerializer._toJsonObject(self.priceId),
      product_id: ProductIdSerializer._toJsonObject(self.productId),
      self_serviceable: self.selfServiceable,
    };
  },
};
