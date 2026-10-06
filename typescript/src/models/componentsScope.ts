// this file is @generated
import { extraProperties } from "../json.js";
/** Component names — matched against `ReplacePlanRequest::components[].name`. */
export interface ComponentsScope {
  componentNames: string[];
}

/** Converts `ComponentsScope` values from (`parse`) and to (`serialize`) their JSON form. */
export const ComponentsScopeSerializer = {
  parse(json: any): ComponentsScope {
    return {
      ...extraProperties(json, ["component_names"]),
      componentNames: json["component_names"],
    };
  },

  serialize(value: ComponentsScope): any {
    return {
      ...extraProperties(value, ["componentNames"]),
      component_names: value.componentNames,
    };
  },
};
