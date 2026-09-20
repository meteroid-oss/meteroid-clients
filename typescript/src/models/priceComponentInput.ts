// this file is @generated
import { type Fee, FeeSerializer } from "./fee";
import { type ProductId, ProductIdSerializer } from "./productId";

export interface PriceComponentInput {
  fee: Fee;

  name: string;

  productId?: ProductId | null;
}

export const PriceComponentInputSerializer = {
  _fromJsonObject(object: any): PriceComponentInput {
    return {
      fee: FeeSerializer._fromJsonObject(object["fee"]),
      name: object["name"],
      productId:
        object["product_id"] != null
          ? ProductIdSerializer._fromJsonObject(object["product_id"])
          : undefined,
    };
  },

  _toJsonObject(self: PriceComponentInput): any {
    return {
      fee: FeeSerializer._toJsonObject(self.fee),
      name: self.name,
      product_id:
        self.productId != null
          ? ProductIdSerializer._toJsonObject(self.productId)
          : undefined,
    };
  },
};
