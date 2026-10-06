// this file is @generated
import { extraProperties } from "../json.js";
import { type Fee, FeeSerializer } from "./fee.js";
import { type PriceComponentId, PriceComponentIdSerializer } from "./priceComponentId.js";
import { type ProductId, ProductIdSerializer } from "./productId.js";

export interface PriceComponent {
  fee?: Fee | null | undefined;
  id: PriceComponentId;
  name: string;
  productId?: ProductId | null | undefined;
}

/** Converts `PriceComponent` values from (`parse`) and to (`serialize`) their JSON form. */
export const PriceComponentSerializer = {
  parse(json: any): PriceComponent {
    return {
      ...extraProperties(json, ["fee", "id", "name", "product_id"]),
      fee: json["fee"] != null ? FeeSerializer.parse(json["fee"]) : json["fee"],
      id: PriceComponentIdSerializer.parse(json["id"]),
      name: json["name"],
      productId:
        json["product_id"] != null
          ? ProductIdSerializer.parse(json["product_id"])
          : json["product_id"],
    };
  },

  serialize(value: PriceComponent): any {
    return {
      ...extraProperties(value, ["fee", "id", "name", "productId"]),
      fee: value.fee != null ? FeeSerializer.serialize(value.fee) : value.fee,
      id: PriceComponentIdSerializer.serialize(value.id),
      name: value.name,
      product_id:
        value.productId != null
          ? ProductIdSerializer.serialize(value.productId)
          : value.productId,
    };
  },
};
