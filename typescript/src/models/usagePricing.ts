// this file is @generated
import { extraProperties } from "../json.js";
import {
  type UsagePricingModel,
  UsagePricingModelSerializer,
} from "./usagePricingModel.js";

export interface UsagePricing {
  model: UsagePricingModel;
}

/** Converts `UsagePricing` values from (`parse`) and to (`serialize`) their JSON form. */
export const UsagePricingSerializer = {
  parse(json: any): UsagePricing {
    return {
      ...extraProperties(json, ["model"]),
      model: UsagePricingModelSerializer.parse(json["model"]),
    };
  },

  serialize(value: UsagePricing): any {
    return {
      ...extraProperties(value, ["model"]),
      model: UsagePricingModelSerializer.serialize(value.model),
    };
  },
};
