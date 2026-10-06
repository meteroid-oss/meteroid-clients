// this file is @generated
import { extraProperties } from "../json.js";
import { type Fee, FeeSerializer } from "./fee.js";
import { type ProductId, ProductIdSerializer } from "./productId.js";

export interface PriceComponentInput {
  fee: Fee;
  name: string;
  productId?: ProductId | null | undefined;
}

/** Converts `PriceComponentInput` values from (`parse`) and to (`serialize`) their JSON form. */
export const PriceComponentInputSerializer = {
  parse(json: any): PriceComponentInput {
    return {
      ...extraProperties(json, ["fee", "name", "product_id"]),
      fee: FeeSerializer.parse(json["fee"]),
      name: json["name"],
      productId:
        json["product_id"] != null
          ? ProductIdSerializer.parse(json["product_id"])
          : json["product_id"],
    };
  },

  serialize(value: PriceComponentInput): any {
    return {
      ...extraProperties(value, ["fee", "name", "productId"]),
      fee: FeeSerializer.serialize(value.fee),
      name: value.name,
      product_id:
        value.productId != null
          ? ProductIdSerializer.serialize(value.productId)
          : value.productId,
    };
  },
};
