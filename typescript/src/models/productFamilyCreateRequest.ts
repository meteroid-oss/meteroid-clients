// this file is @generated
import { extraProperties } from "../json.js";

export interface ProductFamilyCreateRequest {
  name: string;
}

/** Converts `ProductFamilyCreateRequest` values from (`parse`) and to (`serialize`) their JSON form. */
export const ProductFamilyCreateRequestSerializer = {
  parse(json: any): ProductFamilyCreateRequest {
    return {
      ...extraProperties(json, ["name"]),
      name: json["name"],
    };
  },

  serialize(value: ProductFamilyCreateRequest): any {
    return {
      ...extraProperties(value, ["name"]),
      name: value.name,
    };
  },
};
