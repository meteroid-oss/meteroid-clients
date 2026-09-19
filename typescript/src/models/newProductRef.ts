// this file is @generated
import {
  type ProductFeeStructure,
  ProductFeeStructureSerializer,
} from "./productFeeStructure";
import {
  type ProductFeeTypeEnum,
  ProductFeeTypeEnumSerializer,
} from "./productFeeTypeEnum";

export interface NewProductRef {
  feeStructure: ProductFeeStructure;

  feeType: ProductFeeTypeEnum;

  name: string;
}

export const NewProductRefSerializer = {
  _fromJsonObject(object: any): NewProductRef {
    return {
      feeStructure: ProductFeeStructureSerializer._fromJsonObject(
        object["fee_structure"]
      ),
      feeType: ProductFeeTypeEnumSerializer._fromJsonObject(object["fee_type"]),
      name: object["name"],
    };
  },

  _toJsonObject(self: NewProductRef): any {
    return {
      fee_structure: ProductFeeStructureSerializer._toJsonObject(self.feeStructure),
      fee_type: ProductFeeTypeEnumSerializer._toJsonObject(self.feeType),
      name: self.name,
    };
  },
};
