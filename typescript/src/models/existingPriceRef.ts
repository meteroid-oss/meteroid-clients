// this file is @generated
import { extraProperties } from "../json.js";
import { type PriceId, PriceIdSerializer } from "./priceId.js";

export interface ExistingPriceRef {
  id: PriceId;
}

/** Converts `ExistingPriceRef` values from (`parse`) and to (`serialize`) their JSON form. */
export const ExistingPriceRefSerializer = {
  parse(json: any): ExistingPriceRef {
    return {
      ...extraProperties(json, ["id"]),
      id: PriceIdSerializer.parse(json["id"]),
    };
  },

  serialize(value: ExistingPriceRef): any {
    return {
      ...extraProperties(value, ["id"]),
      id: PriceIdSerializer.serialize(value.id),
    };
  },
};
