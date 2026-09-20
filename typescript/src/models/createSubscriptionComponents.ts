// this file is @generated
import { type ComponentOverride, ComponentOverrideSerializer } from "./componentOverride";
import {
  type ComponentParameterization,
  ComponentParameterizationSerializer,
} from "./componentParameterization";
import { type ExtraComponent, ExtraComponentSerializer } from "./extraComponent";
import { type PriceComponentId, PriceComponentIdSerializer } from "./priceComponentId";

export interface CreateSubscriptionComponents {
  extraComponents?: ExtraComponent[] | null;

  overriddenComponents?: ComponentOverride[] | null;

  parameterizedComponents?: ComponentParameterization[] | null;

  removeComponents?: PriceComponentId[] | null;
}

export const CreateSubscriptionComponentsSerializer = {
  _fromJsonObject(object: any): CreateSubscriptionComponents {
    return {
      extraComponents:
        object["extra_components"] != null
          ? object["extra_components"].map((item: any) =>
              ExtraComponentSerializer._fromJsonObject(item)
            )
          : undefined,
      overriddenComponents:
        object["overridden_components"] != null
          ? object["overridden_components"].map((item: any) =>
              ComponentOverrideSerializer._fromJsonObject(item)
            )
          : undefined,
      parameterizedComponents:
        object["parameterized_components"] != null
          ? object["parameterized_components"].map((item: any) =>
              ComponentParameterizationSerializer._fromJsonObject(item)
            )
          : undefined,
      removeComponents:
        object["remove_components"] != null
          ? object["remove_components"].map((item: any) =>
              PriceComponentIdSerializer._fromJsonObject(item)
            )
          : undefined,
    };
  },

  _toJsonObject(self: CreateSubscriptionComponents): any {
    return {
      extra_components:
        self.extraComponents != null
          ? self.extraComponents.map((item: any) =>
              ExtraComponentSerializer._toJsonObject(item)
            )
          : undefined,
      overridden_components:
        self.overriddenComponents != null
          ? self.overriddenComponents.map((item: any) =>
              ComponentOverrideSerializer._toJsonObject(item)
            )
          : undefined,
      parameterized_components:
        self.parameterizedComponents != null
          ? self.parameterizedComponents.map((item: any) =>
              ComponentParameterizationSerializer._toJsonObject(item)
            )
          : undefined,
      remove_components:
        self.removeComponents != null
          ? self.removeComponents.map((item: any) =>
              PriceComponentIdSerializer._toJsonObject(item)
            )
          : undefined,
    };
  },
};
