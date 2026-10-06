// this file is @generated
import { extraProperties } from "../json.js";
import { type ProductFamilyId, ProductFamilyIdSerializer } from "./productFamilyId.js";

export interface ProductFamily {
  id: ProductFamilyId;
  name: string;
}

/** Converts `ProductFamily` values from (`parse`) and to (`serialize`) their JSON form. */
export const ProductFamilySerializer = {
  parse(json: any): ProductFamily {
    return {
      ...extraProperties(json, ["id", "name"]),
      id: ProductFamilyIdSerializer.parse(json["id"]),
      name: json["name"],
    };
  },

  serialize(value: ProductFamily): any {
    return {
      ...extraProperties(value, ["id", "name"]),
      id: ProductFamilyIdSerializer.serialize(value.id),
      name: value.name,
    };
  },
};
