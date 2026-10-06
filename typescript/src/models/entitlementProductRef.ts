// this file is @generated
import { extraProperties } from "../json.js";
import { type ProductId, ProductIdSerializer } from "./productId.js";
/** Minimal reference to the product a feature belongs to. */
export interface EntitlementProductRef {
  id: ProductId;
  name: string;
}

/** Converts `EntitlementProductRef` values from (`parse`) and to (`serialize`) their JSON form. */
export const EntitlementProductRefSerializer = {
  parse(json: any): EntitlementProductRef {
    return {
      ...extraProperties(json, ["id", "name"]),
      id: ProductIdSerializer.parse(json["id"]),
      name: json["name"],
    };
  },

  serialize(value: EntitlementProductRef): any {
    return {
      ...extraProperties(value, ["id", "name"]),
      id: ProductIdSerializer.serialize(value.id),
      name: value.name,
    };
  },
};
