// this file is @generated
import { parseDateTime } from "../datetime.js";
import { extraProperties } from "../json.js";
import { type ProductFamilyId, ProductFamilyIdSerializer } from "./productFamilyId.js";
import {
  type ProductFeeStructure,
  ProductFeeStructureSerializer,
} from "./productFeeStructure.js";
import {
  type ProductFeeTypeEnum,
  ProductFeeTypeEnumSerializer,
} from "./productFeeTypeEnum.js";
import { type ProductId, ProductIdSerializer } from "./productId.js";

export interface Product {
  archivedAt?: Date | null | undefined;
  catalog: boolean;
  createdAt: Date;
  description?: string | null | undefined;
  feeStructure: ProductFeeStructure;
  feeType: ProductFeeTypeEnum;
  id: ProductId;
  name: string;
  productFamilyId: ProductFamilyId;
}

/** Converts `Product` values from (`parse`) and to (`serialize`) their JSON form. */
export const ProductSerializer = {
  parse(json: any): Product {
    return {
      ...extraProperties(json, [
        "archived_at",
        "catalog",
        "created_at",
        "description",
        "fee_structure",
        "fee_type",
        "id",
        "name",
        "product_family_id",
      ]),
      archivedAt:
        json["archived_at"] != null
          ? parseDateTime(json["archived_at"])
          : json["archived_at"],
      catalog: json["catalog"],
      createdAt: parseDateTime(json["created_at"]),
      description: json["description"],
      feeStructure: ProductFeeStructureSerializer.parse(json["fee_structure"]),
      feeType: ProductFeeTypeEnumSerializer.parse(json["fee_type"]),
      id: ProductIdSerializer.parse(json["id"]),
      name: json["name"],
      productFamilyId: ProductFamilyIdSerializer.parse(json["product_family_id"]),
    };
  },

  serialize(value: Product): any {
    return {
      ...extraProperties(value, [
        "archivedAt",
        "catalog",
        "createdAt",
        "description",
        "feeStructure",
        "feeType",
        "id",
        "name",
        "productFamilyId",
      ]),
      archived_at: value.archivedAt,
      catalog: value.catalog,
      created_at: value.createdAt,
      description: value.description,
      fee_structure: ProductFeeStructureSerializer.serialize(value.feeStructure),
      fee_type: ProductFeeTypeEnumSerializer.serialize(value.feeType),
      id: ProductIdSerializer.serialize(value.id),
      name: value.name,
      product_family_id: ProductFamilyIdSerializer.serialize(value.productFamilyId),
    };
  },
};
