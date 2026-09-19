// this file is @generated
import { type PriceComponentId, PriceComponentIdSerializer } from "./priceComponentId";
import { type ProductId, ProductIdSerializer } from "./productId";
import { type SubscriptionFee, SubscriptionFeeSerializer } from "./subscriptionFee";
import {
  type SubscriptionFeeBillingPeriodEnum,
  SubscriptionFeeBillingPeriodEnumSerializer,
} from "./subscriptionFeeBillingPeriodEnum";

export interface SubscriptionComponent {
  fee: SubscriptionFee;

  name: string;

  period: SubscriptionFeeBillingPeriodEnum;

  priceComponentId?: PriceComponentId | null;

  productId?: ProductId | null;
}

export const SubscriptionComponentSerializer = {
  _fromJsonObject(object: any): SubscriptionComponent {
    return {
      fee: SubscriptionFeeSerializer._fromJsonObject(object["fee"]),
      name: object["name"],
      period: SubscriptionFeeBillingPeriodEnumSerializer._fromJsonObject(
        object["period"]
      ),
      priceComponentId:
        object["price_component_id"] != null
          ? PriceComponentIdSerializer._fromJsonObject(object["price_component_id"])
          : undefined,
      productId:
        object["product_id"] != null
          ? ProductIdSerializer._fromJsonObject(object["product_id"])
          : undefined,
    };
  },

  _toJsonObject(self: SubscriptionComponent): any {
    return {
      fee: SubscriptionFeeSerializer._toJsonObject(self.fee),
      name: self.name,
      period: SubscriptionFeeBillingPeriodEnumSerializer._toJsonObject(self.period),
      price_component_id:
        self.priceComponentId != null
          ? PriceComponentIdSerializer._toJsonObject(self.priceComponentId)
          : undefined,
      product_id:
        self.productId != null
          ? ProductIdSerializer._toJsonObject(self.productId)
          : undefined,
    };
  },
};
