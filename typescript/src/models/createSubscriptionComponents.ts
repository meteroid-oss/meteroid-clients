// this file is @generated
import { extraProperties } from "../json.js";
import {
  type ComponentOverride,
  ComponentOverrideSerializer,
} from "./componentOverride.js";
import {
  type ComponentParameterization,
  ComponentParameterizationSerializer,
} from "./componentParameterization.js";
import { type ExtraComponent, ExtraComponentSerializer } from "./extraComponent.js";
import { type PriceComponentId, PriceComponentIdSerializer } from "./priceComponentId.js";

export interface CreateSubscriptionComponents {
  extraComponents?: ExtraComponent[] | null | undefined;
  overriddenComponents?: ComponentOverride[] | null | undefined;
  parameterizedComponents?: ComponentParameterization[] | null | undefined;
  removeComponents?: PriceComponentId[] | null | undefined;
}

/** Converts `CreateSubscriptionComponents` values from (`parse`) and to (`serialize`) their JSON form. */
export const CreateSubscriptionComponentsSerializer = {
  parse(json: any): CreateSubscriptionComponents {
    return {
      ...extraProperties(json, [
        "extra_components",
        "overridden_components",
        "parameterized_components",
        "remove_components",
      ]),
      extraComponents:
        json["extra_components"] != null
          ? json["extra_components"].map((item: any) =>
              ExtraComponentSerializer.parse(item)
            )
          : json["extra_components"],
      overriddenComponents:
        json["overridden_components"] != null
          ? json["overridden_components"].map((item: any) =>
              ComponentOverrideSerializer.parse(item)
            )
          : json["overridden_components"],
      parameterizedComponents:
        json["parameterized_components"] != null
          ? json["parameterized_components"].map((item: any) =>
              ComponentParameterizationSerializer.parse(item)
            )
          : json["parameterized_components"],
      removeComponents:
        json["remove_components"] != null
          ? json["remove_components"].map((item: any) =>
              PriceComponentIdSerializer.parse(item)
            )
          : json["remove_components"],
    };
  },

  serialize(value: CreateSubscriptionComponents): any {
    return {
      ...extraProperties(value, [
        "extraComponents",
        "overriddenComponents",
        "parameterizedComponents",
        "removeComponents",
      ]),
      extra_components:
        value.extraComponents != null
          ? value.extraComponents.map((item: any) =>
              ExtraComponentSerializer.serialize(item)
            )
          : value.extraComponents,
      overridden_components:
        value.overriddenComponents != null
          ? value.overriddenComponents.map((item: any) =>
              ComponentOverrideSerializer.serialize(item)
            )
          : value.overriddenComponents,
      parameterized_components:
        value.parameterizedComponents != null
          ? value.parameterizedComponents.map((item: any) =>
              ComponentParameterizationSerializer.serialize(item)
            )
          : value.parameterizedComponents,
      remove_components:
        value.removeComponents != null
          ? value.removeComponents.map((item: any) =>
              PriceComponentIdSerializer.serialize(item)
            )
          : value.removeComponents,
    };
  },
};
