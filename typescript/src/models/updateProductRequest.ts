// this file is @generated
import { extraProperties } from "../json.js";
import {
  type ProductFeeStructure,
  ProductFeeStructureSerializer,
} from "./productFeeStructure.js";

export interface UpdateProductRequest {
  description?: string | null | undefined;
  feeStructure?: ProductFeeStructure | null | undefined;
  name?: string | null | undefined;
}

/** Converts `UpdateProductRequest` values from (`parse`) and to (`serialize`) their JSON form. */
export const UpdateProductRequestSerializer = {
  parse(json: any): UpdateProductRequest {
    return {
      ...extraProperties(json, ["description", "fee_structure", "name"]),
      description: json["description"],
      feeStructure:
        json["fee_structure"] != null
          ? ProductFeeStructureSerializer.parse(json["fee_structure"])
          : json["fee_structure"],
      name: json["name"],
    };
  },

  serialize(value: UpdateProductRequest): any {
    return {
      ...extraProperties(value, ["description", "feeStructure", "name"]),
      description: value.description,
      fee_structure:
        value.feeStructure != null
          ? ProductFeeStructureSerializer.serialize(value.feeStructure)
          : value.feeStructure,
      name: value.name,
    };
  },
};
