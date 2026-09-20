// this file is @generated
import { type PriceId, PriceIdSerializer } from "./priceId";

export interface ExistingPriceRef {
  id: PriceId;
}

export const ExistingPriceRefSerializer = {
  _fromJsonObject(object: any): ExistingPriceRef {
    return {
      id: PriceIdSerializer._fromJsonObject(object["id"]),
    };
  },

  _toJsonObject(self: ExistingPriceRef): any {
    return {
      id: PriceIdSerializer._toJsonObject(self.id),
    };
  },
};
