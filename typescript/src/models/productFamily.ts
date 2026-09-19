// this file is @generated
import { type ProductFamilyId, ProductFamilyIdSerializer } from "./productFamilyId";

export interface ProductFamily {
  id: ProductFamilyId;

  name: string;
}

export const ProductFamilySerializer = {
  _fromJsonObject(object: any): ProductFamily {
    return {
      id: ProductFamilyIdSerializer._fromJsonObject(object["id"]),
      name: object["name"],
    };
  },

  _toJsonObject(self: ProductFamily): any {
    return {
      id: ProductFamilyIdSerializer._toJsonObject(self.id),
      name: self.name,
    };
  },
};
