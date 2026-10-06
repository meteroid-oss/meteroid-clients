// this file is @generated
import { extraProperties } from "../json.js";
import { type AddOnId, AddOnIdSerializer } from "./addOnId.js";
import { type PriceId, PriceIdSerializer } from "./priceId.js";

export interface PlanAddOnInput {
  addOnId: AddOnId;
  maxInstances?: number | null | undefined;
  priceId?: PriceId | null | undefined;
  selfServiceable?: boolean | null | undefined;
}

/** Converts `PlanAddOnInput` values from (`parse`) and to (`serialize`) their JSON form. */
export const PlanAddOnInputSerializer = {
  parse(json: any): PlanAddOnInput {
    return {
      ...extraProperties(json, [
        "add_on_id",
        "max_instances",
        "price_id",
        "self_serviceable",
      ]),
      addOnId: AddOnIdSerializer.parse(json["add_on_id"]),
      maxInstances: json["max_instances"],
      priceId:
        json["price_id"] != null
          ? PriceIdSerializer.parse(json["price_id"])
          : json["price_id"],
      selfServiceable: json["self_serviceable"],
    };
  },

  serialize(value: PlanAddOnInput): any {
    return {
      ...extraProperties(value, [
        "addOnId",
        "maxInstances",
        "priceId",
        "selfServiceable",
      ]),
      add_on_id: AddOnIdSerializer.serialize(value.addOnId),
      max_instances: value.maxInstances,
      price_id:
        value.priceId != null
          ? PriceIdSerializer.serialize(value.priceId)
          : value.priceId,
      self_serviceable: value.selfServiceable,
    };
  },
};
