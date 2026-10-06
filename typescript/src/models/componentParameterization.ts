// this file is @generated
import { extraProperties } from "../json.js";
import {
  type ComponentParameters,
  ComponentParametersSerializer,
} from "./componentParameters.js";
import { type PriceComponentId, PriceComponentIdSerializer } from "./priceComponentId.js";

export interface ComponentParameterization {
  componentId: PriceComponentId;
  parameters: ComponentParameters;
}

/** Converts `ComponentParameterization` values from (`parse`) and to (`serialize`) their JSON form. */
export const ComponentParameterizationSerializer = {
  parse(json: any): ComponentParameterization {
    return {
      ...extraProperties(json, ["component_id", "parameters"]),
      componentId: PriceComponentIdSerializer.parse(json["component_id"]),
      parameters: ComponentParametersSerializer.parse(json["parameters"]),
    };
  },

  serialize(value: ComponentParameterization): any {
    return {
      ...extraProperties(value, ["componentId", "parameters"]),
      component_id: PriceComponentIdSerializer.serialize(value.componentId),
      parameters: ComponentParametersSerializer.serialize(value.parameters),
    };
  },
};
