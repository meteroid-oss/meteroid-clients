// this file is @generated
import {
  type SubscriptionAddOnParameterization,
  SubscriptionAddOnParameterizationSerializer,
} from "./subscriptionAddOnParameterization";
import {
  type SubscriptionAddOnPriceOverride,
  SubscriptionAddOnPriceOverrideSerializer,
} from "./subscriptionAddOnPriceOverride";

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

export const SubscriptionAddOnCustomizationSerializer = {
  _fromJsonObject(object: any): SubscriptionAddOnCustomization {
    const type = object["type"];

    switch (type) {
      case "PRICE_OVERRIDE":
        return {
          ...SubscriptionAddOnPriceOverrideSerializer._fromJsonObject(object),
          type: "PRICE_OVERRIDE",
        };
      case "PARAMETERIZATION":
        return {
          ...SubscriptionAddOnParameterizationSerializer._fromJsonObject(object),
          type: "PARAMETERIZATION",
        };
      default:
        throw new Error(`Unexpected type for SubscriptionAddOnCustomization: ${type}`);
    }
  },

  _toJsonObject(self: SubscriptionAddOnCustomization): any {
    switch (self.type) {
      case "PRICE_OVERRIDE":
        return {
          ...SubscriptionAddOnPriceOverrideSerializer._toJsonObject(self),
          type: "PRICE_OVERRIDE",
        };
      case "PARAMETERIZATION":
        return {
          ...SubscriptionAddOnParameterizationSerializer._toJsonObject(self),
          type: "PARAMETERIZATION",
        };
      default:
        throw new Error(`Unexpected type for SubscriptionAddOnCustomization`);
    }
  },
};
