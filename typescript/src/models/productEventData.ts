// this file is @generated
import { parseDateTime } from "../datetime";
import { type ProductFamilyId, ProductFamilyIdSerializer } from "./productFamilyId";
import {
  type ProductFeeTypeEnum,
  ProductFeeTypeEnumSerializer,
} from "./productFeeTypeEnum";
import { type ProductId, ProductIdSerializer } from "./productId";

export interface ProductEventData {
  createdAt: Date;

  description?: string | null;

  feeType: ProductFeeTypeEnum;

  name: string;

  productFamilyId: ProductFamilyId;

  productId: ProductId;
}

export const ProductEventDataSerializer = {
  _fromJsonObject(object: any): ProductEventData {
    return {
      createdAt: parseDateTime(object["created_at"]),
      description: object["description"],
      feeType: ProductFeeTypeEnumSerializer._fromJsonObject(object["fee_type"]),
      name: object["name"],
      productFamilyId: ProductFamilyIdSerializer._fromJsonObject(
        object["product_family_id"]
      ),
      productId: ProductIdSerializer._fromJsonObject(object["product_id"]),
    };
  },

  _toJsonObject(self: ProductEventData): any {
    return {
      created_at: self.createdAt,
      description: self.description,
      fee_type: ProductFeeTypeEnumSerializer._toJsonObject(self.feeType),
      name: self.name,
      product_family_id: ProductFamilyIdSerializer._toJsonObject(self.productFamilyId),
      product_id: ProductIdSerializer._toJsonObject(self.productId),
    };
  },
};
