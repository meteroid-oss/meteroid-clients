// this file is @generated
import { type ProductFamilyId, ProductFamilyIdSerializer } from "./productFamilyId";
import {
  type ProductFeeStructure,
  ProductFeeStructureSerializer,
} from "./productFeeStructure";
import {
  type ProductFeeTypeEnum,
  ProductFeeTypeEnumSerializer,
} from "./productFeeTypeEnum";
import { type ProductId, ProductIdSerializer } from "./productId";

export interface Product {
  archivedAt?: Date | null;

  catalog: boolean;

  createdAt: Date;

  description?: string | null;

  feeStructure: ProductFeeStructure;

  feeType: ProductFeeTypeEnum;

  id: ProductId;

  name: string;

  productFamilyId: ProductFamilyId;
}

export const ProductSerializer = {
  _fromJsonObject(object: any): Product {
    return {
      archivedAt:
        object["archived_at"] != null ? new Date(object["archived_at"]) : undefined,
      catalog: object["catalog"],
      createdAt: new Date(object["created_at"]),
      description: object["description"],
      feeStructure: ProductFeeStructureSerializer._fromJsonObject(
        object["fee_structure"]
      ),
      feeType: ProductFeeTypeEnumSerializer._fromJsonObject(object["fee_type"]),
      id: ProductIdSerializer._fromJsonObject(object["id"]),
      name: object["name"],
      productFamilyId: ProductFamilyIdSerializer._fromJsonObject(
        object["product_family_id"]
      ),
    };
  },

  _toJsonObject(self: Product): any {
    return {
      archived_at: self.archivedAt,
      catalog: self.catalog,
      created_at: self.createdAt,
      description: self.description,
      fee_structure: ProductFeeStructureSerializer._toJsonObject(self.feeStructure),
      fee_type: ProductFeeTypeEnumSerializer._toJsonObject(self.feeType),
      id: ProductIdSerializer._toJsonObject(self.id),
      name: self.name,
      product_family_id: ProductFamilyIdSerializer._toJsonObject(self.productFamilyId),
    };
  },
};
