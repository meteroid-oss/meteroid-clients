// this file is @generated
import { type Fee, FeeSerializer } from "./fee";
import { type PriceComponentId, PriceComponentIdSerializer } from "./priceComponentId";
import { type ProductId, ProductIdSerializer } from "./productId";

export interface PriceComponent {
  fee?: Fee | null;

  id: PriceComponentId;

  name: string;

  productId?: ProductId | null;
}

export const PriceComponentSerializer = {
  _fromJsonObject(object: any): PriceComponent {
    return {
      fee:
        object["fee"] != null ? FeeSerializer._fromJsonObject(object["fee"]) : undefined,
      id: PriceComponentIdSerializer._fromJsonObject(object["id"]),
      name: object["name"],
      productId:
        object["product_id"] != null
          ? ProductIdSerializer._fromJsonObject(object["product_id"])
          : undefined,
    };
  },

  _toJsonObject(self: PriceComponent): any {
    return {
      fee: self.fee != null ? FeeSerializer._toJsonObject(self.fee) : undefined,
      id: PriceComponentIdSerializer._toJsonObject(self.id),
      name: self.name,
      product_id:
        self.productId != null
          ? ProductIdSerializer._toJsonObject(self.productId)
          : undefined,
    };
  },
};
