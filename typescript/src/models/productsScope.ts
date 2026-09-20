// this file is @generated
/**
 * Only lines for the listed products count. A product is the identity shared by plan
 * components, overrides and ad-hoc extras, so a subscription's billed set is matched uniformly.
 */
export interface ProductsScope {
  productIds: string[];
}

export const ProductsScopeSerializer = {
  _fromJsonObject(object: any): ProductsScope {
    return {
      productIds: object["product_ids"],
    };
  },

  _toJsonObject(self: ProductsScope): any {
    return {
      product_ids: self.productIds,
    };
  },
};
