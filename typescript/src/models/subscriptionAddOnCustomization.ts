// this file is @generated
import {
  type SubscriptionAddOnParameterization,
  SubscriptionAddOnParameterizationSerializer,
} from "./subscriptionAddOnParameterization.js";
import {
  type SubscriptionAddOnPriceOverride,
  SubscriptionAddOnPriceOverrideSerializer,
} from "./subscriptionAddOnPriceOverride.js";

export interface SubscriptionAddOnCustomizationPriceOverride
  extends SubscriptionAddOnPriceOverride {
  type: "PRICE_OVERRIDE";
}
export interface SubscriptionAddOnCustomizationParameterization
  extends SubscriptionAddOnParameterization {
  type: "PARAMETERIZATION";
}

export type SubscriptionAddOnCustomization =
  | SubscriptionAddOnCustomizationPriceOverride
  | SubscriptionAddOnCustomizationParameterization;

/** Converts `SubscriptionAddOnCustomization` values from (`parse`) and to (`serialize`) their JSON form. */
export const SubscriptionAddOnCustomizationSerializer = {
  parse(json: any): SubscriptionAddOnCustomization {
    switch (json["type"]) {
      case "PRICE_OVERRIDE":
        return {
          ...SubscriptionAddOnPriceOverrideSerializer.parse(json),
          type: "PRICE_OVERRIDE",
        };
      case "PARAMETERIZATION":
        return {
          ...SubscriptionAddOnParameterizationSerializer.parse(json),
          type: "PARAMETERIZATION",
        };
      default:
        // A variant added to the API after this SDK was generated, kept as received.
        return json;
    }
  },

  serialize(value: SubscriptionAddOnCustomization): any {
    switch (value.type) {
      case "PRICE_OVERRIDE":
        return {
          ...SubscriptionAddOnPriceOverrideSerializer.serialize(value),
          type: "PRICE_OVERRIDE",
        };
      case "PARAMETERIZATION":
        return {
          ...SubscriptionAddOnParameterizationSerializer.serialize(value),
          type: "PARAMETERIZATION",
        };
      default:
        return value;
    }
  },
};
