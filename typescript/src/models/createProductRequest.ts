// this file is @generated
import { type ProductFamilyId, ProductFamilyIdSerializer } from "./productFamilyId";
import {
  type ProductFeeStructure,
  ProductFeeStructureSerializer,
} from "./productFeeStructure";

export interface CreateProductRequest {
  catalog?: boolean;

  description?: string | null;

  feeStructure: ProductFeeStructure;

  name: string;

  productFamilyId: ProductFamilyId;
}

export const CreateProductRequestSerializer = {
  _fromJsonObject(object: any): CreateProductRequest {
    return {
      catalog: object["catalog"],
      description: object["description"],
      feeStructure: ProductFeeStructureSerializer._fromJsonObject(
        object["fee_structure"]
      ),
      name: object["name"],
      productFamilyId: ProductFamilyIdSerializer._fromJsonObject(
        object["product_family_id"]
      ),
    };
  },

  _toJsonObject(self: CreateProductRequest): any {
    return {
      catalog: self.catalog,
      description: self.description,
      fee_structure: ProductFeeStructureSerializer._toJsonObject(self.feeStructure),
      name: self.name,
      product_family_id: ProductFamilyIdSerializer._toJsonObject(self.productFamilyId),
    };
  },
};
