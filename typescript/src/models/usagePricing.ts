// this file is @generated
import { type UsagePricingModel, UsagePricingModelSerializer } from "./usagePricingModel";

export interface UsagePricing {
  model: UsagePricingModel;
}

export const UsagePricingSerializer = {
  _fromJsonObject(object: any): UsagePricing {
    return {
      model: UsagePricingModelSerializer._fromJsonObject(object["model"]),
    };
  },

  _toJsonObject(self: UsagePricing): any {
    return {
      model: UsagePricingModelSerializer._toJsonObject(self.model),
    };
  },
};
