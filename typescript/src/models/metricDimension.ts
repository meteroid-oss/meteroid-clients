// this file is @generated

export interface MetricDimension {
  key: string;

  values: string[];
}

export const MetricDimensionSerializer = {
  _fromJsonObject(object: any): MetricDimension {
    return {
      key: object["key"],
      values: object["values"],
    };
  },

  _toJsonObject(self: MetricDimension): any {
    return {
      key: self.key,
      values: self.values,
    };
  },
};
