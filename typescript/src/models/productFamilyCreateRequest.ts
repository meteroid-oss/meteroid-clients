// this file is @generated

export interface ProductFamilyCreateRequest {
  name: string;
}

export const ProductFamilyCreateRequestSerializer = {
  _fromJsonObject(object: any): ProductFamilyCreateRequest {
    return {
      name: object["name"],
    };
  },

  _toJsonObject(self: ProductFamilyCreateRequest): any {
    return {
      name: self.name,
    };
  },
};
