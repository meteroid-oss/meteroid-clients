// this file is @generated
import { type AddOnId, AddOnIdSerializer } from "./addOnId";
import { type PriceId, PriceIdSerializer } from "./priceId";

export interface PlanAddOnInput {
  addOnId: AddOnId;

  maxInstances?: number | null;

  priceId?: PriceId | null;

  selfServiceable?: boolean | null;
}

export const PlanAddOnInputSerializer = {
  _fromJsonObject(object: any): PlanAddOnInput {
    return {
      addOnId: AddOnIdSerializer._fromJsonObject(object["add_on_id"]),
      maxInstances: object["max_instances"],
      priceId:
        object["price_id"] != null
          ? PriceIdSerializer._fromJsonObject(object["price_id"])
          : undefined,
      selfServiceable: object["self_serviceable"],
    };
  },

  _toJsonObject(self: PlanAddOnInput): any {
    return {
      add_on_id: AddOnIdSerializer._toJsonObject(self.addOnId),
      max_instances: self.maxInstances,
      price_id:
        self.priceId != null ? PriceIdSerializer._toJsonObject(self.priceId) : undefined,
      self_serviceable: self.selfServiceable,
    };
  },
};
