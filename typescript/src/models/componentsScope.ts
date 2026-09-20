// this file is @generated
/** Component names — matched against `ReplacePlanRequest::components[].name`. */
export interface ComponentsScope {
  componentNames: string[];
}

export const ComponentsScopeSerializer = {
  _fromJsonObject(object: any): ComponentsScope {
    return {
      componentNames: object["component_names"],
    };
  },

  _toJsonObject(self: ComponentsScope): any {
    return {
      component_names: self.componentNames,
    };
  },
};
